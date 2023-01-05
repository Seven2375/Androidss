package com.huangxue.s01.Fragment.Home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.ServicesGridAdapter;
import com.huangxue.s01.Beans.ServicesListBean;
import com.huangxue.s01.Activity.Bus.BusHomeActivity;
import com.huangxue.s01.Activity.Film.FilmHomeActivity;
import com.huangxue.s01.Activity.Hospital.HospitalHomeActivity;
import com.huangxue.s01.Activity.Lawyer.LawyerAskHomeActivity;
import com.huangxue.s01.Activity.LifePay.LifePayActivity;
import com.huangxue.s01.Activity.Logistics.LogisticsActivity;
import com.huangxue.s01.Activity.LookJob.LookJobHomeActivity;
import com.huangxue.s01.Activity.LookRoom.LookRoomHomeActivity;
import com.huangxue.s01.Activity.PetHospotal.PetHomeActivity;
import com.huangxue.s01.R;
import com.huangxue.s01.Activity.Stop.StopListActivity;
import com.huangxue.s01.Activity.Subway.SubwayHomeActivity;
import com.huangxue.s01.Activity.Traffic.TrafficHomeActivity;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

public class ServicesQueryDialogFragment extends DialogFragment implements ServicesGridAdapter.OnRecyclerItemClickListener {

    private RecyclerView rv;
    private List<ServicesListBean.RowsEntity> rows;
    private ProgressBar pb;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View mView = inflater.inflate(R.layout.fragment_services_query, container, false);
        rv = mView.findViewById(R.id.services_dialogFragment_rv);
        pb = mView.findViewById(R.id.item_progress);

        new Thread(this::initHttp).start();

        return mView;
    }

    private void initHttp() {
        String body = WorkOkHttp.get("/prod-api/api/service/list");
        Gson gson = new Gson();
        rows = gson.fromJson(body, ServicesListBean.class).getRows();
        getActivity().runOnUiThread(this::initRv);
    }

    private void initRv() {
        ServicesGridAdapter adapter = new ServicesGridAdapter(getActivity(),rows);
        rv.setLayoutManager(new GridLayoutManager(getActivity(),3));
        adapter.getFilter().filter(getArguments().getString("s"));
        rv.setAdapter(adapter);
        adapter.setOnItemClickListener(this);
        pb.setVisibility(View.GONE);
    }

    @Override
    public void onRecyItemClick(int position, ServicesListBean.RowsEntity data) {
        switch (data.getServiceName()) {
            case "找工作":
                getActivity().startActivity(new Intent(getActivity(), LookJobHomeActivity.class));
                break;
            case "停哪儿":
                getActivity().startActivity(new Intent(getActivity(), StopListActivity.class));
                break;
            case "找房子":
                getActivity().startActivity(new Intent(getActivity(), LookRoomHomeActivity.class));
                break;
            case "门诊预约":
                getActivity().startActivity(new Intent(getActivity(), HospitalHomeActivity.class));
                break;
            case "智慧巴士":
                getActivity().startActivity(new Intent(getActivity(), BusHomeActivity.class));
                break;
            case "看电影":
                getActivity().startActivity(new Intent(getActivity(), FilmHomeActivity.class));
                break;
            case "智慧交管":
                getActivity().startActivity(new Intent(getActivity(), TrafficHomeActivity.class));
                break;
            case "宠物医院":
                getActivity().startActivity(new Intent(getActivity(), PetHomeActivity.class));
                break;
            case "生活缴费":
                getActivity().startActivity(new Intent(getActivity(), LifePayActivity.class));
                break;
            case "物流查询":
                getActivity().startActivity(new Intent(getActivity(), LogisticsActivity.class));
                break;
            case "城市地铁":
                getActivity().startActivity(new Intent(getActivity(), SubwayHomeActivity.class));
                break;
            case "律师咨询":
                getActivity().startActivity(new Intent(getActivity(), LawyerAskHomeActivity.class));
                break;
        }
    }
}
