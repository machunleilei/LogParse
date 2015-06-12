package com.edu.buaa.les.log.struct;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class InterruptExitRescheduleLogStruct extends BaseLogStructInfo {

	private void __initData() {
	}
	public InterruptExitRescheduleLogStruct() {
		super();
		// TODO Auto-generated constructor stub
		__initData();
	}

	public InterruptExitRescheduleLogStruct(ILogType type) {
		super(type);
		// TODO Auto-generated constructor stub
		__initData();
	}


	public String toString(){
		String retString = null;
		retString = super.toString() + "\t"
				+ "log name is: " + "InterruptExitReschedule";
		return retString;
	}
}
