package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huangxue.s01.Beans.ServicesListBean;
import com.huangxue.s01.R;

import java.util.List;

public class MyHomeGridAdapter extends RecyclerView.Adapter<MyHomeGridAdapter.MyHolder> {

    private Context mContext;
    private List<ServicesListBean.RowsEntity> datalist;
    private int id;

    public MyHomeGridAdapter(Context mContext, List<ServicesListBean.RowsEntity> datalist,int id) {
        this.mContext = mContext;
        this.datalist = datalist;
        this.id = id;
    }


    @NonNull
    @Override
    public MyHomeGridAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(mContext, R.layout.item_services_grid, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHomeGridAdapter.MyHolder holder, int position) {
        String Url = "http://124.93.196.45:10001";
        ServicesListBean.RowsEntity data = datalist.get(position);
        if (position==9){
            Glide.with(mContext)
                    .load(Url+data.getImgUrl())
                    .into(holder.img);
            holder.desc.setText("全部服务");
        }else {
            Glide.with(mContext)
                    .load(Url+data.getImgUrl())
                    .into(holder.img);
            holder.desc.setText(data.getServiceName());
        }


    }

    @Override
    public int getItemCount() {
        if (id == 1){
            return 10;
        }else {
            return datalist.size();
        }

    }

    public class MyHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView desc;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.home_grid_item_img);
            desc = itemView.findViewById(R.id.home_grid_item_desc);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null){
                        mOnItemClickListener.onRecyItemClick(getAdapterPosition());
                    }
                }
            });

        }
    }

    public interface OnRecyclerItemClickListener{
        void onRecyItemClick(int position);
    }
    private OnRecyclerItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnRecyclerItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }
}
