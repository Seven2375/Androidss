package com.huangxue.s01.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.huangxue.s01.Adatper.MyHomeGridAdapter;
import com.huangxue.s01.Adatper.ServicesClassPagerFragment;
import com.huangxue.s01.Beans.ServicesListBean;
import com.huangxue.s01.BusHomeActivity;
import com.huangxue.s01.FilmHomeActivity;
import com.huangxue.s01.HospitalHomeActivity;
import com.huangxue.s01.LookJobHomeActivity;
import com.huangxue.s01.LookRoomHomeActivity;
import com.huangxue.s01.PetHomeActivity;
import com.huangxue.s01.R;
import com.huangxue.s01.StopListActivity;
import com.huangxue.s01.TrafficHomeActivity;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import q.rorbin.verticaltablayout.VerticalTabLayout;

public class AllServicesFragment extends Fragment {
    private final static String mainUrl = "http://124.93.196.45:10001";
    private static final String TAG = "wwwwwwwwww";
    protected View mView;
    private List<ServicesListBean.RowsEntity> gridlist;
    private ViewPager viewpager;
    private VerticalTabLayout tab;
    private Map<String, List<ServicesListBean.RowsEntity>> map;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_all_services,container,false);

        Toolbar toolbar = mView.findViewById(R.id.toolbar_noback);
        toolbar.setTitle("全部服务");

        initView();

        new Thread(()->{
            initIsOk();
        }).start();

        return mView;

    }

    private void initView() {
        viewpager = mView.findViewById(R.id.all_services_viewpager);
        tab = mView.findViewById(R.id.all_services_tab);
    }

    private void initIsOk() {
        String s = WorkOkHttp.get("/prod-api/press/category/list");
        if (s.contains(错误)){
            getActivity().runOnUiThread(()->{
                Toast.makeText(getActivity(), "网络崩溃！", Toast.LENGTH_LONG).show();
            });
        }else{
            new Thread(()->{
                initHttp();
            }).start();
        }
    }

    private void initHttp(){
        String body = WorkOkHttp.get("/prod-api/api/service/list");
        Gson gson = new Gson();
        gridlist = gson.fromJson(body,ServicesListBean.class).getRows();

        //新建一个map，key是服务名称，value是该服务分类下所有应用的对象
//        Map<String,List<ServicesListBean.RowsEntity>> map = new HashMap<>();
        map = new HashMap<>();
        //循环所有服务
        for (ServicesListBean.RowsEntity data : gridlist) {
            //新建一个服务对象集合，用来初始化数据
            List<ServicesListBean.RowsEntity> rowsList = new ArrayList<>();
            //判断map的key里有没有当前应用的服务类型
            if (map.keySet().contains(data.getServiceType())){
                //如果有，在当前服务的类型里添加应用
                map.get(data.getServiceType()).add(data);
            }else{//如果没有，服务对象集合添加当前的服务应用
                rowsList.add(data);
                //添加key为当前应用的服务类型，value为服务应用对象集合
                map.put(data.getServiceType(),rowsList);
            }

        }

//        for (String s : map.keySet()) {
//            for (int i = 0; i < map.get(s).size(); i++) {
//
//                Log.d(TAG, s+":"+ map.get(s).get(i).getServiceName());
//            }
//        }

        getActivity().runOnUiThread(()->{
            initPagerFragment();
        });
    }

    private void initPagerFragment() {
        List<Fragment> fragmentList = new ArrayList<>();
        List<String> titleList = new ArrayList<>();
        for (String s : map.keySet()) {
            fragmentList.add(AllServicesClassFragment.newInstance(map.get(s)));
            titleList.add(s);
        }
        ServicesClassPagerFragment pagerFragmentAdapter = new ServicesClassPagerFragment(getChildFragmentManager(), fragmentList, titleList);
        viewpager.setAdapter(pagerFragmentAdapter);
        tab.setupWithViewPager(viewpager);
    }

    private String 错误 = "<title>502 错误 - phpstudy</title>";
}
