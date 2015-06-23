package com.edu.buaa.les.log.constvalue;

public class RecordTypeValue {
	private final static int 	LES_EVENT_BEGIN = 				0x4C4553; //"LES"
	private final static int 	LES_EVENT_SEM_OFFSET = 			0;
	private final static int 	LES_EVENT_MSGQ_OFFSET = 		100;
	private final static int	LES_EVENT_TASK_OFFSET = 		200;
	private final static int 	LES_EVENT_CONTEXT_OFFSET = 		300;
	private final static int 	LES_EVENT_INTERRUPT_OFFSET =	400;
	private final static int 	LES_EVENT_RESCHEDULE_OFFSET	=	500;
	private final static int 	LES_EVENT_CPU_OFFSET =			600;
	
	private final static int 	LES_EVENT_SEM_INDENT(int offset){
		return LES_EVENT_BEGIN + LES_EVENT_SEM_OFFSET + offset;
	}
	
	private final static int 	LES_EVENT_MSGQ_INDENT(int offset){
		return LES_EVENT_BEGIN + LES_EVENT_MSGQ_OFFSET + offset;
	}
	
	private final static int 	LES_EVENT_TASK_INDENT(int offset){
		return LES_EVENT_BEGIN + LES_EVENT_TASK_OFFSET + offset;
	}
	
	private final static int 	LES_EVENT_CONTEXT_INDENT(int offset){
		return LES_EVENT_BEGIN + LES_EVENT_CONTEXT_OFFSET + offset;
	}
	
	private final static int 	LES_EVENT_INTERRUPT_INDENT(int offset){
		return LES_EVENT_BEGIN + LES_EVENT_INTERRUPT_OFFSET + offset;
	}
	
	private final static int 	LES_EVENT_RESCHEDULE_INDENT(int offset){
		return LES_EVENT_BEGIN + LES_EVENT_RESCHEDULE_OFFSET + offset;
	}
	
	private final static int 	LES_EVENT_CPU_INDENT(int offset){
		return LES_EVENT_BEGIN + LES_EVENT_CPU_OFFSET + offset;
	}
	
	public final static int	LES_EVENT_SEMCREATE = LES_EVENT_SEM_INDENT(0);
	public final static int	LES_EVENT_SEMTAKE =  LES_EVENT_SEM_INDENT(1);
	public final static int	LES_EVENT_SEMGIVE =  LES_EVENT_SEM_INDENT(2);
	
	
	public final static int	LES_EVENT_MSGQCREATE = LES_EVENT_MSGQ_INDENT(0);
	public final static int	LES_EVENT_MSGQSEND = LES_EVENT_MSGQ_INDENT(1);
	public final static int	LES_EVENT_MSGQRECV = LES_EVENT_MSGQ_INDENT(2);
	
	
	public final static int LES_EVENT_TASKCREATE = LES_EVENT_TASK_INDENT(0);
	public final static int LES_EVENT_TASKSTART = LES_EVENT_TASK_INDENT(1);
	public final static int LES_EVENT_TASKDELAY = LES_EVENT_TASK_INDENT(2);
	
	
	public final static int LES_EVENT_CONTEXTSWITCH = LES_EVENT_CONTEXT_INDENT(0);
	public final static int LES_EVENT_FAKECONTEXTSWITCH = LES_EVENT_CONTEXT_INDENT(1);
	
	
	public final static int LES_EVENT_INTERRUPTENTER = LES_EVENT_INTERRUPT_INDENT(0);
	public final static int LES_EVENT_INTERRUPTEXIT = LES_EVENT_INTERRUPT_INDENT(1);
	public final static int LES_EVENT_INTERRUPTEXITCONTEXT = LES_EVENT_INTERRUPT_INDENT(2);
	public final static int LES_EVENT_INTERRUPTENTERCONTEXT = LES_EVENT_INTERRUPT_INDENT(3);
	
	public final static int LES_EVENT_SYNCRESCHEDULE = LES_EVENT_RESCHEDULE_INDENT(0);
	public final static int LES_EVENT_INTERRUPTEXITRESCHEDULE = LES_EVENT_RESCHEDULE_INDENT(1);
	
	public final static int LES_EVENT_CPUINDEX = LES_EVENT_CPU_INDENT(0);
}
