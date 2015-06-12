package com.edu.buaa.les.log.core;

import javax.management.relation.InvalidRoleInfoException;

public abstract class BaseLogStructInfo {
	private ILogType logType = null;
	public void setType(ILogType type){
		logType = type;
	}
	public ILogType getType(){
		return logType;
	}
	
	public BaseLogStructInfo(ILogType type){
		logType = type;
	}
	public BaseLogStructInfo(){
		logType = null;
	}
	
	public String toString(){
		return logType.toString();
	}
	
	public Integer getTaskIndentity() throws InvalidRoleInfoException{
		throw new InvalidRoleInfoException();
	}
	
	public LogCategory getLogCategory(){
		return LogCategory.LOG_CATEGORY_UNKNOWN;
	}
	
	public enum LogCategory{
		LOG_CATEGORY_SYNCHRONOUS(0),
		LOG_CATEGORY_SYNCHRONOUSRESCHEDULE(1),
		LOG_CATEGORY_ASYNCHRONOUS(2),
		LOG_CATEGORY_UNKNOWN(3);
		private int type = 2;
		private LogCategory(int val){
			type = val;
		}
	}
}
