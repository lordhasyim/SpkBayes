package com.hasyim.response;

import java.util.List;

/**
 * Created by Diiyo on 12/20/15.
 */
public class DetailData {

    private List<DetailDataEntity> detailData;

    public void setDetailData(List<DetailDataEntity> detailData) {
        this.detailData = detailData;
    }

    public List<DetailDataEntity> getDetailData() {
        return detailData;
    }
}
