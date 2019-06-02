package com.fang.help.controll;

/**
 * 模式控制的接口类，实现的是对模式控制的接口规范
 * @author fang
 *
 */
public interface ModeControllInt  {

	
	/**
	 * 考核模式
	 */
	public static final String ASSESS_MODE="assessMode";
	
	/**
	 * 训练模式
	 */
	public static final String TRAIN_MODE="trainMode";
	
	/**
	 * 自定义模式
	 */
	public static final String CONSUME_MODE="consumeMode";
		
	/**
	 * 设置操作模式
	 * {@link #ASSESS_MODE}
	 * {@link #TRAIN_MODE}
	 * {@link #CONSUME_MODE}
	 * @param mode
	 * @return
	 */
	public boolean setMode(String mode);
	
	
	/**
	 * 停止当前的操作
	 * @return
	 */
	public boolean stopOprate();
	
	
	
}
