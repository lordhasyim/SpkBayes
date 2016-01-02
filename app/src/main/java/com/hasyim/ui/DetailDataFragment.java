package com.hasyim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.hasyim.app.CustomApp;
import com.hasyim.response.ViewData;
import com.hasyim.spkbayes.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hasyim on 12/21/2015.
 */


public class DetailDataFragment extends AppCompatActivity {

    @Bind(R.id.txt_id)
    TextView textId;
    @Bind(R.id.txt_no_toko)
    TextView textNoToko;
    @Bind(R.id.txt_alamat)
    TextView textAlamat;
    @Bind(R.id.txt_s_mrbread)
    TextView textSMrBread;
    @Bind(R.id.txt_s_sariroti)
    TextView textSSariRoti;
    @Bind(R.id.txt_luas_lokasi)
    TextView textLuasLokasi;
    @Bind(R.id.txt_besar_daya)
    TextView textBesarDaya;
    @Bind(R.id.txt_induk_listrik)
    TextView textIndukListrik;
    @Bind(R.id.txt_kompetitor)
    TextView textKompetitor;
    @Bind(R.id.txt_akses_lokasi)
    TextView textAksesLokasi;
    @Bind(R.id.txt_target_konsumen)
    TextView textTargetKonsumen;
    @Bind(R.id.txt_daya_tarik)
    TextView textDayaTarik;
    @Bind(R.id.txt_izin_dinkes)
    TextView textIzinDinkes;
    @Bind(R.id.txt_status)
    TextView textStatus;
    @Bind(R.id.btnHapusData)
    Button btnHapusData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail_data);
        ButterKnife.bind(this);




        ViewData viewData = (ViewData) getIntent().getExtras().getSerializable("viewdata");
        System.out.println(viewData);

        //url delete dengan parameter diambil dari id
        final String idDelete = viewData.getId();
        final String URL_DELETE = "http://kaptenkomodo.bl.ee/spk/api/deleteData.php?id="+idDelete;

        //textId.setText(viewData.getId().toString());

        textId.setText(viewData.getId());
        textNoToko.setText(viewData.getNo_toko());
        textAlamat.setText(viewData.getAlamat());
        textSMrBread.setText(viewData.getS_mrbread());
        textSSariRoti.setText(viewData.getS_sariroti());
        textLuasLokasi.setText(viewData.getLuas_lokasi());
        textBesarDaya.setText(viewData.getBesar_daya());
        textIndukListrik.setText(viewData.getInduk_listrik());
        textKompetitor.setText(viewData.getKompetitor());
        textAksesLokasi.setText(viewData.getAkses_lokasi());
        textTargetKonsumen.setText(viewData.getTarget_konsumen());
        textDayaTarik.setText(viewData.getDaya_tarik());
        textIzinDinkes.setText(viewData.getIzin_dinkes());
        textStatus.setText(viewData.getStatus());

        btnHapusData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check logcat apakah url dan id sudah sesuai
                System.out.println("idDelete : " + idDelete);
                System.out.println("Url Delete : " + URL_DELETE);

                //sendDataToServer
                StringRequest request = new StringRequest(Request.Method.POST, URL_DELETE,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //check logcat
                                System.out.println("request delete : " + response);

                                if (response != null) {
                                    Toast.makeText(getApplicationContext(), "Berhasil Menghapus data",
                                            Toast.LENGTH_SHORT).show();
                                    MoveToLihatData();
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        error.printStackTrace();
                    }
                });
                CustomApp.getInstance().addToRequestQueue(request);
            }
        });

    }

    private void MoveToLihatData() {
        /*Fragment newFragment = new MainFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.mainMenuFragment, newFragment);
        ft.commit();*/

        Intent intent = new Intent(DetailDataFragment.this, MainActivity.class);
        startActivity(intent);


    }

/*
    private void sendDataToServer() {

        StringRequest request = new StringRequest(Request.Method.POST, URL_DELETE

    }
*/


}
