package com.fang.tool;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间的操作对象
 * @author fang
 *
 */
public class DateTool {
	
	

	public static void main(String[] args) {
		
			System.out.println(getCurrentDateAndTime());
	}
	
	
  
	/*
	 * 月份的天数，在这里我们不去考虑闰年还是平年
	 */
	public static int  monthCount[]= {31,28,31,30,31,30,31,31,30,31,30,31};
	
	public static float getCurrentMonthCount() {
		Date date=new Date();
		return monthCount[date.getMonth()];
	}
	
	/**
	 * 获得当前的day相对于月份来说
	 * @return
	 */
	public static float getCurrentDayByMonth() {
		Date date=new Date();
		return date.getDate();
	}
	
	
	/**
	 * 获得当前的日期和时间
	 * 返回的格式如下  201811131446
	 * 这个格式用于数据的存储
	 * @return
	 */
	public static String getCurrentDateAndTime() {
		Date date=new Date();
       SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmm");
		return  sdf.format(date);
	}
	
	/**
	 * 获得当前的时间，参数是没有作用的，只是方法重载的需要
	 * 返回的数据是我们需要进行显示的格式
	 * @param Null
	 * @return
	 */
	public static String formatDataAndTime(String articlePublishTime) {
		String year=articlePublishTime.substring(0, 4);
		String month=articlePublishTime.substring(4,6);
		String day=articlePublishTime.substring(6,8);
		String hour=articlePublishTime.substring(8,10);
		String minute=articlePublishTime.substring(10,12);
			String value=String.format("%s-%s-%s %s:%s", year,month,day,hour,minute);
			return  value;
	}
	
	
	
	
	
}
