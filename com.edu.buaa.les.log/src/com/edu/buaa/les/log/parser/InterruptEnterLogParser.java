package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.InterruptEnterLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class InterruptEnterLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException{
		// TODO Auto-generated method stub
		InterruptEnterLogStruct logStruct = new InterruptEnterLogStruct(type);
		/*
		 * 读取数据填充结构体
		 */
		logStruct.setVector(file.getInteger());
		logStruct.setNestLevel(file.getInteger());
		return logStruct;
	}

}
