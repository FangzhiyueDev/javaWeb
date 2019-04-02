package com.fang.rice.model;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Setmeal {

	private int setmealId;
	private int cityId;
	private String classfy;
	public int getSetmealId() {
		return setmealId;
	}
	public void setSetmealId(int setmealId) {
		this.setmealId = setmealId;
	}
	public int getCityId() {
		return cityId;
	}
	public void setCityId(int cityId) {
		this.cityId = cityId;
	}
	public String getClassfy() {
		return classfy;
	}
	public void setClassfy(String classfy) {
		this.classfy = classfy;
	}
	public Setmeal(int setmealId, int cityId, String classfy) {
		super();
		this.setmealId = setmealId;
		this.cityId = cityId;
		this.classfy = classfy;
	}
	
	public Setmeal() {
		// TODO Auto-generated constructor stub
	}
	
}
