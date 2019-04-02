package com.fang.rice.dbController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


import org.omg.CORBA.PUBLIC_MEMBER;

import com.fang.rice.controll.CardProductSalePageAction.CardFilterCondition;
import com.fang.rice.dbHelper.DbHelper;
import com.fang.rice.model.Card;
import com.fang.rice.model.FilterCondition;
import com.fang.rice.model.FilterType;
import com.fang.rice.model.RootTable;
import com.fang.rice.model.Type;
import com.mysql.jdbc.StringUtils;

public class CardDbController implements CardOpration {
	
	
   public static void main(String[] args) {
		 
	   int[] callTime= {0,0};
	   int[] flowTime= {2,3};
	   String[] sort= {"asc","asc"};
	   List<Card> cards=new CardDbController().queryCardInfoByCityIdFlowConsume(150,flowTime,sort);
	   
	   List<FilterType> filterTypes=new ArrayList<>();
	   filterTypes.add(new FilterType("cscc", new int[] {0,1000})) ;
	   filterTypes.add(new FilterType("csct",new int[] {200,300}));
	   filterTypes.add(new FilterType("csfs", new int[] {5,8}));
	  
	   
	   FilterCondition filterCondition=new FilterCondition(0, 0, 147, 0, "移动动感地带",filterTypes);
	   
	   cards=new CardDbController().queryCardInfoByCityIdandFilterCondition(filterCondition, sort);
	   if (cards.size()==0) {
		System.out.println("\n没有查询到数据");
	}
	   for(int i=0;i<cards.size();i++) {
		   System.out.println("\n"+cards.get(i).getCardId());
	   }
	}
   
   
	@Override
	public List<Card> queryCardInfoByCityId(int cityId,String[] sort) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Card> cards=new ArrayList<>();
	    boolean isSucessful = true;
		try {
		
			ps=connection.prepareStatement("(select card.*, cardSaleVolume.saleVolumn\n" + 
					" from card\n" + 
					"        join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
					" where cityCode = ?\n" + 
					"\n" + 
					" order by cardSaleVolume.saleVolumn asc, card.price asc)\n" + 
					"union distinct\n" + 
					"    (select card.*, cardSaleVolume.saleVolumn\n" + 
					"     from card\n" + 
					"            join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
					"     where provinceSetmealId in(select provinceSetmealId\n" + 
					"                                from provinceSetmeal\n" + 
					"                                where provinceCode in (select provinceCode from city where cityCode=?))\n" + 
					"       and cityCode is null\n" + 
					"     order by cardSaleVolume.saleVolumn "+sort[0]+", card.price "+sort[1]+")");
			
			
			
			ps.setInt(1, cityId);
			ps.setInt(2, cityId);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				int cardId=resultSet.getInt(1);
				int cityCode =resultSet.getInt(2);
				int provinceSetmealId=resultSet.getInt(3);
				String cardName=resultSet.getString(4);
				int price=resultSet.getInt(5);
				int rank=resultSet.getInt(6);
				String oprator=resultSet.getString(7);
				int talkTime=resultSet.getInt(8);
				String netFlowTime=resultSet.getString(9);
				String destribute=resultSet.getString(10);
				int saleVolumn=resultSet.getInt(11);
				cards.add(new Card(cardId, cityCode, provinceSetmealId,cardName, price, rank, oprator, talkTime, netFlowTime, destribute,saleVolumn));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		
		return cards;
	}


