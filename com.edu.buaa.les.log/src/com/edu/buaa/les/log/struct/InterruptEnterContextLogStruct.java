package com.edu.buaa.les.log.struct;

import java.util.Arrays;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.ILogType;

public class InterruptEnterContextLogStruct extends BaseLogStructInfo {
	private static final Integer gprsNums = 14;
	private Integer taskIdentity;
	private Integer srr0;
	private Integer srr1;
	private Integer cr;
	private Integer lr;
	private Integer ctx;
	private Integer xer;
	private Integer gprs[];
	public InterruptEnterContextLogStruct() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InterruptEnterContextLogStruct(ILogType type) {
		super(type);
		// TODO Auto-generated constructor stub
	}
	public Integer getTaskIdentity() {
		return taskIdentity;
	}
	public void setTaskIdentity(Integer taskIdentity) {
		this.taskIdentity = taskIdentity;
	}
	public Integer getSrr0() {
		return srr0;
	}
	public void setSrr0(Integer srr0) {
		this.srr0 = srr0;
	}
	public Integer getSrr1() {
		return srr1;
	}
	public void setSrr1(Integer srr1) {
		this.srr1 = srr1;
	}
	public Integer getCr() {
		return cr;
	}
	public void setCr(Integer cr) {
		this.cr = cr;
	}
	public Integer getLr() {
		return lr;
	}
	public void setLr(Integer lr) {
		this.lr = lr;
	}
	public Integer getCtx() {
		return ctx;
	}
	public void setCtx(Integer ctx) {
		this.ctx = ctx;
	}
	public Integer getXer() {
		return xer;
	}
	public void setXer(Integer xer) {
		this.xer = xer;
	}
	public Integer[] getGprs() {
		return gprs;
	}
	public void setGprs(Integer[] gprs) {
		this.gprs = gprs;
	}
	
	public static Integer getGprsNums() {
		return gprsNums;
	}
	@Override
	public String toString() {
		return super.toString() + "\t" 
				+ "log name is: " + "InterruptEnterContextLogStruct" + "\t"
				+ "the task identity is: " + taskIdentity + "\t"
				+ "(srr0=" + srr0 + ", srr1=" + srr1 + ", cr=" + cr + ", lr="
				+ lr + ", ctx=" + ctx + ", xer=" + xer + ", gprs="
				+ Arrays.toString(gprs) + ")";
	}
	
	@Override
	public Integer getTaskIndentity() throws InvalidRoleInfoException {
		// TODO Auto-generated method stub
		return taskIdentity;
	}
}
