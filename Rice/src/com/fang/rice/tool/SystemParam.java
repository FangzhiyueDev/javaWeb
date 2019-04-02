package com.fang.rice.tool;

public class SystemParam {
	
	
	public static String ipAddress="192.168.42.27";
	public static String port="8080";
	public static String imageAddress="http://"+ipAddress+":"+port+"/Rice/image/";
	
	/**
     * 这个常量的作用是用来进行数据映射成视图添加的父布局
     * 对于整个系统软件来说，由于使用的计数是动态技术，我们必须定义一个视图常量来规定我们需要动态创建的视图被添加的位置
     * 对于该VIew_GROUP来说，对应的是软件的四个fragment布局文件里面ScrollView里面的LinearLayout，对于我们的界面来说
     * 大部分的自定义的视图都会被添加到该类型的下面，原因是系统主要fragment界面的动态性，决定了该视图可能超出系统屏幕的大小
     * 这也就代表这我们通常定义的视图都会被添加到该view的下面，除非我门定义的是consumeToolbar，在视图的顶部，不会随着视图的滑动而滑动
     */
    public static final String VIEW_GROUP = "viewGroup";

    /**
     * 同上面一样，定义的是fragment的最顶级视图的名称，网路数据返回后，一般只有consumeToolbar会被默认添加在里面
     */
    public static final String VIEW_ROOT = "viewRoot";
	
    public enum TableName {

        CRBT("CRBT"),
        SMSGenerationFee("SMSGenerationFee"),
        SMSNewsletter("SMSNewsletter"),
        User("User"),
        aggregate("aggregate"),
        callerDisplay("callerDisplay"),
        card("card"),
        cardSaleVolume("cardSaleVolume"),
        city("city"),
        inDiscountAreaDomesticLongDistanceFee("inDiscountAreaDomesticLongDistanceFee"),
        inLocalDiscountAreaCommuCharges("inLocalDiscountAreaCommuCharges"),
        inProvinceRoamFee("inProvinceRoamFee"),
        interProvineRoamFee("interProvineRoamFee"),
        localAreaCommuCharges("localAreaCommuCharges"),
        other("other"),
        outDiscountAreaDomesticLongDistanceFee("outDiscountAreaDomesticLongDistanceFee"),
        outLocalDiscountAreaCommuCharges("outLocalDiscountAreaCommuCharges"),
        phone("phone"),
        phoneSaleVolumn("phoneSaleVolumn"),
        province("province"),
        provinceSetmeal("provinceSetmeal"),
        setMeal("setMeal"),
        tariff("tariff"),
        vip("vip"),
        voiceInfoFee("voiceInfoFee"),
        withinCompanyCommuCharges("withinCompanyCommuCharges");
        public String tableName;

        private TableName(String tableName) {
            this.tableName = tableName;
        }

    }

}
