package com.huangxue.s01.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.huangxue.s01.Adatper.NewsClassPagerFragment;
import com.huangxue.s01.Beans.BannerListBean;
import com.huangxue.s01.Beans.NewsClassBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;
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
            initHttp();
        }).start();

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
            bannerUrl.add(Url+bannerRows.get(i).getAdvImg());
        }

        ImageLoader imageLoader = new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context)
                        .load(path)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(imageView);
            }
        };

        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setImageLoader(imageLoader)
                .setBannerAnimation(Transformer.DepthPage)
                .setDelayTime(3000)
                .setIndicatorGravity(BannerConfig.CENTER)
                .setImages(bannerUrl)
                .setOnBannerListener(this)
                .start();
    }

    @Override
    public void OnBannerClick(int position) {

    }
}
