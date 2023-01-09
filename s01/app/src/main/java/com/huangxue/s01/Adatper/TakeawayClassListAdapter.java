package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.TakeawayClassListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.MyOnClick;
import com.huangxue.s01.Utils.Tools;

import java.util.List;

public class TakeawayClassListAdapter extends RecyclerView.Adapter<TakeawayClassListAdapter.MyHolder> {

    private List<TakeawayClassListBean.DataEntity> dataList;
    private Context mContext;

    public TakeawayClassListAdapter(List<TakeawayClassListBean.DataEntity> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_grid_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        TakeawayClassListBean.DataEntity data = dataList.get(position);
        holder.title.setText(data.getThemeName());
        Tools.setImg(mContext,data.getImgUrl(),holder.img);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView title;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.grid_item_img);
            title = itemView.findViewById(R.id.grid_item_title);

            itemView.setOnClickListener(v->{
                if (myOnClick!=null){
                    myOnClick.onClick(getAdapterPosition());
                }
            });

        }
    }

    private MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }
}
