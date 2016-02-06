package com.hasyim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.google.gson.Gson;
import com.hasyim.adapter.ViewDataAdapter;
import com.hasyim.app.CustomApp;
import com.hasyim.response.ViewData;
import com.hasyim.response.ViewDataResponse;
import com.hasyim.spkbayes.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


public class SpvLihatDataFragment extends Fragment implements ViewDataAdapter.OnItemClickListener {

    @Bind(R.id.spv_list_lihat_data)
    RecyclerView spvListLihatData;

    List<ViewData> items = new ArrayList<>();
    ViewDataAdapter adapter;

    public static final String URL_SPV_LIHAT_DATA = "http://kaptenkomodo.bl.ee/spk/api/viewData.php";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_spv_lihat_data, container, false);

        ButterKnife.bind(this, rootView);

        spvListLihatData.setHasFixedSize(true);
        spvListLihatData.setLayoutManager(new LinearLayoutManager(getContext()));

        items.clear();
        adapter = new ViewDataAdapter(getContext(), items);
        adapter.setOnItemClickListener(this);
        spvListLihatData.setAdapter(adapter);

        getSpvDataFromJson();

        return rootView;
    }

    private void getSpvDataFromJson() {
        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL_SPV_LIHAT_DATA,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if (response!=null) {
                            System.out.println(response);
                            ViewDataResponse dataResponse = new Gson().fromJson(response, ViewDataResponse.class);

                            items.addAll(dataResponse.getData());
                            //utk logging di logcat
                            System.out.println(items.size());
                            adapter.notifyDataSetChanged();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();

            }

        });
        CustomApp.getInstance().addToRequestQueue(stringRequest);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

  /*  @OnClick(R.id.spv_list_lihat_data)
    public void onClick() {
    }*/

    @Override
    public void onClick(int position) {
        ViewData viewData = items.get(position);
        Intent intent = new Intent(getActivity(), SpvDetailDataActivity.class);
        intent.putExtra("spv_view_data", viewData);
        startActivity(intent);


    }
}








