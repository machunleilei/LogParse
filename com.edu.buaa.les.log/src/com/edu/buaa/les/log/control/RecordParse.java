package com.edu.buaa.les.log.control;

import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.edu.buaa.les.log.parser.*;
import com.edu.buaa.les.log.core.BaseLogStructInfo;
import com.edu.buaa.les.log.core.FileStreamBinary;
import com.edu.buaa.les.log.core.IFileStream;
import com.edu.buaa.les.log.core.ILogOperation;
import com.edu.buaa.les.log.core.ILogType;
import com.edu.buaa.les.log.core.ILogTypeParse;
import com.edu.buaa.les.log.core.LogParse;
import com.edu.buaa.les.log.core.LogType4Integer;
import com.edu.buaa.les.log.core.LogTypeParse4Integer;
import com.edu.buaa.les.log.constvalue.RecordTypeValue;

public class RecordParse {
	private LogParse parser = null;
	private String fileName = null;
	
	private LinkedList<BaseLogStructInfo> records = null;
	
	
	
	public RecordParse() {
		super();
		// TODO Auto-generated constructor stub
		parser = new LogParse();
		records = new LinkedList<BaseLogStructInfo>();
	}

	public void setRecordFilePath(final String name) throws FileNotFoundException,
		IOException{
		fileName = name;
		
		IFileStream stream =
				new FileStreamBinary(name);
		
		parser.configLogFile(stream);
		parser.configTypeFile(stream);
		
	}
	
	public String getFilename(){
		return fileName;
	}
	
	public void configLogTypeParser(ILogTypeParse parser){
		this.parser.configTypeParse(parser);
	}
	
	public void registerParser(ILogType type, ILogOperation operation){
		parser.register(type, operation);
	}
	
	public void parseAll(){
		BaseLogStructInfo info = null;
		try {
			while(parser.nextLogType() != null){
				info = parser.getNext();
				//System.out.println(info);
				records.add(info);
//				System.out.println(info);
			}
		} catch (EOFException e) {
			System.out.println("Eof file now");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Other Exception of IOException");
		}catch (NullPointerException e) {
			// TODO: handle exception
			System.err.println(e);
		}
	}
	
	public void printAllInfo(){
		Iterator<BaseLogStructInfo> iterable = records.iterator();
		while(iterable.hasNext()){
			System.err.println(iterable.next());
		}
	}
	
	public void regiseterDefaultParse(){
		/*
		 * 下面注册事件的解析函数
		 */
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_SEMCREATE), 
				new SemaphoreCreateLogParser()
				);
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_SEMTAKE), 
				new SemaphoreObtainLogParser()
				);
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_SEMGIVE), 
				new SemaphoreReleaseLogParser()
				);
		
		
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_MSGQCREATE), 
				new MessageQueueCreateLogParser()
				);
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_MSGQSEND), 
				new MessageQueueSendLogParser()
				);
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_MSGQRECV), 
				new MessageQueueReceiveLogParser()
				);
		
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_TASKCREATE), 
				new TaskCreateLogParser()
				);
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_TASKSTART), 
				new TaskStartLogParser()
				);
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_TASKDELAY), 
				new TaskDelayLogParser()
				);
		
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_CONTEXTSWITCH), 
				new ContextSwitchLogParser()
				);
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_FAKECONTEXTSWITCH), 
				new FakeContextSwitchLogParser()
				);
		
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_INTERRUPTENTER), 
				new InterruptEnterLogParser()
				);
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_INTERRUPTEXIT), 
				new InterruptExitLogParser()
				);
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_INTERRUPTEXITRESCHEDULE), 
				new InterruptExitRescheduleLogParser()
				);
		
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_SYNCRESCHEDULE),
				new SynchronousRescheduleLogParser());
		
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_CPUINDEX),
				new CpuIndexLogParser());
		
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_INTERRUPTENTERCONTEXT), 
				new InterruptEnterContextLogParser());
		
		this.registerParser(
				new LogType4Integer(RecordTypeValue.LES_EVENT_INTERRUPTEXITCONTEXT), 
				new InterruptExitContextLogParser());
	}
	
	/* 获取解析得到的日志 */
	public LinkedList<BaseLogStructInfo> getParsedLogs(){
		return records;
	}
	
	
}
