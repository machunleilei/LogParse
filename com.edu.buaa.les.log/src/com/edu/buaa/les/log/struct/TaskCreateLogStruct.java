package com.edu.buaa.les.log.struct;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class TaskCreateLogStruct extends BaseLogStructInfo {
	Integer taskIdentity;
	Integer priority;
	Integer option;
	Integer stackSize;
	String taskName;
	
	private void __initData() {
		taskIdentity = 0;
		priority = 0;
		option = 0;
		stackSize = 0;
		taskName = null;
	}

	public TaskCreateLogStruct() {
		super();
		// TODO Auto-generated constructor stub
		__initData();
	}

	public TaskCreateLogStruct(ILogType type) {
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

	public Integer getPriority() {
		return priority;
	}

	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	public Integer getOption() {
		return option;
	}

	public void setOption(Integer option) {
		this.option = option;
	}

	public Integer getStackSize() {
		return stackSize;
	}

	public void setStackSize(Integer stackSize) {
		this.stackSize = stackSize;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	
	public String toString(){
		String retString = super.toString() + "\t"
				+ "log name is: " + "TaskCreate" + "\t"
				+ "the task identity is: " + taskIdentity + "\t"
				+ "the task name is: " + taskName + "\t"
				+ "the task priority is: " + priority + "\t"
				+ "the task option is: " + option + "\t"
				+ "the stack size is: " + stackSize;
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
