package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.Log;
import com.fang.model.Proverb;

public class LogDbController  implements LogOpration{

	private  LogDbController() {
		
	}
	
	private static LogOpration lo=null;
	
	public static LogOpration getInstance() {
		if(lo==null) {
			lo=new LogDbController();
		}
		return lo;	
	}
	
	
	@Override
	public int delLog(Log log) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addLog(Log log) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> getLogcatBySize(int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Log> logs =new ArrayList<>();
		try {
			ps=connection.prepareStatement("select logTime,content from log order by logTime desc limit ?");
			ps.setInt(1, size);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String logTime=resultSet.getString(1);
				String content=resultSet.getString(2);
				logs.add(new Log(logTime, -1, content,-1));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return logs;
	}

}
