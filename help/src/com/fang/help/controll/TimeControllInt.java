package com.fang.help.controll;


/**
 * 用于时间控制的接口设计
 * @author fang
 *
 */
public interface TimeControllInt {
   
	/**
	 * 默认的最大的秒数
	 */
	public static final int DEFAULT_MAX_SECOND=120;
	
	/**
	 * 设置一次操作的最长时间
	 * @param second
	 */
	public void setMaxSecond(int second);
	

	
	
}
