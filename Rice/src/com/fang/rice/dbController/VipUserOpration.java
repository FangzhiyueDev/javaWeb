package com.fang.rice.dbController;

import javax.jws.soap.SOAPBinding.Use;

import com.fang.rice.model.User;

/**
 * vip用户的处理类
 * @author fang
 *
 */
public interface VipUserOpration {

	boolean addVIP(User user);
	
	boolean cancelVIP(User user);
	
	boolean isVIP(User user);
	
	
}
