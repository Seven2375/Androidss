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
import com.huangxue.s01.Beans.NewsListBean;
import com.huangxue.s01.R;

import java.util.List;

public class MyNewsListAdapter extends RecyclerView.Adapter<MyNewsListAdapter.MyHolder> {

    private Context mContext;
    private List<NewsListBean.RowsEntity> datalist;

    public MyNewsListAdapter(Context mContext, List<NewsListBean.RowsEntity> datalist) {
        this.mContext = mContext;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_news_list, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String Url = "http://124.93.196.45:10001";
        NewsListBean.RowsEntity data = datalist.get(position);
        Glide.with(mContext)
                .load(Url+data.getCover())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.img);
        holder.title.setText(data.getTitle());
        holder.content.setText(data.getContent());
        holder.commentNum.setText("评论："+data.getCommentNum());
        holder.publishDate.setText(""+data.getPublishDate());
        holder.likeNum.setText("点赞："+data.getLikeNum());
        holder.readNum.setText("观看："+data.getReadNum());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder{
        private ImageView img;
        private TextView title;
        private TextView content;
        private TextView commentNum;
        private TextView publishDate;
        private TextView likeNum;
        private TextView readNum;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.news_list_item_img);
            title = itemView.findViewById(R.id.news_list_item_title);
            content = itemView.findViewById(R.id.news_list_item_content);
            commentNum = itemView.findViewById(R.id.news_list_item_commentNum);
            publishDate = itemView.findViewById(R.id.news_list_item_publishDate);
            likeNum = itemView.findViewById(R.id.news_list_item_likeNum);
            readNum = itemView.findViewById(R.id.news_list_item_readNum);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null){
                        mOnItemClickListener.onClick(getAdapterPosition());
                    }
                }
            });
        }
    }
    //定义一个点击的接口
    public interface OnRecyclerItemClickListener{
        void onClick(int position);
    }
    //创建接口对象
    private OnRecyclerItemClickListener mOnItemClickListener;
    //设置监听事件方法
    public void setOnItemClickListener(OnRecyclerItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

}
