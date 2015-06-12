package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.MessageQueueCreateLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class MessageQueueCreateLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException {
		// TODO Auto-generated method stub
		MessageQueueCreateLogStruct logStruct = new MessageQueueCreateLogStruct(type);
		
		/*
		 * 读取数据,进行结构体的填充
		 */
		logStruct.setMessageQueueCount(file.getInteger());
		logStruct.setTaskIdentity(file.getInteger());
		logStruct.setProgramCounter(file.getInteger());
		logStruct.setSynchronousCounter(file.getInteger());
		/*
		 * 读取名字,分别先读取名字的长度,然后读取具体的字符串
		 */
		int nameLen = 0;
		nameLen = file.getInteger();
		byte[] name = file.getBytes(nameLen);
		logStruct.setMessageQueueName(new String(name));
		
		return logStruct;
	}

}
