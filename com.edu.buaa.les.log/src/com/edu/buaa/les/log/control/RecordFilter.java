package com.edu.buaa.les.log.control;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.filter.LogFilterByCpuIndex;
import com.edu.buaa.les.log.filter.LogFilterByInterruptExitReschedule;
import com.edu.buaa.les.log.filter.LogFilterByTaskIdentity;
import com.edu.buaa.les.log.filter.LogFilterInTask;
import com.edu.buaa.les.log.filter.LogFilterRedundancyByCpuIndex;
import com.edu.buaa.les.log.filter.LogFilterRedundancyByInterruptExitReschedule;
import com.edu.buaa.les.log.struct.ContextSwitchLogStruct;
import com.edu.buaa.les.log.struct.CpuIndexLogStruct;

public class RecordFilter {
	private Set<String> taskNamesSet = null;
	private Map<String, Integer> mapTaskName2Id = null;
	private List<BaseLogStructInfo> filterResult = 
			new LinkedList<BaseLogStructInfo>();
	
	private Map<Integer, BaseLogStructInfo> mapId2TaskCreateInfo = 
			new HashMap<Integer, BaseLogStructInfo>();
	/* 管理任务id和对应日志的结构体 */
	private Map<Integer, List<BaseLogStructInfo>> mapId2ItsLogs = null;
	
	public RecordFilter(){
		taskNamesSet = null;
		mapTaskName2Id = new HashMap<String, Integer>();
		mapId2ItsLogs = new HashMap<Integer, List<BaseLogStructInfo>>();
	}
	
	public RecordFilter(Set<String> nameSet){
		taskNamesSet = nameSet;
		mapTaskName2Id = new HashMap<String, Integer>();
		mapId2ItsLogs = new HashMap<Integer, List<BaseLogStructInfo>>();
	}
	
	public List<BaseLogStructInfo> getFilterResult(){
		return filterResult;
	}
	
	public Map<Integer, BaseLogStructInfo> getMapId2TaskCreateInfo(){
		return mapId2TaskCreateInfo;
	}
	
	private void printMapInformation(){
		Iterator<Integer> iterator = mapId2ItsLogs.keySet().iterator();
		while(iterator.hasNext()){
			Iterator<BaseLogStructInfo> info = mapId2ItsLogs.get(iterator.next()).iterator();
			while(info.hasNext()){
				
			}
			break;
		}
	}
	
	private void printListInformation(List<BaseLogStructInfo> infos){
		Iterator<BaseLogStructInfo> iterator = infos.iterator();
		while(iterator.hasNext()){
			System.err.println(iterator.next());
		}
	}
	
