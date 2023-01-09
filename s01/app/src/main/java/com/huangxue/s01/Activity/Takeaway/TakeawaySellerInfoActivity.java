package com.huangxue.s01.Activity.Takeaway;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.huangxue.s01.Adatper.LookJobPagerFragment;
import com.huangxue.s01.Beans.TakeawaySellerInfoBean;
import com.huangxue.s01.Fragment.Takeaway.TakeawayCommentFragment;
import com.huangxue.s01.Fragment.Takeaway.TakeawayMenuFragment;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.ArrayList;
import java.util.List;

public class TakeawaySellerInfoActivity extends AppCompatActivity {


    private int id;
    private ImageView TakeawaySellerInfoImg;
    private TextView TakeawaySellerInfoName;
    private TextView TakeawaySellerInfoIsLike;
    private TextView TakeawaySellerInfoScore;
    private TextView TakeawaySellerInfoDeliveryTime;
    private TextView TakeawaySellerInfoDistance;
    private TextView TakeawaySellerInfoDesc;
    private TabLayout takeawaySellerInfoTab;
    private ViewPager takeawaySellerInfoViewPager;
    private TakeawaySellerInfoBean.DataEntity infoData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takeaway_seller_info);
        initView();

        id = getIntent().getIntExtra("id", 0);


        new Thread(() -> {
            initHttp();
        }).start();

    }

    private void initHttp() {
        Gson gson = new Gson();
        String infoBody = WorkOkHttp.get("/prod-api/api/takeout/seller/" + id);

        infoData = gson.fromJson(infoBody, TakeawaySellerInfoBean.class).getData();

        runOnUiThread(() -> {
            initInfoData();
            initViewPager();
        });

    }

    private void initViewPager() {

        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        TakeawayMenuFragment takeawayMenuFragment = new TakeawayMenuFragment();
        takeawayMenuFragment.setArguments(bundle);
        fragmentList.add(takeawayMenuFragment);
        titleList.add("点菜");
        TakeawayCommentFragment takeawayCommentFragment = new TakeawayCommentFragment();
        takeawayCommentFragment.setArguments(bundle);
        fragmentList.add(takeawayCommentFragment);
        titleList.add("评论");

        LookJobPagerFragment adapter = new LookJobPagerFragment(getSupportFragmentManager(), fragmentList, titleList);
        this.takeawaySellerInfoViewPager.setAdapter(adapter);
        takeawaySellerInfoTab.setupWithViewPager(takeawaySellerInfoViewPager);


    }

    private void initInfoData() {

        TakeawaySellerInfoName.setText(infoData.getName());
        TakeawaySellerInfoScore.setText(infoData.getScore()+"分");
        TakeawaySellerInfoDeliveryTime.setText("配送时间 "+infoData.getDeliveryTime()+"分");
        TakeawaySellerInfoDesc.setText(infoData.getIntroduction());
        TakeawaySellerInfoDistance.setText("距离 "+(int) infoData.getDistance()+"m");
        Tools.setImg(this,infoData.getImgUrl(),TakeawaySellerInfoImg);

    }

    private void initView() {
        TakeawaySellerInfoImg = (ImageView) findViewById(R.id.TakeawaySellerInfo_img);
        TakeawaySellerInfoName = (TextView) findViewById(R.id.TakeawaySellerInfo_name);
        TakeawaySellerInfoIsLike = (TextView) findViewById(R.id.TakeawaySellerInfo_isLike);
        TakeawaySellerInfoScore = (TextView) findViewById(R.id.TakeawaySellerInfo_score);
        TakeawaySellerInfoDeliveryTime = (TextView) findViewById(R.id.TakeawaySellerInfo_deliveryTime);
        TakeawaySellerInfoDistance = (TextView) findViewById(R.id.TakeawaySellerInfo_distance);
        TakeawaySellerInfoDesc = (TextView) findViewById(R.id.TakeawaySellerInfo_desc);
        takeawaySellerInfoTab = (TabLayout) findViewById(R.id.takeawaySellerInfo_tab);
        takeawaySellerInfoViewPager = (ViewPager) findViewById(R.id.takeawaySellerInfo_viewPager);
    }
}