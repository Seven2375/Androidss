package com.huangxue.s01.Adatper;

import android.content.Context;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.SubwayAllStationListBean;
import com.huangxue.s01.R;

import java.util.ArrayList;
import java.util.List;

public class SubwayAllStationListAdapter extends RecyclerView.Adapter<SubwayAllStationListAdapter.MyHolder> implements Filterable {

    private List<SubwayAllStationListBean.DataEntity> dataList;
    private List<SubwayAllStationListBean.DataEntity> originList;
    private Context mContext;

    public SubwayAllStationListAdapter(List<SubwayAllStationListBean.DataEntity> dataList, Context mContext) {
        this.dataList = dataList;
        this.originList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_text,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        SubwayAllStationListBean.DataEntity data = dataList.get(position);
        holder.name.setText(data.getName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String s = charSequence.toString();
                if (s.isEmpty()){
                    dataList = originList;
                }else{
                    List<SubwayAllStationListBean.DataEntity> filteredList = new ArrayList<>();
                    for (SubwayAllStationListBean.DataEntity data : originList) {
                        if (data.getName().contains(s)){
                            filteredList.add(data);
                        }
                    }
                    dataList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = dataList;
                return filterResults;
            }
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                dataList = (List<SubwayAllStationListBean.DataEntity>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView name;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.item_text);

            itemView.setOnClickListener(v->{
                if (myOnClick!=null){
                    myOnClick.onClick(dataList.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface MyOnClick{
        void onClick(Object data);
    }

    private MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }
}
