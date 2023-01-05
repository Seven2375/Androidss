package com.huangxue.s01.Activity.Lawyer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.huangxue.s01.Adatper.LawyerInfoPagerFragment;
import com.huangxue.s01.Beans.LawyerInfoBean;
import com.huangxue.s01.Fragment.Lawyer.LawyerServicesModeFragment;
import com.huangxue.s01.Fragment.Lawyer.LawyerUserEvaluateFragment;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class LawyerInfoActivity extends AppCompatActivity {

    private int id;
    private ImageView img;
    private TextView name,workingYear,expertise,askNumber,goodRate;
    private LawyerInfoBean.DataEntity infoData;
    private ProgressBar pb;
    private String token;
    private ViewPager viewPager;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_info);

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("律师详情");
        toolbar.setNavigationOnClickListener(v->finish());

        id = getIntent().getIntExtra("id", 0);

        initView();
        new Thread(()->{
            initHttp();
        }).start();


    }

    private void initHttp() {
        Gson gson = new Gson();
        String infoBody = WorkOkHttp.get("/prod-api/api/lawyer-consultation/lawyer/" + id,token);

        infoData = gson.fromJson(infoBody, LawyerInfoBean.class).getData();

        runOnUiThread(()->{
            initInfoData();
            initViewPager();
            pb.setVisibility(View.GONE);
        });

    }

    private void initViewPager() {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();

        LawyerServicesModeFragment lawyerServicesModeFragment = new LawyerServicesModeFragment();
        LawyerUserEvaluateFragment lawyerUserEvaluateFragment = new LawyerUserEvaluateFragment();

        Bundle bundle = new Bundle();
        bundle.putInt("id",id);

        lawyerServicesModeFragment.setArguments(bundle);
        lawyerUserEvaluateFragment.setArguments(bundle);

        fragmentList.add(lawyerServicesModeFragment);
        fragmentList.add(lawyerUserEvaluateFragment);

        titleList.add("服务方式");
        titleList.add("用户评价");

        LawyerInfoPagerFragment infoPagerFragment = new LawyerInfoPagerFragment(getSupportFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(infoPagerFragment);
        tab.setupWithViewPager(viewPager);


    }

    @SuppressLint("SetTextI18n")
    private void initInfoData() {
        Tools.setImg(this,infoData.getAvatarUrl(),img);
        name.setText(infoData.getName());
        askNumber.setText("咨询人数："+infoData.getServiceTimes());
        goodRate.setText("好评率："+infoData.getFavorableRate());
        expertise.setText("专长："+infoData.getLegalExpertiseName());

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.CHINA);
        LocalDate startTime = LocalDate.parse(infoData.getWorkStartAt());
        LocalDate endTime = LocalDate.parse(simpleDateFormat.format(date));
        Period period = Period.between(startTime, endTime);

        workingYear.setText("从业时长："+period.getYears()+"年");
    }

    private void initView() {
        img =  findViewById(R.id.lawyer_list_item_img);
        name =  findViewById(R.id.lawyer_list_item_name);
        workingYear =  findViewById(R.id.lawyer_list_item_workingYear);
        expertise =  findViewById(R.id.lawyer_list_item_expertise);
        askNumber =  findViewById(R.id.lawyer_list_item_askNumber);
        goodRate =  findViewById(R.id.lawyer_list_item_goodRate);
        pb = findViewById(R.id.item_progress);
        viewPager = findViewById(R.id.lawyerInfo_viewpager);
        tab = findViewById(R.id.lawyerInfo_tab);
    }
}