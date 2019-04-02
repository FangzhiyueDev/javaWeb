package com.xiaofangfang.rice.model.view_mode;



import java.util.List;
import com.xiaofangfang.rice.model.Card;

/**
 * 套餐类型的视图封装的bean
 */
public class SetmealViewDataBean {


    private String title;
    private String linkName;
    private String linkClickStartActivityName;
    private String imageAddress;
    private String imageClickStartActivityName;
    private String tableName;
    private List<CardType> cardTypeList;

    public SetmealViewDataBean(String title, String linkName, String linkClickStartActivityName, 
    		String imageAddress, String imageClickStartActivityName, List<CardType> cardTypeList,
    		String tableName) {
        this.title = title;
        this.linkName = linkName;
        this.linkClickStartActivityName = linkClickStartActivityName;
        this.imageAddress = imageAddress;
        this.imageClickStartActivityName = imageClickStartActivityName;
        this.cardTypeList = cardTypeList;
        this.tableName=tableName;
    }

    public SetmealViewDataBean() {
    }

    public String getTableName() {
		return tableName;
	}
    
    public void setTableName(String tableName) {
		this.tableName = tableName;
	}
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinkName() {
        return linkName;
    }

    public void setLinkName(String linkName) {
        this.linkName = linkName;
    }

    public String getLinkClickStartActivityName() {
        return linkClickStartActivityName;
    }

    public void setLinkClickStartActivityName(String linkClickStartActivityName) {
        this.linkClickStartActivityName = linkClickStartActivityName;
    }

    public String getImageAddress() {
        return imageAddress;
    }

    public void setImageAddress(String imageAddress) {
        this.imageAddress = imageAddress;
    }

    public String getImageClickStartActivityName() {
        return imageClickStartActivityName;
    }

    public void setImageClickStartActivityName(String imageClickStartActivityName) {
        this.imageClickStartActivityName = imageClickStartActivityName;
    }
    
    public List<CardType> getCardTypeList() {
		return cardTypeList;
	}

    public void setCardTypeList(List<CardType> cardTypeList) {
		this.cardTypeList = cardTypeList;
	}

    /**
     * card的类型
     * @author fang
     *
     */
    public static class CardType{
    	private String clickStartActivityName;
    	private String tableName;
    	private Card card;
		public CardType(String clickStartActivityName, String tableName, Card card) {
			super();
			this.clickStartActivityName = clickStartActivityName;
			this.tableName = tableName;
			this.card = card;
		}
		public String getClickStartActivityName() {
			return clickStartActivityName;
		}
		public void setClickStartActivityName(String clickStartActivityName) {
			this.clickStartActivityName = clickStartActivityName;
		}
		public String getTableName() {
			return tableName;
		}
		public void setTableName(String tableName) {
			this.tableName = tableName;
		}
		public Card getCard() {
			return card;
		}
		public void setCard(Card card) {
			this.card = card;
		}
    }
    
    
}
