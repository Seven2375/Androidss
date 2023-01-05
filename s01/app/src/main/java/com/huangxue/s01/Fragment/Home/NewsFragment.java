package com.huangxue.s01.Fragment.Home;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.huangxue.s01.Adatper.NewsClassPagerFragment;
import com.huangxue.s01.Beans.BannerListBean;
import com.huangxue.s01.Beans.NewsClassBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment implements OnBannerListener {

    protected View mView;
    private ViewPager viewpager;
    private TabLayout table;
    private List<Fragment> fragmentList;
    private List<String> titleList;
    private List<NewsClassBean.DataEntity> data;
    private List<BannerListBean.RowsEntity> bannerRows;
    private Banner banner;
    private String Url = "http://124.93.196.45:10001";

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
        banner = view.findViewById(R.id.news_banner);
        new Thread(()->{
            initIsOk();
        }).start();
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

    private void initData() {
        fragmentList = new ArrayList<>();
        titleList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            fragmentList.add(NewsClassFragment.newInstance(data.get(i).getId()));
            titleList.add(data.get(i).getName());
        }
        viewpager.setAdapter(new NewsClassPagerFragment(getChildFragmentManager(),fragmentList,titleList));
        table.setupWithViewPager(viewpager);
    }

    private void initHttp(){
        String bannerBody = WorkOkHttp.get("/prod-api/api/rotation/list");
        String body = WorkOkHttp.get("/prod-api/press/category/list");
        Gson gson = new Gson();
        data = gson.fromJson(body, NewsClassBean.class).getData();
        bannerRows = gson.fromJson(bannerBody, BannerListBean.class).getRows();
        getActivity().runOnUiThread(()->{
            initBanner();
            initData();
        });
    }

    private void initBanner() {
        List<String> bannerUrl = new ArrayList<>();
        for (int i = 0; i < bannerRows.size(); i++) {
            bannerUrl.add(bannerRows.get(i).getAdvImg());
        }

        ImageLoader imageLoader = new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Tools.setImg(context,path,imageView);
            }
        };

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(imageLoader)
                .setImages(bannerUrl)
                .setOnBannerListener(this)
                .start();
    }

    @Override
    public void OnBannerClick(int position) {

    }

    private String 错误 = "<title>502 错误 - phpstudy</title>";
}
