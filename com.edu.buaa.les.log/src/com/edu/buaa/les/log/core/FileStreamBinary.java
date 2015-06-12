package com.edu.buaa.les.log.core;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



public class FileStreamBinary implements IFileStream {
	DataInputStream stream = null;
	
	public FileStreamBinary(final String pathname) throws FileNotFoundException{
		// TODO Auto-generated constructor stub
		File file = new File(pathname);
		try {
			stream = new DataInputStream(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			throw e;
		}
	}
	@Override
	public Integer getInteger() throws IOException {
		// TODO Auto-generated method stub
		return stream.readInt();
	}

	@Override
	public String getStringByLen(Integer len) throws IOException {
		// TODO Auto-generated method stub
		byte[] b = new byte[len];
		stream.read(b, 0, len);
		return new String(b);
	}

	@Override
	public Double getDouble() throws IOException {
		// TODO Auto-generated method stub
		return stream.readDouble();
	}

	@Override
	public Character getCharacter() throws IOException {
		// TODO Auto-generated method stub
		return stream.readChar();
	}

	@Override
	public byte getByte() throws IOException {
		// TODO Auto-generated method stub
		return stream.readByte();
	}

	@Override
	public byte[] getBytes(Integer len) throws IOException {
		// TODO Auto-generated method stub
		byte[] b = new byte[len];
		stream.read(b, 0, len);
		return b;
	}

	@Override
	public Float getFloat() throws IOException {
		// TODO Auto-generated method stub
		return stream.readFloat();
	}

	@Override
	public Short getShort() throws IOException {
		// TODO Auto-generated method stub
		return stream.readShort();
	}
	@Override
	public void close() throws IOException {
		// TODO Auto-generated method stub
		stream.close();
	}

}
