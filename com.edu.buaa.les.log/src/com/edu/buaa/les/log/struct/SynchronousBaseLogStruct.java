package com.edu.buaa.les.log.struct;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class SynchronousBaseLogStruct extends BaseLogStructInfo {
	private Integer taskIdentity;
	private Integer programCounter;
	
	public SynchronousBaseLogStruct() {
		// TODO Auto-generated constructor stub
		taskIdentity = 0;
		programCounter = 0;
	}
	public SynchronousBaseLogStruct(ILogType type) {
		super(type);
		// TODO Auto-generated constructor stub
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
	
}
