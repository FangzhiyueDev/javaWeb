package com.fang.model.ReuniteModel;

import com.fang.model.LeaveMessage;
import com.fang.model.User;

public class LeaveMessageUser extends User {
	
	
	private LeaveMessage leaveMessage;
	

	public LeaveMessageUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveMessageUser(int userid, String password) {
		super(userid, password);
		// TODO Auto-generated constructor stub
	}

	public LeaveMessageUser(String name, String qqNumber, String occupation, String hobby, String likeSinger,
			String likeMusic, String motto, int userid, String picture, String password, String nikeName) {
		super(name, qqNumber, occupation, hobby, likeSinger, likeMusic, motto, userid, picture, password, nikeName);
		// TODO Auto-generated constructor stub
	}
	
	public LeaveMessageUser(int userid,String userName,String picture,LeaveMessage leaveMessage) {
		super(userName,userid,picture);
		this.leaveMessage=leaveMessage;
	}
	

}
