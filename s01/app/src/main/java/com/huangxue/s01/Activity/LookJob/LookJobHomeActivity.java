package com.huangxue.s01.Activity.LookJob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.huangxue.s01.Adatper.LookJobPagerFragment;
import com.huangxue.s01.Fragment.LookJob.LookJob01Fragment;
import com.huangxue.s01.Fragment.LookJob.LookJob02Fragment;
import com.huangxue.s01.Fragment.LookJob.LookJob03Fragment;
import com.huangxue.s01.R;

import java.util.ArrayList;
import java.util.List;

public class LookJobHomeActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TabLayout tab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_job_home);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("找工作");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();
        initPagerFragment();
    }

    private void initView() {
        viewPager = findViewById(R.id.look_job_viewpager);
        tab = findViewById(R.id.look_job_tab);
    }

    private void initPagerFragment() {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        titleList.add("找工作");
        titleList.add("投递记录");
        titleList.add("个人简历");
        fragmentList.add(new LookJob01Fragment());
        fragmentList.add(new LookJob02Fragment());
        fragmentList.add(new LookJob03Fragment());
        LookJobPagerFragment adapter = new LookJobPagerFragment(getSupportFragmentManager(),fragmentList,titleList);
        viewPager.setAdapter(adapter);
        tab.setupWithViewPager(viewPager);
    }

}