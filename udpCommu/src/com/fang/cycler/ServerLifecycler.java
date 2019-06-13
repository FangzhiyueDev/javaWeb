package com.fang.cycler;

import java.util.List;

import com.fang.mode.Device;
import com.fang.mode.Info;

/**
 * 该类的实现是用来实现 对udp通信的回调实现 管理整个udp连接的生命周期
 * 
 * @author fang
 *
 */
public class ServerLifecycler implements ServerLifeCyclerCall {

	@Override
	public void onCreate(Device device) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<? extends Device> getAllDevice() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onReceiver(Device device, Info info) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onNewDevice(Device device) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onDeviceBack(Device device) {
		// TODO Auto-generated method stub

	}

}
