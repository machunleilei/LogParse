package com.edu.buaa.les.log.filter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.struct.InterruptExitLogStruct;
import com.edu.buaa.les.log.struct.InterruptExitRescheduleLogStruct;

public class LogFilterByInterruptExitReschedule implements ILogFilter {

	private List<BaseLogStructInfo> interruptExitLogs = 
			new LinkedList<BaseLogStructInfo>();
	public LogFilterByInterruptExitReschedule() {
		// TODO Auto-generated constructor stub
	}
	
	public List<BaseLogStructInfo> getFilterResult(){
		return interruptExitLogs;
	}
	
	@Override
	public List<BaseLogStructInfo> filter(List<BaseLogStructInfo> input) {
		// TODO Auto-generated method stub
		Iterator<BaseLogStructInfo> iterator = input.iterator();
		while(iterator.hasNext()){
			BaseLogStructInfo infoStruct = iterator.next();
			if(infoStruct instanceof InterruptExitRescheduleLogStruct){
				interruptExitLogs.add(infoStruct);
			}
		}
		return interruptExitLogs;
	}

}
