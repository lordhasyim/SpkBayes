package com.hasyim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hasyim.spkbayes.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailMapsActivity extends AppCompatActivity {

    @Bind(R.id.judul)
    TextView judul;
    @Bind(R.id.txt_title_no_toko)
    TextView txtTitleNoToko;
    @Bind(R.id.txt_detail_alamat)
    TextView txtDetailAlamat;
    @Bind(R.id.txt_detail_maps_status)
    TextView txtDetailMapsStatus;
    private String id, noToko, alamat, status;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_maps);
        ButterKnife.bind(this);

        Intent in = getIntent();

        id = in.getStringExtra("lokasi_id");
        noToko = in.getStringExtra("lokasi_no_toko");
        alamat = in.getStringExtra("lokasi_alamat");
        status = in.getStringExtra("lokasi_status");

        txtTitleNoToko.setText(noToko);
        txtDetailAlamat.setText(alamat);
        txtDetailMapsStatus.setText(status);

        /*
        * TAmbahkan method utk fitur navigasi
        * */









    }





















}
