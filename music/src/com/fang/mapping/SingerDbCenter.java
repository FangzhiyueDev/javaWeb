package com.fang.mapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.Singer;

public class SingerDbCenter implements SingerOprate {

	@Override
	public List<Singer> getAllSinger() {
		   Connection connection =DbHelper.initDB();
		   PreparedStatement ps=null;
		   ResultSet resultSet=null;
		   List<Singer> singers=new ArrayList<>();
		   try {
			
			   ps=connection.prepareStatement("select *\n" + 
			   		"from singer");
			   resultSet=ps.executeQuery();
			   while(resultSet.next()) {
				   int id=resultSet.getInt(1);
				   String name=resultSet.getString(2);
				   String describute=resultSet.getString(3);
				   String image=resultSet.getString(4);
				   singers.add(new Singer(id, name, describute, image));
			   }
			   
			   
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return singers;
	}
	
	
	

}
