package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.SemaphoreObtainLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class SemaphoreObtainLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException {
		// TODO Auto-generated method stub
		SemaphoreObtainLogStruct logStruct =
				new SemaphoreObtainLogStruct(type);
		
		/*
		 * 读数据填充结构体
		 */
		logStruct.setSemaphoreIdentity(file.getInteger());
		logStruct.setTaskIdentity(file.getInteger());
		logStruct.setProgramCounter(file.getInteger());
		logStruct.setSynchronousCounter(file.getInteger());
		
		return logStruct;
	}

}
