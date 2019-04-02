package com.fang.rice.tool;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 图标映射图
 * @author fang
 *
 */
public class IconMapping {
	
	
	
   public static enum Icon_functionMode{
        ic_register_vip("ic_register_vip"),
        ic_dianhuazixun_big("ic_dianhuazixun_big"),
        ic_qiyefuwu_big("ic_qiyefuwu_big"),
        ic_publish_phone("ic_publish_phone");

        public String iconName;

        Icon_functionMode(String iconName){
            this.iconName=iconName;
        }
    }

   public static enum Icon_menuFunctionList{

        ic_change_setmeal("ic_change_setmeal"),
        ic_lianghaozhongxin("ic_lianghaozhongxin"),
        ic_shouji("ic_shouji"),
        ic_liuliang("ic_liuliang"),
        ic_zhangdan("ic_zhangdan"),
        ic_shenqing("ic_shenqing"),
        ic_kuandai("ic_kuandai"),
        ic_guhua_server("ic_guhua_server"),
        ic_zhuan_net("ic_zhuan_net"),
        ic_pingjia("ic_pingjia"),
        ic_tongxun("ic_tongxun"),
        ic_youhui("ic_youhui");

        public String iconName;

        Icon_menuFunctionList(String iconName){
            this.iconName=iconName;
        }
    }
    
   
   public static enum Icon_IndexInfo{

        ic_logistics("ic_logistics"),
        ic_shop_car("ic_shop_car"),
        ic_setting("ic_setting");

        public String iconName;

        Icon_IndexInfo(String iconName){
            this.iconName=iconName;
        }
        
    }
    
    private String[] iconArray;
    
    
    private IconMapping(String[] iconName) {
    	this.iconArray=iconName;
    }
    
    
    
   public  static IconMapping menuFunctionList1;
    public static IconMapping myindexInfo1;
    public static IconMapping functionMode1;
	static {
	
		String [] icon1= {
				   "ic_change_setmeal",
		            "ic_lianghaozhongxin",
		            "ic_shouji",
		            "ic_liuliang",
		            "ic_zhangdan",
		            "ic_shenqing",
		            "ic_kuandai",
		            "ic_guhua_server",
		            "ic_zhuan_net",
		            "ic_pingjia",
		            "ic_tongxun",
		            "ic_youhui",
	
		};
		menuFunctionList1=new IconMapping(icon1);
		
		String[] icon2= {
				"ic_logistics",
	            "ic_shop_car",
	            "ic_setting"
		};
		myindexInfo1=new IconMapping(icon2);
		
		String[] icon3= {
				  "ic_register_vip",
	            "ic_dianhuazixun_big",
	            "ic_qiyefuwu_big",
	            "ic_publish_phone"
		};
	
	functionMode1=new IconMapping(icon3);		
		
	}
	
	
	public static int getFunctionModeIconAddress(Icon_functionMode icon_functionMode) {
		int imageAddress = 0;
	      for(int i=0;i<functionMode1.iconArray.length;i++) {
	    	  if(icon_functionMode.iconName.equals(functionMode1.iconArray[i])) {
	    		 imageAddress=i;
	    	  }
	      }
		return imageAddress;
	}
    
	
	public static int getMenuFunctionListIconAddress(Icon_menuFunctionList icon_menuFunctionList) {
		
		
		int imageAddress = 0;
	      for(int i=0;i<menuFunctionList1.iconArray.length;i++) {
	    	  if(icon_menuFunctionList.iconName.equals(menuFunctionList1.iconArray[i])) {
	    		 imageAddress=i;
	    	  }
	      }
		return imageAddress;
	}
	
	public static int getIndexInfoIconAddress(Icon_IndexInfo icon_IndexInfo) {
		int imageAddress = 0;
	      for(int i=0;i<myindexInfo1.iconArray.length;i++) {
	    	  if(icon_IndexInfo.iconName.equals(myindexInfo1.iconArray[i])) {
	    		 imageAddress=i;
	    	  }
	      }
		return imageAddress;
	}

    


}
