package com.huangxue.s01.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Adatper.AllServicesClassGridAdapter;
import com.huangxue.s01.Adatper.MyHomeGridAdapter;
import com.huangxue.s01.Beans.ServicesListBean;
import com.huangxue.s01.BusHomeActivity;
import com.huangxue.s01.FilmHomeActivity;
import com.huangxue.s01.HospitalHomeActivity;
import com.huangxue.s01.LookJobHomeActivity;
import com.huangxue.s01.LookRoomHomeActivity;
import com.huangxue.s01.PetHomeActivity;
import com.huangxue.s01.R;
import com.huangxue.s01.StopListActivity;
import com.huangxue.s01.TrafficHomeActivity;

import java.io.Serializable;
import java.util.List;

public class AllServicesClassFragment extends Fragment {

    private List<ServicesListBean.RowsEntity> data;
    private View mView;

    public static AllServicesClassFragment newInstance(List<ServicesListBean.RowsEntity> dataList) {

        Bundle args = new Bundle();
        args.putSerializable("data", (Serializable) dataList);
        AllServicesClassFragment fragment = new AllServicesClassFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        data = (List<ServicesListBean.RowsEntity>) getArguments().getSerializable("data");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_services_class, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView gridView = mView.findViewById(R.id.services_class_fragment_gridView);
        MyHomeGridAdapter adapter = new MyHomeGridAdapter(getActivity(), data);
        gridView.setLayoutManager(new GridLayoutManager(getActivity(),5));
        gridView.setAdapter(adapter);

        adapter.setOnItemClickListener(new MyHomeGridAdapter.OnRecyclerItemClickListener() {
            @Override
            public void onRecyItemClick(int position) {
                switch (data.get(position).getServiceName()){
                    case "找工作":
                        startActivity(new Intent(getActivity(), LookJobHomeActivity.class));
                        break;
                    case "停哪儿":
                        startActivity(new Intent(getActivity(), StopListActivity.class));
                        break;
                    case "找房子":
                        startActivity(new Intent(getActivity(), LookRoomHomeActivity.class));
                        break;
                    case "门诊预约":
                        startActivity(new Intent(getActivity(), HospitalHomeActivity.class));
                        break;
                    case "智慧巴士":
                        startActivity(new Intent(getActivity(), BusHomeActivity.class));
                        break;
                    case "看电影":
                        startActivity(new Intent(getActivity(), FilmHomeActivity.class));
                        break;
                    case "智慧交管":
                        startActivity(new Intent(getActivity(), TrafficHomeActivity.class));
                        break;
                    case "宠物医院":
                        startActivity(new Intent(getActivity(), PetHomeActivity.class));
                        break;
                }
            }
        });
    }

}
