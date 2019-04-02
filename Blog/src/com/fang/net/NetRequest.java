package com.fang.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import com.fang.net.model.Root;
import com.google.gson.Gson;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class NetRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url="http://s1.bdstatic.com/r/www/cache/bdorz/baidu.min.css";
        System.out.println(sendRequest(url));
	}
	
	
	public static String sendRequest(String url) {
        URL url2;
        HttpURLConnection huc=null;
        String result = null;
		BufferedReader reader = null;
		try {
			url2 = new URL(url);
			huc=(HttpURLConnection) url2.openConnection();
			huc.setDoInput(true);
			huc.setConnectTimeout(8000);
			StringBuffer sbf = new StringBuffer();
			InputStream iStream=huc.getInputStream();
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
		}finally {
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
