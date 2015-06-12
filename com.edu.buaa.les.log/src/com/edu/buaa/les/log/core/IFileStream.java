package com.edu.buaa.les.log.core;

import java.io.IOException;

/**
 * Description: 定义日志数据读取接口,该接口定义了基本数据类型的读取
 * @author 马春雷
 *
 */
public interface IFileStream {
	public Integer 		getInteger() throws IOException;
	public String 		getStringByLen(Integer len) throws IOException;
	public Double		getDouble() throws IOException;
	public Character	getCharacter() throws IOException;
	public byte			getByte() throws IOException;
	public byte[]		getBytes(Integer len) throws IOException;
	public Float		getFloat() throws IOException;
	public Short		getShort() throws IOException;
	public void			close() throws IOException;
}
