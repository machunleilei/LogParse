package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.FakeContextSwitchLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class FakeContextSwitchLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException {
		// TODO Auto-generated method stub
		FakeContextSwitchLogStruct logStruct = new FakeContextSwitchLogStruct(type);
		logStruct.setTaskIdentity(file.getInteger());
		return logStruct;
	}

}
