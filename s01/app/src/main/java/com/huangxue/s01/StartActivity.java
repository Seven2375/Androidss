package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.bumptech.glide.Glide;
import com.huangxue.s01.Adatper.MyPagerAdatper;
import com.huangxue.s01.Utils.WorkOkHttp;
import com.youth.banner.view.BannerViewPager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StartActivity extends AppCompatActivity {

    private String Url = "http://124.93.196.45:10001/prod-api/api/rotation/list";
    private List<String> bannerImgUrl;
    private Button btn;
    private RadioGroup rg;
    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        new Thread(()->{try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }}).start();
    }

    private void initUI() {
        rg = findViewById(R.id.start_rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.start_rb1:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.start_rb2:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.start_rb3:
                        viewpager.setCurrentItem(2);
                        break;
                }
            }
        });
    }

    private void init() throws IOException {

        bannerImgUrl = WorkOkHttp.getBannerImgUrl(Url);
        runOnUiThread(()->{
            initPager();
        });

    }
    private void initPager(){
        List<View> views = new ArrayList<>();
        for (int i = 0; i < bannerImgUrl.size(); i++) {
            View view = View.inflate(this, R.layout.item_start_pager, null);
            ImageView img = view.findViewById(R.id.start_item_img);
            Glide.with(this).load(bannerImgUrl.get(i)).into(img);
            if (i==bannerImgUrl.size()-1){
                btn = view.findViewById(R.id.start_item_btn);
                btn.setVisibility(View.VISIBLE);
                btn.setOnClickListener(v->{
                    startActivity(new Intent(this,LoginActivity.class));
                });
            }
            views.add(view);
        }
        viewpager = findViewById(R.id.start_viewpager);
        viewpager.setAdapter(new MyPagerAdatper(views));
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < rg.getChildCount(); i++) {
                    RadioButton childAt = (RadioButton) rg.getChildAt(i);
                    if (i==position){
                        childAt.setChecked(true);
                    }
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        initUI();
    }

}