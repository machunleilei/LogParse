package com.edu.buaa.les.log.filter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.management.relation.InvalidRoleInfoException;

import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.struct.TaskCreateLogStruct;

public class LogFilterByTaskIdentity implements ILogFilter {

	private Integer identity = null;
	private String taskName = null;
	private List<BaseLogStructInfo> taskLog = null;
	private BaseLogStructInfo taskCreateLog = null;
	
	public LogFilterByTaskIdentity() {
		// TODO Auto-generated constructor stub
		taskLog = new LinkedList<BaseLogStructInfo>();
	}
	
	public LogFilterByTaskIdentity(Integer data){
		identity = data;
		taskLog = new LinkedList<BaseLogStructInfo>();
	}
	
	public LogFilterByTaskIdentity(String taskName){
		this.taskName = taskName;
		identity = null;
		taskLog = new LinkedList<BaseLogStructInfo>();
	}
	
	public List<BaseLogStructInfo> getFilterResult(){
		return taskLog;
	}
	
	public BaseLogStructInfo getTaskCreateLog(){
		return taskCreateLog;
	}
	
	public Integer getTaskIdentity(){
		return identity;
	}
	
	public String getTaskName(){
		return taskName;
	}
	
	@Override
	public List<BaseLogStructInfo> filter(
			List<BaseLogStructInfo> input) {
		// TODO Auto-generated method stub
		Iterator<BaseLogStructInfo> infoIterator =
				input.iterator();
		if(identity == null && taskName == null){
			return null;
		}
		
		if(identity == null){
			while(infoIterator.hasNext()){
				BaseLogStructInfo baseInfo = infoIterator.next();
				if(baseInfo instanceof TaskCreateLogStruct){
					/* 找到对应任务的ID */
					TaskCreateLogStruct createLogStruct = (TaskCreateLogStruct)baseInfo;
					if(createLogStruct.getTaskName().equals(taskName)){
						identity = createLogStruct.getTaskIdentity();
						/* 加入任务创建日志 */
						taskCreateLog = createLogStruct;
						break;
					}
				}
			}
		}
		
		while(infoIterator.hasNext()){
			BaseLogStructInfo baseInfo = infoIterator.next();
			Integer idx = null;
			try {
				idx = baseInfo.getTaskIndentity();
			} catch (InvalidRoleInfoException e) {
				// TODO Auto-generated catch block
				idx = null;
			}
			if(idx != null && idx.equals(identity)){
				/* 找到该任务的事件 */
				taskLog.add(baseInfo);
			}
		}
		return taskLog;
	}
}