package com.huangxue.s01.Adatper;

import android.content.Context;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.NewsListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;

import java.util.List;

public class HotNewsAdapter extends RecyclerView.Adapter<HotNewsAdapter.Holder> {

    private List<NewsListBean.RowsEntity> filterList;
    private Context mContext;

    public HotNewsAdapter(List<NewsListBean.RowsEntity> filterList, Context mContext) {
        this.filterList = filterList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(View.inflate(mContext, R.layout.item_hot_news,null));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        NewsListBean.RowsEntity data = filterList.get(position);
        holder.title.setText(data.getTitle());
        Tools.setImg(mContext,data.getCover(),holder.img);
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public class Holder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView title;

        public Holder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.hotNews_item_img);
            title = itemView.findViewById(R.id.hotNews_item_title);

        }
    }
}