	public void filter(List<BaseLogStructInfo> input){
		Iterator<String> iterTaskName = taskNamesSet.iterator();
		LogFilterInTask inTaskFilter = new LogFilterInTask();
		while(iterTaskName.hasNext()){
			String taskName = iterTaskName.next();
			LogFilterByTaskIdentity filter01 = 
					new LogFilterByTaskIdentity(taskName);
			filter01.filter(input);
			/*mapId2ItsLogs.put(filter01.getTaskIdentity(),
					filter01.getFilterResult());*/
			mapTaskName2Id.put(taskName, filter01.getTaskIdentity());
			//printListInformation(filter01.getFilterResult());
			/*printListInformation(
					inTaskFilter.filter(filter01.getFilterResult()));
			System.exit(0);*/
			List<BaseLogStructInfo> ret = inTaskFilter.filter(filter01.getFilterResult());
			mapId2ItsLogs.put(filter01.getTaskIdentity(), ret);
			mapId2TaskCreateInfo.put(filter01.getTaskIdentity(), filter01.getTaskCreateLog());
		}
		
		
		LogFilterByInterruptExitReschedule interruptFilter = 
				new LogFilterByInterruptExitReschedule();
		LogFilterByCpuIndex cpuIndexFilter = 
				new LogFilterByCpuIndex();
		List<BaseLogStructInfo> interruptLogRet =  interruptFilter.filter(input);
		List<BaseLogStructInfo> cpuIndexLogRet = cpuIndexFilter.filter(input);
		/* 为了方便合并,将上面两个事件作为两个任务的事件, 确保这里的值不会跟任务ID重复 */
		mapId2ItsLogs.put(0, interruptLogRet);
		mapId2ItsLogs.put(1, cpuIndexLogRet);
		/* 打印出所有的日志 */
		/*Iterator<Integer> iterator = mapId2ItsLogs.keySet().iterator();
		while(iterator.hasNext()){
			printListInformation(mapId2ItsLogs.get(iterator.next()));
		}*/
		/* 下面进行日志的合并 */
		List<BaseLogStructInfo> mergeResult = merge(mapId2ItsLogs, interruptLogRet);
		
		/* 最后进行多余中断和同步事件的过滤 */
		LogFilterRedundancyByCpuIndex filterRedundancyByCpuIndex = 
				new LogFilterRedundancyByCpuIndex();
		
		/* 将不是由同步事件触发的切换的同步事件去掉 */
		LogFilterRedundancyByInterruptExitReschedule filterRedundancyByInterruptExitReschedule =
				new LogFilterRedundancyByInterruptExitReschedule();
		List<BaseLogStructInfo> lastRet = filterRedundancyByInterruptExitReschedule.filter(
				filterRedundancyByCpuIndex.filter(mergeResult));
		//printListInformation(lastRet);
		
		/* 对一个ContextSwitch进行修补，因为之前过滤的时候除去了别的任务的切换信息  */
		filterResult = repairContextSwitchLog(input, lastRet);
	}
	
	public List<BaseLogStructInfo> merge(Map<Integer, List<BaseLogStructInfo>> taskLogs, 
			List<BaseLogStructInfo> interruptLogs){
		List<BaseLogStructInfo> retList = 
				new LinkedList<BaseLogStructInfo>();
		BaseLogStructInfo ret = null;
		while((ret = getMinTimestampLog(taskLogs, interruptLogs)) != null){
			/*System.err.println(ret);*/
			retList.add(ret);
			/* 主要在于中断事件的处理 */
		}
		
		return retList;
	}
	
