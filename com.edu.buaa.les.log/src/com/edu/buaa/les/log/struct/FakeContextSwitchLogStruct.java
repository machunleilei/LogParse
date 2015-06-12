package com.edu.buaa.les.log.struct;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class FakeContextSwitchLogStruct extends BaseLogStructInfo {
	Integer taskIdentity;

	public int getTaskIdentity() {
		return taskIdentity;
	}

	public void setTaskIdentity(int taskIdentity) {
		this.taskIdentity = taskIdentity;
	}
	
	public FakeContextSwitchLogStruct() {
		// TODO Auto-generated constructor stub
		taskIdentity = 0;
	}
	
	public FakeContextSwitchLogStruct(ILogType type){
		super(type);
	}
	
	public String toString(){
		String retString = super.toString() + "\t"
				+ "log name is: " + "FakeContextSwitch" + "\t"
				+ "task indentity is: " + taskIdentity;
		
		return retString;
	}

	@Override
	public Integer getTaskIndentity() throws InvalidRoleInfoException {
		// TODO Auto-generated method stub
		return taskIdentity;
	}
}
