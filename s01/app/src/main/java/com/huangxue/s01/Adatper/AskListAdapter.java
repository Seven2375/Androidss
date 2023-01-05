package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.AskListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;

import java.util.List;

public class AskListAdapter extends RecyclerView.Adapter<AskListAdapter.MyHolder> {

    private List<AskListBean.RowsEntity> dataList;
    private Context mContext;

    public AskListAdapter(List<AskListBean.RowsEntity> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_ask_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        AskListBean.RowsEntity data = dataList.get(position);

        if (data.getDoctor() == null){
            holder.desc.setText("描述:\n"+data.getQuestion());
            holder.name.setText("未知");
            holder.img.setImageResource(R.drawable.my_bottom);
        }else{
            holder.desc.setText("描述:\n"+data.getQuestion());
            holder.name.setText(data.getDoctor().getName());
            Tools.setImg(mContext,data.getDoctor().getAvatar(),holder.img);
        }

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView name;
        private TextView desc;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.my_askList_item_img);
            name = itemView.findViewById(R.id.my_askList_item_name);
            desc = itemView.findViewById(R.id.my_askList_item_desc);

            itemView.setOnClickListener(v->{
                if (myOnClick!=null){
                    myOnClick.onClick(dataList.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface MyOnClick{
        void onClick(AskListBean.RowsEntity data);
    }
    private MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }
}
