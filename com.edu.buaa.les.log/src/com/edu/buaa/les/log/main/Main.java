package com.edu.buaa.les.log.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.edu.buaa.les.log.control.RecordFilter;
import com.edu.buaa.les.log.control.RecordParse;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.LogTypeParse4Integer;

public class Main {
	/*
	 * 执行Main函数
	 */
	
	private Map<String, Integer> mapName2Id = null;
	
	private Map<Integer, BaseLogStructInfo> mapId2TaskCreateInfo = null;
	
	private List<BaseLogStructInfo> logResult = null;
	
	private String filePath = null;
	Set<String> taskNamesSet = new HashSet<String>();
	public Main() {
		// TODO Auto-generated constructor stub
	}
	
	public Main(String filePath){
		this.filePath = filePath;
	}
	
	public List<BaseLogStructInfo> getFilteredLogs(){
		return logResult;
	}
	
	public Map<Integer, BaseLogStructInfo> getMapId2TaskCreateInfo(){
		return mapId2TaskCreateInfo;
	}
	
	public Map<String, Integer> getMapName2Id(){
		return mapName2Id;
	}
	
	public void addTaskName(String name){
		taskNamesSet.add(name);
	}
	
	public Set<String> getTaskNameSet(){
		return taskNamesSet;
	}
	
	public void defaultSetTaskName(){
		taskNamesSet.add("UserTask01");
		taskNamesSet.add("UserTask02");
		taskNamesSet.add("UserTask03");
		taskNamesSet.add("UserTask04");
		taskNamesSet.add("UserTask05");
		taskNamesSet.add("UserTask06");
		taskNamesSet.add("UserTask07");
		taskNamesSet.add("UserTask08");
		taskNamesSet.add("UserTask09");
		taskNamesSet.add("UserTask10");
		taskNamesSet.add("UserTask11");
		taskNamesSet.add("UserTask12");
	}
	
	public void start(){
		RecordParse parser = new RecordParse();
		try {
			parser.setRecordFilePath(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		parser.configLogTypeParser(new LogTypeParse4Integer());
		/* 注册事件处理函数 */
		parser.regiseterDefaultParse();
		parser.parseAll();
		/*parser.printAllInfo();
		System.exit(0);*/
		/* 过滤日志 */
		/* 获取得到的日志 */
		LinkedList<BaseLogStructInfo> logs = parser.getParsedLogs();
//		Iterator<BaseLogStructInfo> iterator = logs.iterator();
//		while(iterator.hasNext()){
//			System.err.println(iterator.next());
//		}
//		System.exit(0);
		/* 构造过滤器 */
		RecordFilter filter = new RecordFilter(taskNamesSet);
		filter.filter(logs);
		logResult = filter.getFilterResult();
		mapId2TaskCreateInfo = filter.getMapId2TaskCreateInfo();
	}
	
	public static void main(String[] args){
		String filePath = "D:\\eclipse4.2.2\\workspace\\com.edu.buaa.les.log\\logfile\\target.svr";
		//Main obj = new Main("/home/mcl/workspace/eclipse/java/Replay/logfile/target.svr");
		Main obj = new Main(filePath);
		obj.defaultSetTaskName();
		obj.start();
		List<BaseLogStructInfo> result = null;
		result = obj.getFilteredLogs();
		System.out.println("过滤日志之后的输出");
		Iterator<BaseLogStructInfo> iterator = result.iterator();
		while(iterator.hasNext()){
			System.err.println(iterator.next());
		}
		System.out.println("过滤日志之后的输出完成");
		Map<Integer, BaseLogStructInfo> ret = obj.getMapId2TaskCreateInfo();
/*		Iterator<Integer> iterator = ret.keySet().iterator();
		while(iterator.hasNext()){
			System.out.println(ret.get(iterator.next()));
		}*/
	}
}
