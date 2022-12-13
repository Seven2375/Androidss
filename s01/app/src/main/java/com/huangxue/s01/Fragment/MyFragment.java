package com.huangxue.s01.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.R;
import com.huangxue.s01.UserInfoActivity;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MyFragment extends Fragment {

    protected View mView;
    private String name;
    private String avatar_url;
    private String Url = "http://124.93.196.45:10001";
    private TextView tv_name;
    private ImageView img_avatar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_my,container,false);

        initUI();

        new Thread(()->{try {
            initHttp();
        } catch (IOException e) {
            e.printStackTrace();
        }}).start();

        return mView;

    }

    private void initUI() {
        tv_name = mView.findViewById(R.id.my_tv_name);
        img_avatar = mView.findViewById(R.id.my_img_avatar);
        mView.findViewById(R.id.my_btn_info).setOnClickListener(v->{
            startActivity(new Intent(getActivity(), UserInfoActivity.class));
        });
    }

    private void initHttp() throws IOException {

        SharedPreferences sp = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE);
        String token = sp.getString("token", "");
        Request request = new Request.Builder()
                .header("Authorization",token)
                .url("http://124.93.196.45:10001/prod-api/api/common/user/getInfo").build();
        OkHttpClient okHttpClient = new OkHttpClient();
        String string = okHttpClient.newCall(request).execute().body().string();
        JsonObject asJsonObject = new JsonParser().parse(string).getAsJsonObject();
        name = asJsonObject.get("user").getAsJsonObject().get("nickName").getAsString();
        avatar_url = asJsonObject.get("user").getAsJsonObject().get("avatar").getAsString();
        getActivity().runOnUiThread(()->{
            tv_name.setText(name);
            Glide.with(getActivity()).load(avatar_url).into(img_avatar);
        });
    }
}
