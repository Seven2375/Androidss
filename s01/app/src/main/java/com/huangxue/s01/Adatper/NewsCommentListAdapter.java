package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.NewsCommentListBean;
import com.huangxue.s01.R;

import java.util.List;

public class NewsCommentListAdapter extends RecyclerView.Adapter<NewsCommentListAdapter.MyHolder> {

    private List<NewsCommentListBean.RowsEntity> dataList;
    private Context mContext;

    public NewsCommentListAdapter(List<NewsCommentListBean.RowsEntity> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public NewsCommentListAdapter.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_news_comment_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull NewsCommentListAdapter.MyHolder holder, int position) {
        NewsCommentListBean.RowsEntity data = dataList.get(position);
        holder.name.setText(data.getUserName());
        holder.desc.setText(data.getContent());
        holder.date.setText(data.getCommentDate());
        holder.like.setText(""+data.getLikeNum());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private TextView name;
        private TextView desc;
        private TextView date;
        private TextView like;
        private ImageView upImg;
        public MyHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.news_comment_item_name);
            desc = itemView.findViewById(R.id.news_comment_item_desc);
            date = itemView.findViewById(R.id.news_comment_item_date);
            like = itemView.findViewById(R.id.news_comment_item_likeNum);
            upImg = itemView.findViewById(R.id.news_comment_item_upImg);

            upImg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (myCommentOnClick!=null){
                        myCommentOnClick.OnClick(getAdapterPosition());
                    }
                }
            });
        }
    }

    public interface MyCommentOnClick{
        void OnClick(int positon);
    }
    private MyCommentOnClick myCommentOnClick;
    public void setMyCommentOnClick(MyCommentOnClick myCommentOnClick){
        this.myCommentOnClick = myCommentOnClick;
    }
}
