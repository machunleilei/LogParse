package com.edu.buaa.les.log.core;

import java.io.IOException;

public interface ILogOperation {
	public BaseLogStructInfo parse(IFileStream file, ILogType type) throws IOException; //自定义的事件解析函数
}
