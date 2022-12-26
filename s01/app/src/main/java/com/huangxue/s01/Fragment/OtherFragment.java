package com.huangxue.s01.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.huangxue.s01.A0Test.A0TESTActivity;
import com.huangxue.s01.AidThePoorActivity;
import com.huangxue.s01.CityAnalyseActivity;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

public class OtherFragment extends Fragment {
    private String 错误 = "<title>502 错误 - phpstudy</title>";
    private View inflateView;
    private Button data1;
    private Button data2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        inflateView = inflater.inflate(R.layout.fragment_other, container, false);

        Toolbar toolbar = inflateView.findViewById(R.id.toolbar_noback);
        toolbar.setTitle("其它");

        initView();

        new Thread(()->{
            String s = WorkOkHttp.get("/prod-api/press/category/list");
            if (s.contains(错误)){
                getActivity().runOnUiThread(()->{
                    Toast.makeText(getActivity(), "网络崩溃！", Toast.LENGTH_LONG).show();
                    data1.setEnabled(false);
                    data2.setEnabled(false);
                    initData();
                });
            }else{
                initData();
            }
        }).start();

        return inflateView;
    }

    private void initData() {
        //数据分析1
        data1.setOnClickListener(v->{
            startActivity(new Intent(getActivity(), CityAnalyseActivity.class));
        });
        //精准扶贫
        inflateView.findViewById(R.id.other_aidThePoor).setOnClickListener(v->{
            startActivity(new Intent(getActivity(), AidThePoorActivity.class));
        });
        //功能测试
        inflateView.findViewById(R.id.other_btn_test).setOnClickListener(v->{
            startActivity(new Intent(getActivity(), A0TESTActivity.class));
        });
    }

    private void initView() {
        data1 = inflateView.findViewById(R.id.other_btn_data1);
        data2 = inflateView.findViewById(R.id.other_btn_data2);
    }
}
