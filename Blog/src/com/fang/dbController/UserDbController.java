package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.User;
import com.fang.model.Video;

public class UserDbController implements UserOpration {
	
	
	private static UserOpration udc;
	
	private  UserDbController() {
	
	}
	
	public static UserOpration getInstance() {
		if(udc==null) {
			udc=new UserDbController();
		}
		return udc;
	}
	
	

	@Override
	public User queryUserInfo(User user) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		int count = 0;
		try {
			ps=connection.prepareStatement("select name,qqNumber,occupation,hobby,"
					+ "likeSinger,likeMusic,motto,userid,picture,password,nikeName"
					+ " from user where userid=?");
			ps.setInt(1, user.getUserid());
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String name=resultSet.getString(1);
				String qqNumber=resultSet.getString(2);
				String occupation=resultSet.getString(3);
				String hobby=resultSet.getString(4);
				String likeSinger=resultSet.getString(5);
				String likeMusic=resultSet.getString(6);
				String motto=resultSet.getString(7);
				int userid=resultSet.getInt(8);
				String picture=resultSet.getString(9);
				String password=resultSet.getString(10);
				String nikeName=resultSet.getString(11);
			user=new User(name, qqNumber, occupation, hobby, 
					likeSinger, likeMusic, motto, userid, 
					picture, password, nikeName);		
			}
		} catch (Exception e) {
		   e.printStackTrace();
		}finally {
		DbHelper.closeDb(connection, ps, resultSet);
		}
		return user;
	}

	@Override
	public boolean validateLogin(User user) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		boolean exist = false;
		int count=0;
		try {
			ps=connection.prepareStatement("select count(*) from user where userid=? and password=?");
			ps.setInt(1, user.getUserid());
			ps.setString(2, user.getPassword());
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				count=resultSet.getInt(1);
			}
			if(count>0) {
				exist=true;
			}else {
				exist=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return exist;
	}

	@Override
	public boolean validateRegister(User user) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		boolean exist = false;
		int count=0;
		try {
			ps=connection.prepareStatement("select count(*) from user where userid=?");
			ps.setInt(1, user.getUserid());
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				count=resultSet.getInt(1);
			}
			if(count>0) {
				exist=true;
			}else {
				exist=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return exist;
	}

	@Override
	public boolean registerUser(User user) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		boolean sucessful = true;
		try {
			ps=connection.prepareStatement("insert into user(name,nikeName,password,picture,userid)"
					+ " values(?,?,?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getName());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getPicture());
			ps.setInt(5, user.getUserid());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			sucessful=false;
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return sucessful;
	}
   
	@Override
	public String queryUserInfo(String articlePublishTime) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
	    String name = null;
		
		try {
			ps=connection.prepareStatement("select name from user where userid in" + 
					" (select userid from manager where authorid in" + 
					" (select authorid from article where articlePublishTime=?))");
			ps.setString(1, articlePublishTime);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				name=resultSet.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return name;
	}

	@Override
	public List<User> queryManagerUserInfo(int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<User> users=new ArrayList<>();
		try {
			ps=connection.prepareStatement("select user.name,user.qqNumber,user.occupation,user.hobby," + 
					"user.likeSinger,user.likeMusic,user.motto from manager left join user"
					+" on manager.userid = user.userid"
					+" limit ?");
			ps.setInt(1, size);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String name=resultSet.getString(1);
				String qqNumber=resultSet.getString(2);
				String occupation=resultSet.getString(3);
				String hobby=resultSet.getString(4);
				String likeSinger=resultSet.getString(5);
				String likeMusic=resultSet.getString(6);
				String motto=resultSet.getString(7);
				users.add(new User(name, qqNumber, occupation, hobby, likeSinger, likeMusic, motto, 0, "", "",""));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return users;
	}
	
	
	
	@Override
	public boolean updateUserInfoByUserid(User user) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		boolean isSucessful=true;
		List<User> users=new ArrayList<>();
		try {
			ps=connection.prepareStatement("update user " + 
					"set name       = ?," + 
					"    qqNumber   = ?," + 
					"    occupation = ?," + 
					"    hobby      = ?," + 
					"    likeSinger = ?," + 
					"    likeMusic  = ?," + 
					"    motto      = ?" + 
					"where userid = ?");
			ps.setString(1, user.getName());
			ps.setString(2,user.getQqNumber());
			ps.setString(3, user.getOccupation());
			ps.setString(4, user.getHobby());
			ps.setString(5, user.getLikeSinger());
			ps.setString(6, user.getLikeMusic());
			ps.setString(6, user.getMotto());
			ps.setInt(8, user.getUserid());
			ps.executeUpdate();
		}catch(Exception e) {
			isSucessful=false;
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return isSucessful;
	}

}