	private BaseLogStructInfo getMinTimestampLog(Map<Integer, List<BaseLogStructInfo>> taskLogs,
			List<BaseLogStructInfo> interruptLogs){
		Integer which = null;
		BaseLogStructInfo ret = null;
		Iterator<Integer> iterator = taskLogs.keySet().iterator();
		while(iterator.hasNext()){
			which = iterator.next();
			if(taskLogs.get(which).size() == 0){
				continue;
			}
			ret = taskLogs.get(which).get(0);
			break;
		}
		if(taskLogs.get(which).size() == 0){
			return null;
		}
		while(iterator.hasNext()){
			Integer value = iterator.next();
			if(taskLogs.get(value).size() == 0){
				continue;
			}
			BaseLogStructInfo tmp = taskLogs.get(value).get(0);
			if(tmp.getType().getTimestamp().intValue() 
					< ret.getType().getTimestamp().intValue()){
				which = value;
				ret = tmp;
			}
		}
		if(which != null){
			taskLogs.get(which).remove(0);
		}
		return ret;
		/* 跟中断事件比较 */
/*		if(which != null){
			if(interruptLogs.size() > 0){
				BaseLogStructInfo interLog = interruptLogs.get(0);
				if(interLog.getType().getTimestamp().intValue() 
						< ret.getType().getTimestamp().intValue()){
					ret = interLog;
					interruptLogs.remove(0);
				}else{
					taskLogs.get(which).remove(0);
				}
			}else{
				taskLogs.get(which).remove(0);
			}
		}*/
		//return ret;
	}
	
	
	private List<BaseLogStructInfo> repairContextSwitchLog(List<BaseLogStructInfo> input,
			List<BaseLogStructInfo> beRepair){
		Integer whichCpuNeedRepair = -1;
		List<BaseLogStructInfo> ret = new LinkedList<BaseLogStructInfo>();
		Iterator<BaseLogStructInfo> iterator4BeRepair = beRepair.iterator();
		Iterator<BaseLogStructInfo> iterator4Input = input.iterator();
		while(iterator4BeRepair.hasNext()){
			/* 查找缺少的位置 */
			BaseLogStructInfo info = iterator4BeRepair.next();
			ret.add(info);
			if(info instanceof CpuIndexLogStruct){
				whichCpuNeedRepair = ((CpuIndexLogStruct)info).getIndex();
			}else if(info instanceof ContextSwitchLogStruct){
				/* 找到一条ContextSwitch，尝试找另外一个 */
				Integer currentCpu = whichCpuNeedRepair;
				while(iterator4BeRepair.hasNext()){
					BaseLogStructInfo anotherInfo = iterator4BeRepair.next();
					ret.add(anotherInfo);
					if(anotherInfo instanceof CpuIndexLogStruct){
						currentCpu = ((CpuIndexLogStruct)info).getIndex();
					}else if(currentCpu.equals(whichCpuNeedRepair)){
						/* 只有都是相同CPU上的才可以进行比较 */
						if(anotherInfo instanceof ContextSwitchLogStruct){
							/* 如果接下来的信息就是一个ContextSwitch，那么说明无需修复 */
							break;
						}else{
							/* 需要修复 */
							repairContextSwitchLog(ret, input, info.getType().getTimestamp(), whichCpuNeedRepair);
							break;
						}
					}
				}
			}
		}
		return ret;
	}
	
	/* 具体修复操作 */
	private void repairContextSwitchLog(List<BaseLogStructInfo> ret, 
			List<BaseLogStructInfo>input, Integer timestamp, Integer cpuIndex){
		/* 具体修复 */
		ListIterator<BaseLogStructInfo> iterator = input.listIterator();
		Integer currentCpu = cpuIndex;
		while(iterator.hasNext()){
			/* 找到时间点一样的事件 */
			BaseLogStructInfo info = iterator.next();
			if(info.getType().getTimestamp().equals(timestamp)){
				break;
			}
		}
		
		/* 下面尝试从两个方向尝试进行修复 */
		Integer iteratorCounts = 0;
		boolean hasRepair = false;
		while(iterator.hasNext()){
			BaseLogStructInfo info = iterator.next();
			iteratorCounts ++;
			if(info instanceof CpuIndexLogStruct){
				/* 如果是CPUIndex */
				currentCpu = ((CpuIndexLogStruct)info).getIndex();
			}else if(currentCpu.equals(cpuIndex)){
				/* 找到对应的需要修补的CPU的事件 */
				if(info instanceof ContextSwitchLogStruct){
					/* 找到了ContextSwitch的另一半 */
					ret.add(ret.size() -1, info); /* 将其修补进去 */
					hasRepair = true;
					break;
				}else{
					break;
				}
			}
		}
		iteratorCounts ++;
		if(! hasRepair){
			/* 还原迭代器 */
			while(iterator.hasPrevious() && iteratorCounts -- > 0){
				iterator.previous();
			}
			
			while(iterator.hasPrevious()){
				BaseLogStructInfo info = iterator.previous();
				iteratorCounts ++;
				if(info instanceof CpuIndexLogStruct){
					/* 如果是CPUIndex */
					currentCpu = ((CpuIndexLogStruct)info).getIndex();
				}else if(currentCpu.equals(cpuIndex)){
					/* 找到对应的需要修补的CPU的事件 */
					if(info instanceof ContextSwitchLogStruct){
						/* 找到了ContextSwitch的另一半 */
						ret.add(ret.size() - 2, info);					
						hasRepair = true;
						break;
					}else{
						break;
					}
				}
			}
		}
	}
}
