package com.edu.buaa.les.log.struct;


import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class MessageQueueCreateLogStruct extends SynchronousBaseLogStruct {

	Integer messageQueueCount;
	Integer synchronousCounter;
	String messageQueueName;
	
	private void __initialData() {
		// TODO Auto-generated method stub
		messageQueueCount = 0;
		synchronousCounter = 0;
		this.setTaskIdentity(0);
		this.setProgramCounter(0);
		messageQueueName = null;
	}
	
	public Integer getMessageQueueCount() {
		return messageQueueCount;
	}

	public void setMessageQueueCount(Integer messageQueueCount) {
		this.messageQueueCount = messageQueueCount;
	}

	public Integer getSynchronousCounter() {
		return synchronousCounter;
	}

	public void setSynchronousCounter(Integer synchronousCounter) {
		this.synchronousCounter = synchronousCounter;
	}

	public String getMessageQueueName() {
		return messageQueueName;
	}

	public void setMessageQueueName(String messageQueueName) {
		this.messageQueueName = messageQueueName;
	}

	public MessageQueueCreateLogStruct(){
		__initialData();
	}
	public MessageQueueCreateLogStruct(ILogType type){
		super(type);
		__initialData();
	}
	
	public String toString(){
		String retString = null;
		retString = super.toString() + "\t"
				+ "log name is: " + "MessageQueueCreate" + "\t"
				+ "the message queue name is: " + messageQueueName + "\t"
				+ "the message count is: " + messageQueueCount + "\t"
				+ "the task identity is: " + this.getTaskIdentity() + "\t"
				+ "the  program counter is: " + this.getProgramCounter() + "\t"
				+ "the synchronous counter is: " + synchronousCounter;
		return retString;
	}
	
	@Override
	public Integer getTaskIndentity() throws InvalidRoleInfoException {
		// TODO Auto-generated method stub
		return this.getTaskIdentity();
	}
	
	@Override
	public BaseLogStructInfo.LogCategory getLogCategory(){
		return BaseLogStructInfo.LogCategory.LOG_CATEGORY_SYNCHRONOUS;
	}
}
