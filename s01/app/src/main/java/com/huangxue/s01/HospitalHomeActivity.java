package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.MenuItemCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.HospitalListAdapter;
import com.huangxue.s01.Beans.HospitalListBean;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

public class HospitalHomeActivity extends AppCompatActivity {


    private RecyclerView rv;
    private List<HospitalListBean.RowsEntity> rows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospital_home);

        Toolbar toolBar = findViewById(R.id.toolbar_search);
        toolBar.setTitle("门诊预约");
        setSupportActionBar(toolBar);
        toolBar.setNavigationOnClickListener(v->finish());

        initView();
        new Thread(()->initHttp()).start();

    }

    private void initHttp() {
        String body = WorkOkHttp.get("/prod-api/api/hospital/hospital/list");
        Gson gson = new Gson();
        rows = gson.fromJson(body, HospitalListBean.class).getRows();
        runOnUiThread(()->{
            initRecyclerView();
        });

    }

    private void initRecyclerView() {
        Log.d("TAG", "initRecyclerView: ");
        HospitalListAdapter hospitalListAdapter = new HospitalListAdapter(rows, this);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL);
        rv.setLayoutManager(staggeredGridLayoutManager);
        rv.setAdapter(hospitalListAdapter);
        hospitalListAdapter.setMyOnClick(i->{
            int id = rows.get(i).getId();
            String desc = rows.get(i).getBrief();
            Intent intent = new Intent(this, HospitalInfoActivity.class);
            intent.putExtra("id",id);
            intent.putExtra("desc",desc);
            startActivity(intent);
        });
    }

    private void initView() {

        rv = findViewById(R.id.hospital_rv);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_toolbar_search,menu);
        MenuItem item = menu.findItem(R.id.toolbar_title_search);
        SearchView sv = (SearchView) MenuItemCompat.getActionView(item);
        return super.onCreateOptionsMenu(menu);
    }
}