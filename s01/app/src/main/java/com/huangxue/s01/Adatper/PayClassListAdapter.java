package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.PayClassListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;

import org.w3c.dom.Text;

import java.util.List;

public class PayClassListAdapter extends RecyclerView.Adapter<PayClassListAdapter.MyHolder> {

    private List<PayClassListBean.DataEntity> dataList;
    private Context mContext;

    public PayClassListAdapter(List<PayClassListBean.DataEntity> dataList, Context mContext) {
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
        PayClassListBean.DataEntity data = dataList.get(position);
        holder.title.setText(data.getLiveName());
        Tools.setImg(mContext,data.getImgUrl(),holder.img);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView title;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.pay_class_item_img);
            title = itemView.findViewById(R.id.pay_class_item_text);
            itemView.setOnClickListener(v->{
                if (myOnClick!=null){
                    myOnClick.onClick(dataList.get(getAdapterPosition()).getLiveName());
                }
            });
        }
    }
    public interface MyOnClick{
        void onClick(String name);
    }
    private MyOnClick myOnClick;

    public void setMyOnClick(MyOnClick myOnClick) {
        this.myOnClick = myOnClick;
    }
}
