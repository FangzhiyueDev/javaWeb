package com.fang.rice.model;

import java.util.List;

/**
 * 过滤条件的bean
 * @author fang
 *
 */
public class FilterCondition {
	
	private int callTimeCount;
	private int flowTimeCount;
	private int cityId;
	private int sortMessageCount;
	private String setMeal;
	private List<FilterType> filterRange;
	
	public int getCallTimeCount() {
		return callTimeCount;
	}
	public void setCallTimeCount(int callTimeCount) {
		this.callTimeCount = callTimeCount;
	}
	public int getFlowTimeCount() {
		return flowTimeCount;
	}
	public void setFlowTimeCount(int flowTimeCount) {
		this.flowTimeCount = flowTimeCount;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public int getSortMessageCount() {
		return sortMessageCount;
	}
	public void setSortMessageCount(int sortMessageCount) {
		this.sortMessageCount = sortMessageCount;
	}
	public String getSetMeal() {
		return setMeal;
	}
	public void setSetMeal(String setMeal) {
		this.setMeal = setMeal;
	}
	
	
	
	public List<FilterType> getFilterRange() {
		return filterRange;
	}
	public void setFilterRange(List<FilterType> filterRange) {
		this.filterRange = filterRange;
	}
	public FilterCondition() {
		// TODO Auto-generated constructor stub
	}
	public FilterCondition(int callTimeCount, int flowTimeCount, int cityId, int sortMessageCount, String setMeal,
			List<FilterType> filterRange) {
		
		this.callTimeCount = callTimeCount;
		this.flowTimeCount = flowTimeCount;
		this.cityId = cityId;
		this.sortMessageCount = sortMessageCount;
		this.setMeal = setMeal;
		this.filterRange=filterRange;
	}
	public FilterCondition(int cityId, String setMeal, List<FilterType> filterRange) {
	
		this.cityId = cityId;
		this.setMeal = setMeal;
	    this.filterRange=filterRange;
	}
	
	
	
	
	
	
}

