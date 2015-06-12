package com.edu.buaa.les.log.struct;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class InterruptExitLogStruct extends BaseLogStructInfo {
	
	Integer vector;
	Integer nestLevel;

	public Integer getNestLevel() {
		return nestLevel;
	}

	public void setNestLevel(Integer nestLevel) {
		this.nestLevel = nestLevel;
	}

	public InterruptExitLogStruct() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InterruptExitLogStruct(ILogType type) {
		super(type);
		// TODO Auto-generated constructor stub
	}

	public Integer getVector() {
		return vector;
	}

	public void setVector(Integer vector) {
		this.vector = vector;
	}

	public String toString(){
		String retString = null;
		retString = super.toString() + "\t"
				+ "log name is: " + "InterruptExit" + "\t"
				+ "the interrupt vector is: " + vector + "\t"
				+ "the nest level is: " + nestLevel;
		return retString;
	}

	@Override
	public Integer getTaskIndentity() throws InvalidRoleInfoException {
		// TODO Auto-generated method stub
		return super.getTaskIndentity();
	}
}
