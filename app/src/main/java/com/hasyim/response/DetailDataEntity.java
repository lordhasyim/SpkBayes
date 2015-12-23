package com.hasyim.response;

import java.io.Serializable;

/**
 * Created by Diiyo on 12/20/15.
 */
public class DetailDataEntity implements Serializable{

    private String no_toko;
    private String alamat;
    private String s_mrbread;
    private String s_sariroti;
    private String luas_lokasi;
    private String besar_daya;
    private String induk_listrik;
    private String kompetitor;
    private String akses_lokasi;
    private String target_konsumen;
    private String daya_tarik;
    private String izin_dinkes;
    private String status;

    public void setNo_toko(String no_toko) {
        this.no_toko = no_toko;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public void setS_mrbread(String s_mrbread) {
        this.s_mrbread = s_mrbread;
    }

    public void setS_sariroti(String s_sariroti) {
        this.s_sariroti = s_sariroti;
    }

    public void setLuas_lokasi(String luas_lokasi) {
        this.luas_lokasi = luas_lokasi;
    }

    public void setBesar_daya(String besar_daya) {
        this.besar_daya = besar_daya;
    }

    public void setInduk_listrik(String induk_listrik) {
        this.induk_listrik = induk_listrik;
    }

    public void setKompetitor(String kompetitor) {
        this.kompetitor = kompetitor;
    }

    public void setAkses_lokasi(String akses_lokasi) {
        this.akses_lokasi = akses_lokasi;
    }

    public void setTarget_konsumen(String target_konsumen) {
        this.target_konsumen = target_konsumen;
    }

    public void setDaya_tarik(String daya_tarik) {
        this.daya_tarik = daya_tarik;
    }

    public void setIzin_dinkes(String izin_dinkes) {
        this.izin_dinkes = izin_dinkes;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNo_toko() {
        return no_toko;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getS_mrbread() {
        return s_mrbread;
    }

    public String getS_sariroti() {
        return s_sariroti;
    }

    public String getLuas_lokasi() {
        return luas_lokasi;
    }

    public String getBesar_daya() {
        return besar_daya;
    }

    public String getInduk_listrik() {
        return induk_listrik;
    }

    public String getKompetitor() {
        return kompetitor;
    }

    public String getAkses_lokasi() {
        return akses_lokasi;
    }

    public String getTarget_konsumen() {
        return target_konsumen;
    }

    public String getDaya_tarik() {
        return daya_tarik;
    }

    public String getIzin_dinkes() {
        return izin_dinkes;
    }

    public String getStatus() {
        return status;
    }
}

