package com.huangxue.s01.Fragment.LookJob;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.huangxue.s01.Activity.LookJob.AddResumeActivity;
import com.huangxue.s01.Activity.LookJob.QueryResumeActivity;
import com.huangxue.s01.R;
import com.huangxue.s01.Activity.LookJob.UpdateResumeActivity;

public class LookJob03Fragment extends Fragment {

    private View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_look_job_03, container,false);

        initView();

        return mView;
    }

    private void initView() {
        mView.findViewById(R.id.look_job_fragment03_btn1).setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), QueryResumeActivity.class));
        });
        mView.findViewById(R.id.look_job_fragment03_btn2).setOnClickListener(view -> {
             startActivity(new Intent(getActivity(), AddResumeActivity.class));
        });
        mView.findViewById(R.id.look_job_fragment03_btn3).setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), UpdateResumeActivity.class));
        });
    }


}
