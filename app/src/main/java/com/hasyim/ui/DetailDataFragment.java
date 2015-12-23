package com.hasyim.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hasyim.response.ViewData;
import com.hasyim.spkbayes.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hasyim on 12/21/2015.
 */


public class  DetailDataFragment extends AppCompatActivity {

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_detail_data);
        ButterKnife.bind(this);


        ViewData viewData = (ViewData)getIntent().getExtras().getSerializable("viewdata");
        System.out.println(viewData);

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
    }

    /* @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_detail_data, container, false);

        Bundle bundle = getArguments();
        ViewData viewdata = (ViewData)bundle.getSerializable("viewdata");

        //gawe ngecek tok..
        System.out.println(viewdata);
        return rootView;

    }*/
}
