package com.hasyim.ui;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.support.v7.widget.Toolbar;

import com.hasyim.spkbayes.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class SpvMainActivity extends AppCompatActivity {

    @Bind(R.id.content_spv_frame)
    FrameLayout contentSpvFrame;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spv_main);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.spv_main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(0xFFFFFFFF);



        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().replace(R.id.content_spv_frame, new SpvMainFragment()).commit();


    }
}
