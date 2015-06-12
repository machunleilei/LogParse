package com.edu.buaa.les.log.core;

import java.io.IOException;

public interface ILogTypeParse {
	public ILogType parse(IFileStream stream) throws IOException;
}
