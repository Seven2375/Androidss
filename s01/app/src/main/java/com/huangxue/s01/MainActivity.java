package com.huangxue.s01;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.huangxue.s01.Adatper.MainPagerFragment;
import com.huangxue.s01.Fragment.AllServicesFragment;
import com.huangxue.s01.Fragment.HomeFragment;
import com.huangxue.s01.Fragment.MyFragment;
import com.huangxue.s01.Fragment.NewsFragment;
import com.huangxue.s01.Fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ViewPager viewpager;
    private BottomNavigationView bottomNav;

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
        fragmentList.add(new OtherFragment());
        fragmentList.add(new MyFragment());

        MainPagerFragment mainPagerFragment = new MainPagerFragment(getSupportFragmentManager(), fragmentList);
        viewpager.setAdapter(mainPagerFragment);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNav.setSelectedItemId(R.id.menu_home);
                        break;
                    case 1:
                        bottomNav.setSelectedItemId(R.id.menu_all_services);
                        break;
                    case 2:
                        bottomNav.setSelectedItemId(R.id.menu_news);
                        break;
                    case 3:
                        bottomNav.setSelectedItemId(R.id.menu_other);
                        break;
                    case 4:
                        bottomNav.setSelectedItemId(R.id.menu_my);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menu_home:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.menu_all_services:
                        viewpager.setCurrentItem(1);
                        break;
                    case R.id.menu_news:
                        viewpager.setCurrentItem(2);
                        break;
                    case R.id.menu_other:
                        viewpager.setCurrentItem(3);
                        break;
                    case R.id.menu_my:
                        viewpager.setCurrentItem(4);
                        break;
                }
                return true;
            }
        });
    }

    private void initView() {
        viewpager = findViewById(R.id.main_viewpager);
        bottomNav = findViewById(R.id.bottom_nav);
    }

}