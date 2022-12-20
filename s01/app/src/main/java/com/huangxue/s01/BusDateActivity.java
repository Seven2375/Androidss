package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class BusDateActivity extends AppCompatActivity {

    private TextView tvDate;
    private DatePicker dp;
    private Button btn;
    private int price;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_date);
        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("班车定制");
        toolbar.setNavigationOnClickListener(view -> finish());
        price = getIntent().getIntExtra("price", 2);
        path = getIntent().getStringExtra("path");

        initView();

    }

    private void initView() {
        tvDate = findViewById(R.id.bus_date_tvDate);
        dp = findViewById(R.id.bus_date_datePicker);
        btn = findViewById(R.id.bus_date_btn_skip);
        dp.init(2021, 9, 21, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                tvDate.setText(""+i+"-"+(i1+1)+"-"+i2);
            }
        });
        btn.setOnClickListener(v->{
            Intent intent = new Intent(this, BusUserActivity.class);
            intent.putExtra("date",tvDate.getText().toString());
            intent.putExtra("price",price);
            intent.putExtra("path",path);
            startActivity(intent);
        });
    }
}