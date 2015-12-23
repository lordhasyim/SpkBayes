package com.hasyim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.google.gson.Gson;
import com.hasyim.app.CustomApp;
import com.hasyim.model.PrediksiModel;
import com.hasyim.response.HasilEntity;
import com.hasyim.response.HasilPrediksiResponse;
import com.hasyim.spkbayes.R;
import com.hasyim.util.Constanta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hasyim on 12/18/2015.
 */
public class PrediksiFragment extends Fragment {

    @Bind(R.id.edt_id_toko)
    EditText edtIdToko;
    @Bind(R.id.edt_alamat_toko)
    EditText edtAlamatToko;
    @Bind(R.id.radio_smBread_ya)
    RadioButton radioSmBreadYa;
    @Bind(R.id.radio_smBread_tidak)
    RadioButton radioSmBreadTidak;
    @Bind(R.id.rg_smBread)
    RadioGroup rgSmBread;
    @Bind(R.id.radio_ssari_ya)
    RadioButton radioSsariYa;
    @Bind(R.id.radio_ssari_tidak)
    RadioButton radioSsariTidak;
    @Bind(R.id.rg_sSari)
    RadioGroup rgSSari;
    @Bind(R.id.radio_lokasiAda)
    RadioButton radioLokasiAda;
    @Bind(R.id.radio_lokasiTidakAda)
    RadioButton radioLokasiTidakAda;
    @Bind(R.id.rg_luasLokasi)
    RadioGroup rgLuasLokasi;
    @Bind(R.id.radio_bd_sanggup)
    RadioButton radioBdSanggup;
    @Bind(R.id.radio_bd_tidak)
    RadioButton radioBdTidak;
    @Bind(R.id.rg_besarDaya)
    RadioGroup rgBesarDaya;
    @Bind(R.id.radio_induk_bisa)
    RadioButton radioIndukBisa;
    @Bind(R.id.radio_induk_tidak)
    RadioButton radioIndukTidak;
    @Bind(R.id.rg_induk_listrik)
    RadioGroup rgIndukListrik;
    @Bind(R.id.radio_k_banyak)
    RadioButton radioKBanyak;
    @Bind(R.id.radio_k_sedikit)
    RadioButton radioKSedikit;
    @Bind(R.id.rg_kompetitor)
    RadioGroup rgKompetitor;
    @Bind(R.id.radio_al_mudah)
    RadioButton radioAlMudah;
    @Bind(R.id.radio_al_sulit)
    RadioButton radioAlSulit;
    @Bind(R.id.rg_akses_lokasi)
    RadioGroup rgAksesLokasi;
    @Bind(R.id.radio_target_besar)
    RadioButton radioTargetBesar;
    @Bind(R.id.radio_target_kecil)
    RadioButton radioTargetKecil;
    @Bind(R.id.rg_target_konsumen)
    RadioGroup rgTargetKonsumen;
    @Bind(R.id.radio_dt_tertarik)
    RadioButton radioDtTertarik;
    @Bind(R.id.radio_dt_tidak_tertarik)
    RadioButton radioDtTidakTertarik;
    @Bind(R.id.rg_dayatarik)
    RadioGroup rgDayatarik;
    @Bind(R.id.radio_izin_disetujui)
    RadioButton radioIzinDisetujui;
    @Bind(R.id.radio_izin_tidak)
    RadioButton radioIzinTidak;
    @Bind(R.id.rg_izin)
    RadioGroup rgIzin;
    @Bind(R.id.fabPrediksi)
    FloatingActionButton fabPrediksi;


    //variabel penampung untuk nantinya di kirim dengan method POST
    //penamaan variabel disesuaikan dengan bagian $_POST['name_variable'] yang ada di server php

//    Terapkan OOP saja
//    String notoko;
//    String alamatLokasi;
//    String s_mrBread;
//    String s_sariroti;
//    String luas_lokasi;
//    String besar_daya;
//    String p_induk;
//    String kompetitor;
//    String akses_lokasi;
//    String t_konsumen;
//    String dt_konsumen;
//    String izin_dinkes;

    //prediksi model
    PrediksiModel prediksi = new PrediksiModel();

