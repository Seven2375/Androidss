package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.SubwayListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;

import java.util.List;

public class SubwayListAdapter extends RecyclerView.Adapter<SubwayListAdapter.MyHolder> {

    private List<SubwayListBean.DataEntity> dataList;
    private Context mContext;

    public SubwayListAdapter(List<SubwayListBean.DataEntity> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_subway_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        SubwayListBean.DataEntity data = dataList.get(position);
        holder.lineName.setText(data.getLineName());
        holder.currentName.setText("当前站："+data.getCurrentName());
        holder.nextName.setText("下一站："+data.getNextStep().getName());
        holder.reachTime.setText("还有 "+data.getReachTime()+" 分钟");
        holder.preStep.setText("上一站："+data.getPreStep().getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView lineName,currentName,nextName,reachTime,preStep;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            lineName = itemView.findViewById(R.id.subway_item_name);
            currentName = itemView.findViewById(R.id.subway_item_currentName);
            nextName = itemView.findViewById(R.id.subway_item_nextStep);
            reachTime = itemView.findViewById(R.id.subway_item_reachTime);
            preStep = itemView.findViewById(R.id.subway_item_preStep);

            itemView.setOnClickListener(view -> {
                if (myOnClick!=null){
                    myOnClick.onClick(dataList.get(getAdapterPosition()));
                }
            });

        }
    }

    public interface MyOnClick{
        void onClick(SubwayListBean.DataEntity data);
    }
    private MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }
}
