package com.xiaofangfang.rice.model;

import java.util.List;

/**
 * 由于程序的字段用问题
 */

public class Phone extends OrderList {

    private int cityCode;
    private int phoneId;
    private String brand;
    private String oprationSystem;
    private String network;//网络类型
    private String cardType;//card的类型，是否是单卡或双卡
    private String roughImageAddress;
    private List<String> imageList;
    private String salePhoneTitle;
    private String screenDimension;
    private String powerCapacity;
    private String tnickness;
    private String discount;

    public Phone(float price, int saleColume, String destribute,
                 String name, int phoneId, String network, String cardType) {

        this.setName(name);
        this.setDestribute(destribute);
        this.setPrice(price);
        this.setSaleVolume(saleColume);
        this.phoneId = phoneId;
        this.network = network;
        this.cardType = cardType;
    }
    
    

    private String image;

    private String action;

    /**
     * 分类，用来标识当前的产品的分类信息，从而为手机标识一个标签
     */
    private String classfy;

    public int getPhoneId() {
        return phoneId;
    }

    public void setPhoneId(int phoneId) {
        this.phoneId = phoneId;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    /**
     * 这个构造函数用于对主界面的手机的展示界面的显示，
     *
     * @param image
     * @param name
     * @param action
     * @param price
     * @param destribute
     * @param phoneId
     */
    public Phone( int phoneId,String image, String name, String action, float price, String destribute) {
    	this.phoneId=phoneId;
        this.image = image;
        this.setName(name);
        this.action = action;
        this.phoneId = phoneId;
        this.setPrice(price);
        this.setDestribute(destribute);
    }

    /**
     * 这个视图是用来进行详细界面的信息的显示
     * @param phoneId
     * @param cityCode
     * @param name
     * @param brand
     * @param price
     * @param salePhoneTitle
     * @param action
     * @param networkType
     * @param cardType
     * @param images
     * @param screenDimension
     * @param powerCapacity
     * @param tnickness
     * @param saleCount
     * @param discount
     * @param systemOprate
     */
    public Phone(int phoneId,int cityCode,String name,String brand,int price,String salePhoneTitle,
    		String action,String networkType,String cardType,List<String> images,String screenDimension,
    		String powerCapacity,String tnickness,int saleCount,String discount,String systemOprate) {
    	this.phoneId=phoneId;
    	this.cityCode=cityCode;
    	this.setName(name);
    	this.brand=brand;
    	this.setPrice(price);
    	this.salePhoneTitle=salePhoneTitle;
    	this.action=action;
    	this.network=networkType;
    	this.cardType=cardType;
    	this.imageList=images;
    	this.screenDimension=screenDimension;
    	this.powerCapacity=powerCapacity;
    	this.tnickness=tnickness;
    	this.setSaleVolume(saleCount);
    	this.discount=discount;
    	this.oprationSystem=systemOprate;
    }
    
     
    public String getPowerCapacity() {
		return powerCapacity;
	}

	public void setPowerCapacity(String powerCapacity) {
		this.powerCapacity = powerCapacity;
	}

	public String getTnickness() {
		return tnickness;
	}

	public void setTnickness(String tnickness) {
		this.tnickness = tnickness;
	}

	public String getDiscount() {
		return discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getScreenDimension() {
		return screenDimension;
	}

	public void setScreenDimension(String screenDimension) {
		this.screenDimension = screenDimension;
	}

	public String getClassfy() {
        return classfy;
    }

    public void setClassfy(String classfy) {
        this.classfy = classfy;
    }

    public Phone() {
    }

    /**
     * 这个构造函数的作用是用来构建手机展示列表的数据
     * @param phoneId2
     * @param roughImageAddress
     * @param salePhoneTitle
     * @param networkType1
     * @param cardType1
     * @param systemOprate
     * @param action2
     * @param price
     */
    public Phone(int phoneId, String roughImageAddress, String salePhoneTitle, String networkType, String cardType,
			String systemOprate, String action, int price) {
		this.phoneId=phoneId;
		this.roughImageAddress=roughImageAddress;
		this.salePhoneTitle=salePhoneTitle;
		this.network=networkType;
		this.cardType=cardType;
		this.oprationSystem=systemOprate;
		this.action=action;
		this.setPrice(price);
	}
    
    
    
    
    
  
	public String getRoughImageAddress() {
		return roughImageAddress;
	}

	public void setRoughImageAddress(String roughImageAddress) {
		this.roughImageAddress = roughImageAddress;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	public String getSalePhoneTitle() {
		return salePhoneTitle;
	}

	public void setSalePhoneTitle(String salePhoneTitle) {
		this.salePhoneTitle = salePhoneTitle;
	}

	public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getOprationSystem() {
        return oprationSystem;
    }

    public void setOprationSystem(String oprationSystem) {
        this.oprationSystem = oprationSystem;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
