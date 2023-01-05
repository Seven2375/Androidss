package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.huangxue.s01.Beans.HotJobBean;
import com.huangxue.s01.R;

import java.util.List;

public class HotJobTextListAdapter extends BaseAdapter {

    private List<HotJobBean> data;
    private Context mContext;

    public HotJobTextListAdapter(List<HotJobBean> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return 3;
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

        view = View.inflate(mContext, R.layout.item_text,null);
        TextView text = view.findViewById(R.id.item_text);
        text.setText(data.get(i).name);

        return view;
    }
}
