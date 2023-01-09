package com.huangxue.s01.Adatper;

import android.content.Context;
import android.media.Image;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.SubwayInfoBean;
import com.huangxue.s01.R;

import java.util.List;

public class SubwayInfoTimeLineAdapter extends RecyclerView.Adapter<SubwayInfoTimeLineAdapter.MyHolder> {

    private List<SubwayInfoBean.DataEntity.MetroStepListEntity> dataList;
    private Context mContext;
    private String lineName;

    public SubwayInfoTimeLineAdapter(List<SubwayInfoBean.DataEntity.MetroStepListEntity> dataList, Context mContext,String lineName) {
        this.dataList = dataList;
        this.mContext = mContext;
        this.lineName = lineName;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_timeline,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        SubwayInfoBean.DataEntity.MetroStepListEntity data = dataList.get(position);
        if (TextUtils.equals(lineName,data.getName())){
            if (lineName.equals(data.getName())){
                holder.img.setBackgroundResource(R.drawable.shape_oval_orange);
            }
        }else{
            holder.img.setBackgroundResource(R.drawable.shape_oval_black);
        }
        holder.name.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private ImageView img;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.subway_info_item_lineName);
            img = itemView.findViewById(R.id.subway_info_item_lineBg);
        }
    }
}