	/**
	 * 查询卡自定义查询的是单一的流量的过滤
	 * @param sort 排序的方式是   销量   价格 
	 */
	@Override
	public List<Card> queryCardInfoByCityIdFlowConsume(int cityIdInt, int[] flowTimeRange,String[] sort) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Card> cards=new ArrayList<>();
	    boolean isSucessful = true;
		try {
		
			ps=connection.prepareStatement("(select card.*, cardSaleVolume.saleVolumn\n" + 
					" from card\n" + 
					"        join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
					" where cityCode = ?\n" + 
					"   and netFlowTime between ? and ?\n" + 
					" order by cardSaleVolume.saleVolumn "+sort[0]+", card.price "+sort[1]+")\n" + 
					"union distinct\n" + 
					"    (select card.*, cardSaleVolume.saleVolumn\n" + 
					"     from card\n" + 
					"            join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
					"     where provinceSetmealId in(select provinceSetmealId\n" + 
					"                                from provinceSetmeal\n" + 
					"                                where provinceCode in (select provinceCode from city where cityCode=?))\n" + 
					"       and cityCode is null\n" + 
					"       and netFlowTime between ? and ?\n" + 
					"     order by cardSaleVolume.saleVolumn "+sort[0]+", card.price "+sort[1]+")");
			ps.setInt(1, cityIdInt);
			ps.setInt(2, flowTimeRange[0]);
			ps.setInt(3, flowTimeRange[1]);
			ps.setInt(4, cityIdInt);
			ps.setInt(5, flowTimeRange[0]);
			ps.setInt(6, flowTimeRange[1]);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				int cardId=resultSet.getInt(1);
				int cityCode =resultSet.getInt(2);
				int provinceSetmealId=resultSet.getInt(3);
				String cardName=resultSet.getString(4);
				int price=resultSet.getInt(5);
				int rank=resultSet.getInt(6);
				String oprator=resultSet.getString(7);
				int talkTime=resultSet.getInt(8);
				String netFlowTime=resultSet.getString(9);
				String destribute=resultSet.getString(10);
				int saleVolumn=resultSet.getInt(11);
				cards.add(new Card(cardId, cityCode, provinceSetmealId,cardName, price, rank, oprator, talkTime, netFlowTime, destribute,saleVolumn));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		
		return cards;
	}

