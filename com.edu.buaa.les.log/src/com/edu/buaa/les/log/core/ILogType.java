package com.edu.buaa.les.log.core;

public interface ILogType {
	public boolean equals(Object object);
	public int hashCode();
	public String toString();
	public Integer getTimestamp();
}
