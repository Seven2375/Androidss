package com.huangxue.s01.Activity.News;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.MyNewsListAdapter;
import com.huangxue.s01.Beans.NewsListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

public class NewsSearchActivity extends AppCompatActivity {

    private String msg;
    private RecyclerView rvList;
    private ProgressBar pb;
    private List<NewsListBean.RowsEntity> rows;
    private MyNewsListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_search);

        msg = getIntent().getStringExtra("s");
        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("搜索");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();

        new Thread(()->{
            initHttp();
        }).start();
    }

    private void initView() {
        pb = findViewById(R.id.item_progress);
        rvList = findViewById(R.id.news_searchList);
    }

    private void initHttp() {
        String body = WorkOkHttp.get("/prod-api/press/press/list");
        Gson gson = new Gson();
        rows = gson.fromJson(body, NewsListBean.class).getRows();
        runOnUiThread(() -> {
            initList();
        });
    }

    private void initList() {
        adapter = new MyNewsListAdapter(this, rows);
        rvList.setLayoutManager(new LinearLayoutManager(this));
        initData();
    }

    private void initData() {
        adapter.getFilter().filter(msg);
        rvList.setAdapter(adapter);
        rvList.setVisibility(View.VISIBLE);
        pb.setVisibility(View.GONE);
        adapter.setOnItemClickListener(new MyNewsListAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onClick(int position, NewsListBean.RowsEntity data) {
                int id = data.getId();
                Intent intent = new Intent(NewsSearchActivity.this, NewsInfoActivity.class);
                intent.putExtra("id",id);
                startActivity(intent);
            }
        });
    }
}