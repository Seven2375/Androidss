package com.huangxue.s01.Fragment.Lawyer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.gson.Gson;
import com.huangxue.s01.Beans.LawyerInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class LawyerServicesModeFragment extends Fragment {


    private int id;
    private View mView;
    private ImageView img;
    private TextView name;
    private TextView eduInfo;
    private TextView expertise;
    private TextView licenseNo;
    private TextView desc;
    private TextView workYear;
    private ImageView infoImg;
    private LawyerInfoBean.DataEntity data;
    private String token;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getArguments().getInt("id", 0);
        token = getActivity().getSharedPreferences("token", Context.MODE_PRIVATE).getString("token", "");
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.fragment_lawyer_services_mode, container, false);

        initView();

        new Thread(()->{
            initHttp();
        }).start();

        return mView;
    }

    private void initHttp() {
        Gson gson = new Gson();
        String body = WorkOkHttp.get("/prod-api/api/lawyer-consultation/lawyer/" + id,token);

        data = gson.fromJson(body, LawyerInfoBean.class).getData();

        getActivity().runOnUiThread(()->{
            initData();
        });

    }

    private void initData() {
        name.setText(data.getName());
        eduInfo.setText("教育背景："+data.getEduInfo());
        expertise.setText("专长："+data.getLegalExpertiseName());
        licenseNo.setText("持证号"+data.getLicenseNo());
        desc.setText("简介：\n"+data.getBaseInfo());

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate startTime = LocalDate.parse(data.getWorkStartAt());
        LocalDate endTime = LocalDate.parse(simpleDateFormat.format(date));

        Period period = Period.between(startTime, endTime);

        workYear.setText("工作年限："+period.getYears()+"年");

        String s = data.getCertificateImgUrl();
        String originUrl = s.replace("dev","prod");

        Tools.setImg(getActivity(),data.getAvatarUrl(),img);
        Tools.setImg(getActivity(),originUrl,infoImg);
    }

    private void initView() {
        img = mView.findViewById(R.id.lawyer_service_img);
        name = mView.findViewById(R.id.lawyer_service_name);
        eduInfo = mView.findViewById(R.id.lawyer_service_eduInfo);
        expertise = mView.findViewById(R.id.lawyer_service_expertise);
        licenseNo = mView.findViewById(R.id.lawyer_service_licenseNo);
        desc = mView.findViewById(R.id.lawyer_service_desc);
        workYear = mView.findViewById(R.id.lawyer_service_workYear);
        infoImg = mView.findViewById(R.id.lawyer_service_infoImg);
    }
}
