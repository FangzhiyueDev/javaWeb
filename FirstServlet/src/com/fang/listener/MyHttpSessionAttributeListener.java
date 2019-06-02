package com.fang.listener;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * 这个是Session 相关的属性被移除的时候调用
 * 
 * @author fang
 *
 */
public class MyHttpSessionAttributeListener implements HttpSessionAttributeListener {

	/**
	 * 当属性被添加的时候调用
	 */
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * 当属性被移除的时候调用
	 */
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

	/**
	 * 当属性被替代的时候调用
	 */
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// TODO Auto-generated method stub

	}

}
