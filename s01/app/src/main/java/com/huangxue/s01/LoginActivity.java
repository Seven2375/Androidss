package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class LoginActivity extends AppCompatActivity {

    private EditText et_username;
    private EditText et_password;
    private String username;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
    }

    private void init() {
        findViewById(R.id.login_btn_login).setOnClickListener(v->{
            et_username = findViewById(R.id.login_et_username);
            et_password = findViewById(R.id.login_et_password);
            username = this.et_username.getText().toString();
            password = this.et_password.getText().toString();
            if (username.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
            }else{
                new Thread(()->{
                    try {
                        login();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        });
    }

    private void login() throws IOException {
        JsonObject json_body = new JsonObject();
        json_body.addProperty("username",username);
        json_body.addProperty("password",password);
        MediaType json_type = MediaType.get("application/json;charset=utf-8");
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder().url("http://124.93.196.45:10001/prod-api/api/login")
                .post(RequestBody.create(String.valueOf(json_body),json_type)).build();
        String body = okHttpClient.newCall(request).execute().body().string();
        JsonObject asJsonObject = new JsonParser().parse(body).getAsJsonObject();
        String msg = asJsonObject.get("msg").getAsString();
        runOnUiThread(()->{
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });
        if (msg.equals("操作成功")){
            SharedPreferences.Editor token = getSharedPreferences("token", Context.MODE_PRIVATE).edit();
            token.putString("token",asJsonObject.get("token").getAsString());
            token.apply();
            startActivity(new Intent(this,MainActivity.class));
        }
    }
}