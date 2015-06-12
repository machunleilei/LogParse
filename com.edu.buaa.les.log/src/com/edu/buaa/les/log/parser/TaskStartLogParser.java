package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.TaskStartLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class TaskStartLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException {
		// TODO Auto-generated method stub
		TaskStartLogStruct logStruct =
				new TaskStartLogStruct(type);
		
		/*
		 * 读取数据填充结构体
		 */
		logStruct.setTaskIdentity(file.getInteger());
		logStruct.setEntryPoint(file.getInteger());
		logStruct.setArgs(file.getInteger());
		
		return logStruct;
	}

}
