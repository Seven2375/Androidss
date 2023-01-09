package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.TakeawaySellerListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.MyOnClick;
import com.huangxue.s01.Utils.Tools;

import java.util.List;

public class TakeawaySellerListAdapter extends RecyclerView.Adapter<TakeawaySellerListAdapter.MyHolder> {

    private List<TakeawaySellerListBean.RowsEntity> dataList;
    private Context mContext;

    public TakeawaySellerListAdapter(List<TakeawaySellerListBean.RowsEntity> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_takeaway_seller_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        TakeawaySellerListBean.RowsEntity data = dataList.get(position);
        holder.name.setText(data.getName());
        holder.score.setText(data.getScore()+"分");
        holder.saleQuantity.setText("月销"+data.getSaleQuantity());
        holder.avgCost.setText("人均 ￥"+data.getAvgCost());
        holder.address.setText("地址:"+data.getAddress());
        holder.deliveryTime.setText(data.getDeliveryTime()+"分钟");
        holder.distance.setText(Integer.valueOf((int) data.getDistance())+"m");
        Tools.setImg(mContext,data.getImgUrl(),holder.img);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView name,score,saleQuantity,avgCost,address,deliveryTime,distance;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.takeawaySeller_item_img);
            name = itemView.findViewById(R.id.takeawaySeller_item_name);
            score = itemView.findViewById(R.id.takeawaySeller_item_score);
            saleQuantity = itemView.findViewById(R.id.takeawaySeller_item_saleQuantity);
            avgCost = itemView.findViewById(R.id.takeawaySeller_item_avgCost);
            address = itemView.findViewById(R.id.takeawaySeller_item_address);
            deliveryTime = itemView.findViewById(R.id.takeawaySeller_item_deliveryTime);
            distance = itemView.findViewById(R.id.takeawaySeller_item_distance);

            itemView.setOnClickListener(v->{
                if (myOnClick!=null){
                    myOnClick.onClick(dataList.get(getAdapterPosition()));
                }
            });

        }
    }
    private MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }
}
