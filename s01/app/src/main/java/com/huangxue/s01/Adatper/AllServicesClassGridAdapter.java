package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.huangxue.s01.Beans.ServicesListBean;
import com.huangxue.s01.R;

import java.util.List;

public class AllServicesClassGridAdapter extends BaseAdapter {
    private List<ServicesListBean.RowsEntity> data;
    private Context mContext;

    public AllServicesClassGridAdapter(List<ServicesListBean.RowsEntity> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        String Url = "http://124.93.196.45:10001";
        ServicesListBean.RowsEntity row = data.get(i);
        MyHolder myHolder;
        if (view==null){
            view = View.inflate(mContext, R.layout.item_services_grid,null);
            myHolder = new MyHolder();
            myHolder.img = view.findViewById(R.id.home_grid_item_img);
            myHolder.title = view.findViewById(R.id.home_grid_item_desc);
            view.setTag(myHolder);
        }else {
            myHolder = (MyHolder) view.getTag();
        }

        Glide.with(mContext).load(Url+row.getImgUrl()).into(myHolder.img);
        myHolder.title.setText(row.getServiceName());

        return view;
    }
    static class MyHolder{
        private ImageView img;
        private TextView title;
    }
}
