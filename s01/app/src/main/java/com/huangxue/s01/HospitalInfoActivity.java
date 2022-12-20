package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.huangxue.s01.Utils.WorkOkHttp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class HospitalInfoActivity extends AppCompatActivity {

    private int id;
    private String desc;
    private Banner banner;
    private TextView view_desc;
    private Button btn_intent;
    private String Url = "http://124.93.196.45:10001";
    private List<String> bannerUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_info);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("医院简介");
        toolbar.setNavigationOnClickListener(V->{finish();});
        id = getIntent().getIntExtra("id", 1);
        desc = getIntent().getStringExtra("desc");

        initView();
        new Thread(()->{
            initHttp();
        }).start();

    }

    private void initView() {
        banner = findViewById(R.id.hospital_info_banner);
        view_desc = findViewById(R.id.hospital_info_desc);
        btn_intent = findViewById(R.id.hospital_info_btn_intent);
        view_desc.setText(desc);
        btn_intent.setOnClickListener(v->{
            Intent intent = new Intent(this, MedicalCardActivity.class);
            startActivity(intent);
        });
    }

    private void initHttp() {
        bannerUrl = new ArrayList<>();
        String body = WorkOkHttp.get("/prod-api/api/hospital/banner/list?hospitalId=" + id);
        JsonArray data = new JsonParser().parse(body).getAsJsonObject().get("data").getAsJsonArray();
        for (int i = 0; i < data.size(); i++) {
            bannerUrl.add(Url+data.get(i).getAsJsonObject().get("imgUrl").getAsString());
        }
        runOnUiThread(()->{
            initBanner();
        });

    }

    private void initBanner() {
        ImageLoader imageLoader = new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context)
                        .load(path)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(imageView);
            }
        };
        banner.setBannerAnimation(Transformer.DepthPage)
                .setImageLoader(imageLoader)
                .setImages(bannerUrl)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .start();
    }
}