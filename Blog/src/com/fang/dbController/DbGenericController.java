package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.Proverb;

public class DbGenericController implements DbGeneric{

	
	private  DbGenericController() {
		// TODO Auto-generated constructor stub
	}
	
	private static DbGeneric dbgeneric;
	
	public static DbGeneric getInstance() {
		if(dbgeneric==null) {
			dbgeneric=new DbGenericController();
		}
		return dbgeneric;
	}
	
	
	
	@Override
	public int getResultCount(String table) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Proverb> proverbs = null;
		int count = 0;
		try {
			ps=connection.prepareStatement("select count(*) from "+table);
			resultSet=resultSet=ps.executeQuery();
			while(resultSet.next()) {
				count=resultSet.getInt(1);
			}
		}catch (Exception e) {
		e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return count;
	}

}
