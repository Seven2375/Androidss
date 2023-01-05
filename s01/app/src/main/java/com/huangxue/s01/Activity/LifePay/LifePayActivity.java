package com.huangxue.s01.Activity.LifePay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.PayClassListAdapter;
import com.huangxue.s01.Beans.PayClassListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

public class LifePayActivity extends AppCompatActivity {

    private List<PayClassListBean.DataEntity> data;
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_pay);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("生活缴费");
        toolbar.setNavigationOnClickListener(v->finish());

        rv = findViewById(R.id.life_pay_home_rv);
        new Thread(()->{
            initHttp();
        }).start();


    }

    private void initHttp() {
        String body = WorkOkHttp.get("/prod-api/api/living/category/list");
        Gson gson = new Gson();
        data = gson.fromJson(body, PayClassListBean.class).getData();
        runOnUiThread(()->{
            initList();
        });
    }

    private void initList() {
        PayClassListAdapter adapter = new PayClassListAdapter(data, this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        adapter.setMyOnClick(name -> {
            switch (name){
                case "手机话费":
                    startActivity(new Intent(this, PhoneBillHomeActivity.class));
                    break;
            }
        });
    }
}