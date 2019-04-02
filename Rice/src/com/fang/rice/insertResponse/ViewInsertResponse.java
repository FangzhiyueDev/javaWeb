package com.fang.rice.insertResponse;

import com.fang.viewdataBean.ActionHorizontalScrollViewDataBean;
import com.fang.viewdataBean.BannerDataRespnse;
import com.fang.viewdataBean.DataResponse;
import com.fang.viewdataBean.FunctionModeViewDataBean;
import com.fang.viewdataBean.LiangHaoDisplayViewDataBean;
import com.fang.viewdataBean.MyIndexInfoVIewDataBean;
import com.fang.viewdataBean.PhoneDisplayViewDataBean;
import com.fang.viewdataBean.PhoneSaleViewDataBean;
import com.fang.viewdataBean.SetmealViewDataBean;

public abstract class ViewInsertResponse extends ViewResponse {

    protected String consumeViewName;

    protected int updateLeavel;


    public static class FunctionModeInsertResponse extends ViewInsertResponse {


        private FunctionModeViewDataBean functionDataResponse;


        @Override
        public void setResponse(DataResponse dataResponse) {
            this.functionDataResponse = (FunctionModeViewDataBean) dataResponse;
        }

        @Override
        public DataResponse getResponse() {

            return functionDataResponse;
        }
    }


    /**
     * bannerFlipperCOntainer的更新的响应数据封装
     */
    public static class BannerFlipperInsertResponse extends ViewInsertResponse {


        private BannerDataRespnse bannerDataRespnse;

        public BannerFlipperInsertResponse(BannerDataRespnse bannerDataRespnse) {
            this.bannerDataRespnse = bannerDataRespnse;
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
    public static class ActionHorizonalScrollViewInsertResponse extends ViewInsertResponse {


        private ActionHorizontalScrollViewDataBean ahsd;

         public ActionHorizonalScrollViewInsertResponse(int index,int oprateCode,ActionHorizontalScrollViewDataBean ahsvdb,String consumeViewName,int updateLeavel) {
			this.oprateCode=oprateCode;
			this.index=index;
			this.ahsd=ahsvdb;
			this.consumeViewName=consumeViewName;
			this.updateLeavel=updateLeavel;
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
     * 手机展示视图的更新的响应接口的数据封装
     */
    public static class PhoneDisplayInsertResponse extends ViewInsertResponse {

        private PhoneDisplayViewDataBean pdvd;


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
    public static class SetmealViewDataBeanInsertResponse extends ViewInsertResponse {

        private SetmealViewDataBean svdb;


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
    public static class LiangHaoInsertResponse extends ViewInsertResponse {

        private LiangHaoDisplayViewDataBean lhdvd;


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
    public static class PhoneSaleInsertResponse extends ViewInsertResponse {

        private PhoneSaleViewDataBean psvdb;

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
    public static class MyIndexInfoInsertResponse extends ViewInsertResponse {
        private MyIndexInfoVIewDataBean miivdb;


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
