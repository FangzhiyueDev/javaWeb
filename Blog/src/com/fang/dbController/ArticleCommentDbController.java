package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.Article;
import com.fang.model.ArticleComment;
import com.fang.model.User;
import com.fang.model.Video;
import com.fang.model.ReuniteModel.UserCommentArticle;

public class ArticleCommentDbController implements ArticleCommentOpration{

private static ArticleCommentOpration aco=null;
	
	private ArticleCommentDbController() {
		
	}
	
	public static ArticleCommentOpration getInstance() {
		if(aco==null) {
			aco=new ArticleCommentDbController();
		}
		return aco;
	}


	@Override
	public int delArticleComment(ArticleComment articleComment) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * useridInt, content, -1, time, commentTime
	 */
	@Override
	public int addArticleComment(ArticleComment articleComment) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		int index;
		try {
			ps=connection.prepareStatement("insert into articleComment(content,articlePublishTime,commentTime,userid)"
					+ " values(?,?,?,?)");
			ps.setString(1, articleComment.getContent());
			ps.setString(2, articleComment.getArticlePublishTime());
			ps.setString(3, articleComment.getCommentTime());
			ps.setInt(4, articleComment.getUserid());
			index=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			index=-1;
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return index;
	}

	@Override
	public int updateArticleComment(ArticleComment articleComment) {

		

		return 0;
	}

	@Override
	public int delAllArticleComment(ArticleComment articleComment) {
	
		return 0;
	}

	
	/**
	 * 获得文章的评论，通过指定大小
	 * 获得的是文章评论内容以及用户的相关信息
	 */
	@Override
	public List<? extends User> queryNowComment(int size,ArticleComment articleComment) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<UserCommentArticle> ucas = new ArrayList<>();
		int count = 0;
		try {
			ps=connection.prepareStatement("select user.picture,user.userid,"
					+ "user.name,articleComment.content,"
					+ "articleComment.commentTime" 
					+ " from user join articleComment on user.userid=articleComment.userid"
					+ " where articlePublishTime=?"  
					+ " order by articleComment.commentTime desc" 
					+ " limit ?");
			ps.setString(1,articleComment.getArticlePublishTime());
			ps.setInt(2, size);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String picture=resultSet.getString(1);
				int userid=resultSet.getInt(2);
				String name=resultSet.getString(3);
				String content=resultSet.getString(4);
				String commentTime=resultSet.getString(5);
				ucas.add(new UserCommentArticle(picture, userid, name, content, commentTime));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return ucas;
	}

	

}
