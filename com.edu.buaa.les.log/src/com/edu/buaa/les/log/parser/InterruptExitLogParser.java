package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.InterruptExitLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class InterruptExitLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type)
			throws IOException {
		// TODO Auto-generated method stub
		InterruptExitLogStruct logStruct =
				new InterruptExitLogStruct(type);
		
		logStruct.setVector(file.getInteger());
		logStruct.setNestLevel(file.getInteger());
		return logStruct;
	}

}
