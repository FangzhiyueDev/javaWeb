package com.fang.rice.server;

public class DataBackAnalysis {
	
	public static final float CALL_TIME_RATE=0.4f;
	public static final float FLOW_TIME_RATE=0.6F;
	
	/**
	 * 返回一个数组,里面存放的是起始的通话时间
	 * 和结束的通话时间的取值范围
	 * @param callTime
	 * @return
	 */
	public static  int[] callTimeRange(int callTime) {
		float startTime=callTime*CALL_TIME_RATE;
		float endTime =callTime+callTime*CALL_TIME_RATE;
		int[] value=new int[2];
		value[0]=(int) startTime;
		value[1]=(int) endTime;
		return value;
	}
	
	public static  int[] flowTimeRange(int flowTime) {
		float startTime=flowTime*FLOW_TIME_RATE;
		float endTime =flowTime+flowTime*FLOW_TIME_RATE;
		int[] value=new int[2];
		value[0]=(int) startTime;
		value[1]=(int) endTime;
		return value;
	}
	
	

}
