package com.huangxue.s01.Adatper;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.LookJobRecruitListBean;
import com.huangxue.s01.R;

import java.util.ArrayList;
import java.util.List;

public class LookJobListAdapter extends RecyclerView.Adapter<LookJobListAdapter.MyHolder> implements Filterable {

    private List<LookJobRecruitListBean.RowsEntity> filterList;
    private List<LookJobRecruitListBean.RowsEntity> sourceList;
    private Context mContext;

    public LookJobListAdapter(List<LookJobRecruitListBean.RowsEntity> filterList, Context mContext) {
        this.filterList = filterList;
        this.sourceList = filterList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext,R.layout.item_job_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        LookJobRecruitListBean.RowsEntity data = filterList.get(position);
        holder.name.setText(data.getProfessionName()==null ? data.getName():data.getProfessionName());
        holder.salary.setText(data.getSalary()+"K");
        holder.desc.setText("简介：  "+data.getObligation());
        holder.companyName.setText(data.getCompanyName());
        holder.address.setText(data.getAddress());
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
                    List<LookJobRecruitListBean.RowsEntity> filteredList = new ArrayList<>();
                    //循环源数据
                    for (LookJobRecruitListBean.RowsEntity nb : sourceList) {
                        //判断源数据里的标题有没有搜索框输入的文字
                        if(nb.getName().contains(charString) || (nb.getProfessionName()==null ? nb.getName():nb.getProfessionName()).contains(charString)){
                            //如果有，添加数据
                            filteredList.add(nb);
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
                filterList = (List<LookJobRecruitListBean.RowsEntity>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView salary;
        private TextView desc;
        private TextView companyName;
        private TextView address;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.job_item_name);
            salary = itemView.findViewById(R.id.job_item_salary);
            desc = itemView.findViewById(R.id.job_item_desc);
            companyName = itemView.findViewById(R.id.job_item_companyName);
            address = itemView.findViewById(R.id.job_item_address);

            itemView.setOnClickListener(v->{
                if (myOnClick!=null){
                    myOnClick.onClick(filterList.get(getAdapterPosition()));
                }
            });

        }
    }
    public interface MyOnClick{
        void onClick(LookJobRecruitListBean.RowsEntity rows);
    }
    private MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }
}
