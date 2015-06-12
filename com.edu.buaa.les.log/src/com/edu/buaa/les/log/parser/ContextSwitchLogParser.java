package com.edu.buaa.les.log.parser;

import java.io.IOException;

import com.edu.buaa.les.log.struct.ContextSwitchLogStruct;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;

public class ContextSwitchLogParser implements ILogOperation {

	@Override
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException{
		// TODO Auto-generated method stub
		ContextSwitchLogStruct logStruct = new ContextSwitchLogStruct(type);
		
		/* 根据读取的数据设置结构体信息,从而达到解析的目的 */
		logStruct.setTaskIdentity(file.getInteger());
		logStruct.setStackMarker(file.getInteger());
		logStruct.setProgramCounter(file.getInteger());
		
		/*
		 * 读取通用寄存器数值
		 */
		Integer[] gprs = 
				new Integer[ContextSwitchLogStruct.getRegisterNums()];
		int index = 0;
		while(index ++ < ContextSwitchLogStruct.getRegisterNums()){
			gprs[index - 1] = file.getInteger();
		}
		logStruct.setRegisters(gprs);
		logStruct.setProgramCounter(gprs[2]);
		return logStruct;
	}
}
