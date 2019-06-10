package com.fang.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fang.dao.DbHelper;
import com.fang.model.Video;
import com.fang.model.ReuniteModel.VideoClass;

public class VideoDbController implements VideoOpration {

	public static String VIDEO_TABLE = "video";

	private VideoDbController() {

	}

	/**
	 * 获得实例
	 * 
	 * @return
	 */
	public static VideoOpration getInstance() {

		if (vdc == null) {
			vdc = new VideoDbController();
		}
		return vdc;
	}

	private static VideoOpration vdc;

	/**
	 * 
	 */
	@Override
	public List<?> getAllVideo() {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection = DbHelper.initDB();
		List<Video> videos = new ArrayList<>();
		int count = 0;
		try {
			ps = connection.prepareStatement("select videoName," + "videoAddress,videoSize,uploadTime,videoNote,"
					+ "videoDestribute,authorid,class,classOrder from video order by classOrder asc");
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String videoName = resultSet.getString(1);
				String videoAddress = resultSet.getString(2);
				String videoSize = resultSet.getString(3);
				String uploadTime = resultSet.getString(4);
				String videoNote = resultSet.getString(5);
				String videoDestribute = resultSet.getString(6);
				int authorid = resultSet.getInt(7);
				String classfy = resultSet.getString(8);
				String classOrder = resultSet.getString(9);
				videos.add(new Video(videoName, videoAddress, videoSize, uploadTime, videoNote, videoDestribute,
						authorid, classfy, classOrder));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return videos;
	}

	@Override
	public List<?> getVideo(int startPage, int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection = DbHelper.initDB();
		List<Video> videos = new ArrayList<>();
		int count = 0;
		try {
			ps = connection.prepareStatement("select videoName," + "videoAddress,videoSize,uploadTime,videoNote,"
					+ "videoDestribute,authorid,class,classOrder from video limit" + startPage + "," + size);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String videoName = resultSet.getString(1);
				String videoAddress = resultSet.getString(2);
				String videoSize = resultSet.getString(3);
				String uploadTime = resultSet.getString(4);
				String videoNote = resultSet.getString(5);
				String videoDestribute = resultSet.getString(6);
				int authorid = resultSet.getInt(7);
				String classfy = resultSet.getString(8);
				String classOrder = resultSet.getString(9);
				videos.add(new Video(videoName, videoAddress, videoSize, uploadTime, videoNote, videoDestribute,
						authorid, classfy, classOrder));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return videos;
	}

	/**
	 * 查询最新的数据
	 */
	@Override
	public List<?> queryNowVideo(int size) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection = DbHelper.initDB();
		List<Video> videos = new ArrayList<>();
		int count = 0;
		try {
			ps = connection.prepareStatement("select videoName,videoAddress,videoSize,"
					+ "uploadTime,videoNote,videoDestribute,authorid,class,classOrder "
					+ "from video order by uploadTime desc limit " + size);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String videoName = resultSet.getString(1);
				String videoAddress = resultSet.getString(2);
				String videoSize = resultSet.getString(3);
				String uploadTime = resultSet.getString(4);
				String videoNote = resultSet.getString(5);
				String videoDestribute = resultSet.getString(6);
				int authorid = resultSet.getInt(7);
				String classfy = resultSet.getString(8);
				String classOrder = resultSet.getString(9);
				videos.add(new Video(videoName, videoAddress, videoSize, uploadTime, videoNote, videoDestribute,
						authorid, classfy, classOrder));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return videos;
	}

	@Override
	public int delVideo(Video video) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection = DbHelper.initDB();
		List<Video> videos = null;
		int count = 0;
		try {

			ps = connection.prepareStatement("delete from video where videoAddress =?");
			count = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return count;
	}

	@Override
	public Video queryVideoInfoByVideoAddress(String videoAddress) {
		Connection connection;
		PreparedStatement ps = null;
		Statement statement = null;
		ResultSet resultSet = null;
		connection = DbHelper.initDB();
		List<Video> videos = new ArrayList<>();
		int count = 0;

		System.out.println("当前的videoAddress=" + videoAddress);

		try {
			String sql = "select videoName,videoAddress,videoSize,uploadTime,"
					+ "videoNote,videoDestribute,authorid,class,classOrder from video where videoAddress = '"
					+ videoAddress + "'";
//			String sql="select videoName,videoAddress,videoSize,uploadTime,"
//					+ "videoNote,videoDestribute,authorid from video limit 1";
//			System.out.println(sql);
			ps = connection.prepareStatement(sql);
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String videoName = resultSet.getString(1);
				String videoAddress1 = resultSet.getString(2);
				String videoSize = resultSet.getString(3);
				String uploadTime = resultSet.getString(4);
				String videoNote = resultSet.getString(5);
				String videoDestribute = resultSet.getString(6);
				int authorid = resultSet.getInt(7);
				String classfy = resultSet.getString(8);
				String classOrder = resultSet.getString(9);
				videos.add(new Video(videoName, videoAddress, videoSize, uploadTime, videoNote, videoDestribute,
						authorid, classfy, classOrder));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return videos.get(0);
	}

	public List<VideoClass> queryVideoByClassfy() {
		Connection connection;
		PreparedStatement ps = null;
		Statement statement = null;
		ResultSet resultSet = null;
		connection = DbHelper.initDB();
		List<String> classInfos = this.videoClassfyInfo();
		List<VideoClass> videoClasses = new ArrayList<>();

		int count = 0;
		try {
			for (String classInfo : classInfos) {
				ps = connection.prepareStatement("select videoName,videoAddress,videoSize,uploadTime,"
						+ "videoNote,videoDestribute,authorid,class,classOrder from video where class=?");
				ps.setString(1, classInfo);
				resultSet = ps.executeQuery();
				List<Video> videos = new ArrayList<>();
				while (resultSet.next()) {
					String videoName = resultSet.getString(1);
					String videoAddress1 = resultSet.getString(2);
					String videoSize = resultSet.getString(3);
					String uploadTime = resultSet.getString(4);
					String videoNote = resultSet.getString(5);
					String videoDestribute = resultSet.getString(6);
					int authorid = resultSet.getInt(7);
					String classfy = resultSet.getString(8);
					String classOrder = resultSet.getString(9);
					videos.add(new Video(videoName, videoAddress1, videoSize, uploadTime, videoNote, videoDestribute,
							authorid, classfy, classOrder));
				}
				videoClasses.add(new VideoClass(videos, classInfo));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return videoClasses;
	}

	/**
	 * 查询文章的分类信息的显示
	 * 
	 * @return
	 */
	public List<String> videoClassfyInfo() {
		Connection connection;
		PreparedStatement ps = null;
		Statement statement = null;
		ResultSet resultSet = null;
		connection = DbHelper.initDB();
		List<String> classfys = new ArrayList<>();
		try {
			ps = connection.prepareStatement("select class from video group by class");
			resultSet = ps.executeQuery();
			while (resultSet.next()) {
				String singleClass = resultSet.getString(1);
				classfys.add(singleClass);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return classfys;
	}

}
