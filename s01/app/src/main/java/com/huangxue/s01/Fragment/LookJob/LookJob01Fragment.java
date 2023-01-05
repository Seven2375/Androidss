package com.huangxue.s01.Fragment.LookJob;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.HotJobTextListAdapter;
import com.huangxue.s01.Adatper.LookJobListAdapter;
import com.huangxue.s01.Adatper.LookJobNameListAdapter;
import com.huangxue.s01.Beans.BannerListBean;
import com.huangxue.s01.Beans.HotJobBean;
import com.huangxue.s01.Beans.LookJobRecruitListBean;
import com.huangxue.s01.Activity.LookJob.JobInfoActivity;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LookJob01Fragment extends Fragment{

    private static final String Url = "http://124.93.196.45:10001";
    private View mView;
    private Banner banner;
    private List<BannerListBean.RowsEntity> bannerRows;
    private ProgressBar pb;
    private RecyclerView rv2;
    private RecyclerView rv1;
    private List<LookJobRecruitListBean.RowsEntity> jobRows;
    private GridView listView;
//    private SearchView searchView;
    private LookJobListAdapter jobListAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_look_job_01, container,false);
        initView();
        new Thread(()->{
            initHttp();
        }).start();

        return mView;
    }

    private void initView() {
        banner = mView.findViewById(R.id.look_job_fragment01_banner);
        pb = mView.findViewById(R.id.item_progress);
        rv1 = mView.findViewById(R.id.look_job_fragment01_rv01);
        rv2 = mView.findViewById(R.id.look_job_fragment01_rv02);
        listView = mView.findViewById(R.id.look_job_fragment01_listView);
        SearchView searchView = mView.findViewById(R.id.look_job_fragment01_search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                jobListAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    private void initHttp() {
        Gson gson = new Gson();

        String bannerBody = WorkOkHttp.get("/prod-api/api/rotation/list");
        bannerRows = gson.fromJson(bannerBody, BannerListBean.class).getRows();

        String jobBody = WorkOkHttp.get("/prod-api/api/job/post/list");
        jobRows = gson.fromJson(jobBody, LookJobRecruitListBean.class).getRows();


        getActivity().runOnUiThread(()->{
            initJobNameList();
            initBanner();
            initJobList();
            initHotJobList();
            pb.setVisibility(View.GONE);
        });

    }

    public void initHotJobList() {

        Map<String,Integer> map = new HashMap<>();
        for (LookJobRecruitListBean.RowsEntity data : jobRows) {
            String s = data.getProfessionName()==null ? data.getName():data.getProfessionName();
            if(map.keySet().contains(s)){
                map.put(s,map.get(data.getProfessionName())+1);
            }else{
                map.put(s,1);
            }
        }
        List<HotJobBean> nums = new ArrayList<>();
        for (String s : map.keySet()) {
            nums.add(new HotJobBean(map.get(s),s));
        }
        Collections.sort(nums, new Comparator<HotJobBean>() {
            @Override
            public int compare(HotJobBean t1, HotJobBean t2) {
                return Integer.valueOf(t2.num).compareTo(t1.num);
            }
        });
        HotJobTextListAdapter adapter = new HotJobTextListAdapter(nums, getActivity());
        listView.setAdapter(adapter);

    }

    private void initJobList() {
        jobListAdapter = new LookJobListAdapter(jobRows, getActivity());
        rv2.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv2.setAdapter(jobListAdapter);
        jobListAdapter.setMyOnClick(new LookJobListAdapter.MyOnClick() {
            @Override
            public void onClick(LookJobRecruitListBean.RowsEntity rows) {
                Intent intent = new Intent(getActivity(), JobInfoActivity.class);
                intent.putExtra("id",rows.getId());
                intent.putExtra("companyId",rows.getCompanyId());
                startActivity(intent);
            }
        });
    }

    private void initJobNameList() {
        Map<String,LookJobRecruitListBean.RowsEntity> map = new ArrayMap<>();
        List<LookJobRecruitListBean.RowsEntity> nameList = new ArrayList<>();
        for (LookJobRecruitListBean.RowsEntity data : jobRows) {
            if (!map.keySet().contains(data.getProfessionName()) && data.getProfessionName()!=null){
                map.put(data.getProfessionName(),data);
            }
        }
        for (String s : map.keySet()) {
            nameList.add(map.get(s));
        }
        LookJobNameListAdapter adapter = new LookJobNameListAdapter(nameList, getActivity());
        rv1.setLayoutManager(new GridLayoutManager(getActivity(),3));
        rv1.setAdapter(adapter);
        adapter.setMyOnClick(new LookJobListAdapter.MyOnClick() {
            @Override
            public void onClick(LookJobRecruitListBean.RowsEntity rows) {
                jobListAdapter.getFilter().filter((rows.getProfessionName()==null ? rows.getName():rows.getProfessionName()));
            }
        });
    }

    private void initBanner() {
        List<String> bannerUrlList = new ArrayList<>();
        for (BannerListBean.RowsEntity data : bannerRows) {
            bannerUrlList.add(Url+data.getAdvImg());
        }
        ImageLoader imageLoader = new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Tools.setImg(context,path,imageView);
            }
        };
        banner.setImages(bannerUrlList)
                .setImageLoader(imageLoader)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .start();
    }

}
