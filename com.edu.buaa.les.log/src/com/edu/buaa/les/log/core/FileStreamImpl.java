package com.edu.buaa.les.log.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 * Description: 实现了一个典型的文件读取接口的所有操作
 * @author mcl
 */
public class FileStreamImpl implements IFileStream {
	private FileReader reader = null;
	
	private char[] getCharArray(int length) throws IOException {
		char[] cbuf = new char[length];
		try {
			reader.read(cbuf, 0, length);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return cbuf;
	}
	/**
	 * Description: 构造函数,传入文件名即可
	 * @param fileName, 传入的文件路径名
	 */
	public FileStreamImpl(final String fileName) throws FileNotFoundException{
		// TODO Auto-generated constructor stub
		File file = new File(fileName);		
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	
	/**
	 * Description: 从文件当前位置读取一个整数
	 * @return Integer,返回一个整数对象
	 */
	@Override
	public Integer getInteger() throws IOException, NumberFormatException {
		// TODO Auto-generated method stub
		int ret = 0;
		try {
			ret = Integer.parseInt(new String(getCharArray(4))); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}catch (NumberFormatException e) {
			// TODO: handle exception
			throw e;
		}
		return ret;
	}

	/**
	 * Description: 从文件当前位置读取一个长度为len的字符串
	 * @param len,读取的字符串的长度
	 * @return String,刚读取的字符串
	 */
	@Override
	public String getStringByLen(Integer len) throws IOException{
		// TODO Auto-generated method stub
		char[] cbuf = null;
		try {
			cbuf = getCharArray(len);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return new String(cbuf);
	}

	/**
	 * Description: 读取一个Double类型的数据
	 * @return Double,读取得到的数据
	 */
	@Override
	public Double getDouble() throws IOException, NumberFormatException{
		// TODO Auto-generated method stub
		try {
			return Double.parseDouble(new String(
					getCharArray(8)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}catch (NumberFormatException e) {
			// TODO: handle exception
			throw e;
		}
	}

	/**
	 * Description: 读取一个字符
	 * @return Character,读取的字符
	 */
	@Override
	public Character getCharacter() throws IOException{
		// TODO Auto-generated method stub
		char[] cbuf = null;
		try {
			return getCharArray(1)[0];
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	/**
	 * Description: 从当前文件处读取一个字节的数据
	 * @return byte,读取的Byte类型数据
	 */
	@Override
	public byte getByte() throws IOException{
		// TODO Auto-generated method stub
		return (byte)(char)getCharacter();
	}

	/**
	 * Description: 读取一串长度为len的byte数据
	 */
	@Override
	public byte[] getBytes(Integer len) throws IOException{
		// TODO Auto-generated method stub
		char[] cbuf = null;
		try {
			cbuf = getCharArray(len);
			return new String(cbuf).getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}

	/**
	 * Description: 读取一个浮点数据
	 */
	@Override
	public Float getFloat() throws IOException, NumberFormatException{
		// TODO Auto-generated method stub
		try {
			return Float.parseFloat(new String(
					getCharArray(4)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}catch (NumberFormatException e) {
			// TODO: handle exception
			throw e;
		}
	}

	/**
	 * Description: 读取一个short类型的数据
	 */
	@Override
	public Short getShort() throws IOException, NumberFormatException{
		// TODO Auto-generated method stub
		try {
			return Short.parseShort(new String(
					getCharArray(2)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		reader.close();
	}
}
