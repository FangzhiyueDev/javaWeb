/**
 * 
 */
package com.fang.rice.model;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * @author fang
 * 该接口是卡消费的详细信息的接口,通过继承这个接口实现不同的数据显示
 *
 */
public class CardChargeInfo {
	
	private int id;
	private int cardId;
	private int monthlyFee;
	private int callingCharges;
	private int callingTime;
	private int callingCommuFee;
	private String calledCharges;
	private int calledTime;
	private int calledCommuFee;
	private int aggregate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getMonthlyFee() {
		return monthlyFee;
	}
	public void setMonthlyFee(int monthlyFee) {
		this.monthlyFee = monthlyFee;
	}
	public int getCallingCharges() {
		return callingCharges;
	}
	public void setCallingCharges(int callingCharges) {
		this.callingCharges = callingCharges;
	}
	public int getCallingTime() {
		return callingTime;
	}
	public void setCallingTime(int callingTime) {
		this.callingTime = callingTime;
	}
	public int getCallingCommuFee() {
		return callingCommuFee;
	}
	public void setCallingCommuFee(int callingCommuFee) {
		this.callingCommuFee = callingCommuFee;
	}
	public String getCalledCharges() {
		return calledCharges;
	}
	public void setCalledCharges(String calledCharges) {
		this.calledCharges = calledCharges;
	}
	public int getCalledTime() {
		return calledTime;
	}
	public void setCalledTime(int calledTime) {
		this.calledTime = calledTime;
	}
	public int getCalledCommuFee() {
		return calledCommuFee;
	}
	public void setCalledCommuFee(int calledCommuFee) {
		this.calledCommuFee = calledCommuFee;
	}
	public int getAggregate() {
		return aggregate;
	}
	public void setAggregate(int aggregate) {
		this.aggregate = aggregate;
	}
	public CardChargeInfo(int id, int cardId, int monthlyFee, int callingCharges, int callingTime, int callingCommuFee,
			String calledCharges, int calledTime, int calledCommuFee, int aggregate) {
		super();
		this.id = id;
		this.cardId = cardId;
		this.monthlyFee = monthlyFee;
		this.callingCharges = callingCharges;
		this.callingTime = callingTime;
		this.callingCommuFee = callingCommuFee;
		this.calledCharges = calledCharges;
		this.calledTime = calledTime;
		this.calledCommuFee = calledCommuFee;
		this.aggregate = aggregate;
	}
	
	public CardChargeInfo() {
		// TODO Auto-generated constructor stub
	}
	
	

}
