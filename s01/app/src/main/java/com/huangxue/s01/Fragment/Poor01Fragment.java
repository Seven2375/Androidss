package com.huangxue.s01.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huangxue.s01.Adatper.PoorCaseListAdapter;
import com.huangxue.s01.Datas.PoorCaseListData;
import com.huangxue.s01.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class Poor01Fragment extends Fragment {

    private View mView;
    private Banner banner;
    private RecyclerView caseRv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_poor01, container, false);

        initView();
        initBanner();
        initCase();

        return mView;
    }

    private void initCase() {
        List<PoorCaseListData> data = PoorCaseListData.getData();
        PoorCaseListAdapter adapter = new PoorCaseListAdapter(getActivity(),data);
        caseRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        caseRv.setAdapter(adapter);
    }

    private void initBanner() {
        List<Integer> imgPath = new ArrayList<>();
        List<String> bannerTitle = new ArrayList<>();
        imgPath.add(R.drawable.poor_banner_01);
        imgPath.add(R.drawable.poor_banner_02);
        imgPath.add(R.drawable.poor_banner_03);
        bannerTitle.add("扶贫日记，深入基层");
        bannerTitle.add("精准扶贫，精准脱困");
        bannerTitle.add("志愿者入户走访，了解生活状况");

        banner.setImages(imgPath)
                .setImageLoader(new ImageLoader() {
                    @Override
                    public void displayImage(Context context, Object path, ImageView imageView) {
                        Glide.with(context).load(path).into(imageView); }})
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE)
                .setBannerTitles(bannerTitle)
                .start();
    }

    private void initView() {
        banner = mView.findViewById(R.id.poor_fragment01_banner);
        caseRv = mView.findViewById(R.id.poor_fragment01_rv);
    }
}
