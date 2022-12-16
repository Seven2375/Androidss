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

import com.huangxue.s01.R;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment {

    protected View mView;
    private ViewPager viewpager;
    private TableLayout table;

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
        initData();
    }

    private void initData() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(NewsClassFragment.newInstance(20));
        fragmentList.add(NewsClassFragment.newInstance(21));

    }

}
