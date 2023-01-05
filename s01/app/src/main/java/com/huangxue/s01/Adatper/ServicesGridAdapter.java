package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.ServicesListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;

import java.util.ArrayList;
import java.util.List;

public class ServicesGridAdapter extends RecyclerView.Adapter<ServicesGridAdapter.MyHolder> implements Filterable {

    private Context mContext;
    private List<ServicesListBean.RowsEntity> filterList;
    private List<ServicesListBean.RowsEntity> originList;
    private int id;

    public ServicesGridAdapter(Context mContext, List<ServicesListBean.RowsEntity> filterList, int id) {
        this.mContext = mContext;
        this.filterList = filterList;
        this.id = id;
    }
    public ServicesGridAdapter(Context mContext, List<ServicesListBean.RowsEntity> filterList) {
        this.mContext = mContext;
        this.filterList = filterList;
        this.originList = filterList;
    }


    @NonNull
    @Override
    public ServicesGridAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = View.inflate(mContext, R.layout.item_grid_list, null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesGridAdapter.MyHolder holder, int position) {
        ServicesListBean.RowsEntity data = filterList.get(position);
        if (id==1){
            if (position==9){
                Tools.setImg(mContext,data.getImgUrl(),holder.img);
                holder.title.setText("全部服务");
            }else {
                Tools.setImg(mContext,data.getImgUrl(),holder.img);
                holder.title.setText(data.getServiceName());
            }
        }else{
            Tools.setImg(mContext,data.getImgUrl(),holder.img);
            holder.title.setText(data.getServiceName());
        }

    }

    @Override
    public int getItemCount() {
        if (id == 1){
            return 10;
        }else {
            return filterList.size();
        }

    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String s = charSequence.toString();
                if (s.isEmpty()){
                    filterList = originList;
                }else{
                    List<ServicesListBean.RowsEntity> filteredList = new ArrayList<>();
                    for (ServicesListBean.RowsEntity data : originList) {
                        if (data.getServiceType().contains(s)||data.getServiceName().contains(s)){
                            filteredList.add(data);
                        }
                    }
                    filterList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filterList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterList = (List<ServicesListBean.RowsEntity>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        private ImageView img;
        private TextView title;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.grid_item_img);
            title = itemView.findViewById(R.id.grid_item_title);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null){
                        mOnItemClickListener.onRecyItemClick(getAdapterPosition(),filterList.get(getAdapterPosition()));
                    }
                }
            });

        }
    }

    public interface OnRecyclerItemClickListener{
        void onRecyItemClick(int position,ServicesListBean.RowsEntity data);
    }
    private OnRecyclerItemClickListener mOnItemClickListener;
    public void setOnItemClickListener(OnRecyclerItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }
}
