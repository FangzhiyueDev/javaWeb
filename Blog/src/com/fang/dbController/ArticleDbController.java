package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.Article;
import com.fang.model.Author;
import com.fang.model.User;
import com.fang.model.Video;
import com.fang.model.ReuniteModel.ArticleClass;
import com.fang.model.ReuniteModel.ArticleUser;

/**
 * 文档的数据控制类
 * @author fang
 *
 */
public class ArticleDbController implements ArticleOpration{

	private static ArticleDbController adc=null;
	
	private ArticleDbController() {
		
	}
	
	public static ArticleDbController getInstance() {
		if(adc==null) {
			adc=new ArticleDbController();
		}
		return adc;
	}

	@Override
	public int addArticle(Article article) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Video> videos = null;
		int count = 0;
		try {
			ps=connection.prepareStatement("insert into article(articleDestribute,"
					+ "articleName,articlePublishTime,authorid) values(?,?,?,?)");
			ps.setString(1, article.getArticleDestribute());
			ps.setString(2,article.getArticleName());
			ps.setString(3, article.getArticlePublishTime());
			ps.setInt(4, article.getAuthorid());
			count=ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return count;
	}

	@Override
	public List<?> queryAllArticle() {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Video> videos = null;
		int count = 0;
		try {
			ps=connection.prepareStatement("select articleDestribute,articleName,articlePublishTime,authorid,class from article");
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			
			
		}
	
		return null;
	}

