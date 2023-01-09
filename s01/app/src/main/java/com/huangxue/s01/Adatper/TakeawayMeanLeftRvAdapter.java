package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.TakeawayMenuClassListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.MyOnClick;
import com.huangxue.s01.Utils.MyOnClickPosition;

import java.util.List;

public class TakeawayMeanLeftRvAdapter extends RecyclerView.Adapter<TakeawayMeanLeftRvAdapter.MyHolder> {

    private List<TakeawayMenuClassListBean.DataEntity> listData;
    private Context mContext;
    public int selectPosition = 0;

    public TakeawayMeanLeftRvAdapter(List<TakeawayMenuClassListBean.DataEntity> listData, Context mContext) {
        this.listData = listData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_services_left_text,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        TakeawayMenuClassListBean.DataEntity data = listData.get(position);
        holder.title.setText(data.getName());

        holder.title.setBackgroundColor(selectPosition==position ?0xFFffffff:0xffF6F6F6);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView title;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.services_leftRv_text);

            itemView.setOnClickListener(v->{
                if (myOnClickPosition!=null){
                    myOnClickPosition.onClick(listData.get(getAdapterPosition()),getAdapterPosition());
                }
            });

        }
    }
    private MyOnClickPosition myOnClickPosition;

    public void setMyOnClickPosition(MyOnClickPosition myOnClickPosition) {
        this.myOnClickPosition = myOnClickPosition;
    }
}