    List<HasilEntity> items = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_prediksi, container, false);
        ButterKnife.bind(this, rootView);

         /*ambil nilai kriteria 1
        * Sales MrBread
        * */
        rgSmBread.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_smBread_ya:
                        prediksi.setS_mrBread("diatas 500000");
                        break;
                    case R.id.radio_smBread_tidak:
                        prediksi.setS_mrBread("dibawah 500000");
                        break;
                }
            }
        });
        /*
        * kriteria 2
        * Sales Sari Roti
        * */
        rgSSari.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_ssari_ya:
                        prediksi.setS_sariroti("diatas 500000");
                        break;
                    case R.id.radio_ssari_tidak:
                        prediksi.setS_sariroti("dibawah 500000");
                        break;
                }
            }
        });

        /*
        * kriteria 3
        * Luas Lokasi
        * */
        rgLuasLokasi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_lokasiAda:
                        prediksi.setLuas_lokasi("ada");
                        break;
                    case R.id.radio_lokasiTidakAda:
                        prediksi.setLuas_lokasi("tidak ada");
                        break;
                }
            }
        });

        /*
        * kriteria 4
        * Besar Daya
        * */
        rgBesarDaya.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_bd_sanggup:
                        prediksi.setBesar_daya("sanggup");
                        break;
                    case R.id.radio_bd_tidak:
                        prediksi.setBesar_daya("tidak_sanggup");
                        break;
                }
            }
        });

        /*
        * kriteria 5
        * Induk Listrik
        * */
        rgIndukListrik.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_induk_bisa:
                        prediksi.setP_induk("bisa");
                        break;
                    case R.id.radio_induk_tidak:
                        prediksi.setP_induk("tidak_bisa");
                        break;
                }
            }
        });

        /*
        * kriteria 6
        * Kompetitor
        * */
        rgKompetitor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_k_banyak:
                        prediksi.setKompetitor("banyak");
                        break;
                    case R.id.radio_k_sedikit:
                        prediksi.setKompetitor("sedikit");
                        break;
                }
            }
        });
        /*
        * kriteria 7
        * akses lokasi
        * */
        rgAksesLokasi.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_al_mudah:
                        prediksi.setAkses_lokasi("mudah");
                        break;
                    case R.id.radio_al_sulit:
                        prediksi.setAkses_lokasi("sulit");
                        break;
                }
            }
        });
        /*
        * kriteria 8
        * target konsumen
        * */
        rgTargetKonsumen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_target_besar:
                        prediksi.setT_konsumen("besar");
                        break;
                    case R.id.radio_target_kecil:
                        prediksi.setT_konsumen("kecil");
                        break;
                }
            }
        });
        /*
        * kriteria 9
        * Daya Tarik
        * */
        rgDayatarik.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_dt_tertarik:
                        prediksi.setDt_konsumen("tertarik");
                        break;
                    case R.id.radio_dt_tidak_tertarik:
                        prediksi.setDt_konsumen("tidak_tertarik");
                        break;
                }
            }
        });

        /*
        * kriteria 10
        * Izin Dinkes
        * */
        rgIzin.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_izin_disetujui:
                        prediksi.setIzin_dinkes("disetujui");
                        break;
                    case R.id.radio_izin_tidak:
                        prediksi.setIzin_dinkes("tidak_disetujui");
                        break;
                }
            }
        });

        fabPrediksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ambil value dr edittext
                prediksi.setNotoko(edtIdToko.getText().toString());
                prediksi.setAlamatLokasi(edtAlamatToko.getText().toString());

                sendDataToServer();
            }
        });



        return rootView;
    }

    private void sendDataToServer() {
        StringRequest request = new StringRequest(Request.Method.POST, Constanta.URL_PREDIKSI,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if (response != null) {

                            System.out.println("hasilnya " + response);

                            //check di logcat
                            HasilPrediksiResponse hasil = new Gson().fromJson(response, HasilPrediksiResponse.class);

                            Intent intent = new Intent(getActivity(), HasilPrediksiActivity.class);
                            intent.putExtra(Constanta.HASIL, hasil);
                            startActivity(intent);

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put(Constanta.NO_TOKO, prediksi.getNotoko());
                parameters.put(Constanta.ALAMAT, prediksi.getAlamatLokasi());
                parameters.put(Constanta.MRBREAD, prediksi.getS_mrBread());
                parameters.put(Constanta.SARI_ROTI, prediksi.getS_sariroti());
                parameters.put(Constanta.LUAS, prediksi.getLuas_lokasi());
                parameters.put(Constanta.DAYA, prediksi.getBesar_daya());
                parameters.put(Constanta.INDUK, prediksi.getP_induk());
                parameters.put(Constanta.KOMPETITOR, prediksi.getKompetitor());
                parameters.put(Constanta.AKSES_LOKASI, prediksi.getAkses_lokasi());
                parameters.put(Constanta.T_KONSUMEN, prediksi.getT_konsumen());
                parameters.put(Constanta.DT_KONSUMEN, prediksi.getDt_konsumen());
                parameters.put(Constanta.IZIN_DINKES, prediksi.getIzin_dinkes());
                return parameters;
            }
        };
        CustomApp.getInstance().addToRequestQueue(request);


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
