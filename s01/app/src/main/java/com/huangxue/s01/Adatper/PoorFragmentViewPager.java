package com.huangxue.s01.Adatper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

public class PoorFragmentViewPager extends FragmentPagerAdapter {

    private List<Fragment> fragmentList;
    private List<String> titleList;

    public PoorFragmentViewPager(@NonNull FragmentManager fm,List<Fragment> fragmentList,List<String> titleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}
