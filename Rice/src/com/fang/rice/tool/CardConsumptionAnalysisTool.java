package com.fang.rice.tool;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.event.ListSelectionEvent;

import com.fang.rice.model.Card;
import com.mysql.jdbc.StringUtils;

/**
 * 套餐推荐的分析工具，用于实现套餐内部的数据的计算，属于该软件的核心功能模块
 * @author fang
 *
 */
public class CardConsumptionAnalysisTool {
	
	
	/**
	 * 定义了移动的套餐外流量的资费
	 */
	public static final float yidongFlowTariff=0.29f;
	
	/**
	 * 定义的联通的套餐外流量的资费
	 */
	public static final float liantongFlowTariff=0.3f;
	
	public static final float dianxinFlowTariff=0.03f;
	
	public static final float messageTariff=0.1f;
	

	public static final String[] oprators= {"中国联通","中国电信","中国移动"};
	
	
	
	public static class CardTariff implements Comparator<CardTariff>{
		
		private Card card;
		private float realTariff;
		public Card getCard() {
			return card;
		}
		
		
		
		
		@Override
		public String toString() {
			return "CardTariff [card=" + card + ", realTariff=" + realTariff + "]";
		}


		public void setCard(Card card) {
			this.card = card;
		}
		public float getRealTariff() {
			return realTariff;
		}
		public void setRealTariff(float realTariff) {
			this.realTariff = realTariff;
		}
		public CardTariff(Card card, float realTariff) {
			super();
			this.card = card;
			this.realTariff = realTariff;
		}
		
		public CardTariff() {
			// TODO Auto-generated constructor stub
		}
	
		@Override
		public int compare(CardTariff o1, CardTariff o2) {
			if(o1.realTariff>o2.realTariff) {
				return 1;
			}else if(o1.realTariff<o2.realTariff) {
				return -1;
			}else {
				return 0;	
			}
		}
	}
	
	
	
	
	
   /**
    * 获得最便宜的套餐的信息
    * @param cards
    * @param callTime
    * @param flowCount
    */
	public static List<Card>  getCheapSetmeal(List<Card> cards,int callTime,int flowCount,int messageCount){
	
		List<Card> cards1=new ArrayList<>();
		
		CardTariff[] cards2=new CardTariff[cards.size()];
		 DecimalFormat df = new DecimalFormat("#.##");
		
		for(int i=0;i<cards.size();i++) {
		
		 float voiceTariff= getCardVoiceTariff(cards.get(i).getVoiceTariff());
		 float flowTariff=getCardFlowTariff(cards.get(i).getFlowTariff());
		 float monthFee=getMonthFeeTariff(cards.get(i).getMonthFee());
		 
//		 System.out.println("语音费用:"+voiceTariff+"\t通话时长:"+callTime+"\t流量费用:"+flowCount+"\t月费:"+monthFee+"\t定向流量:"+cards.get(i).getNetFlowCount()+"\t定向通话时长:"+ cards.get(i).getTalkTime());
		 System.out.println("语音计费:"+voiceTariff+"\t流量计费:"+flowTariff+"\t月费:"+monthFee);
		 //查看这个套餐是否有定向的流量
		 
		 int innerFlowCount=cards.get(i).getFlowCount();
		 int innerTalkCount=cards.get(i).getTalkTime();
		 
		 if(innerFlowCount>=flowCount) {
			 flowTariff=0;
		 }
		 if(innerTalkCount>=callTime) {
			 voiceTariff=0;
		 }
		 		 
		 float realTariff=voiceTariff*(callTime-innerFlowCount)+flowTariff*(flowCount-innerFlowCount)+monthFee+messageCount*messageTariff;
	
		 cards2[i]=new CardTariff(cards.get(i), realTariff);
		}
		 Arrays.sort(cards2, new CardTariff());	 
		 cards.clear();
		for(int i=0;i<cards2.length;i++) {
			Card card=cards2[i].card;
			card.setTotalPrice(Float.parseFloat(df.format(cards2[i].realTariff)));
			cards1.add(cards2[i].card);
		}
		return cards1;
	}
	
	
	
	private static int getInnerFlowCount(String netFlowCount) {
		
		int flow;
		String flowS="";
		char[] value=netFlowCount.toCharArray();
		for(int i=0;i<value.length;i++) {
			if(value[i]>='0'&&value[i]<='9') {
				flowS+=value[i];
			}
		}
		
		
		return 0;
	}
	
	
	public static  float getCardVoiceTariff(String value) {
		//System.out.println(value);
		value=value.substring(0, value.indexOf("元"));
		
		return Float.parseFloat(value);
	}
	
	/**
	 * 获得套餐卡的月费数据
	 * @param value
	 * @return
	 */
	public static float getMonthFeeTariff(String value) {
		String value1="";
		char[] chars=value.toCharArray();
		for(char c:chars) {
			if(c>='0'&&c<='9') {
				value1+=c;
			}
		}
		//System.out.println("得到的值为"+value1);
		return Float.parseFloat(value1);
	}
	
	
   
	/**
	 * 获得套餐卡的流量的计费标准，在该类中定义了三家套餐的流量计费标准，当我们发现流量计费为空的情况下，我们就可以判断该卡属于不限量流量卡，直接返回0就行
	 * 
	 * @param value
	 * @return
	 */
	public static  float getCardFlowTariff(String value) {
		float flowTariff=0f;
	   Map<String,Float> map=new HashMap<>();
	   map.put(oprators[0], liantongFlowTariff);
	   map.put(oprators[1], dianxinFlowTariff);
	   map.put(oprators[2], yidongFlowTariff);	
		
		if(value==null||"".equals(value)) {//
			//flowTariff=map.get(oprator);
			flowTariff=0f;
		}else {
			flowTariff=Float.parseFloat(value.substring(0, value.indexOf("元")));
		}
		return flowTariff*1000;
	}
	
	
	
	
}


