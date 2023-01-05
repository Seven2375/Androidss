package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.R;

import java.util.List;

public class ServicesClassLeftRvAdapter extends RecyclerView.Adapter<ServicesClassLeftRvAdapter.MyHolder> {

    private List<String> dataList;
    private Context mContext;
    public int mCheckedPosition = 0;

    public ServicesClassLeftRvAdapter(List<String> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_services_left_text,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.title.setText(dataList.get(position));
        holder.title.setBackgroundColor(mCheckedPosition==position ? 0xffffffff:0xffF6F6F6);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private TextView title;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.services_leftRv_text);

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

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }
}
