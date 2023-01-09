package com.huangxue.s01.Adatper;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.gifdecoder.GifHeader;
import com.huangxue.s01.Beans.TakeawayMenuClassListBean;
import com.huangxue.s01.Beans.TakeawayMenuListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.MyOnClick;
import com.huangxue.s01.Utils.MyOnClickPosition;
import com.huangxue.s01.Utils.Tools;

import java.util.List;

public class TakeawayMeanRightRvItemAdapter extends RecyclerView.Adapter<TakeawayMeanRightRvItemAdapter.MyHolder> {

    private List<TakeawayMenuListBean.DataEntity> listData;
    private Context mContext;

    public TakeawayMeanRightRvItemAdapter(List<TakeawayMenuListBean.DataEntity> listData, Context mContext) {
        this.listData = listData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_takeaway_mean_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        TakeawayMenuListBean.DataEntity data = listData.get(position);

//        if (data.getQuantity()!=0){
//            holder.remove.setVisibility(View.VISIBLE);
//            holder.quantity.setVisibility(View.VISIBLE);
//            holder.quantity.setText(data.getQuantity()+"");
//        }else {
//            holder.remove.setVisibility(View.GONE);
//            holder.quantity.setVisibility(View.GONE);
//        }

        holder.quantity.setText(data.getQuantity()+"");

        Tools.setImg(mContext,data.getImgUrl(),holder.img);
        holder.name.setText(data.getName());
        holder.saleQuantity.setText("月销"+data.getSaleQuantity());
        holder.favorRate.setText("好评度"+data.getFavorRate()+"%");
        holder.price.setText("￥"+data.getPrice());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView img,add,remove;
        private TextView name,saleQuantity,favorRate,price,quantity;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.takeawayMenuList_item_img);
            add = itemView.findViewById(R.id.takeawayMenuList_item_add);
            remove = itemView.findViewById(R.id.takeawayMenuList_item_remove);
            name = itemView.findViewById(R.id.takeawayMenuList_item_name);
            saleQuantity = itemView.findViewById(R.id.takeawayMenuList_item_saleQuantity);
            favorRate = itemView.findViewById(R.id.takeawayMenuList_item_favorRate);
            price = itemView.findViewById(R.id.takeawayMenuList_item_price);
            quantity = itemView.findViewById(R.id.takeawayMenuList_item_quantity);

            add.setOnClickListener(v->{
                if (myOnClickPosition!=null){
                    myOnClickPosition.onClick(listData.get(getAdapterPosition()),getAdapterPosition());
                }
            });

        }
    }

    private MyOnClickPosition myOnClickPosition;

    public void setMyOnClick(MyOnClickPosition myOnClickPosition) {
        this.myOnClickPosition = myOnClickPosition;
    }
}
