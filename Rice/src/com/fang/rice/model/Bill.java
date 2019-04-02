package com.fang.rice.model;

public class Bill {
	
	private int id;
	private String tel;
	private String name;
	private String address;
	private int cardId;
	private String date;//时间是年月日时分  2019-03-12 08:05 --->
	private boolean solved;//是否进行了了处理
	
	
	public Bill() {
			
	}
	
	
	public Bill(int id, String tel, String name, String address, int cardId, String date, boolean solved) {
		super();
		this.id = id;
		this.tel = tel;
		this.name = name;
		this.address = address;
		this.cardId = cardId;
		this.date = date;
		this.solved = solved;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public boolean isSolved() {
		return solved;
	}
	public void setSolved(boolean solved) {
		this.solved = solved;
	}
	
	
	
	
	
	
}
