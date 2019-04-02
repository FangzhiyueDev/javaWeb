package com.fang.dbController;

import java.util.List;

import com.fang.model.Link;

public interface LinkOpration {

	/**
	 * 添加一个link
	 * @param link
	 * @return
	 */
	int addLink(Link link);
	
	/**
	 * 删除一条link
	 */
	int delLink(Link link);
	/**
	 * 获得当前的列表信息
	 * @param size
	 * @return
	 */
	List<?> getListBySize(int size);
	
}
