package com.hasyim.util;

import android.content.Context;

import java.io.UnsupportedEncodingException;

/**
 * Created by danielnimafa on 18/06/2015.
 */
public class Koneksi {
    private static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
    private static final String urlPath = "/rsmobilesby/";
    private static String alamatServer = "";
    String urlIndex, urlFull;
    DBHandler db;

    public Koneksi(Context konteks) {
        db = new DBHandler(konteks);
        alamatServer = db.getAlamatServer();
        try {
            urlIndex = java.net.URLDecoder.decode(alamatServer, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    public String urlItem(){
        String hasil = "http://"+urlIndex + urlPath + "index.php";
        return hasil;
    }

    public String allLokasiUrl(){
        String hasil = "http://"+urlIndex + urlPath + "loadrs.php";
        return hasil;
    }

    public String allrsByAkre(){
        String hasil = "http://"+urlIndex + urlPath + "akreditasi.php";
        return hasil;
    }

    public String urlImg(){
        String hasil = "http://"+urlIndex + urlPath + "img/";
        return hasil;
    }
}
