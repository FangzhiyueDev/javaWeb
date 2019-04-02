package com.fang.rice.model;

import java.util.List;

import com.xiaofangfang.rice.model.StatusResponseJson;

/**
 * 卡数据的响应数剧
 * @author fang
 *
 */
public class CardResponse {

	private String tableName;
	private List<Card> cards;
	private StatusResponseJson statusResponseJson;
	public CardResponse(String tableName, List<Card> cards, StatusResponseJson statusResponseJson) {
		super();
		this.tableName = tableName;
		this.cards = cards;
		this.statusResponseJson = statusResponseJson;
	}
	
	public CardResponse() {
		
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public StatusResponseJson getStatusResponseJson() {
		return statusResponseJson;
	}

	public void setStatusResponseJson(StatusResponseJson statusResponseJson) {
		this.statusResponseJson = statusResponseJson;
	}
	
	
	
	
}
