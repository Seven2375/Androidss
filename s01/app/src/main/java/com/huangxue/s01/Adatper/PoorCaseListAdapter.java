package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Datas.PoorCaseListData;
import com.huangxue.s01.R;

import java.util.List;

public class PoorCaseListAdapter extends RecyclerView.Adapter<PoorCaseListAdapter.MyHolder> {

    private Context mContext;
    private List<PoorCaseListData> data;

    public PoorCaseListAdapter(Context mContext, List<PoorCaseListData> data) {
        this.mContext = mContext;
        this.data = data;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext,R.layout.item_poor_case_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.img.setImageResource(data.get(position).getImg());
        holder.title.setText(data.get(position).getTitle());
        holder.desc.setText(data.get(position).getDesc());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView title;
        private TextView desc;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.poor_case_list_item_img);
            title = itemView.findViewById(R.id.poor_case_list_item_title);
            desc = itemView.findViewById(R.id.poor_case_list_item_desc);
        }
    }
}
