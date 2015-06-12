package com.edu.buaa.les.log.filter;


import java.util.List;

import com.edu.buaa.les.log.core.BaseLogStructInfo;

public interface ILogFilter {
	List<BaseLogStructInfo> filter(List<BaseLogStructInfo> input);
}
