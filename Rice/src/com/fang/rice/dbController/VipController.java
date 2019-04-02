package com.fang.rice.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.fang.rice.dbHelper.DbHelper;
import com.fang.rice.model.User;

/**
 * vip用户的数据库处理中心
 * @author fang
 *
 */
public class VipController implements VipUserOpration {
	
	
//	private VipController() {
//		
//	}
//	
//	private static VipUserOpration vipUser;
//	
//	public static VipUserOpration getInstance() {
//		if(vipUser==null) {
//			vipUser=new VipController();
//		}
//		return vipUser;
//	}
//	
	

	@Override
	public boolean addVIP(User user) {
		
		return false;
	}

	/**
	 * 
	 */
	@Override
	public boolean cancelVIP(User user) {
		
		return false;
	}

	@Override
	public boolean isVIP(User user) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
	    boolean isSucessful = true;
		try {
			ps=connection.prepareStatement("select count(*) from vip where telNumber=?");
			ps.setString(1, user.getTelNumber());
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				isSucessful=resultSet.getInt(1)==0?false:true;
			}
		}catch(Exception e) {
			e.printStackTrace();
			isSucessful=false;
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
;		}
		return isSucessful;
	}
	
	
}
