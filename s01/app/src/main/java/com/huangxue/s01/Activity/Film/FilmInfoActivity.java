package com.huangxue.s01.Activity.Film;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.huangxue.s01.Beans.FilmInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

public class FilmInfoActivity extends AppCompatActivity {

    private int id;
    private ImageView img;
    private TextView title;
    private TextView desc;
    private TextView score;
    private TextView playDate;
    private TextView favoriteNum;
    private TextView likeNum;
    private FilmInfoBean.DataEntity infoData;
    private String Url = "http://124.93.196.45:10001";
    private ProgressBar pb;
    private ImageView imgUp;
    private LinearLayout ll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_info);

        id = getIntent().getIntExtra("id", 0);
        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("电影详情");
        toolbar.setNavigationOnClickListener(v->finish());


        initView();
        new Thread(this::initHttp).start();
    }

    private void initHttp() {

        String infoBody = WorkOkHttp.get("/prod-api/api/movie/film/detail/" + id);
        Gson gson = new Gson();
        infoData = gson.fromJson(infoBody, FilmInfoBean.class).getData();
        runOnUiThread(this::initInfoData);
    }

    private void initInfoData() {
        if (id==2){
            Glide.with(this)
                    .load("https://img0.baidu.com/it/u=1654306224,2099182564&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500")
                    .into(img);
        }else{
            Glide.with(this)
                    .load(Url+infoData.getCover())
                    .into(img);
        }
        title.setText(infoData.getName());
        desc.setText("简介：\n"+infoData.getIntroduction());
        score.setText("评分："+infoData.getScore());
        playDate.setText("上映时间："+infoData.getPlayDate());
        favoriteNum.setText(""+infoData.getFavoriteNum()+"人看过");
        likeNum.setText(""+infoData.getLikeNum()+"人喜欢");
        pb.setVisibility(View.GONE);
        ll.setVisibility(View.VISIBLE);
        imgUp.setVisibility(View.VISIBLE);
    }

    private void initView() {
        img = findViewById(R.id.film_info_img);
        title = findViewById(R.id.film_info_title);
        desc = findViewById(R.id.film_info_desc);
        score = findViewById(R.id.film_info_score);
        playDate = findViewById(R.id.film_info_playDate);
        favoriteNum = findViewById(R.id.film_info_favoriteNum);
        likeNum = findViewById(R.id.film_info_likeNum);
        pb = findViewById(R.id.item_progress);
        ll = findViewById(R.id.film_info_linear);
        imgUp = findViewById(R.id.film_info_upImg);
    }
}