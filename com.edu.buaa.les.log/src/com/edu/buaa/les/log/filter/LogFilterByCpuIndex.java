package com.edu.buaa.les.log.filter;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.struct.CpuIndexLogStruct;

public class LogFilterByCpuIndex implements ILogFilter {
	private List<BaseLogStructInfo> filterResult =
			new LinkedList<BaseLogStructInfo>();
	
	public List<BaseLogStructInfo> getFilterResult(){
		return filterResult;
	}
	
	@Override
	public List<BaseLogStructInfo> filter(List<BaseLogStructInfo> input) {
		// TODO Auto-generated method stub
		Iterator<BaseLogStructInfo> iterator = input.iterator();
		while(iterator.hasNext()){
			BaseLogStructInfo info = iterator.next();
			if(info instanceof CpuIndexLogStruct){
				filterResult.add(info);
			}
		}
		return filterResult;
	}
}