   /**
    * 查询城市的卡的信息,该用户只对通话时间做了限制,
    */
	@Override
	public List<Card> queryCardinfoByCityIdCallConsume(int cityId, int[] callTimeRange,String[] sort) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Card> cards=new ArrayList<>();
	    boolean isSucessful = true;
		try {
		
			ps=connection.prepareStatement("(select card.*, cardSaleVolume.saleVolumn\n" + 
					" from card\n" + 
					"        join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
					" where cityCode = ?\n" + 
					"   and talkTime between ? and ?\n" + 
					" order by cardSaleVolume.saleVolumn "+sort[0]+", card.price "+sort[1]+")\n" + 
					"union distinct\n" + 
					"    (select card.*, cardSaleVolume.saleVolumn\n" + 
					"     from card\n" + 
					"            join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
					"     where provinceSetmealId in(select provinceSetmealId\n" + 
					"                                from provinceSetmeal\n" + 
					"                                where provinceCode in (select provinceCode from city where cityCode=?))\n" + 
					"       and cityCode is null\n" + 
					"       and talkTime between ? and ?\n" + 
					"     order by cardSaleVolume.saleVolumn "+sort[0]+", card.price "+sort[1]+")");
			ps.setInt(1, cityId);
			ps.setInt(2, callTimeRange[0]);
			ps.setInt(3, callTimeRange[1]);
			ps.setInt(4, cityId);
			ps.setInt(5, callTimeRange[0]);
			ps.setInt(6, callTimeRange[1]);
			resultSet=ps.executeQuery();  
			while(resultSet.next()) {
				int cardId=resultSet.getInt(1);
				int cityCode =resultSet.getInt(2);
				int provinceSetmealId=resultSet.getInt(3);
				String cardName=resultSet.getString(4);
				int price=resultSet.getInt(5);
				int rank=resultSet.getInt(6);
				String oprator=resultSet.getString(7);
				int talkTime=resultSet.getInt(8);
				String netFlowTime=resultSet.getString(9);
				String destribute=resultSet.getString(10);
				int saleVolumn=resultSet.getInt(11);
				cards.add(new Card(cardId, cityCode, provinceSetmealId,cardName, price, rank, oprator, talkTime, netFlowTime, destribute,saleVolumn));
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		
		return cards;
	}

    /**
     *  @param sort 排序的方式是   销量   价格 
     */
	@Override
	public List<Card> queryCardInfoByCityIdConsumeSort(int cityIdInt, int[] callTimeRange, int[] flowTimeRange,
			String[] sort) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Card> cards=new ArrayList<>();
	    boolean isSucessful = true;
		try {
		
			ps=connection.prepareStatement("(select card.*, cardSaleVolume.saleVolumn\n" + 
					" from card\n" + 
					"        join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
					" where cityCode = ?\n" + 
					"   and talkTime between ? and ?\n" + 
					"   or netFlowTime between ? and ?\n" + 
					" order by cardSaleVolume.saleVolumn "+sort[0]+", card.price "+sort[1]+")\n" + 
					"union distinct\n" + 
					"    (select card.*, cardSaleVolume.saleVolumn\n" + 
					"     from card\n" + 
					"            join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
					"     where provinceSetmealId in(select provinceSetmealId\n" + 
					"                                from provinceSetmeal\n" + 
					"                                where provinceCode in (select provinceCode from city where cityCode=?))\n" + 
					"       and cityCode is null\n" + 
					"       and talkTime between ? and ?\n" + 
					"       or netFlowTime between ? and ?\n" + 
					"     order by cardSaleVolume.saleVolumn "+sort[0]+", card.price "+sort[1]+")");
			ps.setInt(1, cityIdInt);
			ps.setInt(2, callTimeRange[0]);
			ps.setInt(3, callTimeRange[1]);
			ps.setInt(4, flowTimeRange[0]);
			ps.setInt(5, flowTimeRange[1]);
			ps.setInt(6, cityIdInt);
			ps.setInt(7, callTimeRange[0]);
			ps.setInt(8, callTimeRange[1]);
			ps.setInt(9, flowTimeRange[0]);
			ps.setInt(10, flowTimeRange[1]);
			resultSet=ps.executeQuery();  
			while(resultSet.next()) {
				int cardId=resultSet.getInt(1);
				int cityCode =resultSet.getInt(2);
				int provinceSetmealId=resultSet.getInt(3);
				String cardName=resultSet.getString(4);
				int price=resultSet.getInt(5);
				int rank=resultSet.getInt(6);
				String oprator=resultSet.getString(7);
				int talkTime=resultSet.getInt(8);
				String netFlowTime=resultSet.getString(9);
				String destribute=resultSet.getString(10);
				int saleVolumn=resultSet.getInt(11);
				cards.add(new Card(cardId, cityCode, provinceSetmealId,cardName, price, rank, oprator, talkTime, netFlowTime, destribute,saleVolumn));	
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return cards;
	}


	@Override
	public List<Card> queryCardInfoByCityIdandFilterCondition(FilterCondition filterCondition, String[] sort) {
	    
		StringBuilder stringBuilder=new StringBuilder();
		if(filterCondition.getSetMeal()!=null) {
			stringBuilder.append("and provinceSetmeal.classfy=")
			.append("'"+filterCondition.getSetMeal()+"'")
			.append("\n");	
		}
		
		List<FilterType> filterTypes=filterCondition.getFilterRange();
		if(filterTypes!=null) {
				for(FilterType filterType:filterTypes) {
					if("cscc".equals(filterType.getFilterType())) {
						//消费金额
						stringBuilder.append("and card.price between ")
						.append(filterType.getRange()[0])
						.append(" and ")
						.append(filterType.getRange()[1])
						.append("\n");
						continue;
					}
					if("csct".equals(filterType.getFilterType())) {
						//通话时间
						stringBuilder.append("and talkTime between ")
						.append(filterType.getRange()[0])
						.append(" and ")
						.append(filterType.getRange()[1])
						.append("\n");
						continue;
					}
					if("csfs".equals(filterType.getFilterType())) {
						//流量使用
						stringBuilder.append("and netFlowTime between ")
						.append(filterType.getRange()[0]*1000)
						.append(" and ")
						.append(filterType.getRange()[1]*1000)
						.append("\n");
						continue;
					}
				}
				
		  }
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Card> cards=new ArrayList<>();
	    boolean isSucessful = true;
	    
	    String sql="(select card.*, cardSaleVolume.saleVolumn, provinceSetmeal.*\n" + 
				" from card\n" + 
				"        join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
				"        join provinceSetmeal on card.cityCode = provinceSetmeal.cityCode\n" + 
				" where card.cityCode = ?\n"+stringBuilder.toString()+
				"    order by cardSaleVolume.saleVolumn "+sort[0]+", card.price "+sort[1]+")\n"+
				"union distinct\n" + 
				"    (select card.*, cardSaleVolume.saleVolumn, provinceSetmeal.*\n" + 
				"     from card\n" + 
				"            join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
				"            join provinceSetmeal on card.provinceSetmealId = provinceSetmeal.provinceSetmealId\n" + 
				"     where card.provinceSetmealId in(select provinceSetmealId\n" + 
				"                                     from provinceSetmeal\n" + 
				"                                     where provinceCode in (select provinceCode from city where cityCode=?))\n"+
				stringBuilder.toString()+
				"    order by cardSaleVolume.saleVolumn "+sort[0]+", card.price "+sort[1]+")";
	    
	         System.out.print(sql);
	    
	    try {
			ps=connection.prepareStatement("(select card.*, cardSaleVolume.saleVolumn, provinceSetmeal.*\n" + 
					" from card\n" + 
					"        join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
					"        join provinceSetmeal on card.cityCode = provinceSetmeal.cityCode\n" + 
					" where card.cityCode = ?\n"+stringBuilder.toString()+
					"    order by cardSaleVolume.saleVolumn "+sort[0]+", card.price "+sort[1]+")\n"+
					"union distinct\n" + 
					"    (select card.*, cardSaleVolume.saleVolumn, provinceSetmeal.*\n" + 
					"     from card\n" + 
					"            join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
					"            join provinceSetmeal on card.provinceSetmealId = provinceSetmeal.provinceSetmealId\n" + 
					"     where card.provinceSetmealId in(select provinceSetmealId\n" + 
					"                                     from provinceSetmeal\n" + 
					"                                     where provinceCode in (select provinceCode from city where cityCode=?))\n"+
					stringBuilder.toString()+
					"    order by cardSaleVolume.saleVolumn "+sort[0]+", card.price "+sort[1]+")");
			
			     ps.setInt(1, filterCondition.getCityId());
			     ps.setInt(2, filterCondition.getCityId());
			     resultSet=ps.executeQuery();
			     while(resultSet.next()) {
			    	 System.out.println("dfsg");
						int cardId=resultSet.getInt(1);
						int cityCode =resultSet.getInt(2);
						int provinceSetmealId=resultSet.getInt(3);
						String cardName=resultSet.getString(4);
						int price=resultSet.getInt(5);
						int rank=resultSet.getInt(6);
						String oprator=resultSet.getString(7);
						int talkTime=resultSet.getInt(8);
						String netFlowTime=resultSet.getString(9);
						String destribute=resultSet.getString(10);
						int saleVolumn=resultSet.getInt(11);
						
						cards.add(new Card(cardId, cityCode, provinceSetmealId,cardName, price, rank, oprator, talkTime, netFlowTime, destribute,saleVolumn));	
						
//						if(cards.size()==0){
//							cards.add(new Card(cardId, cityCode, provinceSetmealId,cardName, price, rank, oprator, talkTime, netFlowTime, destribute,saleVolumn));	
//						}else {
//							for(Card card:cards) {
//								if(card.getCardId()!=cardId&&cards.size()!=0) {
//									cards.add(new Card(cardId, cityCode, provinceSetmealId,cardName, price, rank, oprator, talkTime, netFlowTime, destribute,saleVolumn));	
//								}
//							}
//						}
					
					}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return cards;
	}


	@Override
	public RootTable queryCardClassfy(int provinceCode) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Type> cards=new ArrayList<>();
		List<String> strings=new ArrayList<>();
		RootTable rootTable=new RootTable();
	    boolean isSucessful = true;
		try {
			ps=connection.prepareStatement("select classfy\n" + 
					"from provinceSetmeal\n" + 
					"where provinceCode=?\n"+
					"group by classfy");
			ps.setInt(1, provinceCode);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String type=resultSet.getString(1);
				strings.add(type);
			}
			
			for(int i=0;i<strings.size();i+=2) {
				String item1=strings.get(i);
				String item2=null;
				if(i+1==strings.size()) {
						item2="期待更多套餐";
				}else {
					item2=strings.get(i+1);
				}
				Type type1=new Type(item1, item2);
				cards.add(type1);
			}
			rootTable.setTypes(cards);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);	
		}
		return rootTable;
	}


