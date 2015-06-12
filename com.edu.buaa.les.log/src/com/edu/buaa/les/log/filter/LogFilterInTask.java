package com.edu.buaa.les.log.filter;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.struct.ContextSwitchLogStruct;
import com.edu.buaa.les.log.struct.SynchronousRescheduleLogStruct;
import com.edu.buaa.les.log.struct.TaskCreateLogStruct;
import com.edu.buaa.les.log.struct.TaskStartLogStruct;

public class LogFilterInTask implements ILogFilter {

	@Override
	public List<BaseLogStructInfo> filter(List<BaseLogStructInfo> input) {
		// TODO Auto-generated method stub
		List<BaseLogStructInfo> retInfos = new
				LinkedList<BaseLogStructInfo>();
		Deque<BaseLogStructInfo> queue = new 
				ArrayDeque<BaseLogStructInfo>();
		
		ListIterator<BaseLogStructInfo> iterator = input.listIterator();
		/* 任务开始事件单独处理 */
		retInfos.add(iterator.next());
		while(iterator.hasNext()){
			BaseLogStructInfo info = iterator.next();
			if(info.getLogCategory() == BaseLogStructInfo.LogCategory.LOG_CATEGORY_SYNCHRONOUS){
				/* 这种情况不会发生 */
				break;
			}else if(info instanceof ContextSwitchLogStruct){
				retInfos.add(info);
				/* 判断紧跟着的是不是SynchronousReschedule,如果是,那么是由于同步事件引发的切换 */
				BaseLogStructInfo nextInfo = iterator.next();
				if(nextInfo instanceof SynchronousRescheduleLogStruct){
					break;
				}
				/* 移动到前一个日志 */
				iterator.previous();
				break;
			}else{
				break;
			}
		}
		boolean shouldRemove = false;
		boolean prevLogIsContextSwith = false;
		BaseLogStructInfo prevSynchronousLog = null;
		while(iterator.hasNext()){
			BaseLogStructInfo info = iterator.next();
			/* 判断是否是可能引发切换的事件 */
			if(info.getLogCategory() == BaseLogStructInfo.LogCategory.LOG_CATEGORY_SYNCHRONOUS){
				prevLogIsContextSwith = false;
				if(queue.size() > 0 && shouldRemove){
					queue.remove();
					shouldRemove = false;
				}
				queue.addLast(info);
			}else if(info.getLogCategory() == BaseLogStructInfo.LogCategory.LOG_CATEGORY_SYNCHRONOUSRESCHEDULE){
				prevLogIsContextSwith = false;
				prevSynchronousLog = info;
				if(queue.size() == 1){
					shouldRemove = true;
					continue;
				}
				queue.removeLast();
			}else if(info instanceof ContextSwitchLogStruct){
				if(prevLogIsContextSwith){
					/* 这里主要用来处理多个ContextSwitch事件在一起的 */
					retInfos.add(info);
					/* 判断下一个事件是不是SynchronousReschedule */
					if(iterator.hasNext()){
						info = iterator.next();
						if(!(info instanceof SynchronousRescheduleLogStruct)){
							/* 如果不是,将该事件放回 */
							iterator.previous();
						}
					}
					continue;
				}
				/* 到这里的时候已经队列中只剩下一个事件 */
				if(queue.size() != 1){
					System.err.println("发现队列中有 " + queue.size() + "个事件");
					System.exit(0);
				}
				retInfos.add(queue.getFirst());
				retInfos.add(prevSynchronousLog);
				retInfos.add(info);
				/* 复位栈 */
				queue.remove();
				shouldRemove = false;
				prevLogIsContextSwith = true;
			}
			
		}
		return retInfos;
	}

}
