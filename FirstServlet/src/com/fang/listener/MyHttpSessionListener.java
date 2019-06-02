package com.fang.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 
 * HttpSession的监听
 * 
 * 也就是我们对session做一些存储操作 当销毁之后的具体操作应该使用下面的监听器来操作
 * 
 * 可以 避免一些错误
 * 
 * 
 * 
 * 
 * @author fang
 *
 */
public class MyHttpSessionListener implements HttpSessionListener {

	/**
	 * 在session被创建之后做的事情
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

	/**
	 * 在session被销毁的时候的事情 例子
	 * 
	 * 有些网站没了避免用户重复登录，会在数据库中存放某一个字段代表用户时候登录 用户登录过后，设置该字段 用户点击注销操作时 ，重置该字段 ，
	 *
	 * 但是如果用户在注销之前不小心关闭了浏览器 ，那么就不会运行注销相关的操作code，数据库中的字段就不会重置
	 *
	 * 使用session的sessionDestroyed 监听方法，在session被销毁的时候，就执行数据库的登录重置，
	 *
	 * 就可以保证数据库的字段和用户自身的登录状态保持一致
	 * 
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub

	}

}
