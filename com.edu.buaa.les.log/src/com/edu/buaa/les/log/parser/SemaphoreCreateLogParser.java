package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.SemaphoreCreateLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class SemaphoreCreateLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException {
		// TODO Auto-generated method stub
		SemaphoreCreateLogStruct logStruct =
				new SemaphoreCreateLogStruct(type);
		
		/*
		 * 填充结构体
		 */
		logStruct.setSemaphoreCount(file.getInteger());
		logStruct.setTaskIdentity(file.getInteger());
		logStruct.setProgramCounter(file.getInteger());
		logStruct.setSynchronousCounter(file.getInteger());
		/*
		 * 读取名字
		 */
		int nameLen = file.getInteger();
		byte[] names = file.getBytes(nameLen);
		logStruct.setSemaphoreName(new String(names));
		
		return logStruct;
	}

}
