package com.edu.buaa.les.log.core;

import java.io.EOFException;
import java.io.IOException;

public class LogParse {
	private RegisterLogOperation logRegister = null;
	private IFileStream logTypestream = null;
	private ILogTypeParse typeParse = null;
	private IFileStream logFileStream = null;
	
	private ILogType nextLogType = null;
	private boolean  hasReadNextLog = true;
	
	public LogParse(){
		logRegister = new RegisterLogOperation();
	}
	
	public LogParse(RegisterLogOperation operation){
		this.logRegister = operation;
	}
	public void configTypeFile(IFileStream stream) throws IOException{
		this.logTypestream = stream;
	}
	
	public void configTypeParse(ILogTypeParse parse){
		typeParse = parse;
	}
	
	public void configLogFile(IFileStream stream) throws IOException{
		logFileStream = stream;
	}
	
	public boolean register(ILogType logType, ILogOperation operation, boolean overwrite){
		return logRegister.register(logType, operation, overwrite);
	}
	
	public boolean register(ILogType logType, ILogOperation operation){
		return logRegister.register(logType, operation);
	}
	
	public ILogType nextLogType() throws IOException{
		nextLogType = typeParse.parse(logTypestream);
		hasReadNextLog = false;
		return nextLogType;
	}
	public boolean hasNext() throws IOException{
		if(hasReadNextLog)
			nextLogType();
		if(nextLogType != null)
			return true;
		return false;
	}
	
	public BaseLogStructInfo getNext() throws IOException, NullPointerException{
		if(hasReadNextLog)
			nextLogType();
		hasReadNextLog = true;
		ILogOperation operation = logRegister.getValueByKey(nextLogType);
		//System.err.println(nextLogType);
		if(operation == null){
			throw new NullPointerException("没有注册" + nextLogType);
		}
		return operation.parse(logFileStream, nextLogType);
	}
}
