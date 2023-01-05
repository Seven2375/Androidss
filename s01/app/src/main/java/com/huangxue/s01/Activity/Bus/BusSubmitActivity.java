package com.huangxue.s01.Activity.Bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import okhttp3.MediaType;

public class BusSubmitActivity extends AppCompatActivity {

    private String date;
    private String name;
    private String phone;
    private String getOn;
    private String getOff;
    private TextView etName;
    private TextView etPhone;
    private TextView etGetOn;
    private TextView etGetOff;
    private TextView etDate;
    private String token;
    private int price;
    private String path;
    private int code;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_submit);

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("确定信息");
        toolbar.setNavigationOnClickListener(v->finish());
        pb = findViewById(R.id.item_progress);
        price = getIntent().getIntExtra("price", 2);
        path = getIntent().getStringExtra("path");

        date = getIntent().getStringExtra("date");
        name = getIntent().getStringExtra("name");
        phone = getIntent().getStringExtra("phone");
        getOn = getIntent().getStringExtra("getOn");
        getOff = getIntent().getStringExtra("getOff");


        initView();

    }

    private void initView() {
        etName = findViewById(R.id.bus_submit_name);
        etPhone = findViewById(R.id.bus_submit_phone);
        etGetOn = findViewById(R.id.bus_submit_getOn);
        etGetOff = findViewById(R.id.bus_submit_getOff);
        etDate = findViewById(R.id.bus_submit_date);
        etName.setText(name);
        etPhone.setText(phone);
        etGetOn.setText(getOn);
        etGetOff.setText(getOff);
        etDate.setText(date);
        pb.setVisibility(View.GONE);
        findViewById(R.id.bus_submit_submit).setOnClickListener(v->{
            new Thread(()->{
                initHttp();
            }).start();

        });
    }

    private void initHttp() {
        MediaType jsonType = MediaType.get("application/json;charset=utf-8");
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("start",getOn);
        jsonBody.addProperty("end",getOff);
        jsonBody.addProperty("path",path);
        jsonBody.addProperty("price",price);
        jsonBody.addProperty("status",0);

        String body = WorkOkHttp.post("/prod-api/api/bus/order", jsonBody, jsonType, token);
        code = new JsonParser().parse(body).getAsJsonObject().get("code").getAsInt();
        runOnUiThread(()->{
            if (code ==200){
                Toast.makeText(this, "操作成功", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "操作失败", Toast.LENGTH_SHORT).show();
            }
        });

    }
}