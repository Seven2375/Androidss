package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.huangxue.s01.Adatper.MyPagerAdatper;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {

    private String Url = "http://124.93.196.45:10001/prod-api/api/rotation/list";
    private List<String> bannerImgUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void init() throws IOException {
        new Thread(()->{
            try {
                bannerImgUrl = WorkOkHttp.getBannerImgUrl(Url);
                runOnUiThread(()->{
                    initPager();
                });
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }
    private void initPager(){
        LayoutInflater inflater = getLayoutInflater().from(this);
        View v1 = inflater.inflate(R.layout.start_pager1, null);
        View v2 = inflater.inflate(R.layout.start_pager2, null);
        View v3 = inflater.inflate(R.layout.start_pager3, null);
        List<ImageView> imageViews = new ArrayList<>();
        imageViews.add(v1.findViewById(R.id.start_img1));
        imageViews.add(v2.findViewById(R.id.start_img2));
        imageViews.add(v3.findViewById(R.id.start_img3));
        for (int i = 0; i < imageViews.size(); i++) {
            Glide.with(this).load(bannerImgUrl.get(i)).into(imageViews.get(i));
        }
        List<View> viewList = new ArrayList<>();
        viewList.add(v1);
        viewList.add(v2);
        viewList.add(v3);
        ViewPager viewpager = findViewById(R.id.start_viewpager);
        MyPagerAdatper myPagerAdatper = new MyPagerAdatper(viewList,this);
        viewpager.setAdapter(myPagerAdatper);

        v3.findViewById(R.id.start_intent).setOnClickListener(v->{
            startActivity(new Intent(this,LoginActivity.class));
        });
    }

}