package com.hasyim.util;

import android.content.Context;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;

/**
 * Created by hasyim on 1/12/2016.
 */
public class Const {

    public static final String URL_ALl_DATA = "http://10.0.3.2/REST_peta/petalokasi.php";


    private static HashMap<String, String> domainHash = new HashMap<String, String>();
    private static String domain, http_tag;
    private static Context cont;
    private DBHandler db;

    public Const(Context ctx) {
        cont = ctx;
        db = new DBHandler(cont);
        try {
            domain = java.net.URLDecoder.decode(domainHash.get("urldomain"),  "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        http_tag = "http://";
    }

    public String urlLoadrs() {
        String url = http_tag + domain + "/index.php";
        return url;
    }
}
