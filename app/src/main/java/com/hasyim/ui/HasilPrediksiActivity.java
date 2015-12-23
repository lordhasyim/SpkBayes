package com.hasyim.ui;

/**
 * Created by hasyim on 12/23/2015.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hasyim.response.HasilPrediksiResponse;
import com.hasyim.spkbayes.R;
import com.hasyim.util.Constanta;

import butterknife.Bind;
import butterknife.ButterKnife;


public class HasilPrediksiActivity extends AppCompatActivity {

    @Bind(R.id.txt_id)
    TextView txtId;
    @Bind(R.id.txt_no_toko)
    TextView txtNoToko;
    @Bind(R.id.txt_alamat)
    TextView txtAlamat;
    @Bind(R.id.txt_hasil_layak)
    TextView txtHasilLayak;
    @Bind(R.id.txt_hasil_tidak_layak)
    TextView txtHasilTidakLayak;
    @Bind(R.id.txt_ya_dibagi_tidak)
    TextView txtYaDibagiTidak;
    @Bind(R.id.txt_hasil_status)
    TextView txtHasilStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_hasil_prediksi);
        ButterKnife.bind(this);

        getDataIntent();
    }

    private void getDataIntent(){

        Bundle data = getIntent().getExtras();
        HasilPrediksiResponse response = (HasilPrediksiResponse) data.getSerializable(Constanta.HASIL);

        txtNoToko.setText(response.hasil.notoko);
        txtAlamat.setText(response.hasil.alamat);
        txtHasilStatus.setText(response.hasil.status);
        txtHasilTidakLayak.setText(response.hasil.hasilTidakLayak);
        txtYaDibagiTidak.setText(response.hasil.yabandingtidak);
        txtHasilLayak.setText(response.hasil.hasilLayak);
    }
}
