package com.edu.buaa.les.log.struct;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class CpuIndexLogStruct extends BaseLogStructInfo{
	Integer index;

	public CpuIndexLogStruct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CpuIndexLogStruct(ILogType type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}
	
	public String toString(){
		String retString = super.toString() + "\t"
				+ "log name is: " + "CpuIndex" + "\t"
				+ "the cpu index is: " + index;
		return retString;
	}

	@Override
	public Integer getTaskIndentity() throws InvalidRoleInfoException {
		// TODO Auto-generated method stub
		return super.getTaskIndentity();
	}
}
