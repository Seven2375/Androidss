package com.huangxue.s01.Fragment.Lawyer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.huangxue.s01.Beans.LawyerUserEvaluateListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

public class LawyerUserEvaluateFragment extends Fragment {

    private View mView;
    private RecyclerView rv;
    private int id;
    private String token;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getInt("id");
        token = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE).getString("token", "");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_lawyer_user_evaluate, container, false);

        initView();
        
        new Thread(()->{
            initHttp();
        }).start();

        return mView;
    }

    private void initHttp() {
        Gson gson = new Gson();
        String body = WorkOkHttp.get("/prod-api/api/lawyer-consultation/lawyer/list-evaluate?lawyerId=" + id, token);

        gson.fromJson(body, LawyerUserEvaluateListBean.class);

    }

    private void initView() {
        rv = mView.findViewById(R.id.lawyer_user_evaluate_rv);
    }
}
