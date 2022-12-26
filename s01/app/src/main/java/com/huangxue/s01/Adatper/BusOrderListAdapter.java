package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.BusOrderBean;
import com.huangxue.s01.R;

import java.util.List;

public class BusOrderListAdapter extends RecyclerView.Adapter<BusOrderListAdapter.MyHolder> {


    private List<BusOrderBean.RowsEntity> rows;
    private Context mContext;

    public BusOrderListAdapter(List<BusOrderBean.RowsEntity> rows, Context mContext) {
        this.rows = rows;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_bus_order_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        BusOrderBean.RowsEntity data = rows.get(position);
        holder.name.setText(data.getPath());
        holder.staName.setText(data.getStart());
        holder.endName.setText(data.getEnd());
        holder.orderDate.setText("时间："+data.getCreateTime());
        holder.orderNum.setText("订单号："+data.getOrderNum());
        holder.price.setText("￥"+data.getPrice());
        holder.status.setText(data.getStatus()==0 ? "待支付":"已支付");
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView staName;
        private TextView endName;
        private TextView price;
        private TextView status;
        private TextView orderNum;
        private TextView orderDate;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.bus_order_item_name);
            staName = itemView.findViewById(R.id.bus_order_item_staName);
            endName = itemView.findViewById(R.id.bus_order_item_endName);
            price = itemView.findViewById(R.id.bus_order_item_price);
            status = itemView.findViewById(R.id.bus_order_item_status);
            orderNum = itemView.findViewById(R.id.bus_order_item_orderNum);
            orderDate = itemView.findViewById(R.id.bus_order_item_orderDate);

        }
    }
}
