package com.huangxue.s01.Activity.Subway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.gson.JsonParser;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;

public class SubwayMapActivity extends AppCompatActivity {

    private String imgUrl;
    private ImageView img;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway_map);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("地铁地图");
        toolbar.setNavigationOnClickListener(view -> finish());
        img = findViewById(R.id.subway_map_img);
        pb = findViewById(R.id.item_progress);

        new Thread(this::initHttp).start();
    }

    private void initHttp() {
        String body = WorkOkHttp.get("/prod-api/api/metro/city");
        imgUrl = new JsonParser().parse(body).getAsJsonObject().get("data").getAsJsonObject().get("imgUrl").getAsString();
        runOnUiThread(()->{
            Tools.setImg(this,imgUrl,img);
            pb.setVisibility(View.GONE);
        });
    }
}