package com.edu.buaa.les.log.struct;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class ContextSwitchLogStruct extends BaseLogStructInfo {
	Integer[] registers;
	Integer taskIdentity;
	Integer stackMarker;
	Integer programCounter;
	final static int registerNums = 32;
	
	public ContextSwitchLogStruct() {
		registers = null;
		taskIdentity = 0;
		stackMarker = 0;
		// TODO Auto-generated constructor stub
	}
	public static int getRegisterNums() {
		return registerNums;
	}
	public ContextSwitchLogStruct(ILogType type){
		super(type);
		registers = null;
		taskIdentity = 0;
		stackMarker = 0;
	}
	public Integer getProgramCounter() {
		return programCounter;
	}
	public void setProgramCounter(Integer programCounter) {
		this.programCounter = programCounter;
	}
	public Integer[] getRegisters() {
		return registers;
	}
	public void setRegisters(Integer[] registers) {
		this.registers = registers;
	}
	public Integer getTaskIdentity() {
		return taskIdentity;
	}
	public void setTaskIdentity(Integer taskIdentity) {
		this.taskIdentity = taskIdentity;
	}
	public Integer getStackMarker() {
		return stackMarker;
	}
	public void setStackMarker(Integer stackMarker) {
		this.stackMarker = stackMarker;
	}
	
	public String toString(){
		String retString = super.toString() + "\t"
				+ "log name is: " + "ContextSwitch" + "\t"
				+ "The task identity is: " + taskIdentity + "\t"
				+ "The program counter is: " + programCounter + "\t" 
				+ "The stack marker is: " + stackMarker + "\t"
				+ "The registers is: (";
		int index = 0;
		while(index ++ < ContextSwitchLogStruct.registerNums){
			retString += registers[index - 1] + ",";
		}
		retString = retString.substring(0, retString.length() - 1);
		retString += ")";
		
		return retString;
	}
	@Override
	public Integer getTaskIndentity() throws InvalidRoleInfoException {
		// TODO Auto-generated method stub
		return taskIdentity;
	}
	
	
}
