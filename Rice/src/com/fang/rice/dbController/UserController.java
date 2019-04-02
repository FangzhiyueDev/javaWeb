package com.fang.rice.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


import com.fang.rice.dbHelper.DbHelper;
import com.fang.rice.model.User;


public class UserController implements UserOpration {

	
//	private static UserOpration uo;
//	
//	public static UserOpration GetInstance() {
//		if(uo==null) {
//			uo=new UserController();
//		}
//		return uo;
//	}
//	
	
	@Override
	public boolean addUser(User user) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
	    boolean isSucessful = true;
		try {
			ps=connection.prepareStatement("insert into User(telNumber,password) values(?,?)");
			ps.setString(1,user.getTelNumber());
			ps.setString(2, user.getPassword());
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			isSucessful=false;
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return isSucessful;
	}

	@Override
	public boolean isExistUser(User user) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		boolean isExist=false;
	    try {
	    	ps=connection.prepareStatement("select count(*) from User where telNumber=?");
	    	ps.setString(1, user.getTelNumber());
	    	resultSet=ps.executeQuery();
	    	while(resultSet.next()) {
	    		isExist=resultSet.getInt(1)==0?false:true;
	    	}
	    }catch (Exception e) {
	    	e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return isExist;
	}


	/**
	 * 用于实现验证登录
	 */
	@Override
	public boolean verificationLogin(User user) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		boolean isExist=false;
		  try {
		    	ps=connection.prepareStatement("select count(*) from User where telNumber=? and password=?");
		    	ps.setString(1, user.getTelNumber());
		    	ps.setString(2, user.getPassword());
		    	resultSet=ps.executeQuery();
		    	while(resultSet.next()) {
		    		isExist=resultSet.getInt(1)==0?false:true;
		    	}
		  }catch (Exception e) {
			// TODO: handle exception
			  isExist=false;
			  e.printStackTrace();
		}finally {
			  DbHelper.closeDb(connection, ps, resultSet);
		}
		return isExist;
	}

    /**
     * 更新用户的登录状态
     */
	@Override
	public boolean changeUserLoginStatus(User user) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		boolean isSucessful=true;
		  try {
			  ps=connection.prepareStatement("update User set loginStatus=false where telNumber=?");
			  ps.setString(1, user.getTelNumber());
			  ps.executeUpdate();
		  }catch(Exception e) {
			  e.printStackTrace();
			  isSucessful=false;
		  }finally {
			  DbHelper.closeDb(connection, ps, resultSet);
		  }
		return isSucessful;
	}


	/**
	 * 查询用户浏览数据的状态
	 */
	@Override
	public boolean queryUserBrowserStatus(String userId) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		boolean browserStatus=true;
		try {
			ps=connection.prepareStatement("select browserStatus\n" + 
					"from User\n" + 
					"where telNumber = ?");
			ps.setString(1, userId);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				browserStatus=resultSet.getBoolean(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
			browserStatus=false;
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return browserStatus;
	}

   
	/**
	 * 更改用户的浏览状态
	 */
	@Override
	public boolean changeUserBrowserStatus(User user) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		boolean isSucessful=true;
		try {
			ps=connection.prepareStatement("update User\n" + 
					"set User.browserStatus = true\n" + 
					"where telNumber = ?");
			ps.setString(1, user.getTelNumber());
			ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			isSucessful=false;
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return isSucessful;
	}
	
	
	
	
	

}
