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

/**
 * Created by hasyim on 12/18/2015.
 */
public class LihatDataFragment extends Fragment implements ViewDataAdapter.OnItemClickListener {

    @Bind(R.id.list_lihat_data)
    RecyclerView listLihatData;

    List<ViewData> items = new ArrayList<>();
    ViewDataAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_lihat_data, container, false);
        ButterKnife.bind(this, rootView);

        listLihatData.setHasFixedSize(true);
        listLihatData.setLayoutManager(new LinearLayoutManager(getContext()));

        items.clear();
        adapter = new ViewDataAdapter(getContext(), items);
        adapter.setOnItemClickListener(this);
        listLihatData.setAdapter(adapter);


        getDataFromJson();

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    public void getDataFromJson(){
        StringRequest request = new StringRequest(Request.Method.GET, "http://kaptenkomodo.bl.ee/spk/api/viewData.php",
                new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response != null){
                    System.out.println(response);
                    ViewDataResponse dataResponse = new Gson().fromJson(response, ViewDataResponse.class);


                    items.addAll(dataResponse.getData());
                    //for logging in logcat :D
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

        CustomApp.getInstance().addToRequestQueue(request);
    }

    @Override
    public void onClick(int position) {
        ViewData viewData = items.get(position);
        Intent intent = new Intent(getActivity(), DetailDataFragment.class);
        intent.putExtra("viewdata", viewData);
        startActivity(intent);


        //Toast.makeText(getActivity(),"bisa di klik, data ke : "+position,Toast.LENGTH_SHORT).show();
        /*Bundle bundle = new Bundle();
        bundle.putSerializable("DATA", ViewData);
        intent.putExtras(bundle);*/
        //ViewData viewData = new ViewData();
        //intent.putExtra("viewdata",viewData);
        //intent.putExtra("viewdata",(Serializable)viewData);
        //intent.putExtra("tahu", adapter.getItemId(position));

    }
}
