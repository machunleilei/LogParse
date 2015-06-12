package com.edu.buaa.les.log.filter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.struct.CpuIndexLogStruct;

public class LogFilterRedundancyByCpuIndex implements ILogFilter {
	private List<BaseLogStructInfo> filterResult =
			new LinkedList<BaseLogStructInfo>();
	
	public List<BaseLogStructInfo> getFilterResult(){
		return filterResult;
	}
	
	@Override
	public List<BaseLogStructInfo> filter(List<BaseLogStructInfo> input) {
		// TODO Auto-generated method stub
		Iterator<BaseLogStructInfo> iterator = input.iterator();
		/* 首先过滤调cpuindex事件在一起的没必要的,例如
		 * cpuindex = 1
		 * cpuindex = 0
		 * cpuindex = 1
		 * cpuindex = 0
		 * 过滤得到cpuindex = 0 */
		Integer prevCpuIndex = -1; /* 刚开始设置为无效 */
		Integer beginCpuIndex = -1; /* 刚开始设置为无效 */
		BaseLogStructInfo beginCpuIndexLog = null;
		BaseLogStructInfo endCpuIndexLog = null;
		Integer findCpuIndexNums = 0;
		boolean cpuIndexLogIsFirst = true; /* 第1个事件一定是CPUIndex */
		while(iterator.hasNext()){
			BaseLogStructInfo info = iterator.next();
			if(info instanceof CpuIndexLogStruct){
				CpuIndexLogStruct cpuIndexLogStruct = (CpuIndexLogStruct)info;
				if(beginCpuIndex.intValue() == -1){
					beginCpuIndex = cpuIndexLogStruct.getIndex();
					beginCpuIndexLog = info;
				}
				endCpuIndexLog = info;
				findCpuIndexNums ++;
			}else{
				if(findCpuIndexNums.intValue() == 0){
					/* 表示目前还没有发现cpuindex日志 */
				}else if(findCpuIndexNums == 1){
					if(prevCpuIndex.intValue() != beginCpuIndex.intValue()){
						/* 表示发生CPU切换,如果没有发生切换,那么没有必要记录 */
						prevCpuIndex = beginCpuIndex;
						filterResult.add(beginCpuIndexLog);
					}
				}else{
					CpuIndexLogStruct begin = (CpuIndexLogStruct)beginCpuIndexLog;
					CpuIndexLogStruct end = (CpuIndexLogStruct)endCpuIndexLog;
					if(cpuIndexLogIsFirst){
						/* 如果是第一次过滤这个CPUIndex事件,由于必须保证事件必须是以
						 * CPUIndex事件开始,故这里如果不考虑,会出现
						 * cpuindex = 1
						 * cpuindex = 0
						 * cpuindex = 1
						 * 过滤之后没有了 */
						filterResult.add(endCpuIndexLog);
						/* 修正上一次CPU为最后一个CPUindex事件 */
						prevCpuIndex = end.getIndex();
					}else if(begin.getIndex().intValue() !=
							end.getIndex().intValue()){
						/* 只有开头和结尾不相等,才需要保留最后一个 */
						if(prevCpuIndex.intValue() != end.getIndex().intValue()){
							/* 只有真正发生了切换CPU才记录,并切换CPU */
							filterResult.add(endCpuIndexLog);
							prevCpuIndex = end.getIndex();
						}
					}else{
						if(prevCpuIndex.intValue() != end.getIndex().intValue()){
							/* 只有真正发生了切换CPU才记录,并切换CPU */
							filterResult.add(endCpuIndexLog);
							prevCpuIndex = end.getIndex();
						}
					}
					cpuIndexLogIsFirst = false;
				}
				/* 初始化过滤器 */
				findCpuIndexNums = 0;
				beginCpuIndexLog = null;
				endCpuIndexLog = null;
				beginCpuIndex = -1;
				filterResult.add(info);
			}
		}
		return filterResult;
	}
}
