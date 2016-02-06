package com.hasyim.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.error.AuthFailureError;
import com.android.volley.error.VolleyError;
import com.android.volley.request.StringRequest;
import com.hasyim.app.CustomApp;
import com.hasyim.spkbayes.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LoginActivity extends AppCompatActivity {

    @Bind(R.id.edt_user)
    EditText edtUser;
    @Bind(R.id.edt_password)
    EditText edtPassword;
    @Bind(R.id.btn_login_manajer)
    Button btnLogin;

    private static final String URL_LOGIN = "http://kaptenkomodo.bl.ee/spk/api/manajer/user_control.php";
    //utk testing pake localhost
    //private static final String URL_LOGIN = "http://192.168.43.11/spk/api/manajer/user_control.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //cek apakah edit text username dan passwod kosong
                String strUsername = edtUser.getText().toString();
                String strPassword = edtPassword.getText().toString();
                if (strUsername.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "masukkan kode karyawan", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (strPassword.trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "masukkan password", Toast.LENGTH_SHORT).show();
                }

                //proses connect ke network
                StringRequest request =new StringRequest(Request.Method.POST, URL_LOGIN,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                //chek di logcat
                                System.out.println("response" + response);
                                try {
                                    JSONObject jsonObject = new JSONObject(response);

                                    if (jsonObject.names().get(0).equals("success")) {
                                        Toast.makeText(getApplicationContext(), "success" + jsonObject
                                            .getString("success"), Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                    } else {
                                        Toast.makeText(getApplicationContext(), "Error" + jsonObject
                                            .get("error"), Toast.LENGTH_LONG);
                                    }

                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        HashMap<String, String> hashMap = new HashMap<String, String>();
                        hashMap.put("kode_kar", edtUser.getText().toString());
                        hashMap.put("password", edtPassword.getText().toString());

                        return hashMap;
                    }
                };
                CustomApp.getInstance().addToRequestQueue(request);
            }
        });


    }
}
