package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.Video;
import com.fang.model.VideoComment;

/**
 * 文章的评论相关的控制
 * @author fang
 *
 */
public class VideoCommentDbController implements VideoCommentOpration {

	private static VideoCommentOpration vco;
	
	public static VideoCommentOpration getInstance() {
		if(vco==null) {
			vco=new VideoCommentDbController();
		}
		return vco;
	}
	
	private VideoCommentDbController() {
	
	}
	
	
	
	
	/**
	 * 用来查询特定文章的评论，
	 * 如果我们想查找最近的评论，直接设置0 ，size填写查找的大小
	 */
	@Override
	public List<?> queryPageVideoComment(int page, int size, VideoComment videoComment) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<VideoComment> videoComments = new ArrayList<>();
		int count = 0;
		try {
			ps=connection.prepareStatement("select videoCommentid,userid,"
					+ "videoAddress,content,commentTime from videoComment where videoAddress =?"
					+ " order by videoCommentid desc"
					+ " limit ?,?");
			ps.setString(1, videoComment.getVideoAddress());
			ps.setInt(2, page);
			ps.setInt(3, size);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
			   	int videoCommentid=resultSet.getInt(1);
			   	int userid=resultSet.getInt(2);
			   	String videoAddress=resultSet.getString(3);
			   	String content=resultSet.getString(4);
			   	String commentTime=resultSet.getString(5);
				videoComments.add(new VideoComment(videoCommentid, 
						userid, videoAddress, content,commentTime));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return videoComments;
	}

	@Override
	public int queryVideoCommentCount(VideoComment videoComment) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<VideoComment> videoComments = new ArrayList<>();
		int count = 0;
		try {
			ps=connection.prepareStatement("select count(*) from videoComment where videoAddress=?");
			ps.setString(1, videoComment.getVideoAddress());
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				count=resultSet.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return count;
	}

	@Override
	public int addNowVideoCommnet(VideoComment videoComment) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<VideoComment> videoComments = new ArrayList<>();
		int index = 0;
		try {
			ps=connection.prepareStatement("insert into videoComment("
					+ "userid,videoAddress,content,commentTime) values(?,?,?,?)");
			ps.setInt(1, videoComment.getUserid());
			ps.setString(2, videoComment.getVideoAddress());
			ps.setString(3, videoComment.getContent());
			ps.setString(4, videoComment.getCommentTime());
			index=ps.executeUpdate();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return index;
	}
	
	
	
}
