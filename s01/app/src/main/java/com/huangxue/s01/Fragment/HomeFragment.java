package com.huangxue.s01.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huangxue.s01.Adatper.MyHomeGridAdapter;
import com.huangxue.s01.Adatper.MyHomeListAdapter;
import com.huangxue.s01.Beans.BannerListBean;
import com.huangxue.s01.Beans.ServicesListBean;
import com.huangxue.s01.Beans.NewsListBean;
import com.huangxue.s01.NewsDetailsActivity;
import com.huangxue.s01.R;
import com.huangxue.s01.StopListActivity;
import com.huangxue.s01.Utils.WorkOkHttp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.io.IOException;
import java.util.List;

public class HomeFragment extends Fragment implements OnBannerListener, MyHomeGridAdapter.OnRecyclerItemClickListener {

    private final static String mainUrl = "http://124.93.196.45:10001";
    private List<String> imgUrlList;
    private Banner mBanner;
    private List<ServicesListBean.RowsEntity> grid_rows;
    private List<NewsListBean.RowsEntity> list_rows;
    private RecyclerView listview;
    private RecyclerView gridview;
    private View view;
    private List<BannerListBean.RowsEntity> bannerDatas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_home, container, false);

        try {
            initUI();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return view;

    }

        private void initUI() throws IOException {
            new Thread(()->{
                try {
                    imgUrlList = WorkOkHttp.getBannerImgUrl(mainUrl+"/prod-api/api/rotation/list?type=2");
                    bannerDatas = WorkOkHttp.getBannerDatas(mainUrl + "/prod-api/api/rotation/list");
                    grid_rows = WorkOkHttp.getHomeServicesListDatas(mainUrl + "/prod-api/api/service/list");
                    list_rows = WorkOkHttp.getHomeNewsListDatas(mainUrl + "/prod-api/press/press/list");
                    getActivity().runOnUiThread(()->{
                        initBanner();
                        initGrid();
                        initList();
                    });
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

        }

        private void initList(){
            listview = view.findViewById(R.id.home_list_view);
            MyHomeListAdapter listAdapter = new MyHomeListAdapter(getActivity(), list_rows);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
            listview.setLayoutManager(linearLayoutManager);
            listview.setAdapter(listAdapter);
            listAdapter.setOnItemClickListener(new MyHomeListAdapter.OnRecyclerItemClickListener() {
                @Override
                public void onClick(int position) {
                    Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
                    intent.putExtra("id",list_rows.get(position).getId());
                    startActivity(intent);
                }
            });

        }

        private void initGrid(){
            gridview = view.findViewById(R.id.home_grid_view);
            MyHomeGridAdapter gridAdapter = new MyHomeGridAdapter(getActivity(), grid_rows,1);
            GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),5);
            gridview.setLayoutManager(gridLayoutManager);
            gridview.setAdapter(gridAdapter);
            gridAdapter.setOnItemClickListener(this);

        }

        private void initBanner() {
            mBanner = view.findViewById(R.id.Banner);
            mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                    .setImageLoader(new MyImgLoader())
                    .setBannerAnimation(Transformer.DepthPage)
                    .setDelayTime(3000)
                    .setIndicatorGravity(BannerConfig.CENTER)
                    .setImages(imgUrlList)
                    .setOnBannerListener(this)
                    .start();
        }

    @Override
    public void OnBannerClick(int position) {
        int id = bannerDatas.get(position).getTargetId();
        Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }

    @Override
    public void onRecyItemClick(int position) {

        switch (grid_rows.get(position).getId()){
            case 17:
                startActivity(new Intent(getActivity(), StopListActivity.class));
                break;
        }
    }

    private class MyImgLoader extends ImageLoader {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context)
                        .load(path)
                        .into(imageView);
            }
        }

}
