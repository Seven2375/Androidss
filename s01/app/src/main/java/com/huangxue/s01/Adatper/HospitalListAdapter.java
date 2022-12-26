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

import com.bumptech.glide.Glide;
import com.huangxue.s01.Beans.HospitalListBean;
import com.huangxue.s01.R;

import java.util.ArrayList;
import java.util.List;

public class HospitalListAdapter extends RecyclerView.Adapter<HospitalListAdapter.MyHolder> implements Filterable {

    private List<HospitalListBean.RowsEntity> filterList;
    private List<HospitalListBean.RowsEntity> sourceList;
    private Context mContext;

    public HospitalListAdapter(List<HospitalListBean.RowsEntity> filterList, Context mContext) {
        this.filterList = filterList;
        this.sourceList = filterList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_hospital_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        HospitalListBean.RowsEntity data = filterList.get(position);
        String Url = "http://124.93.196.45:10001";
        Glide.with(mContext)
                .load(Url+data.getImgUrl())
//                .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                .into(holder.img);
        holder.title.setText(data.getHospitalName());
        holder.desc.setText(data.getBrief());
        holder.level.setText("星级："+data.getLevel());
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                //没有过滤的内容，则使用源数据
                if (charString.isEmpty()){
                    filterList = sourceList;
                }else{//如果有过滤的内容
                    //新建一个集合用来保存过滤结果
                    List<HospitalListBean.RowsEntity> filteredList = new ArrayList<>();
                    //循环源数据
                    for (HospitalListBean.RowsEntity rows : sourceList) {
                        //判断源数据里的标题有没有搜索框输入的文字
                        if(rows.getHospitalName().contains(charString)){
                            //如果有，添加数据
                            filteredList.add(rows);
                        }
                    }
                    //替换数据
                    filterList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filterList;
                return filterResults;
            }
            //把过滤的值返回出来
            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterList = (List<HospitalListBean.RowsEntity>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView title;
        private TextView desc;
        private TextView level;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.hospital_item_img);
            title = itemView.findViewById(R.id.hospital_item_title);
            desc = itemView.findViewById(R.id.hospital_item_desc);
            level = itemView.findViewById(R.id.hospital_item_level);
            img.setOnClickListener(view -> {
                if (myOnClick != null){
                    myOnClick.onClick(getAdapterPosition(),filterList.get(getAdapterPosition()));
                }
            });
        }
    }

    public interface MyOnClick{
        void onClick(int position, HospitalListBean.RowsEntity rowsEntity);
    }
    private MyOnClick myOnClick;
    public void setMyOnClick(MyOnClick myOnClick){
        this.myOnClick = myOnClick;
    }
}
