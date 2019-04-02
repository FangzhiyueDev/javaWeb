package com.fang.model.ReuniteModel;

import com.fang.model.ResponseResult;
import com.fang.model.User;

/**
 * 用户登录状态的复合bean
 * @author fang
 *
 */
public class UserLoginStatus {
  
	private ResponseResult responseResult;
	private User user;
	public ResponseResult getResponseResult() {
		return responseResult;
	}
	public void setResponseResult(ResponseResult responseResult) {
		this.responseResult = responseResult;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserLoginStatus [responseResult=" + responseResult + ", user=" + user + "]";
	}
	public UserLoginStatus(ResponseResult responseResult, User user) {
		this.responseResult = responseResult;
		this.user = user;
	}
	
	public UserLoginStatus() {
	
	}
	
}
