package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.LawyerAskListBean;
import com.huangxue.s01.Beans.LawyerInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;

import java.util.List;

public class LawyerAskListAdapter extends RecyclerView.Adapter<LawyerAskListAdapter.MyHolder> {

    private List<LawyerAskListBean.RowsEntity> dataList;
    private List<LawyerInfoBean.DataEntity> infoList;
    private Context mContext;

    public LawyerAskListAdapter(List<LawyerAskListBean.RowsEntity> dataList,List<LawyerInfoBean.DataEntity> infoList ,Context mContext) {
        this.dataList = dataList;
        this.infoList = infoList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_lawyer_ask_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        LawyerAskListBean.RowsEntity data = dataList.get(position);
        LawyerInfoBean.DataEntity info = infoList.get(position);
        holder.name.setText(data.getLawyerName());
        holder.expertise.setText("专长："+data.getLegalExpertiseName());
        holder.goodRate.setText("好评率："+info.getFavorableRate()+"%");
        holder.state.setText("状态："+data.getState());
        holder.submitTime.setText("咨询时间:"+data.getCreateTime());
        Tools.setImg(mContext,info.getAvatarUrl(),holder.img);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        ImageView img;
        TextView name,expertise,goodRate,state,submitTime;
        Button btn;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.lawyer_ask_list_item_img);
            name = itemView.findViewById(R.id.lawyer_ask_list_item_name);
            expertise = itemView.findViewById(R.id.lawyer_ask_list_item_expertise);
            goodRate = itemView.findViewById(R.id.lawyer_ask_list_item_goodRate);
            state = itemView.findViewById(R.id.lawyer_ask_list_item_state);
            submitTime = itemView.findViewById(R.id.lawyer_ask_list_item_submitTime);
            btn = itemView.findViewById(R.id.lawyer_ask_list_item_btn);

        }
    }
}
