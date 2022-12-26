package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.huangxue.s01.Beans.DoctorListBean;
import com.huangxue.s01.R;

import java.util.List;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.MyHolder> {

    private Context mContext;
    private List<DoctorListBean.RowsEntity> rows;

    public DoctorListAdapter(Context mContext, List<DoctorListBean.RowsEntity> rows) {
        this.mContext = mContext;
        this.rows = rows;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_doctor_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String Url  = "http://124.93.196.45:10001";
        DoctorListBean.RowsEntity data = rows.get(position);
        Glide.with(mContext)
                .load(Url+data.getAvatar())
                .into(holder.img);
        holder.name.setText(data.getName());
        holder.jobName.setText("职称："+data.getJobName());
        holder.goodAt.setText("擅长："+data.getGoodAt());
        holder.practiceNo.setText("职业编号："+data.getPracticeNo());
        holder.workingYears.setText("从业年限："+data.getWorkingYears()+"年");
    }

    @Override
    public int getItemCount() {
        return rows.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        private TextView jobName;
        private TextView goodAt;
        private TextView practiceNo;
        private TextView workingYears;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.doctor_list_item_img);
            name = itemView.findViewById(R.id.doctor_list_item_name);
            jobName = itemView.findViewById(R.id.doctor_list_item_jobName);
            goodAt = itemView.findViewById(R.id.doctor_list_item_goodAt);
            practiceNo = itemView.findViewById(R.id.doctor_list_item_practiceNo);
            workingYears = itemView.findViewById(R.id.doctor_list_item_workingYears);

            itemView.setOnClickListener(view -> {
                if (myOnClick != null){
                    myOnClick.onClick(rows.get(getAdapterPosition()));
                }
            });

        }
    }

    public interface MyOnClick{
        void onClick(DoctorListBean.RowsEntity rows);
    }
    private MyOnClick myOnClick;
    public void setMyOnClick(MyOnClick myOnClick){
        this.myOnClick = myOnClick;
    }
}
