package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.TaskCreateLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class TaskCreateLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException {
		// TODO Auto-generated method stub
		TaskCreateLogStruct logStruct =
				new TaskCreateLogStruct(type);
		
		/*
		 * 读取数据填充结构体
		 */
		logStruct.setTaskIdentity(file.getInteger());
		logStruct.setPriority(file.getInteger());
		logStruct.setOption(file.getInteger());
		logStruct.setStackSize(file.getInteger());
		
		/*
		 * 读取名字
		 */
		int nameLen = file.getInteger();
		byte[] names = file.getBytes(nameLen);
		String name = new String(names);
		/* 名字需要做一点点变换 */
		logStruct.setTaskName(name.split("\0")[0]);
		return logStruct;
	}

}
