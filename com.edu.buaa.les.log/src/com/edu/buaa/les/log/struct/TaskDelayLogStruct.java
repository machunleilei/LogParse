package com.edu.buaa.les.log.struct;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class TaskDelayLogStruct extends BaseLogStructInfo {
	Integer taskIdentity;
	Integer delayHowLong;
	
	private void __initData() {
		taskIdentity = 0;
		delayHowLong = 0;
	}

	public Integer getTaskIdentity() {
		return taskIdentity;
	}

	public void setTaskIdentity(Integer taskIdentity) {
		this.taskIdentity = taskIdentity;
	}

	public Integer getDelayHowLong() {
		return delayHowLong;
	}

	public void setDelayHowLong(Integer delayHowLong) {
		this.delayHowLong = delayHowLong;
	}

	public TaskDelayLogStruct() {
		super();
		// TODO Auto-generated constructor stub
		__initData();
	}

	public TaskDelayLogStruct(ILogType type) {
		super(type);
		// TODO Auto-generated constructor stub
		__initData();
	}
	
	public String toString(){
		String retString = super.toString() + "\t"
				+ "log name is: " + "TaskDelay" + "\t"
				+ "the task identity is: " + taskIdentity + "\t"
				+ "the delay time is: " + delayHowLong;
		return retString;
	}

	@Override
	public Integer getTaskIndentity() throws InvalidRoleInfoException {
		// TODO Auto-generated method stub
		return taskIdentity;
	}
	
	@Override
	public BaseLogStructInfo.LogCategory getLogCategory(){
		return BaseLogStructInfo.LogCategory.LOG_CATEGORY_SYNCHRONOUS;
	}
}
