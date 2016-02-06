package com.hasyim.ui;


/**
 * Created by hasyim on 2/4/2016.
 */

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hasyim.response.ViewData;
import com.hasyim.spkbayes.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SpvDetailDataActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @Bind(R.id.app_bar)
    AppBarLayout appBar;
    @Bind(R.id.spv_txt_id)
    TextView spvTxtId;
    @Bind(R.id.spv_txt_no_toko)
    TextView spvTxtNoToko;
    @Bind(R.id.spv_txt_alamat)
    TextView spvTxtAlamat;
    @Bind(R.id.spv_txt_s_mrbread)
    TextView spvTxtSMrbread;
    @Bind(R.id.spv_txt_s_sariroti)
    TextView spvTxtSSariroti;
    @Bind(R.id.spv_txt_luas_lokasi)
    TextView spvTxtLuasLokasi;
    @Bind(R.id.spv_txt_besar_daya)
    TextView spvTxtBesarDaya;
    @Bind(R.id.spv_txt_induk_listrik)
    TextView spvTxtIndukListrik;
    @Bind(R.id.spv_txt_kompetitor)
    TextView spvTxtKompetitor;
    @Bind(R.id.spv_txt_akses_lokasi)
    TextView spvTxtAksesLokasi;
    @Bind(R.id.spv_txt_target_konsumen)
    TextView spvTxtTargetKonsumen;
    @Bind(R.id.spv_txt_daya_tarik)
    TextView spvTxtDayaTarik;
    @Bind(R.id.spv_txt_izin_dinkes)
    TextView spvTxtIzinDinkes;
    @Bind(R.id.spv_txt_status)
    TextView spvTxtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spv_detail_data);
        ButterKnife.bind(this);

        ViewData viewData = (ViewData) getIntent().getExtras().getSerializable("spv_view_data");
        System.out.println(viewData);




        spvTxtId.setText(viewData.getId());
        spvTxtNoToko.setText(viewData.getNo_toko());
        spvTxtAlamat.setText(viewData.getAlamat());
        spvTxtSMrbread.setText(viewData.getS_mrbread());
        spvTxtSSariroti.setText(viewData.getS_sariroti());
        spvTxtLuasLokasi.setText(viewData.getLuas_lokasi());
        spvTxtBesarDaya.setText(viewData.getBesar_daya());
        spvTxtIndukListrik.setText(viewData.getInduk_listrik());
        spvTxtKompetitor.setText(viewData.getKompetitor());
        spvTxtAksesLokasi.setText(viewData.getAkses_lokasi());
        spvTxtTargetKonsumen.setText(viewData.getTarget_konsumen());
        spvTxtDayaTarik.setText(viewData.getDaya_tarik());
        spvTxtIzinDinkes.setText(viewData.getIzin_dinkes());
        spvTxtStatus.setText(viewData.getStatus());




    }
}















