package com.edu.buaa.les.log.struct;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class MessageQueueSendLogStruct extends SynchronousBaseLogStruct {
	Integer messageQueueIdentity;
	
	Integer synchronousCounter;
	
	
	private void __initData() {
		messageQueueIdentity = 0;
	
		synchronousCounter = 0;
		
	}
	
	public MessageQueueSendLogStruct() {
		// TODO Auto-generated constructor stub
		super();
		__initData();
	}
	
	public MessageQueueSendLogStruct(ILogType type){
		super(type);
		__initData();
	}

	public Integer getMessageQueueIdentity() {
		return messageQueueIdentity;
	}

	public void setMessageQueueIdentity(Integer messageQueueIdentity) {
		this.messageQueueIdentity = messageQueueIdentity;
	}

	
	public Integer getSynchronousCounter() {
		return synchronousCounter;
	}

	public void setSynchronousCounter(Integer synchronousCounter) {
		this.synchronousCounter = synchronousCounter;
	}

	
	
	public String toString(){
		String retString = super.toString() + "\t"
				+ "log name is: " + "MessageQueueSend" + "\t"
				+ "the  message queue identity is: " + messageQueueIdentity + "\t"
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
