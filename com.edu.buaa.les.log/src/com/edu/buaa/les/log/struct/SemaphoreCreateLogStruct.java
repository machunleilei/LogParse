package com.edu.buaa.les.log.struct;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class SemaphoreCreateLogStruct extends SynchronousBaseLogStruct {
	Integer semaphoreCount;
	
	String semaphoreName;
	
	Integer synchronousCounter;
	
	private void __initData() {
		semaphoreCount = 0;
		
		semaphoreName = null;
		
		synchronousCounter = 0;
	}

	public SemaphoreCreateLogStruct() {
		super();
		// TODO Auto-generated constructor stub
		__initData();
	}

	public SemaphoreCreateLogStruct(ILogType type) {
		super(type);
		// TODO Auto-generated constructor stub
		__initData();
	}

	public Integer getSemaphoreCount() {
		return semaphoreCount;
	}

	public void setSemaphoreCount(Integer semaphoreCount) {
		this.semaphoreCount = semaphoreCount;
	}



	public String getSemaphoreName() {
		return semaphoreName;
	}

	public void setSemaphoreName(String semaphoreName) {
		this.semaphoreName = semaphoreName;
	}



	public Integer getSynchronousCounter() {
		return synchronousCounter;
	}

	public void setSynchronousCounter(Integer synchronousCounter) {
		this.synchronousCounter = synchronousCounter;
	}
	
	public String toString(){
		String retString = super.toString() + "\t"
				+ "log name is: " + "SemaphoreCreate" + "\t"
				+ "the semaphore name is: " + semaphoreName + "\t"
				+ "the semaphore count is: " + semaphoreCount + "\t"
				+ "the task identity is: " + getTaskIdentity() + "\t"
				+ "the program counter is: " + getProgramCounter() + "\t"
				+ "the synchronous counter is: " + synchronousCounter;
		return retString;
	}

	@Override
	public Integer getTaskIndentity() throws InvalidRoleInfoException {
		// TODO Auto-generated method stub
		return getTaskIdentity();
	}
	@Override
	public BaseLogStructInfo.LogCategory getLogCategory(){
		return BaseLogStructInfo.LogCategory.LOG_CATEGORY_SYNCHRONOUS;
	}
}
