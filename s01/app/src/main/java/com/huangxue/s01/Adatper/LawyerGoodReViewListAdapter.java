package com.huangxue.s01.Adatper;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.LawyerGoodReviewListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.MyOnClick;
import com.huangxue.s01.Utils.Tools;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

public class LawyerGoodReViewListAdapter extends RecyclerView.Adapter<LawyerGoodReViewListAdapter.MyHolder> {

    private List<LawyerGoodReviewListBean.DataEntity> dataList;
    private Context mContext;

    public LawyerGoodReViewListAdapter(List<LawyerGoodReviewListBean.DataEntity> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_lawyer_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        LawyerGoodReviewListBean.DataEntity data = dataList.get(position);

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate startTime = LocalDate.parse(data.getWorkStartAt());
        LocalDate endTime = LocalDate.parse(simpleDateFormat.format(date));
        Period period = Period.between(startTime, endTime);

        holder.name.setText(data.getName());
        holder.askNumber.setText("咨询人数："+data.getServiceTimes());
        holder.goodRate.setText("好评率："+data.getFavorableRate());
        holder.expertise.setText("专长："+data.getLegalExpertiseName());
        holder.workingYear.setText("从业时长："+period.getYears()+"年");
        Tools.setImg(mContext,data.getAvatarUrl(),holder.img);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView name,workingYear,expertise,askNumber,goodRate;
        private Button btn;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.lawyer_list_item_img);
            name = itemView.findViewById(R.id.lawyer_list_item_name);
            workingYear = itemView.findViewById(R.id.lawyer_list_item_workingYear);
            expertise = itemView.findViewById(R.id.lawyer_list_item_expertise);
            askNumber = itemView.findViewById(R.id.lawyer_list_item_askNumber);
            goodRate = itemView.findViewById(R.id.lawyer_list_item_goodRate);

            btn = itemView.findViewById(R.id.lawyer_list_item_btn);
            btn.setOnClickListener(v->{
                if (myOnClick!=null){
                    myOnClick.onClick(dataList.get(getAdapterPosition()));
                }
            });

        }
    }

    private MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }
}
