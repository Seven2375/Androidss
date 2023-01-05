package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huangxue.s01.Beans.PetClassGridBean;
import com.huangxue.s01.R;

import java.util.List;

public class PetClassGridAdapter extends RecyclerView.Adapter<PetClassGridAdapter.MyHolder> {

    private Context mContext;
    private List<PetClassGridBean.DataEntity> petClassData;

    public PetClassGridAdapter(Context mContext, List<PetClassGridBean.DataEntity> petClassData) {
        this.mContext = mContext;
        this.petClassData = petClassData;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_services_grid,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String Url = "http://124.93.196.45:10001";
        PetClassGridBean.DataEntity data = petClassData.get(position);
        Glide.with(mContext)
                .load(Url+data.getImgUrl())
                .into(holder.img);
        holder.name.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return petClassData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.home_grid_item_img);
            name = itemView.findViewById(R.id.home_grid_item_title);

            itemView.setOnClickListener(view -> {
                if (myOnClick!=null){
                    myOnClick.onClick(petClassData.get(getAdapterPosition()));
                }
            });

        }
    }

    public interface MyOnClick{
        void onClick(PetClassGridBean.DataEntity data);
    }
    private MyOnClick myOnClick;
    public void setMyOnClick(MyOnClick myOnClick){
        this.myOnClick = myOnClick;
    }
}
