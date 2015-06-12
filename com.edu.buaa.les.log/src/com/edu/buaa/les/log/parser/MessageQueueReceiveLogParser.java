package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.MessageQueueReceiveLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class MessageQueueReceiveLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException{
		// TODO Auto-generated method stub
		MessageQueueReceiveLogStruct logStruct = 
				new MessageQueueReceiveLogStruct(type);
		
		/*
		 * 读取数据,填充结构体
		 */
		logStruct.setMessageQueueIdentity(file.getInteger());
		logStruct.setTaskIdentity(file.getInteger());
		logStruct.setProgramCounter(file.getInteger());
		logStruct.setSynchronousCounter(file.getInteger());
		
		return logStruct;
	}

}
