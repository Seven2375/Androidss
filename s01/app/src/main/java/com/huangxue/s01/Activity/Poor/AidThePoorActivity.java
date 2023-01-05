package com.huangxue.s01.Activity.Poor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.huangxue.s01.Adatper.PoorFragmentViewPager;
import com.huangxue.s01.Fragment.Poor.Poor01Fragment;
import com.huangxue.s01.Fragment.Poor.Poor02Fragment;
import com.huangxue.s01.R;

import java.util.ArrayList;
import java.util.List;

public class AidThePoorActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aid_the_poor);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("精准扶贫");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();
        initViewPagerFragment();
    }

    private void initViewPagerFragment() {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        fragmentList.add(new Poor01Fragment());
        fragmentList.add(new Poor02Fragment());
        fragmentList.add(new Poor01Fragment());
        fragmentList.add(new Poor01Fragment());
        titleList.add("扶贫案例");
        titleList.add("村情村貌");
        titleList.add("扶贫求助");
        titleList.add("入户走访");
        PoorFragmentViewPager adapter = new PoorFragmentViewPager(getSupportFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initView() {
        viewPager = findViewById(R.id.poor_viewPager);
        tabLayout = findViewById(R.id.poor_tab);
    }
}