package com.fang.threadOprate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.Vector;

import com.fang.mode.Device;

/**
 * 该类是
 * @author fang
 *
 */
public class ThreadWrapper extends Thread {
	
	private boolean isRun=true;
	
	private Vector<Device> devices=new Vector<Device>();
	
	private DatagramSocket socket;
	
	/**
	 * 定义了系统启动的端口
	 */
	public static final int PORT=8888;
	
	/**
	 * 用来向节点进行输出
	 */
	private ByteArrayOutputStream bo;
	

	
	public ThreadWrapper() throws SocketException {
		// TODO Auto-generated constructor stub
		this("serverThread");
	}
	
	public ThreadWrapper(String name) throws SocketException{
		super(name);
		/**
		 * 用于建立起服务端连接的通信实现
		 */
		socket=new DatagramSocket(PORT);
	}
	

	
	@Override
	public void run() {
		while(isRun) {
				//当前的程序是整个程序的核心入口
			byte[] buf=new byte[1024];
		DatagramPacket dp=new DatagramPacket(buf, buf.length);
		try {
			socket.receive(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		socket.getInetAddress();
		System.out.println("接收到网络请求");
		
		
			
			
			
			
			
		}	
	}
	
	private void stopLoop() {
		isRun=false;
	}
	
}
