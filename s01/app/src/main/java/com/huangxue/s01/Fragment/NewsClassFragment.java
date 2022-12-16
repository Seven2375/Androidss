package com.huangxue.s01.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.huangxue.s01.R;

public class NewsClassFragment extends Fragment {

    public static NewsClassFragment newInstance(int id) {

        Bundle args = new Bundle();
        args.putInt("id",id);
        NewsClassFragment fragment = new NewsClassFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_class_list, container, false);
        return view;
    }
}
