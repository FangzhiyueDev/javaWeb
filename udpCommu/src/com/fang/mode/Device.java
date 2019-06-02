package com.fang.mode;


/**
 * 连接到当前udp通信的设备的基本信息
 * @author fang
 *
 */
public class Device {
	
	private int intAddress;

	public int getIntAddress() {
		return intAddress;
	}

	public void setIntAddress(int intAddress) {
		this.intAddress = intAddress;
	}
	
	public Device() {
		// TODO Auto-generated constructor stub
	}
	
	public Device(int ip){
		this.intAddress=ip;
	}
	
	
}
