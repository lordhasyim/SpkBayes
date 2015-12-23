package com.hasyim.response;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Diiyo on 12/20/15.
 */
public class HasilResponse implements Serializable {

    private List<HasilEntity> dataHasil;

    public void setDataHasil(List<HasilEntity> dataHasil) {
        this.dataHasil = dataHasil;
    }

    public List<HasilEntity> getDataHasil(){
        return dataHasil;
    }


    //asline ngene
    /*private HasilEntity hasil;

    public void setHasil(HasilEntity hasil) {
        this.hasil = hasil;
    }

    public HasilEntity getHasil() {
        return hasil;
    }
*/

}