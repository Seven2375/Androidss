package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.huangxue.s01.Beans.LookRoomListBean;
import com.huangxue.s01.R;

import java.util.List;

public class LookRoomListAdapter extends RecyclerView.Adapter<LookRoomListAdapter.MyHolder> {

    private List<LookRoomListBean.RowsEntity> dataList;
    private Context mContext;

    public LookRoomListAdapter(List<LookRoomListBean.RowsEntity> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_look_room_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String Url = "http://124.93.196.45:10001";
        LookRoomListBean.RowsEntity data = dataList.get(position);
        Glide.with(mContext)
                .load(Url+data.getPic())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(holder.img);
        holder.title.setText(data.getSourceName());
        holder.price.setText(data.getPrice());
        holder.areaSieze.setText("面积："+data.getAreaSize());
        holder.desc.setText(data.getDescription());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView title;
        private TextView price;
        private TextView areaSieze;
        private TextView desc;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.look_room_item_img);
            title = itemView.findViewById(R.id.look_room_item_title);
            price = itemView.findViewById(R.id.look_room_item_price);
            areaSieze = itemView.findViewById(R.id.look_room_item_areasize);
            desc = itemView.findViewById(R.id.look_room_item_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(myOnClick!=null){
                        myOnClick.onClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface MyOnClick{
        void onClick(int position);
    }
    private MyOnClick myOnClick;
    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }
}
