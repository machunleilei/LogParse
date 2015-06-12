package com.edu.buaa.les.log.core;


public class LogType4Integer implements ILogType {
	Integer type;
	Integer timestamp;
	
	public Integer getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}
	public LogType4Integer(Integer value){
		type = new Integer(value);
	}
	public Integer getType(){
		return type;
	}
	public void setType(int type){
		this.type = type;
	}
	
	@Override
	public boolean equals(Object object){
		if(this == object)
			return true;
		if(!(object instanceof LogType4Integer))
			return false;
		LogType4Integer tmpInteger = (LogType4Integer)object;
		return (int)tmpInteger.type == (int)this.type;
	}
	
	@Override
	public int hashCode(){
		return type.hashCode();
	}
	
	@Override
	public String toString(){
		return new String("The log type is: " + type + "\t"
				+ "the timestamp is: " + timestamp);
	}
	
}
