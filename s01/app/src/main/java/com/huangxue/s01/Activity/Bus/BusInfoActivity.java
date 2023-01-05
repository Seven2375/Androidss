package com.huangxue.s01.Activity.Bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huangxue.s01.Beans.BusInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

public class BusInfoActivity extends AppCompatActivity {

    private int id;
    private TextView lineName;
    private TextView staName;
    private TextView endName;
    private TextView mileage;
    private TextView price;
    private TextView staTime;
    private TextView endTime;
    private Button btn;
    private BusInfoBean.DataEntity data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_info);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("班车定制");
        toolbar.setNavigationOnClickListener(v->finish());

        id = getIntent().getIntExtra("id", 0);
        initView();
        new Thread(()->{
            intHttp();
        }).start();

    }

    private void intHttp() {
        String body = WorkOkHttp.get("/prod-api/api/bus/line/" + id);
        Gson gson = new Gson();
        data = gson.fromJson(body, BusInfoBean.class).getData();
        runOnUiThread(()->{
            initData();
        });

    }

    private void initData() {
        lineName.setText(data.getName());
        staName.setText(data.getFirst());
        endName.setText(data.getEnd());
        price.setText("￥"+ data.getPrice());
        mileage.setText(data.getMileage()+"公里");
        staTime.setText("(首)"+ data.getStartTime());
        endTime.setText("(末)"+ data.getEndTime());
    }

    private void initView() {
        lineName = findViewById(R.id.bus_line_item_partent_name);
        staName = findViewById(R.id.bus_line_item_partent_staName);
        endName = findViewById(R.id.bus_line_item_partent_endName);
        mileage = findViewById(R.id.bus_line_item_partent_mileage);
        price = findViewById(R.id.bus_line_item_partent_price);
        staTime = findViewById(R.id.bus_line_item_partent_staTime);
        endTime = findViewById(R.id.bus_line_item_partent_endTime);
        btn = findViewById(R.id.bus_info_btn);
        btn.setOnClickListener(v->{
            Intent intent = new Intent(this, BusDateActivity.class);
            intent.putExtra("price",data.getPrice());
            intent.putExtra("path",data.getName());
            startActivity(intent);
        });
    }
}