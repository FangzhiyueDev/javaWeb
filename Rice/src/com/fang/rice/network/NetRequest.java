package com.fang.rice.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import com.fang.rice.dbController.LocationDbController;
import com.fang.rice.model.City;
import com.fang.rice.model.Province;

/*
 * 用于发送网络请求的实体类
 */
public class NetRequest {
	
		public static void main(String[] argc) {
			String url="http://guolin.tech/api/china";
//	        System.out.println(sendRequest(url));
			obtainCountryCityData();
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
				e.printStackTrace();
			}finally {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return result;
	}
	
	
	public static  void obtainCountryCityData() {
	
			String url="http://guolin.tech/api/china";
			String provinceJson=sendRequest(url);
			JSONArray jsonArray=new JSONArray(provinceJson);
			LocationDbController lob=new LocationDbController();
			for(int i=0;i<jsonArray.length();i++) {
				JSONObject jsonObject=(JSONObject) jsonArray.get(i);
				int id=jsonObject.getInt("id");
				String name=jsonObject.getString("name");
				
				//lob.insertProvince(new Province(name, id));
				
				url="http://guolin.tech/api/china/"+id;
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String jsonCity=sendRequest(url);
				System.out.println(jsonCity);
				JSONArray jsonArray2=new JSONArray(jsonCity);
				for(int j=0;j<jsonArray2.length();j++) {
					JSONObject jsonObject2=jsonArray2.getJSONObject(j);
					int idc=jsonObject2.getInt("id");
					String namec=jsonObject2.getString("name");
					lob.insertCityInfo(new City(id, namec, idc));
				}
				
			}
			
	}
	
	
	public static void obtainCityInfo() {
		
		
	}
	
	
	
	
	
	
}
