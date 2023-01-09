package com.huangxue.s01.Fragment.Takeaway;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.gson.Gson;
import com.huangxue.s01.Activity.Takeaway.TakeawaySellerInfoActivity;
import com.huangxue.s01.Adatper.LawyerExpertiseViewPagerAdapter;
import com.huangxue.s01.Adatper.TakeawayClassListAdapter;
import com.huangxue.s01.Adatper.TakeawaySellerListAdapter;
import com.huangxue.s01.Beans.BannerListBean;
import com.huangxue.s01.Beans.TakeawayClassListBean;
import com.huangxue.s01.Beans.TakeawaySellerListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class TakeawayHomeFragment extends Fragment {

    private Banner banner;
    private List<BannerListBean.RowsEntity> bannerData;
    private List<TakeawayClassListBean.DataEntity> classBean;
    private ViewPager viewPager;
    private RadioGroup rg;
    private View mView;
    private List<TakeawaySellerListBean.RowsEntity> sellerRows;
    private RecyclerView sellerRv;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_takeaway_home, container,false);

        initView();

        new Thread(()->{
            initHttp();
        }).start();

        return mView;
    }

    private void initHttp() {
        Gson gson = new Gson();
        String bannerBody = WorkOkHttp.get("/prod-api/api/takeout/rotation/list");
        String classBody = WorkOkHttp.get("/prod-api/api/takeout/theme/list");
        String sellerBody = WorkOkHttp.get("/prod-api/api/takeout/seller/near");

        bannerData = gson.fromJson(bannerBody, BannerListBean.class).getRows();
        classBean = gson.fromJson(classBody, TakeawayClassListBean.class).getData();
        sellerRows = gson.fromJson(sellerBody, TakeawaySellerListBean.class).getRows();

        getActivity().runOnUiThread(()->{
            initBanner();
            initClassPager();
            initSeller();
        });
    }

    private void initSeller() {
        TakeawaySellerListAdapter adapter = new TakeawaySellerListAdapter(sellerRows,getActivity());
        sellerRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        sellerRv.setAdapter(adapter);
        adapter.setMyOnClick(data -> {
            TakeawaySellerListBean.RowsEntity origin = (TakeawaySellerListBean.RowsEntity) data;
            Intent intent = new Intent(getActivity(), TakeawaySellerInfoActivity.class);
            intent.putExtra("id",origin.getId());
            startActivity(intent);
        });
    }

    private void initClassPager() {
        List<TakeawayClassListBean.DataEntity> classDataList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (TakeawayClassListBean.DataEntity data : classBean) {
                classDataList.add(data);
            }
        }
        List<TakeawayClassListBean.DataEntity> originDataList = new ArrayList<>();
        List<View> viewList = new ArrayList<>();
        int num = 0;
        for (TakeawayClassListBean.DataEntity data : classDataList) {
            originDataList.add(data);
            num+=1;
            if (originDataList.size()==15||num==40){
                View mView = View.inflate(getActivity(), R.layout.item_viewpager_grid, null);
                RecyclerView recyclerView = mView.findViewById(R.id.item_viewpager_rv);
                TakeawayClassListAdapter adapter = new TakeawayClassListAdapter(originDataList, getActivity());
                recyclerView.setLayoutManager(new GridLayoutManager(getActivity(),5));
                recyclerView.setAdapter(adapter);
                adapter.setMyOnClick(d->{

                });
                viewList.add(mView);
                originDataList = new ArrayList<>();
                num+=1;
            }
        }
        LawyerExpertiseViewPagerAdapter adapter = new LawyerExpertiseViewPagerAdapter(viewList);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < rg.getChildCount(); i++) {
                    RadioButton childAt = (RadioButton) rg.getChildAt(i);
                    if (i==position){
                        childAt.setChecked(true);
                    }
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {}
        });

    }

    private void initBanner() {
        List<String> bannerUrls = new ArrayList<>();
        for (BannerListBean.RowsEntity data : bannerData) {
            bannerUrls.add(data.getAdvImg());
        }
        ImageLoader imageLoader = new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Tools.setImg(context, path,imageView);
            }
        };
        banner.setImageLoader(imageLoader)
                .setImages(bannerUrls)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .start();

    }

    private void initView() {
        banner = mView.findViewById(R.id.takeawayHome_banner);
        viewPager = mView.findViewById(R.id.takeawayHome_classPage);
        rg = mView.findViewById(R.id.takeawayHome_rg);
        sellerRv = mView.findViewById(R.id.takeawayHome_seller);
    }

}
