package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.InterruptExitRescheduleLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class InterruptExitRescheduleLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type)
			throws IOException {
		// TODO Auto-generated method stub
		InterruptExitRescheduleLogStruct logStruct =
				new InterruptExitRescheduleLogStruct(type);
		/* 这里取得的永远是0 */
		file.getInteger();
		
		return logStruct;
	}

}
