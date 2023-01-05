package com.huangxue.s01.Activity.LifePay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.huangxue.s01.R;

public class PhonePayActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvPhone;
    private TextView r20;
    private TextView r50;
    private TextView r100;
    private TextView r200;
    private String r = null;
    private TextView tv;
    private String phone;
    private String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_pay);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("缴费");
        toolbar.setNavigationOnClickListener(v->finish());

        phone = getIntent().getStringExtra("phone");
        operator = getIntent().getStringExtra("operator");

        initView();

    }

    private void initView() {
        tv = findViewById(R.id.phone_pay_yuan);
        tvPhone = findViewById(R.id.phone_pay_phone);
        tvPhone.setText(phone);
        r20 = findViewById(R.id.phone_pay_20);
        r20.setOnClickListener(this);
        r50 = findViewById(R.id.phone_pay_50);
        r50.setOnClickListener(this);
        r100 = findViewById(R.id.phone_pay_100);
        r100.setOnClickListener(this);
        r200 = findViewById(R.id.phone_pay_200);
        r200.setOnClickListener(this);
        findViewById(R.id.phone_pay_200).setOnClickListener(this);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.phone_pay_20:
                tv.setText("20闷");
                break;
            case R.id.phone_pay_50:
                tv.setText("50闷");
                break;
            case R.id.phone_pay_100:
                tv.setText("100闷");
                break;
            case R.id.phone_pay_200:
                tv.setText("200闷");
                break;
        }
    }
}