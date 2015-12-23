package com.hasyim.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Diiyo on 12/23/15.
 */
public class HasilPrediksiResponse implements Serializable{

    @SerializedName("hasil")
    public Hasil hasil;

    public static class Hasil implements Serializable{
        @SerializedName("notoko")
        public String notoko;
        @SerializedName("alamat")
        public String alamat;
        @SerializedName("p_layak")
        public String pLayak;
        @SerializedName("hasil_layak")
        public String hasilLayak;
        @SerializedName("p_tidaklayak")
        public String pTidakLayak;
        @SerializedName("hasil_tidak_layak")
        public String hasilTidakLayak;
        @SerializedName("p_ya_banding_tidak")
        public String yabandingtidak;
        @SerializedName("status")
        public String status;

    }
}
