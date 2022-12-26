package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

public class MyOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("我的订单");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();

    }

    private void initView() {
        findViewById(R.id.my_order_bus).setOnClickListener(v->{
            startActivity(new Intent(this,BusOrderActivity.class));
        });
    }
}