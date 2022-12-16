package com.huangxue.s01.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.huangxue.s01.Adatper.NewsClassPagerFragment;
import com.huangxue.s01.Beans.NewsClassBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    protected View mView;
    private ViewPager viewpager;
    private TabLayout table;
    private List<Fragment> fragmentList;
    private List<String> titleList;
    private List<NewsClassBean.DataEntity> data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_news,container,false);
        Toolbar toolbar = mView.findViewById(R.id.toolbar_noback);
        toolbar.setTitle("新闻");

        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewpager = view.findViewById(R.id.news_viewpager);
        table = view.findViewById(R.id.news_table);
        new Thread(()->{try {
            initHttp();
        } catch (IOException e) {
            e.printStackTrace();
        }}).start();

    }

    private void initData() {
        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            fragmentList.add(NewsClassFragment.newInstance(data.get(i).getId()));
            titleList.add(data.get(i).getName());
        }
        getActivity().runOnUiThread(()->{
            viewpager.setAdapter(new NewsClassPagerFragment(getChildFragmentManager(),fragmentList,titleList));
            table.setupWithViewPager(viewpager);
        });

    }

    private void initHttp() throws IOException {
        String body = WorkOkHttp.get("/prod-api/press/category/list");
        Gson gson = new Gson();
        data = gson.fromJson(body, NewsClassBean.class).getData();
        initData();

    }

}
