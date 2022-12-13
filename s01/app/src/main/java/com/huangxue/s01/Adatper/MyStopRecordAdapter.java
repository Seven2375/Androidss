package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.StopRecordBean;
import com.huangxue.s01.R;

import java.util.List;

public class MyStopRecordAdapter extends RecyclerView.Adapter<MyStopRecordAdapter.MyHolder> {

    private Context mContext;
    private List<StopRecordBean.RowsEntity> datalist;
    private int id;

    public MyStopRecordAdapter(Context mContext, List<StopRecordBean.RowsEntity> datalist,int id) {
        this.mContext = mContext;
        this.datalist = datalist;
        this.id = id;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_stop_record,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        StopRecordBean.RowsEntity data = datalist.get(position);
        holder.name.setText(data.getParkName());
        holder.plate.setText("车牌号："+data.getPlateNumber());
        holder.money.setText("共计收费："+data.getMonetary());
        holder.statime.setText("入场时间："+data.getEntryTime());
        holder.endtime.setText("出场时间："+data.getOutTime());
    }

    @Override
    public int getItemCount() {
        if (id == 0){
            return 5;
        }else {
            return datalist.size();
        }

    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView plate;
        private TextView money;
        private TextView statime;
        private TextView endtime;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.stop_record_item_name);
            plate = itemView.findViewById(R.id.stop_record_item_plate);
            money = itemView.findViewById(R.id.stop_record_item_money);
            statime = itemView.findViewById(R.id.stop_record_item_statime);
            endtime = itemView.findViewById(R.id.stop_record_item_endtime);
        }
    }
}
