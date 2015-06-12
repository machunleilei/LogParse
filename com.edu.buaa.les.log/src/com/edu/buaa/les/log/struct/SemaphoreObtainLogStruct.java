package com.edu.buaa.les.log.struct;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class SemaphoreObtainLogStruct extends SynchronousBaseLogStruct {
	Integer synchronousCounter;
	Integer semaphoreIdentity;
	
	
	private void __initData() {
		synchronousCounter = 0;
		semaphoreIdentity = 0;
	
	}

	public SemaphoreObtainLogStruct() {
		super();
		// TODO Auto-generated constructor stub
		__initData();
	}

	public SemaphoreObtainLogStruct(ILogType type) {
		super(type);
		// TODO Auto-generated constructor stub
		__initData();
	}

	public Integer getSynchronousCounter() {
		return synchronousCounter;
	}

	public void setSynchronousCounter(Integer synchronousCounter) {
		this.synchronousCounter = synchronousCounter;
	}

	public Integer getSemaphoreIdentity() {
		return semaphoreIdentity;
	}

	public void setSemaphoreIdentity(Integer semaphoreIdentity) {
		this.semaphoreIdentity = semaphoreIdentity;
	}


	
	public String toString(){
		String retString = super.toString() + "\t"
				+ "log name is: " + "SemaphoreObtain" + "\t"
				+ "the semaphore identity is: " + semaphoreIdentity + "\t"
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
