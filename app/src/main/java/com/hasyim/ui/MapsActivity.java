package com.hasyim.ui;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.hasyim.app.CustomApp;
import com.hasyim.model.LokasiModel;
import com.hasyim.spkbayes.R;
import com.hasyim.util.TampilToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private String TAG = MapsActivity.class.getSimpleName();

    private List<LokasiModel> lokasiModels;

    private TampilToast tos;

    private ArrayList<Marker> listMarkers;

    private View v;
    private HashMap<String, HashMap<String, String>> extraMarkerInfo =
            new HashMap<String, HashMap<String, String>>();

   // private String URL_LOKASI = "http://192.168.43.11/spk/api/petalokasi.php";
    private String URL_LOKASI = "http://kaptenkomodo.bl.ee/spk/api/petalokasi.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        /*SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);*/
        //mapFragment.getMapAsync(this);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        lokasiModels = new ArrayList<LokasiModel>();
        tos = new TampilToast(this);
        listMarkers = new ArrayList<Marker>();

        MapFragment mf = (MapFragment) getFragmentManager().findFragmentById(R.id.map_lokasi);
        mf.getMapAsync(this);
        mMap = mf.getMap();
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-7.255930, 112.752529),  14.0f));



    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        //getting data from URL
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_LOKASI,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println("hasil response : " + response );
                        try {
                            JSONObject dataLokasi = new JSONObject(response);
                            //cek di logcat, apakah data sudah berhasil diterima atau tidak
                            System.out.println("dataLokasi : " + dataLokasi);

                            JSONArray arrayData = dataLokasi.getJSONArray("data");
                            //cek di logcat, apakah data sudah berhasil diterima
                            System.out.println("arrayData : " + arrayData);

                            for (int i = 0; i < arrayData.length(); i++) {
                                JSONObject jsonLokasi = arrayData.getJSONObject(i);

                                LokasiModel lokasiModel = new LokasiModel();

                                lokasiModel.setId(jsonLokasi.getString("id"));
                                lokasiModel.setNotoko(jsonLokasi.getString("no_toko"));
                                lokasiModel.setAlamatLokasi(jsonLokasi.getString("alamat"));
                                lokasiModel.setS_mrBread(jsonLokasi.getString("s_mrbread"));
                                lokasiModel.setS_sariroti(jsonLokasi.getString("s_sariroti"));
                                lokasiModel.setLuas_lokasi(jsonLokasi.getString("luas_lokasi"));
                                lokasiModel.setBesar_daya(jsonLokasi.getString("besar_daya"));
                                lokasiModel.setP_induk(jsonLokasi.getString("induk_listrik"));
                                lokasiModel.setKompetitor(jsonLokasi.getString("kompetitor"));
                                lokasiModel.setAkses_lokasi(jsonLokasi.getString("akses_lokasi"));
                                lokasiModel.setT_konsumen(jsonLokasi.getString("target_konsumen"));
                                lokasiModel.setDt_konsumen(jsonLokasi.getString("daya_tarik"));
                                lokasiModel.setIzin_dinkes(jsonLokasi.getString("izin_dinkes"));
                                lokasiModel.setStatus(jsonLokasi.getString("status"));
                                lokasiModel.setLat(jsonLokasi.getString("lat"));
                                lokasiModel.setLng(jsonLokasi.getString("long"));

                                lokasiModels.add(lokasiModel);

                                //proses menampilkan marker ke google maps.....
                                for (LokasiModel data : lokasiModels) {
                                    /*Double lat_lokasi = Double.parseDouble(data.getLat());
                                    Double lng_lokasi = Double.parseDouble(data.getLng());*/

                                    Double lat_lokasi = Double.valueOf(data.getLat());
                                    Double lng_lokasi = Double.valueOf(data.getLng());

                                    /*double lat_lokasi = new Double(Double.parseDouble(data.getLat().toString()));
                                    double lng_lokasi = new Double(Double.parseDouble(data.getLng().toString()));*/



                                    LatLng coordinatLokasi = new LatLng(lat_lokasi, lng_lokasi);
                                    //cek data di logcat apakah data sudah bisa diproses
                                    System.out.println("koordinat lokasi : " + coordinatLokasi);

                                    //masukkan ke marker
                                    Marker markerLokasi = mMap.addMarker(new MarkerOptions()
                                                    .position(coordinatLokasi)
                                                    .snippet(data.getNotoko())
                                    );

                                    markerLokasi.hideInfoWindow();
                                    HashMap<String, String> sip = new HashMap<String, String>();



                                    sip.put("lokasi_id", data.getId());
                                    sip.put("lokasi_no_toko", data.getNotoko());
                                    sip.put("lokasi_alamat", data.getAlamatLokasi());
                                    sip.put("lokasi_s_mrbread", data.getS_mrBread());
                                    sip.put("lokasi_s_sariroti", data.getS_sariroti());
                                    sip.put("lokasi_luas_lokasi", data.getLuas_lokasi());
                                    sip.put("lokasi_besar_daya", data.getBesar_daya());
                                    sip.put("lokasi_induk_listrik", data.getP_induk());
                                    sip.put("lokasi_kompetitor", data.getKompetitor());
                                    sip.put("lokasi_akses_lokasi", data.getAkses_lokasi());
                                    sip.put("lokasi_target_konsumen", data.getT_konsumen());
                                    sip.put("lokasi_dt_konsumen", data.getDt_konsumen());
                                    sip.put("lokasi_izin_dinkes", data.getIzin_dinkes());
                                    sip.put("lokasi_status", data.getStatus());
                                    sip.put("lokasi_lat", data.getLat());
                                    sip.put("lokasi_long", data.getLng());

                                    extraMarkerInfo.put(markerLokasi.getId(), sip);
                                    listMarkers.add(markerLokasi);

                                }
                                
                                mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                                    @Override
                                    public View getInfoWindow(Marker marker) {
                                        return null;
                                    }

                                    @Override
                                    public View getInfoContents(Marker marker) {

                                        HashMap<String, String> mdata = extraMarkerInfo.get(marker.getId());

                                        v = getLayoutInflater().inflate(R.layout.windowlayout_map, null);

                                        TextView text_lokasi_id = (TextView) v.findViewById(R.id.txt_lokasi_id);
                                        TextView text_lokasi_no_toko = (TextView) v.findViewById(R.id.txt_lokasi_no_toko);
                                        TextView text_lokasi_alamat = (TextView) v.findViewById(R.id.txt_lokasi_alamat_toko);
                                        TextView text_lokasi_status = (TextView) v.findViewById(R.id.txt_lokasi_status);


                                        text_lokasi_id.setText(mdata.get("lokasi_id"));
                                        text_lokasi_no_toko.setText(mdata.get("lokasi_no_toko"));
                                        text_lokasi_alamat.setText(mdata.get("lokasi_alamat"));
                                        text_lokasi_status.setText(mdata.get("lokasi_status"));

                                        return v;
                                    }
                                });

                                mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
                                    @Override
                                    public void onInfoWindowClick(Marker mr) {
                                        HashMap<String, String> mdata = extraMarkerInfo.get(mr.getId());

                                        Intent intent = new Intent(MapsActivity.this, DetailMapsActivity.class);

                                        intent.putExtra("lokasi_id", mdata.get("lokasi_id"));
                                        intent.putExtra("lokasi_no_toko", mdata.get("lokasi_no_toko"));
                                        intent.putExtra("lokasi_alamat", mdata.get("lokasi_almat"));
                                        intent.putExtra("lokasi_status", mdata.get("lokasi_status"));

                                        startActivity(intent);
                                    }
                                });

                                LatLngBounds.Builder builder = new LatLngBounds.Builder();
                                for (Marker marker : listMarkers) {
                                    builder.include(marker.getPosition());

                                }

                                LatLngBounds bounds = builder.build();
                                int padding =120;
                                CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(
                                        bounds, padding);
                                mMap.animateCamera(cameraUpdate);




                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println("Terjadi Error");

            }
        });

        CustomApp.getInstance().addToRequestQueue(stringRequest);
    }

}