	@Override
	public List<String> queryCardClassfyForList(int provinceId) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		List<Type> cards=new ArrayList<>();
		List<String> strings=new ArrayList<>();
		try {
			ps=connection.prepareStatement("select classfy\n" + 
					"from provinceSetmeal\n" + 
					"where provinceCode=?\n"+
					"group by classfy");
			ps.setInt(1,provinceId);
			resultSet=ps.executeQuery();
			while(resultSet.next()) {
				String classfy=resultSet.getString(1);
				strings.add(classfy);
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		
		return strings;
	}


	@Override
	public List<Card> getCardList(CardFilterCondition cardFilterCondition) {
		int[] callTimeRank=cardFilterCondition.getCallTime();
		int startPrice=cardFilterCondition.getStartPrice();
		int endPrice=cardFilterCondition.getEndPrice();
		int[] flowCount=cardFilterCondition.getFlowCount();
		String setmealType=cardFilterCondition.getSetmealType();
		
		List<Card> cards=new ArrayList<>();
		
		List<String> filterLst=new ArrayList<>();
		if(callTimeRank!=null) {
			if(callTimeRank[0]>callTimeRank[1]) {
				//代表的是上限   例如 600以上
				filterLst.add("card.talkTime >="+callTimeRank[0]);
			}else {
			filterLst.add("card.talkTime between "+callTimeRank[0]+" and "+callTimeRank[1]);
			}
		}else {
			//代表的是获得定制化的实现
		}
		
		if(startPrice!=-1) {
			filterLst.add("card.price>="+startPrice);
		}
		
		if(endPrice!=-1) {
			filterLst.add("card.price<="+endPrice);
		}
		
		if(flowCount!=null) {
			if(flowCount[0]>flowCount[1]) {
				filterLst.add("card.flowCount >= "+(flowCount[0]));
			}else {
				filterLst.add("card.flowCount between "+(flowCount[0])+" and "+(flowCount[1]));
			}
		}else {
			//代表的是获得定制化的查询的实现
		}
		
		if(setmealType!=null) {
			filterLst.add("provinceSetmeal.classfy='"+setmealType+"'");
		}
		StringBuilder stringBuilder=new StringBuilder();
		if(filterLst.size()>0) {
			stringBuilder.append(" and ( ");
		}
		
		for(int i=0;i<filterLst.size();i++) {
			if(i==filterLst.size()-1) {
				stringBuilder.append(filterLst.get(i));
			}else {
				stringBuilder.append(filterLst.get(i)).append(" or ");	
			}
		}
		if(filterLst.size()>0) {
			stringBuilder.append(" )");
		}
		
		boolean priceAsc=cardFilterCondition.isPriceSortAsc();//order by
		int cityId=cardFilterCondition.getCityId();	//where
		int page=cardFilterCondition.getPage();//limit
		int size=cardFilterCondition.getSize();//limit
		
		String orderBy;
		if(priceAsc) {//如果是降序
			orderBy="order by temp.price desc";
		}else {
			orderBy="order by temp.price asc";//反之升序
		}
		//查询   int cardId, String monthFee,String oprator, String roughImageAddress, int price saleTitle这个是显示list的数据
		
		String sql1="select *\n" + 
				"from ((select card.cardId,card.monthFee,card.oprator,card.roughImageAddress,card.price,card.saleTitle,card.cardName\n" + 
				"       from card\n" + 
				"              join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
				"              join provinceSetmeal on card.cityCode = provinceSetmeal.cityCode\n" + 
				"       where card.cityCode = ?\n" + 
				stringBuilder.toString()+")"+
				"      union distinct\n" + 
				"      (select card.cardId,card.monthFee,card.oprator,card.roughImageAddress,card.price,card.saleTitle,card.cardName\n" + 
				"       from card\n" + 
				"              join cardSaleVolume on card.cardid = cardSaleVolume.cardid\n" + 
				"              join provinceSetmeal on card.provinceSetmealId = provinceSetmeal.provinceSetmealId\n" + 
				"       where card.provinceSetmealId in(select provinceSetmealId\n" + 
				"                                       from provinceSetmeal\n" + 
				"                                       where provinceCode in (select provinceCode from city where cityCode = ?))\n" + 
				stringBuilder.toString()+" )) as temp \n"
				+orderBy;//排序
		
		String sql2="select cardId,monthFee,oprator,roughImageAddress,price,saleTitle,cardName,voiceTariff,smsAmmsTariff,flowTariff,flowCount,talkTime\n" + 
				"from (select * from card where cityCode = ?\n" + 
				stringBuilder.toString()+"\n"+
				"      union select *\n" + 
				"            from card\n" + 
				"            where provinceSetmealId in(select provinceSetmealId\n" + 
				"                                       from provinceSetmeal\n" + 
				"                                       where provinceCode in (select provinceCode from city where cityCode = ?))\n" + 
				"              and cityCode is null\n" + 
				stringBuilder.toString()+"\n"+
				"      ) as temp\n"
				+orderBy+"\n"
				+"limit "+page*size+","+size;//排序
			    
		         System.out.print(sql2);
		
	
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		connection=DbHelper.initDB();
		try {
			ps=connection.prepareStatement(sql2);
			ps.setInt(1,cityId);
			ps.setInt(2, cityId);
			 resultSet=ps.executeQuery();
		     while(resultSet.next()) {
	
					int cardId=resultSet.getInt(1);
					String monthFee =resultSet.getString(2);
					String oprator=resultSet.getString(3);
					String roughImageAddress=resultSet.getString(4);
					int price=resultSet.getInt(5);
					String saleTitle=resultSet.getString(6);
					String cardName=resultSet.getString(7);
					String voiceTraiff=resultSet.getString(8);
					String smsAmmsTraiff=resultSet.getString(9);
					String flowTraiff=resultSet.getString(10);
					int flowCount1=resultSet.getInt(11);
					int talkTime=resultSet.getInt(12);
					Card card;
					card=new Card(cardId, monthFee, oprator, roughImageAddress, price, saleTitle, cardName, voiceTraiff, smsAmmsTraiff, flowTraiff);
					card.setFlowCount(flowCount1);
					card.setTalkTime(talkTime);
					cards.add(card);
					
		     }
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return cards;
	}


	/**
	 * 获得card的详情信息的
	 */
	@Override
	public Card getCardDetailInfo(int cardId) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		Card card=null;
		connection=DbHelper.initDB();
		try {
			/**
			 int cityCode=resultSet.getInt(2);
				String oprator=resultSet.getString(3);
				int talkTime=resultSet.getInt(4);
				int netFlowCount=resultSet.getInt(5);
				String action=resultSet.getString(6);
				String roughImageAddress=resultSet.getString(7);
				String saleTitle=resultSet.getString(8);
				String setmeal=resultSet.getString(9);
				String image1=resultSet.getString(10);
				String image2=resultSet.getString(11);
				String image3=resultSet.getString(12);
				String image4=resultSet.getString(13);
				String image5=resultSet.getString(14);
				int price=resultSet.getInt(15); 
			 
			 */
			
			String sql="select card.*,pS.classfy from card join provinceSetmeal pS on card.provinceSetmealId = pS.provinceSetmealId where card.cardid=?";
			
			
			String sql1="select card.cardId,card.cityCode,card.oprator,"
					+ "card.talkTime,card.netFlowCount,card.action,card.roughImageAddress,"
					+ "card.saleTitle,card.image1,card.image2,card.image3,"
					+ "card.image4,card.image5,pS.classfy\n" + 
					"from card\n" + 
					"       join provinceSetmeal pS on card.provinceSetmealId = pS.provinceSetmealId\n" + 
					"where card.cardid = ?\n" ;
			
			ps=connection.prepareStatement(sql);
			ps.setInt(1,cardId);
			resultSet=ps.executeQuery();
			List<String> imageAddress=new ArrayList<>();	
			List<String> detailImgs=new ArrayList<>();
			while(resultSet.next()) {
//				int cityCode=resultSet.getInt(2);
//				String oprator=resultSet.getString(3);
//				int talkTime=resultSet.getInt(4);
//				String netFlowCount=resultSet.getString(5);
//				String action=resultSet.getString(6);
//				String roughImageAddress=resultSet.getString(7);
//				String saleTitle=resultSet.getString(8);
//				String image1=resultSet.getString(9);
//				String image2=resultSet.getString(10);
//				String image3=resultSet.getString(11);
//				String image4=resultSet.getString(12);
//				String image5=resultSet.getString(13);
//				int price=resultSet.getInt(14);
//				imageAddress.add(image1);
//				imageAddress.add(image2);
//				imageAddress.add(image3);
//				imageAddress.add(image4);
//				imageAddress.add(image5);
//				card=new Card(cardId, cityCode, oprator, talkTime, netFlowCount, action, roughImageAddress, saleTitle, null, imageAddress, price);
	
				int cityCode=resultSet.getInt(2);
				String cardName=resultSet.getString(4);
				int price=resultSet.getInt(5);
				String oprator=resultSet.getString(7);
				int talkTime=resultSet.getInt(8);
				String netFlowCount=resultSet.getString(9);
				String destribute=resultSet.getString(10);
				String action=resultSet.getString(11);
				String roughImageAddress=resultSet.getString(12);
				String saleTitle=resultSet.getString(13);
				String image1=resultSet.getString(14);
				String image2=resultSet.getString(15);
				String image3=resultSet.getString(16);
				String image4=resultSet.getString(17);
				String image5=resultSet.getString(18);
				imageAddress.add(image1);
				imageAddress.add(image2);
				imageAddress.add(image3);
				imageAddress.add(image4);
				imageAddress.add(image5);
				String monthFee=resultSet.getString(19);
				String mark=resultSet.getString(20);
				String offHook=resultSet.getString(21);
				String valueAddSer=resultSet.getString(22);
				String voiceTariff=resultSet.getString(23);
				String smsAmmsTariff=resultSet.getString(24);
				String flowTariff=resultSet.getString(25);
				String otherSer=resultSet.getString(26);
				String brandBand=resultSet.getString(27);
				String tv=resultSet.getString(28);
				String promotPeriod=resultSet.getString(29);
				String redPacket=resultSet.getString(30);
				String detailImg1=resultSet.getString(31);
				String detailImg2=resultSet.getString(32);
				String detailImg3=resultSet.getString(33);
				String detailImg4=resultSet.getString(34);
				String detailImg5=resultSet.getString(35);
				detailImgs.add(detailImg1);
				detailImgs.add(detailImg2);
				detailImgs.add(detailImg3);
				detailImgs.add(detailImg4);
				detailImgs.add(detailImg5);
				String classfy=resultSet.getString(36);
				card=new Card(cardId, cityCode, -1, cardName, price, -1, oprator, talkTime, netFlowCount, destribute, action, roughImageAddress, saleTitle,
						imageAddress, monthFee, mark, offHook, valueAddSer, voiceTariff, smsAmmsTariff, flowTariff, otherSer, brandBand, tv, promotPeriod, redPacket,classfy,detailImgs);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return card;	
	}


	@Override
	public List<Card> getCardList3(String cityId) {
		Connection connection;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<Card> cards=new ArrayList<Card>();
		connection=DbHelper.initDB();
		try {
			ps=connection.prepareStatement("select card.cardId,card.price,card.oprator,card.cardName,roughImageAddress\n"
					+ "from card where cityCode=? limit 0,3");
			ps.setInt(1, Integer.parseInt(cityId));
			 resultSet=ps.executeQuery();
		     while(resultSet.next()) {
	
					int cardId=resultSet.getInt(1);
					int price =resultSet.getInt(2);
					String oprator=resultSet.getString(3);
					String cardName=resultSet.getString(4);
					String image=resultSet.getString(5);
					cards.add(new Card(cardId, price, oprator,cardName,image));	
		     }
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbHelper.closeDb(connection, ps, resultSet);
		}
		return cards;
	}
}
