package com.hasyim.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Danielnimafa on 24/12/2015.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "hospitalsby";
    private static final String login_table = "logintable";
    private static final String data_rs = "datars";
    private static final String TABEL_URL = "urlserver";

    private static final String KEY_ID = "id";
    private static final String KEY_rec_url = "urldomain";

    private static final String CREATE_URL_SETTING = "CREATE TABLE "
            + TABEL_URL + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_rec_url
            + " TEXT" + ")";

    /*private static final String CREATE_DAFPEN = "CREATE TABLE " + TABEL_DAFPEN
            + "(" + KEY_ID + " INTEGER PRIMARY KEY,"
            + key_dep_kode + " TEXT,"
            + KEY_dep + " TEXT,"
            + key_ha_kode + " TEXT," + key_ha_nama + " TEXT,"
            + key_jab_kode + " TEXT,"
            + KEY_jab + " TEXT,"
            + key_peg_email + " TEXT,"
            + key_peg_isaktif + " TEXT,"
            + KEY_kelamin + " TEXT,"
            + KEY_nama + " TEXT,"
            + KEY_nip + " TEXT,"
            + key_peg_ponsel + " TEXT,"
            + key_peg_telp + " TEXT" + ")";*/



    public DBHandler(Context ctx) {
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_URL_SETTING);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_URL_SETTING);
        onCreate(db);
    }

    public void addAlamatServer(String url) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_rec_url, url);
        db.insert(TABEL_URL, null, values);
        db.close();
    }

    public String getAlamatServer() {
        String hasil = "";
        String q = "SELECT * FROM " + TABEL_URL;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery(q, null);
        cur.moveToFirst();
        if (cur.getCount() > 0) {
//            kode.put(KEY_rec_url, cur.getString(1));
            hasil = cur.getString(1);
        }
        cur.close();
        db.close();
        return hasil;
    }

    public void resetAlamatServer() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABEL_URL, null, null);
        db.close();
    }

    public int getRowCountAlamatServer() {
        String countQuery = "SELECT*FROM " + TABEL_URL;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int rowCount = cursor.getCount();
        db.close();
        cursor.close();
        // return row count
        return rowCount;
    }
}
