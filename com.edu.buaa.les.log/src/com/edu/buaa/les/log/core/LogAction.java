package com.edu.buaa.les.log.core;

public class LogAction {
	private RegisterLogOperation logOperation = null;
	public LogAction(RegisterLogOperation operation){
		// TODO Auto-generated constructor stub
		logOperation = operation;
	}
	public LogAction(){
		
	}
	
	public void action(BaseLogStructInfo logStruct){
		/* 调用logOperation */
	}
}
