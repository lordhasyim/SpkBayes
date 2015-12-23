package com.hasyim.response;

import java.io.Serializable;

/**
 * Created by Diiyo on 12/20/15.
 */
public class HasilEntity implements Serializable {
    private String notoko;
    private String alamat;
    private String p_layak;
    private int hasil_layak;
    private String p_tidaklayak;
    private int hasil_tidak_layak;
    private String p_ya_banding_tidak;
    private String status;

    public void setNotoko(String notoko) {
        this.notoko = notoko;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setP_layak(String p_layak) {
        this.p_layak = p_layak;
    }

    public void setHasil_layak(int hasil_layak) {
        this.hasil_layak = hasil_layak;
    }

    public void setP_tidaklayak(String p_tidaklayak) {
        this.p_tidaklayak = p_tidaklayak;
    }

    public void setHasil_tidak_layak(int hasil_tidak_layak) {
        this.hasil_tidak_layak = hasil_tidak_layak;
    }

    public void setP_ya_banding_tidak(String p_ya_banding_tidak) {
        this.p_ya_banding_tidak = p_ya_banding_tidak;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotoko() {
        return notoko;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getP_layak() {
        return p_layak;
    }

    public int getHasil_layak() {
        return hasil_layak;
    }

    public String getP_tidaklayak() {
        return p_tidaklayak;
    }

    public int getHasil_tidak_layak() {
        return hasil_tidak_layak;
    }

    public String getP_ya_banding_tidak() {
        return p_ya_banding_tidak;
    }

    public String getStatus() {
        return status;
    }
}
