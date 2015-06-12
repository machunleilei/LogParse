package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.CpuIndexLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class CpuIndexLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type)
			throws IOException {
		// TODO Auto-generated method stub
		CpuIndexLogStruct logStruct = new CpuIndexLogStruct(type);
		logStruct.setIndex(file.getInteger());
		return logStruct;
	}

}
