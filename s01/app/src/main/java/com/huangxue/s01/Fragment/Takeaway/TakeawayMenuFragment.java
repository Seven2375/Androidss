package com.huangxue.s01.Fragment.Takeaway;

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
import com.huangxue.s01.Adatper.ServicesClassLeftRvAdapter;
import com.huangxue.s01.Adatper.TakeawayMeanLeftRvAdapter;
import com.huangxue.s01.Adatper.TakeawayMeanRightRvAdapter;
import com.huangxue.s01.Beans.TakeawayMenuClassListBean;
import com.huangxue.s01.Beans.TakeawayMenuListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.ArrayList;
import java.util.List;

public class TakeawayMenuFragment extends Fragment {

    private RecyclerView leftRv;
    private RecyclerView rightRv;
    private View mView;
    private int id;
    private List<List<TakeawayMenuListBean.DataEntity>> menuListData;
    private List<TakeawayMenuClassListBean.DataEntity> menuClassData;
    private TakeawayMeanLeftRvAdapter leftRvAdapter;
    private TakeawayMeanRightRvAdapter rightRvAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getInt("id");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_takeaway_menu, container, false);

        initView();

        new Thread(()->{
            initHttpData();
        }).start();

        return mView;
    }

    private void initHttpData() {
        Gson gson = new Gson();
        String menuClassBody = WorkOkHttp.get("/prod-api/api/takeout/category/list?sellerId=" + id);

        menuClassData = gson.fromJson(menuClassBody, TakeawayMenuClassListBean.class).getData();
        List<Integer> menuId = new ArrayList<>();
        for (TakeawayMenuClassListBean.DataEntity data : menuClassData) {
            menuId.add(data.getId());
        }
        menuListData = new ArrayList<>();
        for (Integer menuID : menuId) {
            String menuBody = WorkOkHttp.get("/prod-api/api/takeout/product/list?sellerId=" + id + "&" + "categoryId=" + menuID);
            List<TakeawayMenuListBean.DataEntity> data = gson.fromJson(menuBody, TakeawayMenuListBean.class).getData();
            menuListData.add(data);
        }

        getActivity().runOnUiThread(()->{
            initLeft();
            initRight();
        });


    }

    private void initRight() {
        rightRvAdapter = new TakeawayMeanRightRvAdapter(menuListData, menuClassData, getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        rightRv.setLayoutManager(manager);
        rightRv.setAdapter(rightRvAdapter);
        rightRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int itemPosition = manager.findFirstVisibleItemPosition();
                if (leftRvAdapter.selectPosition!=itemPosition){
                    leftRvAdapter.selectPosition=itemPosition;
                    leftRvAdapter.notifyDataSetChanged();
                    leftRv.scrollToPosition(leftRvAdapter.selectPosition);
                }
            }
        });
    }

    private void initLeft() {
        leftRvAdapter = new TakeawayMeanLeftRvAdapter(menuClassData, getActivity());
        leftRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        leftRv.setAdapter(leftRvAdapter);
        leftRvAdapter.setMyOnClickPosition(((data, position) -> {
            leftRvAdapter.selectPosition = position;
            leftRvAdapter.notifyDataSetChanged();
            rightRv.scrollToPosition(position);
        }));
    }

    private void initView() {
        leftRv = mView.findViewById(R.id.takeawayMenu_left);
        rightRv = mView.findViewById(R.id.takeawayMenu_right);
    }
}
