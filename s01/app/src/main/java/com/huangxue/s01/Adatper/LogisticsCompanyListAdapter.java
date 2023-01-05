package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.LogisticsCompanyListBean;
import com.huangxue.s01.Beans.StringIntBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;

import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LogisticsCompanyListAdapter extends RecyclerView.Adapter<LogisticsCompanyListAdapter.MyHolder> {

    private List<StringIntBean> dataList;
    private Context mContext;

    public LogisticsCompanyListAdapter(List<StringIntBean> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_pay_class_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        StringIntBean data = dataList.get(position);
        holder.title.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView title;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.pay_class_item_text);

            itemView.setOnClickListener(v->{
                if (myOnClick!=null){
                    myOnClick.onClick(dataList.get(getAdapterPosition()));
                }
            });

        }
    }
    public interface MyOnClick{
        void onClick(StringIntBean data);
    }
    private MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }
}
