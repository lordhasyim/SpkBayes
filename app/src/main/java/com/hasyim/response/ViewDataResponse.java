package com.hasyim.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Diiyo on 12/20/15.
 */
public class ViewDataResponse implements Serializable{

    private List<ViewData> data;

    public void setData(List<ViewData> data) {
        this.data = data;
    }

    public List<ViewData> getData() {
        return data;
    }


}
