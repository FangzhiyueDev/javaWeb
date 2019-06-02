package com.fang.server;

import java.net.SocketException;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.fang.mode.Device;
import com.fang.threadOprate.ThreadWrapper;

public class Server {

	
	
	private Server() {}
	
	public static Server getInstance() {
		return ServerHolder.sInstance;
	}
	
	
	/**
	 * 使用静态内部类实现单例模式
	 * @author fang
	 *
	 */
	private static class ServerHolder{
		private static final Server sInstance=new Server();
	}

	public static Vector<Device> devices=new Vector<Device>();
		
	
	public void start() {
		
	}
	
	
	public static void main(String[] args) throws SocketException {
		// TODO Auto-generated method stub
	    new ThreadWrapper().start();
	}
}
