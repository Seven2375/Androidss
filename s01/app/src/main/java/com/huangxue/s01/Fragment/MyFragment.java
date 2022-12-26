package com.huangxue.s01.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.huangxue.s01.Beans.MyInfoBean;
import com.huangxue.s01.MyInfoActivity;
import com.huangxue.s01.MyOrderActivity;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

public class MyFragment extends Fragment {

    protected View mView;
    private TextView tv_name;
    private ImageView img_avatar;
    private String token;
    private MyInfoBean.UserEntity userData;
    private String Url = "http://124.93.196.45:10001";
    private TextView tvIdName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_my,container,false);

        Toolbar toolbar = mView.findViewById(R.id.toolbar_noback);
        toolbar.setTitle("我的");

        SharedPreferences sp = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        token = sp.getString("token", "");

        new Thread(()->{
            initIsOk();
        }).start();

        return mView;

    }

    private void initIsOk() {
        String s = WorkOkHttp.get("/prod-api/press/category/list");
        if (s.contains(错误)){
            getActivity().runOnUiThread(()->{
                Toast.makeText(getActivity(), "网络崩溃！", Toast.LENGTH_LONG).show();
            });
        }else{
            initView();
            new Thread(()->{
                initHttp();
            }).start();
        }
    }

    private void initView() {
        tv_name = mView.findViewById(R.id.my_tv_name);
        tvIdName = mView.findViewById(R.id.my_tv_idName);
        img_avatar = mView.findViewById(R.id.my_img_avatar);
        mView.findViewById(R.id.my_btn_info).setOnClickListener(v->{
            startActivity(new Intent(getActivity(), MyInfoActivity.class));
        });
        mView.findViewById(R.id.my_btn_order).setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), MyOrderActivity.class));
        });
    }

    private void initHttp(){

        String body = WorkOkHttp.get("/prod-api/api/common/user/getInfo", token);
        Gson gson = new Gson();
        MyInfoBean myInfoBean = gson.fromJson(body, MyInfoBean.class);
        int code = myInfoBean.getCode();
        userData = myInfoBean.getUser();
        if (code == 200){
            initData();
        }else{
            Toast.makeText(getActivity(), "登录异常请重新登录", Toast.LENGTH_SHORT).show();
        }
    }

    private void initData() {

        getActivity().runOnUiThread(()->{
            tv_name.setText(userData.getNickName());
            tvIdName.setText("账号："+userData.getUserName());
            Glide.with(getActivity())
                    .load(Url+userData.getAvatar())
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(20)))
                    .into(img_avatar);
        });

    }

    @Override
    public void onResume() {
        super.onResume();
        new Thread(()->{
            String s = WorkOkHttp.get("/prod-api/press/category/list");
            if (s.contains(错误)){
                getActivity().runOnUiThread(()->{
                    Toast.makeText(getActivity(), "网络崩溃！", Toast.LENGTH_LONG).show();
                });
            }else{
                new Thread(()->{
                    initHttp();
                }).start();
            }
        }).start();

    }


    private String 错误 = "<title>502 错误 - phpstudy</title>";
}
