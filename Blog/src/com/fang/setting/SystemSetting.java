package com.fang.setting;

import java.io.File;

/***
 * 提供了对系统的一些设置等相关信息
 * @author fang
 *
 */
public class SystemSetting {

	
	/**
	 * 文件系统的地址路劲。所有的图片存放在该目录下面
	 */
	public static final String IMG_DIR="localhost:8080/Blog/html/html/";
	
	/**
	 * 视频地址的路径，所有视频存放在该位置
	 */
	public static final String VIDEO_DIR="http://localhost:8080/Blog/video";
	
	/**
	 * 图片数据的访问路劲
	 */
	public static final String IMG_DATA_VISIT_PATH="http://10.109.1.201:8080/Blog/ImgServlet";
	
	/**
	 * 每日一言的访问路劲
	 */
	public static final String PROVERB_VISIT_PATH="http://10.109.1.201:8080/Blog/ProverbServlet";
	
	
	/**
	 * 用户存放用户名的cookie的key
	 */
	public static String cookieName="userid";
     
	/**
	 * 用户注册时的默认头像
	 */
	public static String defaultUserHead="http://localhost:8080/Blog/userHeadPortrait/usepricture.jpeg";
	
	
	/**
	 * 系统用户的cookie的默认的维持时间
	 * 代表的是cookie维持一个月
	 */
	public static final int COOKIE_HOID=60*60*24*30;
	
	
	
}
