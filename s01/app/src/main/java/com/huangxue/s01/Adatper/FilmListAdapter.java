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
import com.huangxue.s01.Beans.FilmListBean;
import com.huangxue.s01.R;

import java.util.ArrayList;
import java.util.List;

public class FilmListAdapter extends RecyclerView.Adapter<FilmListAdapter.MyHolder> implements Filterable {

    private List<FilmListBean.RowsEntity> filterRows;
    private List<FilmListBean.RowsEntity> originRows;
    private Context mContext;
    private FilmListBean.RowsEntity data;

    public FilmListAdapter(List<FilmListBean.RowsEntity> filterRows, Context mContext) {
        this.filterRows = filterRows;
        this.originRows = filterRows;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyHolder(View.inflate(mContext, R.layout.item_film_list,null));
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        String Url = "http://124.93.196.45:10001";
        data = filterRows.get(position);
        if (data.getName().equals("变形金刚")){
            Glide.with(mContext)
                    .load("https://img0.baidu.com/it/u=1654306224,2099182564&fm=253&fmt=auto&app=138&f=JPEG?w=800&h=500")
                    .into(holder.img);
        }else{
            Glide.with(mContext)
                    .load(Url+ data.getCover())
                    .into(holder.img);
        }
        holder.title.setText(data.getName());
        holder.desc.setText("简介：\n"+ data.getIntroduction());
        holder.dete.setText(""+ data.getPlayDate());
        holder.duration.setText("时长："+ data.getDuration());
        holder.score.setText("评分："+ data.getScore()+"星");
        holder.language.setText("语言"+ data.getLanguage());
    }

    @Override
    public int getItemCount() {
        return filterRows.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                String charString = charSequence.toString();
                if (charString.isEmpty()){
                    filterRows = originRows;
                }else {
                    List<FilmListBean.RowsEntity> filteredRows = new ArrayList<>();
                    for (FilmListBean.RowsEntity rowsList : originRows) {
                        if (rowsList.getIntroduction().contains(charString)||rowsList.getName().contains(charString)){
                            filteredRows.add(rowsList);
                        }
                    }
                    filterRows = filteredRows;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filterRows;

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                filterRows = (List<FilmListBean.RowsEntity>) filterResults.values;
                notifyDataSetChanged();
            }
        };
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private ImageView img;
        private TextView title;
        private TextView desc;
        private TextView dete;
        private TextView duration;
        private TextView score;
        private TextView language;

        public MyHolder(@NonNull View itemView) {
            super(itemView);

            img = itemView.findViewById(R.id.film_list_item_img);
            title = itemView.findViewById(R.id.film_list_item_title);
            desc = itemView.findViewById(R.id.film_list_item_desc);
            dete = itemView.findViewById(R.id.film_list_item_date);
            duration = itemView.findViewById(R.id.film_list_item_duration);
            score = itemView.findViewById(R.id.film_list_item_score);
            language = itemView.findViewById(R.id.film_list_item_language);

            itemView.setOnClickListener(v->{
                if (myOnClick!=null){
                    myOnClick.onClick(getAdapterPosition(),filterRows.get(getAdapterPosition()));
                }
            });

        }
    }
    public interface MyOnClick{
        void onClick(int position,FilmListBean.RowsEntity data);
    }
    private MyOnClick myOnClick;
    public void setMyOnClick(MyOnClick myOnClick){
        this.myOnClick = myOnClick;
    }
}
