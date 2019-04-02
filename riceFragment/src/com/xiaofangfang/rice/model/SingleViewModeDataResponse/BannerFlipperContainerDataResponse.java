package com.xiaofangfang.rice.model.SingleViewModeDataResponse;

import com.xiaofangfang.rice.model.StatusResponseJson;
import com.xiaofangfang.rice.model.view_mode.BannerFlipContainerDataBean;

public class BannerFlipperContainerDataResponse extends DataResponse {


    private BannerFlipContainerDataBean bannerFlipContainerDataBean;

    public BannerFlipperContainerDataResponse(StatusResponseJson statusResponseJson,
                                              String consumeViewName, String parentViewName,
                                              BannerFlipContainerDataBean bannerFlipContainerDataBean,
                                              int additionLocationIndex) {
        super(statusResponseJson, consumeViewName, parentViewName,additionLocationIndex);
        this.bannerFlipContainerDataBean = bannerFlipContainerDataBean;
    }

    public BannerFlipperContainerDataResponse(BannerFlipContainerDataBean bannerFlipContainerDataBean) {
        this.bannerFlipContainerDataBean = bannerFlipContainerDataBean;
    }


    public BannerFlipContainerDataBean getBannerFlipContainerDataBean() {
        return bannerFlipContainerDataBean;
    }

    public void setBannerFlipContainerDataBean(BannerFlipContainerDataBean bannerFlipContainerDataBean) {
        this.bannerFlipContainerDataBean = bannerFlipContainerDataBean;
    }
}
