package com.fang.rice.dbController;

import java.util.List;

import com.fang.rice.model.Setmeal;

public interface SetmealOration {
	/**
	 * 智能分析查询当前城市用户使用固定的套餐,在使用
	 *数据分析的结果下,进行的推送
	 *  @param cityId
	 * @param range
	 */
	List<Setmeal> queryCitySetmeal(int cityId);
	
	
}
