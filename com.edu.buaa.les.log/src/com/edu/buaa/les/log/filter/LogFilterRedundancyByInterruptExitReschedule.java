package com.edu.buaa.les.log.filter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.struct.ContextSwitchLogStruct;
import com.edu.buaa.les.log.struct.CpuIndexLogStruct;
import com.edu.buaa.les.log.struct.InterruptExitRescheduleLogStruct;

public class LogFilterRedundancyByInterruptExitReschedule implements ILogFilter {
	
	private List<BaseLogStructInfo> filterResult = 
			new LinkedList<BaseLogStructInfo>();

	public List<BaseLogStructInfo> getFilterResult(){
		return filterResult;
	}
	@Override
	public List<BaseLogStructInfo> filter(List<BaseLogStructInfo> input) {
		// TODO Auto-generated method stub
		
		Iterator<BaseLogStructInfo> iterator = 
				input.iterator();
		Integer entryNums = 0;
		while(iterator.hasNext()){
			BaseLogStructInfo info = iterator.next();
			if(info instanceof InterruptExitRescheduleLogStruct){
				/* 开始遍历,看任务切换是不是中断引发的 */
				/* 注意需要跳过CpuIndex事件 */
				Integer skipCpuIndexNums = 0;
				while(entryNums > 0){
					/* 获取最后一项的日志,并判断是否是ContextSwith */
					BaseLogStructInfo entryInfo = filterResult.get(entryNums - 1);
					if(! (entryInfo instanceof ContextSwitchLogStruct)
							&& !(entryInfo instanceof CpuIndexLogStruct)){
						/* 如果不是ContextSwitch,说明上一个事件没有触发任务切换 */
						filterResult.remove(entryNums - 1);
						entryNums --;
					}else if(entryInfo instanceof CpuIndexLogStruct){
						/* 如果是一个CpuIndex事件,跳过这个事件 */
						skipCpuIndexNums ++;
						entryNums --;
						break;
					}else{
						break;
					}
				}
				entryNums += skipCpuIndexNums;
				/* 保留这个中断事件,标示后续的ContextSwitch是他触发的 */
				filterResult.add(info);
				entryNums ++;
			}else{
				filterResult.add(info);
				entryNums ++;
			}
		}
		return filterResult;
	}
}
