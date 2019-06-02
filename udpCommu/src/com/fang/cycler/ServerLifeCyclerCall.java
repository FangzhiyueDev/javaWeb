package com.fang.cycler;


import java.util.List;

import com.fang.mode.Device;
import com.fang.mode.Info;

/**
 * 生命周期的接口回调的实现
 * @author fang
 *
 */
public interface ServerLifeCyclerCall {

	/**
	 * 第一连接时回调
	 * @param ipAddress 返回的是第一次连接的设备信息
	 */
	public void onCreate(Device device);

	/**
	 * 获得当前在线的所有设备
	 * @return
	 */
	public List<? extends Device> getAllDevice();
	
	/**
	 * 接收到信息的回调实现
	 * @param device
	 * @param info
	 */
	public void onReceiver(Device device,Info info);
	
	public void onNewDevice(Device device);
	
	/**
	 * 设备退出的时候调用
	 * @param devide  当前退出的时候调用
	 */
	public void onDeviceBack(Device device);
	
	
	
	
}
