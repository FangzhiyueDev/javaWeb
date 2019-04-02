package com.fang.rice.dbController;

import com.fang.rice.model.User;

public interface UserOpration {
	
	public boolean addUser(User user);
	
	public boolean isExistUser(User user);
	
	public boolean verificationLogin(User user);
	
	public boolean changeUserLoginStatus(User user);

	/**
	 * 查询用户的浏览状态
	 * @param userId
	 * @return 
	 */
	public boolean queryUserBrowserStatus(String userId);
   /**
    * 查询用户的浏览数据的
    * @param user
    * @return
    */
	public boolean changeUserBrowserStatus(User user);
	

}
