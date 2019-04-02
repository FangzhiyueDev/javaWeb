package com.fang.rice.model;

import java.util.IdentityHashMap;
import java.util.List;

/**
 * 二手手机的数据模型视图
 */
public class SecondHandPhone {


	    private int secondHandPhoneId;
	    private String userId;
	    private String name;
	    private String destribute;  //handPhoneDestribute
	    private float price;
	    private String userName;   //publishUserName
	    private String howManyNew;
	    private String userImage;
	    private String publishAddress;


	    /**
	     * 下面是二手手机的数据
	     private String publishUserName;
	     private String publishAddress;
	     private String handPhoneName;
	     private String handPhoneDestribute;
	     private List<String> imageList;
	     private int price;
	     private String userImage;
	     */


	    /**
	     * 图片的地址，根据数据库的需要，只能添加三张图片的地址
	     */
	    private List<String> imageAddress;


	    /**
	     * 这个构造的作用是用来构造显示详情信息的界面的数据
	     *
	     * @param secondHandPhoneId
	     * @param name
	     * @param destribute
	     * @param userName
	     * @param userImage
	     * @param publishAddress
	     * @param imageAddress
	     */
	    public SecondHandPhone(int secondHandPhoneId, String name,
	    		String destribute, String userName, String userImage,
	    		String publishAddress, List<String> imageAddress,
	    		int price,String howManyNew,String userId) {
	        this.secondHandPhoneId = secondHandPhoneId;
	        this.name = name;
	        this.destribute = destribute;
	        this.userName = userName;
	        this.userImage = userImage;
	        this.publishAddress = publishAddress;
	        this.imageAddress = imageAddress;
	        this.price=price;
	        this.userId=userId;
	        this.howManyNew=howManyNew;
	    }

	    


	    public SecondHandPhone(int secondHandPhoneId, String userId, String name, String destribute,
	                           String locationCity, float price, List<String> imageAddress) {
	    	 this.secondHandPhoneId = secondHandPhoneId;
	       this.userId=userId;
	        this.name = name;
	        this.destribute = destribute;
	        this.publishAddress = locationCity;
	        this.price = price;
	        this.imageAddress = imageAddress;
	    }


	    @Override
	    public String toString() {
	        return "SecondHandPhone{" +
	                "SecondHandPhoneId=" + secondHandPhoneId +
	                ", UserId=" + userId +
	                ", name='" + name + '\'' +
	                ", destribute='" + destribute + '\'' +
	                ", locationCity='" + publishAddress + '\'' +
	                ", price=" + price +
	                ", userName='" + userName + '\'' +
	                ", howManyNew='" + howManyNew + '\'' +
	                ", userImage='" + userImage + '\'' +
	                ", imageAddress=" + imageAddress +
	                '}';
	    }

	    /**
	     * 这个构造就是用来构造手机的list显示的界面的数据
	     *
	     * @param secondHandPhoneId
	     * @param destribute
	     * @param price
	     * @param userName
	     * @param howManyNew
	     * @param userImage
	     */
	    public SecondHandPhone(int secondHandPhoneId, String destribute, float price, 
	    		String userName, String howManyNew, String userImage,List<String> imageAddress) {
	        this.secondHandPhoneId = secondHandPhoneId;
	        this.destribute = destribute;
	        this.price = price;
	        this.userName = userName;
	        this.howManyNew = howManyNew;
	        this.userImage = userImage;
	        this.imageAddress=imageAddress;
	    }
	    
	    

	    public String getUserImage() {
	        return userImage;
	    }

	    public void setUserImage(String userImage) {
	        this.userImage = userImage;
	    }

	    public String getUserName() {
	        return userName;
	    }

	    public void setUserName(String userName) {
	        this.userName = userName;
	    }

	    public String getHowManyNew() {
	        return howManyNew;
	    }

	    public void setHowManyNew(String howManyNew) {
	        this.howManyNew = howManyNew;
	    }

	

	    public int getSecondHandPhoneId() {
	        return secondHandPhoneId;
	    }

	    public void setSecondHandPhoneId(int secondHandPhoneId) {
	        this.secondHandPhoneId = secondHandPhoneId;
	    }

	    public String getUserId() {
	        return userId;
	    }

	    public void setUserId(String userId) {
	        this.userId = userId;
	    }

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public List<String> getImageAddress() {
	        return imageAddress;
	    }

	    public void setImageAddress(List<String> imageAddress) {
	        this.imageAddress = imageAddress;
	    }

	    public String getDestribute() {
	        return destribute;
	    }

	    public void setDestribute(String destribute) {
	        this.destribute = destribute;
	    }


	    public String getPublishAddress() {
	        return publishAddress;
	    }


	    public void setPublishAddress(String publishAddress) {
	        this.publishAddress = publishAddress;
	    }

	    public float getPrice() {
	        return price;
	    }

	    public void setPrice(float price) {
	        this.price = price;
	    }
	}

