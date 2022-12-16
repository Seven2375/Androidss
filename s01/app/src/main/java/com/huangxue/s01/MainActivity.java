package com.huangxue.s01;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.huangxue.s01.Adatper.MainPagerFragment;
import com.huangxue.s01.Fragment.AllServicesFragment;
import com.huangxue.s01.Fragment.HomeFragment;
import com.huangxue.s01.Fragment.MyFragment;
import com.huangxue.s01.Fragment.NewsFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initView();
        initData();
    }

    private void initData() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new AllServicesFragment());
        fragmentList.add(new NewsFragment());
//        fragmentList.add(new MyFragment());

        MainPagerFragment mainPagerFragment = new MainPagerFragment(getSupportFragmentManager(), fragmentList);
        viewpager.setAdapter(mainPagerFragment);
    }

    private void initView() {
        viewpager = findViewById(R.id.main_viewpager);

    }

}