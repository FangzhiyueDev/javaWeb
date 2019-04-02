package com.fang.dbController;

import java.util.List;

import com.fang.model.Proverb;

public interface ProverbOpration {

	/**
	 * 添加一个每日一言的语句
	 * @param proverb
	 * @return
	 */
	int addProverb(Proverb proverb);
	
	/**
	 * 删除一个每日一言的语句
	 */
	
	int delProverb(Proverb proverb);
	
	/**
	 * 清除所有的每日一言语句
	 */
	int delAllProverb();
	
	/**
	 * 查询所有的每日一言
	 * @return
	 */
	List<?> queryAllProverb();
	
	/**
	 * 下面是实现分页的效果
	 * @param startPage 开始的page
	 * @param size 请求的数量
	 */
	List<?> queryProverb(int startPage,int size);
	
	
	/**
	 * 查询最新的数据
	 * @return
	 */
	List<?> queryNowProverb(int size);
	
	
	
	
}
