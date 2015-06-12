package com.edu.buaa.les.log.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 马春雷
 * @since  2015-03-17
 * @see	   实现注册操作
 *
 */
public class RegisterLogOperation {
	/**
	 * Description: 定义一个Map,用来保存日志类型和对应的操作函数集合
	 */
	private Map<ILogType, ILogOperation> mapOperations =
			new HashMap<ILogType, ILogOperation>();
	
	/**
	 * Description: 注册日志类型和其对应的操作函数集合接口
	 * @param logType,日志类型
	 * @param operation, 对应的操作函数集合
	 * @param overwrite, 当要注册的日志类型已经被注册过,是否覆盖注册
	 * @return boolean, 是否成功注册,当某个日志已经被注册过,则必须手动指定,否则无法覆盖
	 */
	public boolean register(ILogType logType, ILogOperation operation, boolean overwrite){
		if(mapOperations.containsKey(logType) && overwrite == false){
			System.err.println("你正在注册已经注册过的日志类型的解析函数");
			return false;
		}
		mapOperations.put(logType, operation);
		return true;
	}
	
	/**
	 * Description: 注册日志类型和其对应的操作函数集合接口
	 * @param logType
	 * @param operation
	 * @return boolean, 提示用户是否注册成功
	 */
	public boolean register(ILogType logType, ILogOperation operation) {
		return register(logType, operation, false);
	}
	
	/**
	 * Description: 解注册
	 * @param logType,需要解注册的日志的类型
	 * @return ILogOperation,该日志类型已经注册的操作集合
	 */
	public ILogOperation unregister(ILogType logType){
		if(! mapOperations.containsKey(logType)){
			System.err.println("该类型没有被注册过");
			return null;
		}
		ILogOperation retILogOperation = 
				mapOperations.get(logType);
		mapOperations.remove(logType);
		return retILogOperation;
	}
	
	public ILogOperation getValueByKey(ILogType type){
		return mapOperations.get(type);
	}
}
