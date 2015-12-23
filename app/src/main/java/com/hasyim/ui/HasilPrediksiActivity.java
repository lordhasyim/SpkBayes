package com.hasyim.ui;

/**
 * Created by hasyim on 12/23/2015.
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.hasyim.response.HasilEntity;
import com.hasyim.spkbayes.R;

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

    private String URL_HASIL = "http://kaptenkomodo.bl.ee/spk/api/prosesBayes.php";

    //List<HasilEntity> items = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_hasil_prediksi);
        ButterKnife.bind(this);

        HasilEntity hasilEntity = (HasilEntity)getIntent().getExtras().getSerializable("hasilPerhitungan");
        System.out.println(hasilEntity);




    }

    /*public void getDataFromJson() {
        StringRequest request = new StringRequest(Request.Method.POST, URL_HASIL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        HasilResponse hasilResponse = new Gson().fromJson(response, HasilResponse.class);
                        System.out.println("hasilResponse : " + hasilResponse);

                        HasilEntity hasilEntity = new Gson().fromJson(response, HasilEntity.class);
                        System.out.println("hasil entity : " + hasilEntity);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        CustomApp.getInstance().addToRequestQueue(request);
    }*/
}
