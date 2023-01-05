package com.huangxue.s01.Activity.Bus;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.BusOrderListAdapter;
import com.huangxue.s01.Beans.BusOrderBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

public class BusOrderActivity extends AppCompatActivity {

    private RecyclerView rv;
    private String token;
    private List<BusOrderBean.RowsEntity> rows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_order);

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("巴士订单");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();
        new Thread(()->{
            initHttp();
        }).start();

    }

    private void initHttp() {
        String body = WorkOkHttp.get("/prod-api/api/bus/order/list", token);
        Gson gson = new Gson();
        rows = gson.fromJson(body, BusOrderBean.class).getRows();
        runOnUiThread(()->{
            initListView();
        });

    }

    private void initListView() {
        BusOrderListAdapter adapter = new BusOrderListAdapter(rows, this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    private void initView() {
        rv = findViewById(R.id.bus_order_list);
    }
}