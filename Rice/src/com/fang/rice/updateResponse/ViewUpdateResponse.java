package com.fang.rice.updateResponse;

import com.fang.rice.insertResponse.ViewResponse;
import com.fang.viewdataBean.ActionHorizontalScrollViewDataBean;
import com.fang.viewdataBean.BannerDataRespnse;
import com.fang.viewdataBean.DataResponse;
import com.fang.viewdataBean.FunctionModeViewDataBean;
import com.fang.viewdataBean.LiangHaoDisplayViewDataBean;
import com.fang.viewdataBean.MyIndexInfoVIewDataBean;
import com.fang.viewdataBean.MyMenuFunctionListDataBean;
import com.fang.viewdataBean.PhoneDisplayViewDataBean;
import com.fang.viewdataBean.PhoneSaleViewDataBean;
import com.fang.viewdataBean.SetmealViewDataBean;

public abstract class ViewUpdateResponse extends ViewResponse {

    /**
     * 更新的等级
     */
    public int updateLeavel;


    /**
     * bannerFlipperCOntainer的更新的响应数据封装
     */
    public static class BannerFlipperUpdateResponse extends ViewUpdateResponse {


        private BannerDataRespnse bannerDataRespnse;

        public BannerFlipperUpdateResponse(BannerDataRespnse bannerDataRespnse,int updateLeavel,int index,int oprateCode) {
            this.bannerDataRespnse = bannerDataRespnse;
            this.updateLeavel=updateLeavel;
            this.index=index;
            this.oprateCode=oprateCode;
        }


        @Override
        public void setResponse(DataResponse dataResponse) {
            this.bannerDataRespnse = (BannerDataRespnse) dataResponse;
        }

        @Override
        public DataResponse getResponse() {
            return bannerDataRespnse;
        }
    }


    /**
     * 水平的活动的滚动视图的更新的响应
     */
    public static class ActionHorizonalScrollViewUpdateResponse extends ViewUpdateResponse {


        private ActionHorizontalScrollViewDataBean ahsd;

        public ActionHorizonalScrollViewUpdateResponse(ActionHorizontalScrollViewDataBean ahsd,int updateLeavel,int index,int oprateCode) {
            this.ahsd = ahsd;
            this.updateLeavel=updateLeavel;
            this.index=index;
            this.oprateCode=oprateCode;
        }

        @Override
        public void setResponse(DataResponse dataResponse) {
            this.ahsd = (ActionHorizontalScrollViewDataBean) dataResponse;
         
        }

        @Override
        public DataResponse getResponse() {
            return ahsd;
        }
    }


    /**
     * 功能菜单列表的显示模块
     */
    public static class MenuFunctionListUpdateResponse extends ViewUpdateResponse {

        private MyMenuFunctionListDataBean mfld;

        public MenuFunctionListUpdateResponse(MyMenuFunctionListDataBean mfld,int updateLeavel,int index,int oprateCode) {
            this.mfld = mfld;
            this.updateLeavel=updateLeavel;
            this.index=index;
            this.oprateCode=oprateCode;
        }

        @Override
        public void setResponse(DataResponse dataResponse) {
            this.mfld = (MyMenuFunctionListDataBean) dataResponse;
        }

        @Override
        public DataResponse getResponse() {
            return mfld;
        }
    }


    /**
     * 功能模块的更行响应的数据接口
     */
    public static class FunctionModeUpdateResponse extends ViewUpdateResponse {

        private FunctionModeViewDataBean fmvd;

        public FunctionModeUpdateResponse(FunctionModeViewDataBean fmvd,int updateLeavel,int index,int oprateCode) {
            this.fmvd = fmvd;
            this.updateLeavel=updateLeavel;
            this.index=index;
            this.oprateCode=oprateCode;
        }

        @Override
        public void setResponse(DataResponse dataResponse) {
            this.fmvd = (FunctionModeViewDataBean) dataResponse;
        }

        @Override
        public DataResponse getResponse() {
            return fmvd;
        }
    }


    /**
     * 手机展示视图的更新的响应接口的数据封装
     */
    public static class PhoneDisplayUpdateResponse extends ViewUpdateResponse {

        private PhoneDisplayViewDataBean pdvd;

        public PhoneDisplayUpdateResponse(PhoneDisplayViewDataBean pdvd,int updateLeavel,int index,int oprateCode) {
            this.pdvd = pdvd;
            this.updateLeavel=updateLeavel;
            this.index=index;
            this.oprateCode=oprateCode;
        }

        @Override
        public void setResponse(DataResponse dataResponse) {
            this.pdvd = (PhoneDisplayViewDataBean) dataResponse;
        }

        @Override
        public DataResponse getResponse() {
            return pdvd;
        }
    }


    /**
     * 套餐的数据的更行响应接口
     */
    public static class SetmealViewDataBeanUpdateResponse extends ViewUpdateResponse {

        private SetmealViewDataBean svdb;

        public SetmealViewDataBeanUpdateResponse(SetmealViewDataBean svdb,int updateLeavel,int index,int oprateCode) {
            this.svdb = svdb;
            this.updateLeavel=updateLeavel;
            this.index=index;
            this.oprateCode=oprateCode;
        }

        @Override
        public void setResponse(DataResponse dataResponse) {
            this.svdb = (SetmealViewDataBean) dataResponse;
        }

        @Override
        public DataResponse getResponse() {
            return svdb;
        }
    }


    /**
     * 靓号的更新的响应接口
     */
    public static class LiangHaoUpdateResponse extends ViewUpdateResponse {

        private LiangHaoDisplayViewDataBean lhdvd;

        public LiangHaoUpdateResponse(LiangHaoDisplayViewDataBean lhdvd,int updateLeavel,int index,int oprateCode) {
            this.lhdvd = lhdvd;
            this.updateLeavel=updateLeavel;
            this.index=index;
            this.oprateCode=oprateCode;
        }
        

        @Override
        public void setResponse(DataResponse dataResponse) {
            this.lhdvd = (LiangHaoDisplayViewDataBean) dataResponse;
        }

        @Override
        public DataResponse getResponse() {
            return lhdvd;
        }
    }


    /**
     * 手机的销售展示更新的响应接口
     */
    public static class PhoneSaleUpdateResponse extends ViewUpdateResponse {

        private PhoneSaleViewDataBean psvdb;

        public PhoneSaleUpdateResponse(PhoneSaleViewDataBean psvdb,int updateLeavel,int index,int oprateCode) {
            this.psvdb = psvdb;
            this.updateLeavel=updateLeavel;
            this.index=index;
            this.oprateCode=oprateCode;
        }
        
        @Override
        public void setResponse(DataResponse dataResponse) {
            this.psvdb = (PhoneSaleViewDataBean) dataResponse;
        }

        @Override
        public DataResponse getResponse() {
            return psvdb;
        }
    }

    /**
     * 我的主页界面更新数据的接口
     */
    public static class MyIndexInfoUpdateResponse extends ViewUpdateResponse {
        private MyIndexInfoVIewDataBean miivdb;

        public MyIndexInfoUpdateResponse(MyIndexInfoVIewDataBean miivdb,int updateLeavel,int index,int oprateCode) {
            this.miivdb = miivdb;
            this.updateLeavel=updateLeavel;
            this.index=index;
            this.oprateCode=oprateCode;
        }
        

        @Override
        public void setResponse(DataResponse dataResponse) {
            this.miivdb = (MyIndexInfoVIewDataBean) dataResponse;
        }

        @Override
        public DataResponse getResponse() {
            return miivdb;
        }
    }


}
