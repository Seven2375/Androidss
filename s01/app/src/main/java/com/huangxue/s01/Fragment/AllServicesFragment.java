package com.huangxue.s01.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Adatper.MyHomeGridAdapter;
import com.huangxue.s01.Beans.ServicesListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.StopListActivity;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.IOException;
import java.util.List;

public class AllServicesFragment extends Fragment {
    private final static String mainUrl = "http://124.93.196.45:10001";
    protected View mView;
    private List<ServicesListBean.RowsEntity> gridlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_all_services,container,false);

        Toolbar toolbar = mView.findViewById(R.id.toolbar_noback);
        toolbar.setTitle("全部服务");

        new Thread(()->{try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }}).start();


        return mView;

    }

    private void init() throws IOException {
        gridlist = WorkOkHttp.getHomeServicesListDatas(mainUrl + "/prod-api/api/service/list");
        getActivity().runOnUiThread(()->{
            initGrid();
        });
    }

    private void initGrid(){
        RecyclerView gridview = mView.findViewById(R.id.all_services_gridview);
        MyHomeGridAdapter gridAdapter = new MyHomeGridAdapter(getActivity(), gridlist,2);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),5);
        gridview.setLayoutManager(gridLayoutManager);
        gridview.setAdapter(gridAdapter);
        gridAdapter.setOnItemClickListener(new MyHomeGridAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onRecyItemClick(int position) {
                switch (gridlist.get(position).getId()){
                    case 17:
                        startActivity(new Intent(getActivity(), StopListActivity.class));
                        break;
                }
            }
        });

    }
}
