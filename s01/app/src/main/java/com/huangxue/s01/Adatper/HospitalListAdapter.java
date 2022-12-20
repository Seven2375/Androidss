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
import com.huangxue.s01.Beans.HospitalListBean;
import com.huangxue.s01.R;

import java.util.List;

public class HospitalListAdapter extends RecyclerView.Adapter<HospitalListAdapter.MyHolder> {

    private List<HospitalListBean.RowsEntity> rows;
    private Context mContext;

    public HospitalListAdapter(List<HospitalListBean.RowsEntity> rows, Context mContext) {
        this.rows = rows;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_hospital_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        HospitalListBean.RowsEntity data = rows.get(position);
        String Url = "http://124.93.196.45:10001";
        Glide.with(mContext)
                .load(Url+data.getImgUrl())
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(holder.img);
        holder.title.setText(data.getHospitalName());
        holder.desc.setText(data.getBrief());
        holder.level.setText("星级："+data.getLevel());
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView title;
        private TextView desc;
        private TextView level;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.hospital_item_img);
            title = itemView.findViewById(R.id.hospital_item_title);
            desc = itemView.findViewById(R.id.hospital_item_desc);
            level = itemView.findViewById(R.id.hospital_item_level);
            img.setOnClickListener(view -> {
                if (myOnClick != null){
                    myOnClick.onClick(getAdapterPosition());
                }
            });
        }
    }

    public interface MyOnClick{
        void onClick(int position);
    }
    private MyOnClick myOnClick;
    public void setMyOnClick(MyOnClick myOnClick){
        this.myOnClick = myOnClick;
    }
}
