package com.huangxue.s01.Adatper;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.TakeawayMenuClassListBean;
import com.huangxue.s01.Beans.TakeawayMenuListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.MyOnClick;
import com.huangxue.s01.Utils.MyOnClickPosition;

import java.util.List;

public class TakeawayMeanRightRvAdapter extends RecyclerView.Adapter<TakeawayMeanRightRvAdapter.MyHolder> implements MyOnClickPosition {

    private List<List<TakeawayMenuListBean.DataEntity>> menuListData;
    private List<TakeawayMenuClassListBean.DataEntity> menuClassData;
    private Context mContext;
    private TakeawayMeanRightRvItemAdapter adapter;
    private List<TakeawayMenuListBean.DataEntity> kkkk;

    public TakeawayMeanRightRvAdapter(List<List<TakeawayMenuListBean.DataEntity>> menuListData, List<TakeawayMenuClassListBean.DataEntity> menuClassData, Context mContext) {
        this.menuListData = menuListData;
        this.menuClassData = menuClassData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_takeaway_menu_right,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        TakeawayMenuClassListBean.DataEntity data = menuClassData.get(position);
        kkkk = menuListData.get(position);
        holder.title.setText(data.getName());

        adapter = new TakeawayMeanRightRvItemAdapter(kkkk, mContext);
        holder.rv.setLayoutManager(new LinearLayoutManager(mContext));
        holder.rv.setAdapter(adapter);
        adapter.setMyOnClick(this);
    }

    @Override
    public int getItemCount() {
        return menuClassData.size();
    }

    @Override
    public void onClick(Object data1, int position) {
        TakeawayMenuListBean.DataEntity origin = (TakeawayMenuListBean.DataEntity) data1;
        kkkk.get(position).setQuantity(kkkk.get(position).getQuantity()+1);
        adapter.notifyItemChanged(position);

        Log.e("TAG", "onClick: "+ kkkk.get(position).getQuantity());
    }


    public class MyHolder extends RecyclerView.ViewHolder {

        private RecyclerView rv;
        private TextView title;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            rv = itemView.findViewById(R.id.takeawayMenu_rightItem_rv);
            title = itemView.findViewById(R.id.takeawayMenu_rightItem_text);

        }
    }
}
