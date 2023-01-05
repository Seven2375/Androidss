package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.LookJobRecruitListBean;
import com.huangxue.s01.R;

import java.util.List;

public class LookJobNameListAdapter extends RecyclerView.Adapter<LookJobNameListAdapter.MyHolder> {

    private List<LookJobRecruitListBean.RowsEntity> rows;
    private Context mContext;

    public LookJobNameListAdapter(List<LookJobRecruitListBean.RowsEntity> rows, Context mContext) {
        this.rows = rows;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext,R.layout.item_text,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.name.setText(rows.get(position).getProfessionName());
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView name;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.item_text);

            itemView.setOnClickListener(v->{
                if (myOnClick!=null){
                    myOnClick.onClick(rows.get(getAdapterPosition()));
                }
            });

        }
    }

    private LookJobListAdapter.MyOnClick myOnClick;

    public void setMyOnClick(LookJobListAdapter.MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }
}
