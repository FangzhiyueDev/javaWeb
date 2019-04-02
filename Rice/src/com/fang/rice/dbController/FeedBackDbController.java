package com.fang.rice.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.rice.dbHelper.DbHelper;
import com.fang.rice.model.Card;
import com.fang.rice.model.FeedBack;

public class FeedBackDbController {

	
	
	public boolean insert(FeedBack feedBack) {
		
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
	    boolean isSucessful = true;
		try {
			
			
			ps=connection.prepareStatement("insert INTo feedback(user, content)\n" + 
					"VALUES (?, ?)");
			ps.setString(1, feedBack.getUser());
			ps.setString(2, feedBack.getContent());
		
			isSucessful=ps.executeUpdate()!=-1?true:false;
			
		}catch (Exception e) {
			e.printStackTrace();
			isSucessful=false;
		}
		return isSucessful;
	}
	
	
	
}
