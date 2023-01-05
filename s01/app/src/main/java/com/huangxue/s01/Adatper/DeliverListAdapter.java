package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.DeliverListBean;
import com.huangxue.s01.R;

import java.util.List;

public class DeliverListAdapter extends RecyclerView.Adapter<DeliverListAdapter.MyHolder> {

    private List<DeliverListBean.RowsEntity> rows;
    private Context mContext;

    public DeliverListAdapter(List<DeliverListBean.RowsEntity> rows, Context mContext) {
        this.rows = rows;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_deliver_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        DeliverListBean.RowsEntity data = rows.get(position);
        holder.name.setText("公司："+data.getCompanyName());
        holder.money.setText("薪资："+(data.getMoney()==null ?"无":data.getMoney()));
        holder.postName.setText("岗位名称："+(data.getPostName()==null ?"无":data.getPostName()));
        holder.satrTime.setText("投递时间："+data.getSatrTime());
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        private TextView name;
        private TextView money;
        private TextView postName;
        private TextView satrTime;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.deliver_item_name);
            money = itemView.findViewById(R.id.deliver_item_money);
            postName = itemView.findViewById(R.id.deliver_item_postName);
            satrTime = itemView.findViewById(R.id.deliver_item_satrTime);

        }
    }
}
