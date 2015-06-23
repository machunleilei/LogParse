package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;
import com.edu.buaa.les.log.struct.InterruptEnterContextLogStruct;

public class InterruptEnterContextLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type)
			throws IOException {
		// TODO Auto-generated method stub
		InterruptEnterContextLogStruct logStruct = 
				new InterruptEnterContextLogStruct(type);
		
		logStruct.setTaskIdentity(file.getInteger());
		logStruct.setSrr0(file.getInteger());
		logStruct.setSrr1(file.getInteger());
		logStruct.setCr(file.getInteger());
		logStruct.setLr(file.getInteger());
		logStruct.setCtx(file.getInteger());
		logStruct.setXer(file.getInteger());
		//set 14 gps registers
		Integer idx = 0;
		Integer[] gprs = new Integer[InterruptEnterContextLogStruct.getGprsNums()];
		while(idx < InterruptEnterContextLogStruct.getGprsNums()){
			gprs[idx] = file.getInteger();
			idx ++;
		}
		logStruct.setGprs(gprs);
		//FIXME later
		file.getByte();
		file.getByte();
		file.getByte();
		return logStruct;
	}

}
