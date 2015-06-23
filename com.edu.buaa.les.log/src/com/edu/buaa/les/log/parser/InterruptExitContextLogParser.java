package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;
import com.edu.buaa.les.log.struct.InterruptEnterContextLogStruct;
import com.edu.buaa.les.log.struct.InterruptExitContextLogStruct;

public class InterruptExitContextLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type)
			throws IOException {
		// TODO Auto-generated method stub
		InterruptExitContextLogStruct logStruct = 
				new InterruptExitContextLogStruct(type);
		
		logStruct.setTaskIdentity(file.getInteger());
		logStruct.setSrr0(file.getInteger());
		logStruct.setSrr1(file.getInteger());
		logStruct.setCr(file.getInteger());
		logStruct.setLr(file.getInteger());
		logStruct.setCtx(file.getInteger());
		logStruct.setXer(file.getInteger());
		//set 14 gps registers
		Integer idx = 0;
		Integer[] gprs = new Integer[InterruptExitContextLogStruct.getGprsNums()];
		while(idx < InterruptExitContextLogStruct.getGprsNums()){
			gprs[idx] = file.getInteger();
			idx ++;
		}
		logStruct.setGprs(gprs);
		return logStruct;
	}

}
