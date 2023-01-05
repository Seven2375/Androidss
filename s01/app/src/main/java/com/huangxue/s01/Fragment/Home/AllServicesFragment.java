package com.huangxue.s01.Fragment.Home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.ServicesClassLeftRvAdapter;
import com.huangxue.s01.Adatper.ServicesClassRightRvAdapter;
import com.huangxue.s01.Beans.ServicesListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class AllServicesFragment extends Fragment implements SearchView.OnQueryTextListener {
    private static final String TAG = "wwwwwwwwww";
    protected View mView;
    private RecyclerView rightRv;
    private RecyclerView leftRv;
    private List<String> leftData;
    private List<List<ServicesListBean.RowsEntity>> rightData;
    private ServicesClassLeftRvAdapter leftAdapter;
    private List<ServicesListBean.RowsEntity> gridlist;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_all_services,container,false);

        Toolbar toolbar = mView.findViewById(R.id.toolbar_noback);
        toolbar.setTitle("全部服务");

        initView();

        new Thread(this::initIsOk).start();

        return mView;

    }

    private void initView() {
        leftRv = mView.findViewById(R.id.services_leftRv);
        rightRv = mView.findViewById(R.id.services_rightRv);
        SearchView searchView = mView.findViewById(R.id.services_searchView);
        searchView.setOnQueryTextListener(this);
    }

    private void initIsOk() {
        String s = WorkOkHttp.get("/prod-api/press/category/list");
        if (s.contains(错误)){
            Objects.requireNonNull(getActivity()).runOnUiThread(()->{
                Toast.makeText(getActivity(), "网络崩溃！", Toast.LENGTH_LONG).show();
            });
        }else{
            new Thread(this::initHttp).start();
        }
    }

    private void initHttp(){
        String body = WorkOkHttp.get("/prod-api/api/service/list");
        Gson gson = new Gson();
        gridlist = gson.fromJson(body,ServicesListBean.class).getRows();

        AddServices();


        //新建一个map，key是服务名称，value是该服务分类下所有应用的对象
//        Map<String,List<ServicesListBean.RowsEntity>> map = new HashMap<>();
        Map<String, List<ServicesListBean.RowsEntity>> map = new HashMap<>();
        //循环所有服务
        for (ServicesListBean.RowsEntity data : gridlist) {
            //新建一个服务对象集合，用来初始化数据
            List<ServicesListBean.RowsEntity> rowsList = new ArrayList<>();
            //判断map的key里有没有当前应用的服务类型
            if (map.containsKey(data.getServiceType())){
                //如果有，在当前服务的类型里添加应用
                map.get(data.getServiceType()).add(data);
            }else{//如果没有，服务对象集合添加当前的服务应用
                rowsList.add(data);
                //添加key为当前应用的服务类型，value为服务应用对象集合
                map.put(data.getServiceType(),rowsList);
            }

        }
        leftData = new ArrayList<>();
        rightData = new ArrayList<>();
        for (String s : map.keySet()) {
            leftData.add(s);
            rightData.add(map.get(s));
        }

        Objects.requireNonNull(getActivity()).runOnUiThread(()->{
            initLeftRv();
            initRightRv();
        });
    }

    private void AddServices() {
        gridlist.add(new ServicesListBean.RowsEntity("便民服务",
                "律师咨询",
                "/prod-api/profile/upload/image/2021/05/05/8f5d9d3a-3ac7-4e66-9d9a-630ba4bd80ef.png",
                99));
    }

    private void initRightRv() {
        ServicesClassRightRvAdapter adapter = new ServicesClassRightRvAdapter(rightData, getActivity());
        LinearLayoutManager rightManager = new LinearLayoutManager(getActivity());
        rightRv.setLayoutManager(rightManager);
        rightRv.setAdapter(adapter);
        rightRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int firstPosition = rightManager.findFirstVisibleItemPosition();
                if (leftAdapter.mCheckedPosition!=firstPosition){

                    leftAdapter.mCheckedPosition=firstPosition;
                    leftAdapter.notifyDataSetChanged();

                    leftRv.scrollToPosition(leftAdapter.mCheckedPosition);
                }
            }
        });
    }

    private void initLeftRv() {
        leftAdapter = new ServicesClassLeftRvAdapter(leftData, getActivity());
        LinearLayoutManager leftManager = new LinearLayoutManager(getActivity());
        leftRv.setLayoutManager(leftManager);
        leftRv.setAdapter(leftAdapter);

        leftAdapter.setMyOnClick(i->{
            leftAdapter.mCheckedPosition = i;
            leftAdapter.notifyDataSetChanged();
            rightRv.scrollToPosition(i);
        });

    }

    private String 错误 = "<title>502 错误 - phpstudy</title>";


    @Override
    public boolean onQueryTextSubmit(String s) {

        ServicesQueryDialogFragment dialogFragment = new ServicesQueryDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString("s",s);
        dialogFragment.setArguments(bundle);
        dialogFragment.show(getChildFragmentManager(),"dialogFragment");

        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        return false;
    }
}
