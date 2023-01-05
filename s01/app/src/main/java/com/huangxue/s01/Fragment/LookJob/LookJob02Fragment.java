package com.huangxue.s01.Fragment.LookJob;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.DeliverListAdapter;
import com.huangxue.s01.Beans.BannerListBean;
import com.huangxue.s01.Beans.DeliverListBean;
import com.huangxue.s01.Beans.MyInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.ArrayList;
import java.util.List;

public class LookJob02Fragment extends Fragment {

    private View mView;
    private RecyclerView rv;
    private String token;
    private List<DeliverListBean.RowsEntity> rows;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_look_job_02, container,false);

        token = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE).getString("token", "");

        initView();
        new Thread(()->{
            initHttp();
        }).start();
        return mView;
    }

    private void initHttp() {
        Gson gson = new Gson();
        String userInfoBody = WorkOkHttp.get("/prod-api/api/common/user/getInfo", token);
        int userId = gson.fromJson(userInfoBody, MyInfoBean.class).getUser().getUserId();
        String deliverBody = WorkOkHttp.get("/prod-api/api/job/deliver/list?userId=" + userId,token);

        rows = gson.fromJson(deliverBody, DeliverListBean.class).getRows();
        getActivity().runOnUiThread(()->{
            initList();
        });

    }

    private void initList() {
        DeliverListAdapter adapter = new DeliverListAdapter(rows, getActivity());
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv.setAdapter(adapter);
    }

    private void initView() {
        rv = mView.findViewById(R.id.look_job_fragment02_rv);
    }

}
