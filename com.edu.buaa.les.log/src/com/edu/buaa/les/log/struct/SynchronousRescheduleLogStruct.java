package com.edu.buaa.les.log.struct;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class SynchronousRescheduleLogStruct extends BaseLogStructInfo {
	Integer taskIdentity;
	Integer programCounter;
	Integer nestLevel;
	Integer needReschedule;
	private void __initData() {
		taskIdentity = 0;
		programCounter = 0;
		nestLevel = 0;
		needReschedule = 0;
	}
	
	public SynchronousRescheduleLogStruct() {
		super();
		// TODO Auto-generated constructor stub
		__initData();
	}
	public SynchronousRescheduleLogStruct(ILogType type) {
		super(type);
		// TODO Auto-generated constructor stub
		__initData();
	}
	
	public Integer getTaskIdentity() {
		return taskIdentity;
	}
	public void setTaskIdentity(Integer taskIdentity) {
		this.taskIdentity = taskIdentity;
	}
	public Integer getProgramCounter() {
		return programCounter;
	}
	public void setProgramCounter(Integer programCounter) {
		this.programCounter = programCounter;
	}
	public Integer getNestLevel() {
		return nestLevel;
	}
	public void setNestLevel(Integer nestLevel) {
		this.nestLevel = nestLevel;
	}
	public Integer getNeedReschedule() {
		return needReschedule;
	}
	public void setNeedReschedule(Integer needReschedule) {
		this.needReschedule = needReschedule;
	}
	
	public String toString(){
		String retString = super.toString() + "\t"
				+ "log name is: " + "SynchronousReschedule" + "\t"
				+ "the task identity is: " + taskIdentity + "\t"
				+ "the program counter is: " + programCounter + "\t"
				+ "the nest level is: " + nestLevel + "\t"
				+ "the need reschedule is: " + needReschedule;
		return retString;
	}

	@Override
	public Integer getTaskIndentity() throws InvalidRoleInfoException {
		// TODO Auto-generated method stub
		return taskIdentity;
	}
	@Override
	public BaseLogStructInfo.LogCategory getLogCategory(){
		return BaseLogStructInfo.LogCategory.LOG_CATEGORY_SYNCHRONOUSRESCHEDULE;
	}
}
