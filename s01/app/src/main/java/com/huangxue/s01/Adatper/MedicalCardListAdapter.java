package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.MedicalCardListBean;
import com.huangxue.s01.R;

import java.util.List;

public class MedicalCardListAdapter extends RecyclerView.Adapter<MedicalCardListAdapter.MyHolder> {

    private Context mContext;
    private List<MedicalCardListBean.RowsEntity> rows;

    public MedicalCardListAdapter(Context mContext, List<MedicalCardListBean.RowsEntity> rows) {
        this.mContext = mContext;
        this.rows = rows;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext,R.layout.item_medical_card_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.name.setText(rows.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView name;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.medical_card_item_user_name);
            itemView.setOnClickListener(v->{
                if (myOnClick!=null){
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
