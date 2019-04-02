package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.Link;
import com.fang.model.Log;

public class LinkDbController  implements LinkOpration{
	
	
   private  LinkDbController() {
		
	}
	
	public static LinkOpration lo;
	
	/**
	 * 实现单例模式
	 * @return
	 */
	public static LinkOpration GetInstance() {
		if(lo==null) {
			lo=new LinkDbController();
		}
		return lo;
	
	}
	

	@Override
	public int addLink(Link link) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delLink(Link link) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<?> getListBySize(int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Link> links =new ArrayList<>();
		try {
			ps=connection.prepareStatement("select linkAddress,content from link order by linkid desc limit ?");
			ps.setInt(1, size);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String linkAddress=resultSet.getString(1);
				String content=resultSet.getString(2);
				links.add(new Link(linkAddress, -1, -1, content));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return links;
	}
	

}
