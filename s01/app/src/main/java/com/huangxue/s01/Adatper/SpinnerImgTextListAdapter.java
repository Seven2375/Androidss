package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.huangxue.s01.Beans.LawyerExpertiseListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;

import java.util.List;

public class SpinnerImgTextListAdapter extends BaseAdapter {

    private List<LawyerExpertiseListBean.RowsEntity> dataList;
    private Context mContext;

    public SpinnerImgTextListAdapter(List<LawyerExpertiseListBean.RowsEntity> dataList, Context mContext) {
        this.dataList = dataList;
        this.mContext = mContext;
    }


    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int i) {
        return dataList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = View.inflate(mContext, R.layout.item_spinner_list, null);

        LawyerExpertiseListBean.RowsEntity data = dataList.get(i);
        ImageView img = view.findViewById(R.id.spinner_item_img);
        TextView title = view.findViewById(R.id.spinner_item_title);

        Tools.setImg(mContext,data.getImgUrl(),img);
        title.setText(data.getName());

        return view;
    }
}
