package com.huangxue.s01.Adatper;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.LawyerUserEvaluateListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.MyOnClick;
import com.huangxue.s01.Utils.MyOnClickPosition;
import com.huangxue.s01.Utils.Tools;

import java.util.List;

public class LawyerUserEvaluateListAdapter extends RecyclerView.Adapter<LawyerUserEvaluateListAdapter.MyHolder> {

    private List<LawyerUserEvaluateListBean.RowsEntity> dataList;
    private Context mContext;

    public LawyerUserEvaluateListAdapter(List<LawyerUserEvaluateListBean.RowsEntity> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_lawyer_user_evaluate_list,null));
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        LawyerUserEvaluateListBean.RowsEntity data = dataList.get(position);
        holder.name.setText(data.getFromUserName());
        holder.desc.setText(data.getEvaluateContent());
        holder.likeNum.setText(data.getLikeCount()+"");
        holder.date.setText(data.getCreateTime().substring(0,10));
        Tools.setUserImg(mContext,data.getFromUserAvatar(),holder.img);

        if (data.isMyLikeState()){
            holder.likeImg.setImageResource(R.drawable.thumbsup_true);
        }else {
            holder.likeImg.setImageResource(R.drawable.thumbsup_false);
        }
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView img,likeImg;
        private TextView name,desc,date,likeNum;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.lawyer_evaluate_item_img);
            name = itemView.findViewById(R.id.lawyer_evaluate_item_name);
            desc = itemView.findViewById(R.id.lawyer_evaluate_item_desc);
            date = itemView.findViewById(R.id.lawyer_evaluate_item_date);
            likeNum = itemView.findViewById(R.id.lawyer_evaluate_item_likeNum);

            likeImg = itemView.findViewById(R.id.lawyer_evaluate_item_upImg);

            likeImg.setOnClickListener(v->{
                if (myOnClick!=null){
                    myOnClick.onClick(dataList.get(getAdapterPosition()),getAdapterPosition());
                }
            });

        }
    }
    private MyOnClickPosition myOnClick;

    public void setMyOnClick(MyOnClickPosition myOnClick) {
        this.myOnClick = myOnClick;
    }
}
