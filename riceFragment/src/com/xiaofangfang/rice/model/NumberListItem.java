package com.xiaofangfang.rice.model;


/**
 * 靓号的封装类
 * @author fang
 *
 */
public  class NumberListItem {
    private String number1;
    private String number2;
    private String number3;
    private String number4;
    private String number5;
    private String yucun;
    private String tag;
    private String baodi;


    public NumberListItem(String number1, String number2, String number3,
                          String number4, String number5, String yucun,
                          String baodi, String tag) {
        this.number1 = number1;
        this.number2 = number2;
        this.tag = tag;
        this.number3 = number3;
        this.number4 = number4;
        this.number5 = number5;
        this.yucun = yucun;
        this.baodi = baodi;
    }
    
    
    public NumberListItem() {
		// TODO Auto-generated constructor stub
	}


	public String getNumber1() {
		return number1;
	}


	public void setNumber1(String number1) {
		this.number1 = number1;
	}


	public String getNumber2() {
		return number2;
	}


	public void setNumber2(String number2) {
		this.number2 = number2;
	}


	public String getNumber3() {
		return number3;
	}


	public void setNumber3(String number3) {
		this.number3 = number3;
	}


	public String getNumber4() {
		return number4;
	}


	public void setNumber4(String number4) {
		this.number4 = number4;
	}


	public String getNumber5() {
		return number5;
	}


	public void setNumber5(String number5) {
		this.number5 = number5;
	}


	public String getYucun() {
		return yucun;
	}


	public void setYucun(String yucun) {
		this.yucun = yucun;
	}


	public String getTag() {
		return tag;
	}


	public void setTag(String tag) {
		this.tag = tag;
	}


	public String getBaodi() {
		return baodi;
	}


	public void setBaodi(String baodi) {
		this.baodi = baodi;
	}
    
    


}