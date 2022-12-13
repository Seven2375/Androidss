package com.huangxue.s01.Adatper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.huangxue.s01.R;

import java.util.List;

public class MyPagerAdatper extends PagerAdapter {

    private Context mContext;
    private List<View> mViewList;

    public MyPagerAdatper(List<View> viewList,Context mContext) {
        this.mViewList = viewList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mViewList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        container.addView(mViewList.get(position),0);

        return mViewList.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(mViewList.get(position));
    }
}
