package com.hasyim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

import com.hasyim.spkbayes.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserAccessActivity extends AppCompatActivity {

    @Bind(R.id.user_btn_manajer)
    Button userBtnManajer;
    @Bind(R.id.user_btn_supervisor)
    Button userBtnSupervisor;
    @Bind(R.id.user_btn_petunjuk)
    Button userBtnPetunjuk;

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_access);
        ButterKnife.bind(this);

        toolbar = (Toolbar) findViewById(R.id.spv_main_toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(0xFFFFFFFF);

        userBtnManajer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserAccessActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        userBtnSupervisor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserAccessActivity.this, SpvMainActivity.class);
                startActivity(intent);
            }
        });


    }
}
