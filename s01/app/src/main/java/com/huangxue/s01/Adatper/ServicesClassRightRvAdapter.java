package com.huangxue.s01.Adatper;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Activity.Takeaway.TakeawayMainActivity;
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

import java.util.List;

public class ServicesClassRightRvAdapter extends RecyclerView.Adapter<ServicesClassRightRvAdapter.MyHolder> implements ServicesClassRightItemAdapter.MyOnClick {

    private List<List<ServicesListBean.RowsEntity>> dataList;
    private Context mContext;

    public ServicesClassRightRvAdapter(List<List<ServicesListBean.RowsEntity>> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_services_right,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        List<ServicesListBean.RowsEntity> data = dataList.get(position);
        holder.title.setText(data.get(0).getServiceType());
        ServicesClassRightItemAdapter adapter = new ServicesClassRightItemAdapter(data, mContext);
        holder.rv.setLayoutManager(new GridLayoutManager(mContext,3));
        holder.rv.setAdapter(adapter);
        adapter.setMyOnClick(this);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public void onClick(ServicesListBean.RowsEntity data) {

        switch (data.getServiceName()){
            case "找工作":
                mContext.startActivity(new Intent(mContext, LookJobHomeActivity.class));
                break;
            case "停哪儿":
                mContext.startActivity(new Intent(mContext, StopListActivity.class));
                break;
            case "找房子":
                mContext.startActivity(new Intent(mContext, LookRoomHomeActivity.class));
                break;
            case "门诊预约":
                mContext.startActivity(new Intent(mContext, HospitalHomeActivity.class));
                break;
            case "智慧巴士":
                mContext.startActivity(new Intent(mContext, BusHomeActivity.class));
                break;
            case "看电影":
                mContext.startActivity(new Intent(mContext, FilmHomeActivity.class));
                break;
            case "智慧交管":
                mContext.startActivity(new Intent(mContext, TrafficHomeActivity.class));
                break;
            case "宠物医院":
                mContext.startActivity(new Intent(mContext, PetHomeActivity.class));
                break;
            case "生活缴费":
                mContext.startActivity(new Intent(mContext, LifePayActivity.class));
                break;
            case "物流查询":
                mContext.startActivity(new Intent(mContext, LogisticsActivity.class));
                break;
            case "城市地铁":
                mContext.startActivity(new Intent(mContext, SubwayHomeActivity.class));
                break;
            case "律师咨询":
                mContext.startActivity(new Intent(mContext, LawyerAskHomeActivity.class));
                break;
            case "外卖订餐":
                mContext.startActivity(new Intent(mContext, TakeawayMainActivity.class));
                break;
        }
}

    public static class MyHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private RecyclerView rv;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.services_rightItem_text);
            rv = itemView.findViewById(R.id.services_rightItem_rv);

        }
    }
}
