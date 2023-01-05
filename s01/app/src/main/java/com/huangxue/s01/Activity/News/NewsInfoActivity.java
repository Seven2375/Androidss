package com.huangxue.s01.Activity.News;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.Adatper.NewsCommentListAdapter;
import com.huangxue.s01.Beans.NewsCommentListBean;
import com.huangxue.s01.Beans.NewsContentBean;
import com.huangxue.s01.Beans.NewsInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.MediaType;

public class NewsInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private final static String mainUrl = "http://124.93.196.45:10001";
    private int id;
    private TextView desc;
    private TextView title;
    private ImageView img;
    private String commentsBody;
    private String newsInfoBody;
    private RecyclerView rv;
    private NewsInfoBean.DataEntity newsInfoData;
    private List<NewsCommentListBean.RowsEntity> commentData;
    private LinearLayout linear;
    private ProgressBar pb;
    private EditText edit;
    private Button btn;
    private String editBody;
    private String token;
    private TextView readNum;
    private TextView pubDate;
    private TextView commentNum;
    private TextView likeNum;
    private ImageView upImg;
    private int commentID;
    private NewsCommentListAdapter newsCommentListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_info);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("新闻详情");
        toolbar.setNavigationOnClickListener(v -> finish());

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        Intent intent = getIntent();
        id = intent.getIntExtra("id", 0);

        initView();
        new Thread(() ->{
            initHttp();
        }).start();

    }

    private void initView() {
        pb = findViewById(R.id.news_info_pb);
        img = findViewById(R.id.news_info_img);
        title = findViewById(R.id.news_info_title);
        desc = findViewById(R.id.news_info_desc);
        readNum = findViewById(R.id.news_info_readNum);
        pubDate = findViewById(R.id.news_info_pubDate);
        commentNum = findViewById(R.id.news_info_commentNum);
        likeNum = findViewById(R.id.news_info_likeNum);
        rv = findViewById(R.id.news_info_rv);
        linear = findViewById(R.id.news_info_linear);
        edit = findViewById(R.id.news_info_edit);
        btn = findViewById(R.id.news_info_btn);
        upImg = findViewById(R.id.news_info_upImg);
    }

    private void initHttp(){

        newsInfoBody = WorkOkHttp.get("/prod-api/api/park/press/press/" + id);
        commentsBody = WorkOkHttp.get("/prod-api/press/comments/list?newsId="+id);
        Gson gson = new Gson();
        newsInfoData = gson.fromJson(newsInfoBody, NewsInfoBean.class).getData();
        commentData = gson.fromJson(commentsBody, NewsCommentListBean.class).getRows();

        runOnUiThread(()->{
            initData();
        });

    }

    private void initData() {
        inintInfo();
        initComment();
    }

    private void inintInfo() {
        Glide.with(this)
                .load(mainUrl+newsInfoData.getCover())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(img);
        title.setText(newsInfoData.getTitle());
        desc.setText(newsInfoData.getContent());
        commentNum.setText("评论数量："+newsInfoData.getCommentNum());
        likeNum.setText(""+newsInfoData.getLikeNum());
        pubDate.setText("时间："+newsInfoData.getPublishDate());
        readNum.setText("阅读数量："+newsInfoData.getReadNum());
        upImg.setVisibility(View.VISIBLE);
        upImg.setOnClickListener(this);
        linear.setVisibility(View.VISIBLE);
        btn.setOnClickListener(this);
        pb.setVisibility(View.GONE);
    }

    private void initComment(){
        newsCommentListAdapter = new NewsCommentListAdapter(commentData, this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(newsCommentListAdapter);
        newsCommentListAdapter.setMyCommentOnClick(new NewsCommentListAdapter.MyCommentOnClick() {
            @Override
            public void OnClick(int positon) {
                commentID = commentData.get(positon).getId();
                Log.e("TAG", "OnClick: "+commentID );
                initCommentUp();
            }
        });

    }
    private void initCommentUp(){
        new Thread(()->{
            WorkOkHttp.put("/prod-api/press/pressComment/like/"+commentID,token);
            runOnUiThread(()->{
                Toast.makeText(this, "点赞成功", Toast.LENGTH_SHORT).show();
            });

        }).start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.news_info_btn:
                editBody = edit.getText().toString();
                if (editBody.isEmpty()){
                    Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
                }else {
                    new Thread(()->initIssue()).start();
                }
                break;
            case R.id.news_info_upImg:
                initNewsGood();
                break;
        }

    }
    private void initNewsGood(){
        new Thread(()->{
            WorkOkHttp.put("/prod-api/press/press/like/" + id, token);
            runOnUiThread(()-> Toast.makeText(this, "点赞成功", Toast.LENGTH_SHORT).show());
        }).start();

    }

    private void initIssue() {
        MediaType jsonType = MediaType.get("application/json;charset=utf-8");
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("newsId",id);
        jsonBody.addProperty("content",editBody);
        WorkOkHttp.post("/prod-api/press/pressComment", jsonBody, jsonType,token);
        runOnUiThread(()->{
            Toast.makeText(this, "评论成功", Toast.LENGTH_SHORT).show();
            onCreate(null);
        });
    }

}

