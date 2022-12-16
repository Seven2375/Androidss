package com.huangxue.s01.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.MyNewsListAdapter;
import com.huangxue.s01.Beans.NewsListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.IOException;
import java.util.List;

public class NewsClassFragment extends Fragment {

    private int id;
    private List<NewsListBean.RowsEntity> rows;
    private RecyclerView newsClassList;

    public static NewsClassFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id",id);
        NewsClassFragment fragment = new NewsClassFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getInt("id");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_class_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        newsClassList = view.findViewById(R.id.news_class_list);
        new Thread(()->{try {
            initHttp();
        } catch (IOException e) {
            e.printStackTrace();
        }}).start();

    }

    private void initHttp() throws IOException {
        String body = WorkOkHttp.get("/prod-api/press/press/list?type=" + id);
        Gson gson = new Gson();
        rows = gson.fromJson(body, NewsListBean.class).getRows();
        getActivity().runOnUiThread(()->{
            initData();
        });

    }

    private void initData() {
        MyNewsListAdapter adapter = new MyNewsListAdapter(getActivity(), rows);
        newsClassList.setLayoutManager(new LinearLayoutManager(getActivity()));
        newsClassList.setAdapter(adapter);
    }
}
