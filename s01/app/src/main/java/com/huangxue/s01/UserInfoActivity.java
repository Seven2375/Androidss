package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.Beans.UserInfoBean;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class UserInfoActivity extends AppCompatActivity {

    private ImageView img_avatar;
    private EditText et_name;
    private EditText et_sex;
    private EditText et_phone;
    private String name;
    private String sex;
    private String phone;
    private String img_url;
    private SharedPreferences sp;
    private String token;
    private OkHttpClient okHttpClient = new OkHttpClient();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("个人信息");
        toolbar.setNavigationOnClickListener(view -> finish());

        initUI();

        new Thread(()->{try {
            initHttp();
        } catch (IOException e) {
            e.printStackTrace();
        }}).start();

        findViewById(R.id.myinfo_btn_update_info).setOnClickListener(v->{
            new Thread(()->{try {
                initUpdateInfo();
            } catch (IOException e) {
                e.printStackTrace();
            }}).start();

        });
    }

    private void initUpdateInfo() throws IOException {
        JsonObject json_body = new JsonObject();
        json_body.addProperty("nickName",et_name.getText().toString());
        json_body.addProperty("phonenumber",et_phone.getText().toString());
        json_body.addProperty("sex",et_sex.getText().toString().equals("男") ? "0":"1");
        MediaType json_type = MediaType.get("application/json;charset=utf-8");
        Request request = new Request.Builder()
                .url("http://124.93.196.45:10001/prod-api/api/common/user")
                .header("Authorization",token)
                .put(RequestBody.create(json_type, String.valueOf(json_body))).build();
        String string = okHttpClient.newCall(request).execute().body().string();
        String msg = new JsonParser().parse(string).getAsJsonObject().get("msg").getAsString();
        runOnUiThread(()->{
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        });

    }

    private void initUI() {
        sp = getSharedPreferences("token", Context.MODE_PRIVATE);
        token = sp.getString("token", "");
        img_avatar = findViewById(R.id.myinfo_img_avatar);
        et_name = findViewById(R.id.myinfo_et_name);
        et_sex = findViewById(R.id.myinfo_et_sex);
        et_phone = findViewById(R.id.myinfo_et_phone);

    }
    private void initHttp() throws IOException {

        Request request = new Request.Builder()
                .header("Authorization",token)
                .url("http://124.93.196.45:10001/prod-api/api/common/user/getInfo").build();
        String string = okHttpClient.newCall(request).execute().body().string();
        Gson gson = new Gson();
        UserInfoBean userInfoBean = gson.fromJson(string, UserInfoBean.class);
        name = userInfoBean.getUser().getNickName();
        sex = userInfoBean.getUser().getSex();
        phone = userInfoBean.getUser().getPhonenumber();
        img_url = userInfoBean.getUser().getAvatar();
        runOnUiThread(()->{
            Glide.with(this).load(img_url).into(img_avatar);
            et_name.setText(name);
            et_sex.setText(sex.equals("0") ? "男":"女");
            et_phone.setText(phone);
        });
    }
}