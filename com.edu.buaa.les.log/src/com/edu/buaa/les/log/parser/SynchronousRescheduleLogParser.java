package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.SynchronousRescheduleLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class SynchronousRescheduleLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException {
		// TODO Auto-generated method stub
		SynchronousRescheduleLogStruct logStruct = 
				new SynchronousRescheduleLogStruct(type);
		
		/*
		 * 读取数据填充结构体
		 */
		logStruct.setTaskIdentity(file.getInteger());;
		logStruct.setNestLevel(file.getInteger());
		logStruct.setProgramCounter(file.getInteger());
		logStruct.setNeedReschedule(file.getInteger());
		return logStruct;
	}

}
