package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.huangxue.s01.Beans.StopInfoBean;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.IOException;

public class StopInfoActivity extends AppCompatActivity {

    private String Url = "/prod-api/api/park/lot/";
    private int id;
    private ImageView img;
    private TextView name;
    private TextView address;
    private TextView dis;
    private TextView number;
    private TextView ifOpen;
    private TextView rates;
    private TextView priceCaps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_info);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("停车场详情");
        toolbar.setNavigationOnClickListener(view -> finish());

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        initUI();
        new Thread(()->{try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }}).start();

    }

    private void initUI() {
        img = findViewById(R.id.stop_info_img);
        name = findViewById(R.id.stop_info_name);
        address = findViewById(R.id.stop_info_address);
        number = findViewById(R.id.stop_info_number);
        dis = findViewById(R.id.stop_info_dis);
        ifOpen = findViewById(R.id.stop_info_ifOpen);
        rates = findViewById(R.id.stop_info_rates);
        priceCaps = findViewById(R.id.stop_info_priceCaps);
    }

    private void init() throws IOException {

        String body = WorkOkHttp.get(Url + id);
        Gson gons = new Gson();
        StopInfoBean stopInfoBean = gons.fromJson(body, StopInfoBean.class);
        StopInfoBean.DataEntity data = stopInfoBean.getData();
        runOnUiThread(()->{
            Glide.with(this)
                    .load("https://img1.baidu.com/it/u=1458915908,2029186051&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=333")
                    .into(img);
            name.setText(data.getParkName());
            address.setText("地址："+data.getAddress());
            number.setText("剩余车位："+data.getVacancy());
            dis.setText("距离您："+data.getDistance()+"m");
            ifOpen.setText(data.getDistance().equals("Y") ? "对外开发":"不对外开放");
            rates.setText("小时/"+data.getRates()+"元");
            priceCaps.setText("天/"+data.getPriceCaps()+"元");
        });

    }
}