	@Override
	public List<?> queryArticleByPage(int startPage, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delArticle(Article article) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delAllArticle() {
		
		return 0;
	}

	@Override
	public int updateArticle(Article article) {
		
		
		
		return 0;
	}

	/**
	 * 查询特定文章的详细信息
	 */
	@Override
	public Article queryArticleDetailInfo(Article article) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		int count = 0;
		try {
			ps=connection.prepareStatement("select articleDestribute,articleName,"
					+ "articlePublishTime,authorid,class,articlePictureAddress,articleAddress from article where"
					+ " articlePublishTime=?");
			ps.setString(1, article.getArticlePublishTime());
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String articleDestribute=resultSet.getString(1);
				String articleName=resultSet.getString(2);
				String articlePublishTime=resultSet.getString(3);
				int authorid=resultSet.getInt(4);
				String className=resultSet.getString(5);
				String articlePictureAddress=resultSet.getString(6);
				String articleAddress=resultSet.getString(7);
				article=new Article(articleDestribute, articleName, articlePublishTime, authorid,articleAddress,className,articlePictureAddress);
			}
	}catch (Exception e) {
		e.printStackTrace();
	}finally {
		DbHelper.closeDb(connection, ps, resultSet);
	}
		return article;
	}

	@Override
	public List<?> queryNowArticle(int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Article> articles = new ArrayList<>();
		int count = 0;
		try {
			ps=connection.prepareStatement("select articleDestribute,articleName,"
					+ "articlePublishTime,authorid,class,articlePictureAddress,articleAddress from article order by articlePublishTime desc limit "+size);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String articleDestribute=resultSet.getString(1);
				String articleName=resultSet.getString(2);
				String articlePublishTime=resultSet.getString(3);
				int authorid=resultSet.getInt(4);
				String className=resultSet.getString(5);
				String articlePictureAddress=resultSet.getString(6);
				String articleAddress=resultSet.getString(7);
				articles.add(new Article(articleDestribute, articleName, articlePublishTime, authorid,articleAddress,className,articlePictureAddress));
			}
	}catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}finally {
		DbHelper.closeDb(connection, ps, resultSet);
	}
	return articles;	
	}

	@Override
	public List<String> queryAllArticleClassfy() {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<String> classfyList = new ArrayList<>();
		int count = 0;
		try {
			ps=connection.prepareStatement("select class from article group by class");
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String classfy=resultSet.getString(1);
				classfyList.add(classfy);	
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return classfyList;
	}

	@Override
	public List<?> queryArticleByClass(String classfy) {
		
		return null;
	}

	@Override
	public List<?> queryArticleByClass() {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<String> classfyList=queryAllArticleClassfy();
		List<ArticleClass> articleClasses = null;	
		try {
			articleClasses=new ArrayList<>();
			for(String classfy:classfyList) {
				List<Article> articles=new ArrayList<>();
				ps=connection.prepareStatement("select articleDestribute,articleName,"
						+ "articlePublishTime,authorid,class,articlePictureAddress from article"
						+ " where class like '%"+classfy+"%'"
						+ " order by articlePublishTime desc"
						+ " limit 6");
				//ps.setString(1, classfy);
				resultSet= ps.executeQuery();
				while(resultSet.next()) {
					String articleDestribute=resultSet.getString(1);
					String articleName=resultSet.getString(2);
					String articlePublishTime=resultSet.getString(3);
					int authorid=resultSet.getInt(4);
					String className=resultSet.getString(5);
					String articlePictureAddress=resultSet.getString(6);
					articles.add(new Article(articleDestribute, articleName, articlePublishTime, authorid,null,className,articlePictureAddress));
				}
				articleClasses.add(new ArticleClass(classfy, articles));
			}
		}catch(Exception e) {
			e.printStackTrace();
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return articleClasses;
	}

	
	@Override
	public List<?> queryArticleByTimeBefore(String articlePublishTime, int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Article> articles = new ArrayList<>();	
		try {
			ps=connection.prepareStatement("select articleDestribute,articleName,"
					+ "articlePublishTime,authorid,class,articlePictureAddress,articleAddress"
					+ " from article where articlePublishTime < ? limit ?");
			ps.setString(1, articlePublishTime);
			ps.setInt(2, size);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String articleDestribute=resultSet.getString(1);
				String articleName=resultSet.getString(2);
				String time=resultSet.getString(3);
				int authorid=resultSet.getInt(4);
				String className=resultSet.getString(5);
				String articlePictureAddress=resultSet.getString(6);
				String articleAddress=resultSet.getString(7);
				
				articles.add(new Article(articleDestribute, articleName, time, authorid, articleAddress, className, articlePictureAddress));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return articles;
	}

	@Override
	public List<?> queryArticleByTimeAfter(String articlePublishTime, int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Article> articles = new ArrayList<>();	
		try {
			ps=connection.prepareStatement("select articleDestribute,articleName,"
					+ "articlePublishTime,authorid,class,articlePictureAddress,articleAddress"
					+ " from article where articlePublishTime > ? limit ?");
			ps.setString(1, articlePublishTime);
			ps.setInt(2, size);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String articleDestribute=resultSet.getString(1);
				String articleName=resultSet.getString(2);
				String time=resultSet.getString(3);
				int authorid=resultSet.getInt(4);
				String className=resultSet.getString(5);
				String articlePictureAddress=resultSet.getString(6);
				String articleAddress=resultSet.getString(7);
				articles.add(new Article(articleDestribute, articleName, time, authorid, articleAddress, className, articlePictureAddress));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return articles;
	}

	@Override
	public List<?> queryNowArticleAndUserInfo(int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<ArticleUser> articleUsers = new ArrayList<>();	
		try {
			ps=connection.prepareStatement("select  user.name,user.userid,user.picture," + 
					"article.articleDestribute,article.articleName,article.articlePublishTime," + 
					"article.authorid,article.articleAddress,article.class,article.articlePictureAddress" + 
					" from article join manager on article.authorid=manager.authorid" + 
					" join user on manager.userid=user.userid");
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String name=resultSet.getString(1);
				int userid=resultSet.getInt(2);
				String picture=resultSet.getString(3);
				String articleDestribute=resultSet.getString(4);
				String articleName=resultSet.getString(5);
				String articlePublishTime=resultSet.getString(6);
				int authorid=resultSet.getInt(7);
				String articleAddress=resultSet.getString(8);
				String classfy=resultSet.getString(9);
				String articlePictureAddress=resultSet.getString(10);
				
				articleUsers.add(
						new ArticleUser(
								new User(name, userid, picture),
								new Article(articleDestribute, articleName,
										articlePublishTime, authorid, 
										articleAddress, classfy,
										articlePictureAddress)));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return articleUsers;
	}
	
	
	
	
	
	
	
	
	
}
