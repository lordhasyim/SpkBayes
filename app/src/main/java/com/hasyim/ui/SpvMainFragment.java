package com.hasyim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hasyim.spkbayes.R;

import butterknife.Bind;
import butterknife.ButterKnife;



/**
 * Created by hasyim on 2/3/2016.
 */
public class SpvMainFragment extends Fragment {

    @Bind(R.id.spv_btn_lihat_data)
    Button spvBtnLihatData;
    @Bind(R.id.spv_btn_predikisi)
    Button spvBtnPredikisi;
    @Bind(R.id.spv_btn_lihat_peta)
    Button spvBtnLihatPeta;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_spv_main, container, false);

        ButterKnife.bind(this, rootView);

        spvBtnLihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                SpvLihatDataFragment spvLihatDataFragment = new SpvLihatDataFragment();
                ft.replace(R.id.content_spv_frame, spvLihatDataFragment);
                ft.commit();

            }
        });

        spvBtnPredikisi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                //SpvPrediksiFragment spvPrediksiFragment = new SpvPrediksiFragment();
                //ft.replace(R.id.content_spv_frame, spvPrediksiFragment);
                PrediksiFragment prediksiFragment = new PrediksiFragment();
                ft.replace(R.id.content_spv_frame, prediksiFragment);
                ft.commit();
            }
        });

        spvBtnLihatPeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
