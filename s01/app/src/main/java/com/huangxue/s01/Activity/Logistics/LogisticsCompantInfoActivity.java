package com.huangxue.s01.Activity.Logistics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huangxue.s01.Beans.LogisticsCompanyInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;

public class LogisticsCompantInfoActivity extends AppCompatActivity {

    private ImageView img;
    private TextView desc;
    private TextView way;
    private String name;
    private int id;
    private LogisticsCompanyInfoBean.DataEntity data;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logistics_compant_info);

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        id = getIntent().getIntExtra("id", 0);
        name = getIntent().getStringExtra("name");

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle(name);
        toolbar.setNavigationOnClickListener(v->finish());


        initView();
        new Thread(this::initHttp).start();
    }

    private void initHttp() {
        Gson gson = new Gson();
        String body = WorkOkHttp.get("/prod-api/api/logistics-inquiry/logistics_company/" + id,token);
        Log.e("TAG", "initHttp: "+body);
        data = gson.fromJson(body, LogisticsCompanyInfoBean.class).getData();
        runOnUiThread(this::initData);
    }

    private void initData() {
        Tools.setImg(this,data.getImgUrl(),img);
        desc.setText("简介:\n\n"+data.getIntroduce());
        way.setText("运输方式：\n"+data.getShippingMethod());
    }

    private void initView() {
        img = findViewById(R.id.logistics_company_info_img);
        desc = findViewById(R.id.logistics_company_info_desc);
        way = findViewById(R.id.logistics_company_info_way);
    }
}