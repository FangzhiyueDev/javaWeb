package com.fang.rice.model;

public class FilterType {
	
	private String filterType;
	private int[] range;
	public String getFilterType() {
		return filterType;
	}
	public void setFilterType(String filterType) {
		this.filterType = filterType;
	}
	public int[] getRange() {
		return range;
	}
	public void setRange(int[] range) {
		this.range = range;
	}
	public FilterType(String filterType, int[] range) {
		super();
		this.filterType = filterType;
		this.range = range;
	}
	
	
	
	
	
}
