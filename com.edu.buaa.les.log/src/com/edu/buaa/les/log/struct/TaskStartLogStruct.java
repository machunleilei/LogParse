package com.edu.buaa.les.log.struct;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class TaskStartLogStruct extends BaseLogStructInfo {
	Integer taskIdentity;
	Integer entryPoint;
	Integer args;
	
	private void __initData() {
		taskIdentity = 0;
		entryPoint = 0;
		args = 0;
	}

	public TaskStartLogStruct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskStartLogStruct(ILogType type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Integer getTaskIdentity() {
		return taskIdentity;
	}

	public void setTaskIdentity(Integer taskIdentity) {
		this.taskIdentity = taskIdentity;
	}

	public Integer getEntryPoint() {
		return entryPoint;
	}

	public void setEntryPoint(Integer entryPoint) {
		this.entryPoint = entryPoint;
	}

	public Integer getArgs() {
		return args;
	}

	public void setArgs(Integer args) {
		this.args = args;
	}
	
	public String toString(){
		String retString = super.toString() + "\t"
				+ "log name is: " + "TaskStart" + "\t"
				+ "the task identity is: " + taskIdentity + "\t"
				+ "the task entry point is: " + entryPoint + "\t"
				+ "the task args is: " + args;
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
