package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.huangxue.s01.Beans.NewsListBean;
import com.huangxue.s01.R;

import java.util.List;

public class MyHomeListAdapter extends RecyclerView.Adapter<MyHomeListAdapter.MyHolder> {

    private Context mContext;
    private List<NewsListBean.RowsEntity> datalist;

    public MyHomeListAdapter(Context mContext, List<NewsListBean.RowsEntity> datalist) {
        this.mContext = mContext;
        this.datalist = datalist;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.item_home_list, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String Url = "http://124.93.196.45:10001";
        NewsListBean.RowsEntity data = datalist.get(position);
        Glide.with(mContext).load(Url+data.getCover()).into(holder.img);
        holder.title.setText(data.getTitle());
        holder.content.setText(data.getContent());
        holder.commentNum.setText("评论："+data.getCommentNum());
        holder.publishDate.setText("时间："+data.getPublishDate());
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

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.home_list_item_img);
            title = itemView.findViewById(R.id.home_list_item_title);
            content = itemView.findViewById(R.id.home_list_item_content);
            commentNum = itemView.findViewById(R.id.home_list_item_commentNum);
            publishDate = itemView.findViewById(R.id.home_list_item_publishDate);

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
