package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.TaskDelayLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class TaskDelayLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException {
		// TODO Auto-generated method stub
		TaskDelayLogStruct logStruct =
				new TaskDelayLogStruct(type);
		
		/*
		 * 读取数据填充结构体
		 */
		logStruct.setTaskIdentity(file.getInteger());
		logStruct.setDelayHowLong(file.getInteger());
		
		return logStruct;
	}

}
