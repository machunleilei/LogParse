package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.MessageQueueSendLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class MessageQueueSendLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException{
		// TODO Auto-generated method stub
		MessageQueueSendLogStruct logStruct = 
				new MessageQueueSendLogStruct(type);
		
		/*
		 * 读取数据,进行结构体填充
		 */
		logStruct.setMessageQueueIdentity(file.getInteger());
		logStruct.setTaskIdentity(file.getInteger());
		logStruct.setProgramCounter(file.getInteger());
		logStruct.setSynchronousCounter(file.getInteger());
		return logStruct;
	}
}
