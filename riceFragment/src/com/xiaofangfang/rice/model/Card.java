package com.xiaofangfang.rice.model;

import com.xiaofangfang.rice.model.OrderList;
import java.util.List;

public class Card extends OrderList {

    private int cardId;
    private int cityCode;
    private int provinceSetmealId;
    private int rank;
    private String oprator;
    private int talkTime;
    private int netFlowCount;
    private String action;
    private String monthFee;
    private String roughImageAddress;
    private String saleTitle;
    private String setmeal;//对应的是套餐的名称，对应的数据库的字段是classfy
    private List<String> imageAddressList;//内容详情界面的用于显示的card的图片集合


    @Override

    public String toString() {
        return "Card{" +
                "cardId=" + cardId +
                ", cityCode=" + cityCode +
                ", provinceSetmealId=" + provinceSetmealId +
                ", rank=" + rank +
                ", oprator='" + oprator + '\'' +
                ", talkTime=" + talkTime +
                ", netFlowTime=" + netFlowCount +
                ", action='" + action + '\'' +
                ", monthFee='" + monthFee + '\'' +
                '}';
    }

    public Card() {
		// TODO Auto-generated constructor stub
	}

    /**
     * 这个的作用是用来构建card的list显示界面的数据，并不包括特别复杂的数据
     *
     * @param cardId
     * @param monthFee
     * @param roughImageAddress
     * @param price
     * @param oprator
     */
    public Card(int cardId, String monthFee,String oprator, String roughImageAddress, int price,String destribute) {
        this.cardId = cardId;
        this.monthFee = monthFee;
        this.oprator = oprator;
        this.setPrice(price);
        this.roughImageAddress = roughImageAddress;
        this.setDestribute(destribute);
    }

    /**
     * 这个card的构造，是用来构造详情界面的数据的
     *
     * @param cardId
     * @param cityCode
     * @param oprator
     * @param talkTime
     * @param netFlowCount
     * @param action
     * @param roughImageAddress
     * @param saleTitle
     * @param setmeal
     * @param imageAddressList
     */
    public Card(int cardId, int cityCode, String oprator, int talkTime, int netFlowCount, String action, String roughImageAddress,
    		String saleTitle, String setmeal, List<String> imageAddressList,int price) {
        this.cardId = cardId;
        this.cityCode = cityCode;
        this.oprator = oprator;
        this.talkTime = talkTime;
        this.netFlowCount = netFlowCount;
        this.action = action;
        this.roughImageAddress = roughImageAddress;
        this.saleTitle = saleTitle;
        this.setmeal = setmeal;
        this.imageAddressList = imageAddressList;
        this.setPrice(price);
    }

    public Card(int cardId2, int cityCode2, int provinceSetmealId2, String cardName, int price, int rank2,
			String oprator2, int talkTime2, int netFlowTime, String destribute, int saleVolumn) {
		
	}


    /**
     * 这个的作用是用来进行数据的模拟
     * @param cardId2
     * @param monthFee2
     * @param i
     * @param roughImageAddress2
     * @param string
     */
	public Card(int cardId, String action, int price, String destribute, String name) {
		this.cardId=cardId;
		this.action=action;
		this.setPrice(price);
		this.setDestribute(destribute);
		this.setName(name);
	}


	public int getNetFlowCount() {
        return netFlowCount;
    }

    public void setNetFlowCount(int netFlowCount) {
        this.netFlowCount = netFlowCount;
    }

    public void setMonthFee(String monthFee) {
        this.monthFee = monthFee;
    }

    public String getRoughImageAddress() {
        return roughImageAddress;
    }

    public void setRoughImageAddress(String roughImageAddress) {
        this.roughImageAddress = roughImageAddress;
    }

    public String getSaleTitle() {
        return saleTitle;
    }

    public void setSaleTitle(String saleTitle) {
        this.saleTitle = saleTitle;
    }

    public String getSetmeal() {
        return setmeal;
    }

    public void setSetmeal(String setmeal) {
        this.setmeal = setmeal;
    }

    public List<String> getImageAddressList() {
        return imageAddressList;
    }

    public void setImageAddressList(List<String> imageAddressList) {
        this.imageAddressList = imageAddressList;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getCardId() {
        return cardId;
    }


    public void setCardId(int cardId) {
        this.cardId = cardId;
    }


    public int getCityCode() {
        return cityCode;
    }


    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }


    public int getProvinceSetmealId() {
        return provinceSetmealId;
    }


    public void setProvinceSetmealId(int provinceSetmealId) {
        this.provinceSetmealId = provinceSetmealId;
    }


    public int getRank() {
        return rank;
    }


    public void setRank(int rank) {
        this.rank = rank;
    }


    public String getOprator() {
        return oprator;
    }


    public void setOprator(String oprator) {
        this.oprator = oprator;
    }


    public int getTalkTime() {
        return talkTime;
    }


    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }


    public String getMonthFee() {
        return monthFee;
    }
}