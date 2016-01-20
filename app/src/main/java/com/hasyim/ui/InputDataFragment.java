package com.hasyim.ui;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.hasyim.app.CustomApp;
import com.hasyim.spkbayes.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by hasyim on 12/18/2015.
 */
public class InputDataFragment extends Fragment {

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
    RadioButton radio;
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
    RadioButton radioBesar;
    @Bind(R.id.radio_target_kecil)
    RadioButton radioKecil;
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
    @Bind(R.id.radio_s_layak)
    RadioButton radioSLayak;
    @Bind(R.id.radio_s_tidak_layak)
    RadioButton radioSTidakLayak;
    @Bind(R.id.rg_status)
    RadioGroup rgStatus;
    @Bind(R.id.btn_save)
    Button btnSave;
    @Bind(R.id.btn_reset)
    Button btnReset;
    @Bind(R.id.fabKirimData)
    FloatingActionButton fabKirimData;
    @Bind(R.id.edt_getlat)
    EditText edtGetlat;
    @Bind(R.id.edt_getlong)
    EditText edtGetlong;
    @Bind(R.id.btnGetLocation)
    Button btnGetLocation;

    private String URL_INPUT_DATA = "http://kaptenkomodo.bl.ee/spk/api/inputData.php";
    private Button btnTambahData;

    //variabel penampung untuk nantinya di kirim dengan method POST
    //penamaan variabel disesuaikan dengan bagian $_POST['name_variable'] yang ada di server php
    String notoko;
    String alamatLokasi;
    String lat_lokasi;
    String long_lokasi;
    String s_mrBread;
    String s_sariroti;
    String luas_lokasi;
    String besar_daya;
    String p_induk;
    String kompetitor;
    String akses_lokasi;
    String t_konsumen;
    String dt_konsumen;
    String izin_dinkes;
    String status;

    private LocationManager locationManager;
    private LocationListener locationListener;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_input_data, container, false);
        ButterKnife.bind(this, rootView);

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                //check di logcat apakah locationListener sudah bekerja
                System.out.println("latitude : " + location.getLatitude());
                System.out.println("longitude : " + location.getLongitude());

                edtGetlat.setText(String.valueOf(location.getLatitude()));
                edtGetlong.setText(String.valueOf(location.getLongitude()));

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        /*
        penggunaan this di fragment menggunakan getActivity()
        atau bisa menggunakan getApplicationContext()
        * taken from
        * http://stackoverflow.com/questions/14161892/retrieve-context-from-a-fragment
        * */


        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return null;
        }

        locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);




        /*ambil nilai kriteria 1
        * Sales MrBread
        * */
        rgSmBread.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_smBread_ya:
                        s_mrBread = "diatas 500000";
                        break;
                    case R.id.radio_smBread_tidak:
                        s_mrBread = "dibawah 500000";
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
                        s_sariroti = "diatas 500000";
                        break;
                    case R.id.radio_ssari_tidak:
                        s_sariroti = "dibawah 500000";
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
                        luas_lokasi = "ada";
                        break;
                    case R.id.radio_lokasiTidakAda:
                        luas_lokasi = "tidak_ada";
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
                        besar_daya = "sanggup";
                        break;
                    case R.id.radio_bd_tidak:
                        besar_daya = "tidak_sanggup";
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
                        p_induk = "bisa";
                        break;
                    case R.id.radio_induk_tidak:
                        p_induk = "tidak_bisa";
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
                        kompetitor = "banyak";
                        break;
                    case R.id.radio_k_sedikit:
                        kompetitor = "sedikit";
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
                        akses_lokasi = "mudah";
                        break;
                    case R.id.radio_al_sulit:
                        akses_lokasi = "sulit";
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
                        t_konsumen = "besar";
                        break;
                    case R.id.radio_target_kecil:
                        t_konsumen = "kecil";
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
                        dt_konsumen = "tertarik";
                        break;
                    case R.id.radio_dt_tidak_tertarik:
                        dt_konsumen = "tidak_tertarik";
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
                        izin_dinkes = "disetujui";
                        break;
                    case R.id.radio_izin_tidak:
                        izin_dinkes = "tidak_disetujui";
                        break;
                }
            }
        });

        rgStatus.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_s_layak:
                        status = "layak";
                        break;
                    case R.id.radio_s_tidak_layak:
                        status = "tidak_layak";
                        break;
                }
            }
        });

        btnGetLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });


        fabKirimData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ambil value dr edittext
                notoko = edtIdToko.getText().toString();
                alamatLokasi = edtAlamatToko.getText().toString();
                lat_lokasi = edtGetlat.getText().toString();
                long_lokasi = edtGetlong.getText().toString();


                //utk cek value apakah sudah sesuai di logcat
                System.out.println("no toko : " + notoko);
                System.out.println("alamat : " + alamatLokasi);
                System.out.println("latitude : " + lat_lokasi);
                System.out.println("longitude : " + long_lokasi);
                //kriteria
                System.out.println("kriteria 1 : " + s_mrBread);
                System.out.println("kriteria 2 : " + s_sariroti);
                System.out.println("kriteria 3 : " + luas_lokasi);
                System.out.println("kriteria 4 : " + besar_daya);
                System.out.println("kriteria 5 : " + p_induk);
                System.out.println("kriteria 6 : " + kompetitor);
                System.out.println("kriteria 7 : " + akses_lokasi);
                System.out.println("kriteria 8 : " + t_konsumen);
                System.out.println("kriteria 9 : " + dt_konsumen);
                System.out.println("kriteria 10 : " + izin_dinkes);
                System.out.println("nilai status : " + status);
                System.out.println("lat_lokasi" + lat_lokasi);
                System.out.println("long_lokasi" + long_lokasi);

                //end cek value

                sendDataToServer();
            }
        });


        return rootView;
    }

    private void sendDataToServer() {
        StringRequest request = new StringRequest(Request.Method.POST, URL_INPUT_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response != null) {
                            System.out.println(response);

                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parameters = new HashMap<String, String>();
                parameters.put("notoko", notoko);
                parameters.put("alamatLokasi", alamatLokasi);
                parameters.put("lat_lokasi", lat_lokasi);
                parameters.put("long_lokasi", long_lokasi);
                parameters.put("s_mrBread", s_mrBread);
                parameters.put("s_sariroti", s_sariroti);
                parameters.put("luas_lokasi", luas_lokasi);
                parameters.put("besar_daya", besar_daya);
                parameters.put("p_induk", p_induk);
                parameters.put("kompetitor", kompetitor);
                parameters.put("akses_lokasi", akses_lokasi);
                parameters.put("t_konsumen", t_konsumen);
                parameters.put("dt_konsumen", dt_konsumen);
                parameters.put("izin_dinkes", izin_dinkes);
                parameters.put("status", status);
                parameters.put("lat", lat_lokasi);
                parameters.put("lng", long_lokasi);
                return parameters;
            }
        };
        CustomApp.getInstance().addToRequestQueue(request);

        //tambahkan informasi juga data berhasil dikirim
        Toast.makeText(getActivity(), "Data Berhasil Di input", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
