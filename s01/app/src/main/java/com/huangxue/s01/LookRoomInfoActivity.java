package com.huangxue.s01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.huangxue.s01.Beans.LookRoomInfoBean;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.IOException;

public class LookRoomInfoActivity extends AppCompatActivity {

    private int id;
    private LookRoomInfoBean.DataEntity data;
    private ImageView img;
    private TextView title;
    private TextView price;
    private TextView areaSize;
    private TextView type;
    private TextView phone;
    private TextView desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_room_info);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("房子详情");
        toolbar.setNavigationOnClickListener(v->finish());

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);
        initView();
        new Thread(()-> initHttp()).start();

    }

    private void initView() {
        img = findViewById(R.id.look_room_info_img);
        title = findViewById(R.id.look_room_info_title);
        price = findViewById(R.id.look_room_info_price);
        areaSize = findViewById(R.id.look_room_info_areaSize);
        type = findViewById(R.id.look_room_info_type);
        phone = findViewById(R.id.look_room_info_phone);
        desc = findViewById(R.id.look_room_info_desc);
    }

    private void initHttp(){
        String body = WorkOkHttp.get("/prod-api/api/house/housing/" + id);
        Gson gson = new Gson();
        data = gson.fromJson(body, LookRoomInfoBean.class).getData();
        initData();
    }

    private void initData() {
        runOnUiThread(()->{
            title.setText(data.getAddress());
            price.setText(data.getPrice());
            areaSize.setText("面积："+data.getAreaSize()+"m²");
            type.setText("类型："+data.getHouseType());
            phone.setText("联系电话："+data.getTel());
            desc.setText("介绍：\n\n"+data.getDescription());
            Glide.with(this)
                    .load("http://124.93.196.45:10001"+data.getPic())
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                    .into(img);
        });
    }
}