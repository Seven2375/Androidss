package com.huangxue.s01.Activity.Takeaway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.LawyerExpertiseViewPagerAdapter;
import com.huangxue.s01.Adatper.TakeawayClassListAdapter;
import com.huangxue.s01.Beans.BannerListBean;
import com.huangxue.s01.Beans.TakeawayClassListBean;
import com.huangxue.s01.Fragment.Takeaway.TakeawayHomeFragment;
import com.huangxue.s01.Fragment.Takeaway.TakeawayOrderFragment;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class TakeawayMainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tabHome;
    private TextView tabOrder;
    private FragmentManager fragmentManager;
    private FragmentTransaction beginTransaction;
    private TakeawayHomeFragment homeFragment;
    private TakeawayOrderFragment orderFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_takeaway_main);

        Toolbar toolbar = findViewById(R.id.toolbar_meituan);
        toolbar.setTitle("美团外卖");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();

        fragmentManager = getSupportFragmentManager();

        tabHome.performClick();

    }

    private void initView() {
        tabHome = findViewById(R.id.takeawayMain_tabHome);
        tabOrder = findViewById(R.id.takeawayMain_tabOrder);
        tabHome.setOnClickListener(this);
        tabOrder.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {

        beginTransaction = fragmentManager.beginTransaction();

        hintAllFragment(beginTransaction);

        switch (view.getId()){
            case R.id.takeawayMain_tabHome:
                tabSelect();
                tabHome.setSelected(true);
                if (homeFragment==null){
                    homeFragment = new TakeawayHomeFragment();
                    beginTransaction.add(R.id.takeawayMain_frameLayout,homeFragment);
                }else{
                    beginTransaction.show(homeFragment);
                }
                break;
            case R.id.takeawayMain_tabOrder:
                tabSelect();
                tabOrder.setSelected(true);
                if (orderFragment==null){
                    orderFragment = new TakeawayOrderFragment();
                    beginTransaction.add(R.id.takeawayMain_frameLayout,orderFragment);
                }else{
                    beginTransaction.show(orderFragment);
                }
                break;
        }
        beginTransaction.commit();

    }

    private void hintAllFragment(FragmentTransaction beginTransaction) {
        if (homeFragment!=null)beginTransaction.hide(homeFragment);
        if (orderFragment!=null)beginTransaction.hide(orderFragment);
    }

    private void tabSelect() {
        tabHome.setSelected(false);
        tabOrder.setSelected(false);
    }
}