package com.huangxue.s01;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.huangxue.s01.Beans.NewsContentBean;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.IOException;

public class NewsDetailsActivity extends AppCompatActivity {

    private final static String mainUrl = "http://124.93.196.45:10001";
    private final static String fuUrl = "/prod-api/press/press/";
    private int id;
    private TextView desc;
    private TextView title;
    private ImageView img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("新闻详情");
        toolbar.setNavigationOnClickListener(v->finish());

        Intent intent = getIntent();
        id = intent.getIntExtra("id",0);

        new Thread(()->{
            initUI();
        }).start();


    }

    private void initUI() {

        img = findViewById(R.id.news_img);
        title = findViewById(R.id.news_title);
        desc = findViewById(R.id.news_desc);

        try {
            NewsContentBean.DataEntity data = WorkOkHttp.getNewsContent(mainUrl + fuUrl + id);
            runOnUiThread(()->{
                title.setText(data.getTitle());
                desc.setText(data.getContent());
                Glide.with(this).load(mainUrl+data.getCover()).into(img);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}