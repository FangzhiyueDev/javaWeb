package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.Article;
import com.fang.model.ReadRecords;
import com.fang.model.ReuniteModel.ArticleCorrespondReadCount;

public class ReadRecordDbController implements ReadRecordOpration {

private static ReadRecordOpration rro=null;
	
	private ReadRecordDbController() {
		
	}
	
	public static ReadRecordOpration getInstance() {
		if(rro==null) {
			rro=new ReadRecordDbController();
		}
		return rro;
	}
	
	@Override
	public List<ArticleCorrespondReadCount> getReadRecords(int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		/**
select articlePublishTime,count(articlePublishTime) 
from readRecords 
group by articlePublishTime
limit 6;
		 */
		List<ArticleCorrespondReadCount> readCounts=new ArrayList<>();
		try {
			ps=connection.prepareStatement("select articlePublishTime,count(articlePublishTime)"
					+ " from readRecords"
					+ " group by articlePublishTime"
					+ " order by count(articlePublishTime) desc"
					+ "	limit ?");
			ps.setInt(1, size);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String articlePublishTime=resultSet.getString(1);
				int count=resultSet.getInt(2);
				//文章名称为空
				readCounts.add(new ArticleCorrespondReadCount(null, articlePublishTime, count));
			}
		}catch(Exception e) {
			e.printStackTrace();
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return readCounts;
	}
    
	
	@Override
	public int getSpecifiedArticleReadCount(Article article) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		int count=0;
		try {
			ps=connection.prepareStatement("select count(articlePublishTime) from readRecords where articlePublishTime=? group by articlePublishTime");
			ps.setString(1, article.getArticlePublishTime());
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				count=resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return count;
	}
    
	
	@Override
	public boolean addReadRecord(ReadRecords readRecords) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		boolean isSusessful=true;
		connection=DbHelper.initDB();
		int count=0;
		try {
			ps=connection.prepareStatement("insert into readRecords(userid,articlePublishTime) values(?,?)");
			ps.setInt(1, readRecords.getUserid());
			ps.setString(2, readRecords.getArticlepublishTime());
			count=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			isSusessful=false;
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return isSusessful;
	}
	
	
	

}
