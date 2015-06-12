package com.edu.buaa.les.log.core;

import java.io.IOException;


public class LogTypeParse4Integer implements ILogTypeParse {

	@Override
	public ILogType parse(IFileStream stream) throws IOException{
		// TODO Auto-generated method stub
		Integer value = stream.getInteger();
		LogType4Integer type = new LogType4Integer(value);
		type.setTimestamp(stream.getInteger());
		return type;
	}

}
