package com.huangxue.s01.Activity.Lawyer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.LawyerExpertiseListAdapter;
import com.huangxue.s01.Adatper.LawyerExpertiseViewPagerAdapter;
import com.huangxue.s01.Adatper.LawyerGoodReViewListAdapter;
import com.huangxue.s01.Beans.LawyerBannerListBean;
import com.huangxue.s01.Beans.LawyerExpertiseListBean;
import com.huangxue.s01.Beans.LawyerGoodReviewListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.MyOnClick;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class LawyerAskHomeActivity extends AppCompatActivity implements MyOnClick {

    private Banner banner;
    private String token;
    private List<LawyerBannerListBean.DataEntity> bannerData;
    private ViewPager expertiseViewPager;
    private List<LawyerExpertiseListBean.RowsEntity> expertiseRows;
    private ProgressBar pb;
    private List<LawyerGoodReviewListBean.DataEntity> top10LawyerData;
    private RecyclerView goodReViewRv;
    private LinearLayout top10Title;
    private TextView allLawyer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_ask_home);

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("律师咨询");
        toolbar.setNavigationOnClickListener(v -> finish());

        initView();
        new Thread(this::initHttp).start();
    }

    private void initHttp() {
        Gson gson = new Gson();

        String bannerBody = WorkOkHttp.get("/prod-api/api/lawyer-consultation/ad-banner/list", token);
        String expertiseBody = WorkOkHttp.get("/prod-api/api/lawyer-consultation/legal-expertise/list", token);
        String top10LawyerBody = WorkOkHttp.get("/prod-api/api/lawyer-consultation/lawyer/list-top10", token);

        bannerData = gson.fromJson(bannerBody, LawyerBannerListBean.class).getData();
        expertiseRows = gson.fromJson(expertiseBody, LawyerExpertiseListBean.class).getRows();
        top10LawyerData = gson.fromJson(top10LawyerBody, LawyerGoodReviewListBean.class).getData();

        runOnUiThread(() -> {
            initBanner();
            initExpertise();
            initTop10();
            top10Title.setVisibility(View.VISIBLE);
            pb.setVisibility(View.GONE);
        });
    }

    private void initTop10() {
        LawyerGoodReViewListAdapter adapter = new LawyerGoodReViewListAdapter(top10LawyerData, this);
        goodReViewRv.setLayoutManager(new LinearLayoutManager(this));
        goodReViewRv.setAdapter(adapter);
        adapter.setMyOnClick(data -> {
            Intent intent = new Intent(this, LawyerInfoActivity.class);
            LawyerGoodReviewListBean.DataEntity origin = (LawyerGoodReviewListBean.DataEntity) data;
            intent.putExtra("id",origin.getId());
            startActivity(intent);
        });
    }

    private void initExpertise() {

        List<LawyerExpertiseListBean.RowsEntity> dataList = new ArrayList<>();
        List<View> viewList = new ArrayList<>();
        for (LawyerExpertiseListBean.RowsEntity data : expertiseRows) {
            if (dataList.size()!=8){
                dataList.add(data);
            }
            if(dataList.size()==8) {
                View mView = View.inflate(this, R.layout.item_viewpager_grid, null);
                RecyclerView rv = mView.findViewById(R.id.item_viewpager_rv);
                LawyerExpertiseListAdapter adapter = new LawyerExpertiseListAdapter(dataList, this);
                rv.setLayoutManager(new GridLayoutManager(this,4));
                rv.setAdapter(adapter);
                adapter.setMyOnClick(this);
                viewList.add(mView);
                dataList = new ArrayList<>();
            }
        }
        LawyerExpertiseViewPagerAdapter adapter = new LawyerExpertiseViewPagerAdapter(viewList);
        expertiseViewPager.setAdapter(adapter);

    }

    private void initBanner() {
        List<String> imgUrl = new ArrayList<>();
        List<String> titleList = new ArrayList<>();

        for (LawyerBannerListBean.DataEntity data : bannerData) {
            imgUrl.add(data.getImgUrl());
            titleList.add(data.getTitle());
        }

        ImageLoader imageLoader = new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Tools.setImg(context, path, imageView);
            }
        };

        banner.setImages(imgUrl)
                .setBannerTitles(titleList)
                .setImageLoader(imageLoader)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .start();
    }

    private void initView() {
        pb = findViewById(R.id.item_progress);
        banner = findViewById(R.id.lawyerHome_banner);
        expertiseViewPager = findViewById(R.id.lawyerHome_expertise);
        goodReViewRv = findViewById(R.id.lawyerHome_goodReview);
        top10Title = findViewById(R.id.lawyerHome_top10Title);
        allLawyer = findViewById(R.id.lawyerHome_allLawyer);
        allLawyer.setOnClickListener(v->{
            startActivity(new Intent(this,LawyerListActivity.class));
        });
    }

    @Override
    public void onClick(Object data) {
        LawyerExpertiseListBean.RowsEntity origin = (LawyerExpertiseListBean.RowsEntity) data;
        Intent intent = new Intent(this, LawyerListActivity.class);
        intent.putExtra("id",String.valueOf(origin.getId()));
        startActivity(intent);
    }
}