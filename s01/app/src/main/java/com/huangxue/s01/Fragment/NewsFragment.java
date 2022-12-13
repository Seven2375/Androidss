package com.huangxue.s01.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Adatper.MyHomeListAdapter;
import com.huangxue.s01.Beans.NewsListBean;
import com.huangxue.s01.NewsDetailsActivity;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.IOException;
import java.util.List;

public class NewsFragment extends Fragment {

    protected View mView;
    private final static String mainUrl = "http://124.93.196.45:10001";
    private List<NewsListBean.RowsEntity> listDatas;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_news,container,false);
        new Thread(()->{try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }}).start();

        return mView;

    }

    private void init() throws IOException {
        listDatas = WorkOkHttp.getHomeNewsListDatas(mainUrl + "/prod-api/press/press/list");
        getActivity().runOnUiThread(()->{
            initList();
        });
    }

    private void initList(){
        RecyclerView listview = mView.findViewById(R.id.all_news_listview);
        MyHomeListAdapter listAdapter = new MyHomeListAdapter(getActivity(), listDatas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        listview.setLayoutManager(linearLayoutManager);
        listview.setAdapter(listAdapter);
        listAdapter.setOnItemClickListener(new MyHomeListAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onClick(int position) {
                Intent intent = new Intent(getActivity(), NewsDetailsActivity.class);
                intent.putExtra("id",listDatas.get(position).getId());
                startActivity(intent);
            }
        });

    }
}
