package com.fang.dbController;

import java.util.List;

import com.fang.model.Log;

public interface LogOpration{

	/**
	 * 删除网站日志
	 * @param log
	 * @return
	 */
	int delLog(Log log);
	
	/**
	 * 
	 * @param log
	 * @return
	 */
	int addLog(Log log);
	
	/**
	 * 获得指定大小的logcat的信息
	 * @param size
	 * @return
	 */
	List<?> getLogcatBySize(int size);
	
	
}
