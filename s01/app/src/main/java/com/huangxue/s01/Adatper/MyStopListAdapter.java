package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huangxue.s01.Beans.StopListBean;
import com.huangxue.s01.R;

import java.util.List;

public class MyStopListAdapter extends RecyclerView.Adapter<MyStopListAdapter.MyHodler> {

    private Context mContext;
    private List<StopListBean.RowsEntity> dataBean;
    private int id;

    public MyStopListAdapter(Context context, List<StopListBean.RowsEntity> dataBean,int id) {
        this.mContext = context;
        this.dataBean = dataBean;
        this.id = id;
    }

    @NonNull
    @Override
    public MyHodler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHodler(View.inflate(mContext, R.layout.item_stop_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHodler holder, int position) {
        String Url = "https://img1.baidu.com/it/u=1458915908,2029186051&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=333";
        StopListBean.RowsEntity datas = dataBean.get(position);
        Glide.with(mContext).load(Url).into(holder.img);
        holder.name.setText("名称:"+datas.getParkName());
        holder.address.setText("地址:"+datas.getAddress());
        holder.price.setText("价格:"+datas.getRates()+"元");
        holder.number.setText("剩余位置:"+datas.getVacancy());
        holder.dis.setText("距离:"+datas.getDistance()+"米");
    }

    @Override
    public int getItemCount() {
        if (id==0){
            return 5;
        }else{
            return dataBean.size();
        }
    }

    public class MyHodler extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView name;
        private TextView address;
        private TextView price;
        private TextView number;
        private TextView dis;

        public MyHodler(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.stop_list_item_img);
            name = itemView.findViewById(R.id.stop_list_item_name);
            address = itemView.findViewById(R.id.stop_list_item_address);
            price = itemView.findViewById(R.id.stop_list_item_price);
            number = itemView.findViewById(R.id.stop_list_item_number);
            dis = itemView.findViewById(R.id.stop_list_item_dis);
            itemView.findViewById(R.id.stop_list_item_ll).setOnClickListener(v->{
                if (mOnClickListener != null){
                    mOnClickListener.mOnClick(v,getAdapterPosition());
                }
            });
            itemView.findViewById(R.id.stop_list_item_rl).setOnClickListener(v -> {
                if (mOnClickListener != null){
                    mOnClickListener.mOnClick(v,getAdapterPosition());
                }
            });

        }
    }

    public interface onMyClickListener {
        void mOnClick(View view,int position);
    }
    private onMyClickListener mOnClickListener;
    public void setMyOnClickListener(onMyClickListener onClickListener){
        mOnClickListener = onClickListener;
    }
}
