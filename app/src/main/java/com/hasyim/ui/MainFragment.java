package com.hasyim.ui;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.hasyim.spkbayes.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by hasyim on 12/17/2015.
 */


public class MainFragment extends Fragment {


    @Bind(R.id.profile_image)
    CircleImageView profileImage;
    @Bind(R.id.btn_prediksi)
    Button btnPrediksi;
    @Bind(R.id.btn_lihat_data)
    Button btnLihatData;
    @Bind(R.id.btn_tambah_data)
    Button btnTambahData;
    @Bind(R.id.btn_petunjuk)
    Button btnPetunjuk;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, rootView);



        btnPrediksi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                PrediksiFragment prediksiFragment = new PrediksiFragment();
                ft.replace(R.id.content_frame, prediksiFragment);
                ft.commit();

            }
        });

        btnLihatData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                LihatDataFragment lihatDataFragment = new LihatDataFragment();
                ft.replace(R.id.content_frame, lihatDataFragment);
                ft.commit();
            }
        });

        btnTambahData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                InputDataFragment inputDataFragment = new InputDataFragment();
                ft.replace(R.id.content_frame, inputDataFragment);
                ft.commit();
            }
        });

        btnPetunjuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                PetunjukFragment petunjukFragment =new PetunjukFragment();
                ft.replace(R.id.content_frame, petunjukFragment);
                ft.commit();
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
