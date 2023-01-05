package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;

import java.util.List;

public class AskInfoListAdapter extends RecyclerView.Adapter<AskInfoListAdapter.MyHolder> {

    private List<String> dataList;
    private Context mContext;
    private String imgUrl;

    public AskInfoListAdapter(List<String> dataList, Context mContext, String imgUrl) {
        this.dataList = dataList;
        this.mContext = mContext;
        this.imgUrl = imgUrl;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_ask_info_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String data = dataList.get(position);
        holder.desc.setText(data);
        Tools.setImg(mContext,imgUrl,holder.img);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView desc;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.ask_info_item_img);
            desc = itemView.findViewById(R.id.ask_info_item_desc);

        }
    }
}
