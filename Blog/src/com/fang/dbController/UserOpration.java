package com.fang.dbController;

import java.util.List;

import com.fang.model.User;

public interface UserOpration {
	
	/**
	 * 查询用户的详细信息
	 * @param user
	 * @return
	 */
	User queryUserInfo(User user);
	
	/**
	 * 验证登录，也就是查询数据库中是否存在这个与之相对应的用户名和密码
	 * @param user
	 * @return
	 */
	boolean validateLogin(User user);

	/**
	 * 验证注册
	 * @param user
	 * @return
	 */
	boolean validateRegister(User user);
  /**
   * 注册一个用户
   * @param user
   */
	boolean registerUser(User user);
    /**
     * 查询用户的信息，通过文章的发布时间来获得文章发布者的用户名称信息
     * @param articlePublishTime
     * @return
     */
    String queryUserInfo(String articlePublishTime);

    /**
     * 查询系统管理员的相关信息
     * @param size
     * @return
     */
	List<User> queryManagerUserInfo(int size);

	/**
	 * 更新用户的信息通过用户的id
	 * @param user
	 * @return
	 */
	boolean updateUserInfoByUserid(User user);


	
	
	
}
