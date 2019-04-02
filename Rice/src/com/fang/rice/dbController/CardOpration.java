package com.fang.rice.dbController;

import java.util.List;

import com.fang.rice.controll.CardProductSalePageAction.CardFilterCondition;
import com.fang.rice.model.*;

/**
 * 对卡的操作
 * @author fang
 *
 */
public interface CardOpration {

	/**
	 * 
	 * @param cityId 城市的id
	 * @param sort	排序方式,数组 ,前面是销量的排序方式,后面是资费的排序方式 sort数组的大小是2
	 * @return 返回获得到的card的list数据
	 */
	List<Card> queryCardInfoByCityId(int cityId,String[] sort);
	/**
	 * 
	 * @param cityIdInt 城市的id
	 * @param flowTimeRange 流量的边界 ,代表的是起始和结束的位置的约束
	 * @param sort 排序方式,数组 ,前面是销量的排序方式,后面是资费的排序方式 sort数组的大小是2
	 * @return	返回获得到的card的list数据
	 */
	List<Card> queryCardInfoByCityIdFlowConsume(int cityIdInt, int[] flowTimeRange, String[] sort);
	/**
	 * 
	 * @param cityId 城市的id
	 * @param callTimeRange 通话时长的边界 ,代表的是起始和结束的位置的约束
	 * @param sort 排序方式,数组 ,前面是销量的排序方式,后面是资费的排序方式 sort数组的大小是2
	 * @return 返回获得到的card的list数据
	 */
	List<Card> queryCardinfoByCityIdCallConsume(int cityId, int[] callTimeRange,String[] sort);
	/**
	 * 
	 * @param cityIdInt 城市的id
	 * @param callTimeRange 通话时长的边界 ,代表的是起始和结束的位置的约束
	 * @param flowTimeRange2  流量的边界 ,代表的是起始和结束的位置的约束
	 * @param sort  排序方式,数组 ,前面是销量的排序方式,后面是资费的排序方式 sort数组的大小是2
	 * @return 返回获得到的card的list数据
	 */
	List<Card> queryCardInfoByCityIdConsumeSort(int cityIdInt, int[] callTimeRange, int[] flowTimeRange2, String[] sort);
	
	
	/**
	 *创建带有赛选条件的
	 * @param filterCondition
	 * @param sort
	 */
	List<Card> queryCardInfoByCityIdandFilterCondition(FilterCondition filterCondition, String[] sort);
	/**
	 * 查询卡的分类的数据
	 * @param i 
	 * @return
	 */
	RootTable queryCardClassfy(int provinceId);
	
	List<String> queryCardClassfyForList(int provinceId);
	/**
	 * 获得card的相关信息
	 * @param cardFilterCondition
	 */
	List<Card> getCardList(CardFilterCondition cardFilterCondition);
	/**
	 * 获得card 的详细信息
	 * @param parseInt
	 * @return
	 */
	Card getCardDetailInfo(int parseInt);
	
	List<Card> getCardList3(String cityId);
	
}
