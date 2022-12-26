package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.huangxue.s01.Beans.NewsListBean;
import com.huangxue.s01.R;

import java.util.ArrayList;
import java.util.List;

public class MyNewsListAdapter extends RecyclerView.Adapter<MyNewsListAdapter.MyHolder> implements Filterable {

    private Context mContext;
    private List<NewsListBean.RowsEntity> filterList;
    private List<NewsListBean.RowsEntity> originList;
    private NewsListBean.RowsEntity data;
    private int size;

    public MyNewsListAdapter(Context mContext, List<NewsListBean.RowsEntity> filterList) {
        this.mContext = mContext;
        this.filterList = filterList;
        this.originList = filterList;
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
        data = filterList.get(position);
        Glide.with(mContext)
                .load(Url+ data.getCover())
                .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                .into(holder.img);
        holder.title.setText(data.getTitle());
        holder.content.setText(data.getContent());
        holder.commentNum.setText("评论："+ data.getCommentNum());
        holder.publishDate.setText(""+ data.getPublishDate());
        holder.likeNum.setText("点赞："+ data.getLikeNum());
        holder.readNum.setText("观看："+ data.getReadNum());
    }

    @Override
    public int getItemCount() {
        return filterList.size();
    }

    public int getSize(){
        return size;
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()){
                    filterList = originList;
                }else {
                    List<NewsListBean.RowsEntity> filteredList = new ArrayList<>();
                    for (NewsListBean.RowsEntity kkk : originList) {
                        if (kkk.getTitle().contains(charString)){
                            filteredList.add(kkk);
                        }
                    }
                    filterList = filteredList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filterList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterList = (List<NewsListBean.RowsEntity>) filterResults.values;
                size = filterList.size();
                notifyDataSetChanged();
            }
        };
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
                        mOnItemClickListener.onClick(getAdapterPosition(),filterList.get(getAdapterPosition()));
                    }
                }
            });
        }
    }
    //定义一个点击的接口
    public interface OnRecyclerItemClickListener{
        void onClick(int position,NewsListBean.RowsEntity data);
    }
    //创建接口对象
    private OnRecyclerItemClickListener mOnItemClickListener;
    //设置监听事件方法
    public void setOnItemClickListener(OnRecyclerItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }

}
