package com.edu.buaa.les.log.struct;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class InterruptEnterLogStruct extends BaseLogStructInfo {
	Integer vector;
	Integer nestLevel;
	public InterruptEnterLogStruct(){
		
	}
	public InterruptEnterLogStruct(ILogType type){
		super(type);
	}
	
	public String toString(){
		String retString;
		retString = super.toString() + "\t"
				+ "log name is: " + "InterruptEnter" + "\t"
				+ "the interrupt vector is: " + vector + "\t"
				+ "the nest level is: " + nestLevel;
		
		return retString;
	}
	public Integer getVector() {
		return vector;
	}
	public void setVector(Integer vector) {
		this.vector = vector;
	}
	public Integer getNestLevel() {
		return nestLevel;
	}
	public void setNestLevel(Integer nestLevel) {
		this.nestLevel = nestLevel;
	}
	@Override
	public Integer getTaskIndentity() throws InvalidRoleInfoException {
		// TODO Auto-generated method stub
		return super.getTaskIndentity();
	}
	
	
}
