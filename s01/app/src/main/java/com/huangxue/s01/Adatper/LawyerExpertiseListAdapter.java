package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.LawyerExpertiseListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.MyOnClick;
import com.huangxue.s01.Utils.Tools;

import java.util.List;

public class LawyerExpertiseListAdapter extends RecyclerView.Adapter<LawyerExpertiseListAdapter.MyHolder> {

    private List<LawyerExpertiseListBean.RowsEntity> dataList;
    private Context mContext;

    public LawyerExpertiseListAdapter(List<LawyerExpertiseListBean.RowsEntity> dataList, Context mContext) {
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
        LawyerExpertiseListBean.RowsEntity data = dataList.get(position);
        holder.title.setText(data.getName());
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
