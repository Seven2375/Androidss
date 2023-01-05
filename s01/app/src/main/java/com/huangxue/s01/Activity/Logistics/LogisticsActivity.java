package com.huangxue.s01.Activity.Logistics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.LogisticsCompanyListAdapter;
import com.huangxue.s01.Adatper.LogisticsHotCompanyListAdapter;
import com.huangxue.s01.Beans.LogisticsBannerListBean;
import com.huangxue.s01.Beans.LogisticsCompanyListBean;
import com.huangxue.s01.Beans.StringIntBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogisticsActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private String token;
    private Banner banner;
    private List<LogisticsBannerListBean.DataEntity> bannerData;
    private List<LogisticsCompanyListBean.DataEntity> compnayData;
    private RecyclerView rv1;
    private RecyclerView rv2;
    private ProgressBar pb;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics);

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("物流查询");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();
        new Thread(this::initHttp).start();
    }

    private void initHttp() {
        Gson gson = new Gson();
        String bannerBody = WorkOkHttp.get("/prod-api/api/logistics-inquiry/ad-banner/list", token);
        String compnayBody = WorkOkHttp.get("/prod-api/api/logistics-inquiry/logistics_company/list", token);

        bannerData = gson.fromJson(bannerBody, LogisticsBannerListBean.class).getData();
        compnayData = gson.fromJson(compnayBody, LogisticsCompanyListBean.class).getData();

        runOnUiThread(()->{
            initBanner();
            initHotCompanyList();
            initCompanyList();
            pb.setVisibility(View.GONE);
        });

    }

    private void initCompanyList() {
        Map<String,Integer> map = new HashMap<>();
        String[] name = new String[compnayData.size()];
        for (LogisticsCompanyListBean.DataEntity data : compnayData) {
            map.put(data.getName(),data.getId());
            name[data.getSort()-1] = data.getName();
        }
        Comparator comparator = Collator.getInstance(java.util.Locale.CHINA);
        Arrays.sort(name,comparator);
        List<StringIntBean> nb = new ArrayList<>();
        for (String s : name) {
            nb.add(new StringIntBean(s,map.get(s)));
        }
        LogisticsCompanyListAdapter adapter = new LogisticsCompanyListAdapter(nb, this);
        rv2.setLayoutManager(new LinearLayoutManager(this));
        rv2.setAdapter(adapter);
        adapter.setMyOnClick(data -> {
            Intent intent = new Intent(this, LogisticsCompantInfoActivity.class);
            intent.putExtra("id",data.getId());
            intent.putExtra("name",data.getName());
            startActivity(intent);
        });
    }

    private void initHotCompanyList() {
        LogisticsHotCompanyListAdapter adapter = new LogisticsHotCompanyListAdapter(compnayData, this);
        rv1.setLayoutManager(new GridLayoutManager(this,4));
        rv1.setAdapter(adapter);
        adapter.setMyOnClick(data -> {
            Intent intent = new Intent(this, LogisticsCompantInfoActivity.class);
            intent.putExtra("id",data.getId());
            intent.putExtra("name",data.getName());
            startActivity(intent);
        });
    }

    private void initBanner() {
        List<String> bannerUrls = new ArrayList<>();
        List<String> bannerTitles = new ArrayList<>();
        for (LogisticsBannerListBean.DataEntity data : bannerData) {
            bannerUrls.add(data.getImgUrl());
            bannerTitles.add(data.getTitle());
        }

        ImageLoader imageLoader = new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Tools.setImg(context,path,imageView);
            }
        };

        banner.setImageLoader(imageLoader)
                .setImages(bannerUrls)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .setBannerTitles(bannerTitles)
                .setDelayTime(3000)
                .start();

    }

    private void initView() {
        banner = findViewById(R.id.logistics_banner);
        rv1 = findViewById(R.id.logistics_rv1);
        rv2 = findViewById(R.id.logistics_rv2);
        searchView = findViewById(R.id.logistics_search);
        searchView.setOnQueryTextListener(this);
        pb = findViewById(R.id.item_progress);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {



        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}