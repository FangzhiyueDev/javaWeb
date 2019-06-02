package com.fang.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "https://hongcai.163.com/api/site/v1/getMatchPrediction";
		System.out.println(sendRequest(url));
	}

	public static String sendRequest(String url) {
		URL url2;
		HttpURLConnection huc = null;
		String result = null;
		BufferedReader reader = null;
		try {
			url2 = new URL(url);
			huc = (HttpURLConnection) url2.openConnection();
			huc.setDoInput(true);
			huc.setConnectTimeout(8000);
			StringBuffer sbf = new StringBuffer();
			InputStream iStream = huc.getInputStream();
			reader = new BufferedReader(new InputStreamReader(iStream, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;

	}

}
