package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.huangxue.s01.Adatper.BusLineListAdapter;
import com.huangxue.s01.Beans.BusLineListBean;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BusHomeActivity extends AppCompatActivity {

    private ExpandableListView expandableListView;
    private List<BusLineListBean.RowsEntity> partentRows;
    private List<List<String>> childNameList;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_home);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("智慧巴士");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();
        new Thread(()->{
            initHttp();
        }).start();


    }

    private void initHttp() {
        String body = WorkOkHttp.get("/prod-api/api/bus/line/list");
        Gson gson = new Gson();
        partentRows = gson.fromJson(body, BusLineListBean.class).getRows();

        childNameList = new ArrayList<>();
        for (int i = 0; i < partentRows.size(); i++) {
            String partentBody = WorkOkHttp.get("/prod-api/api/bus/stop/list?linesId="+partentRows.get(i).getId());
            JsonArray jsonArray = new JsonParser().parse(partentBody).getAsJsonObject().get("rows").getAsJsonArray();
            List<String> kkk = new ArrayList<>();
            for (int j = 0; j < jsonArray.size(); j++){
                kkk.add(jsonArray.get(j).getAsJsonObject().get("name").getAsString());
            }
            childNameList.add(kkk);
        }
        runOnUiThread(()->{
            initExList();
        });
    }

    private void initExList() {
        BusLineListAdapter adapter = new BusLineListAdapter(this, partentRows, childNameList);
        expandableListView.setAdapter(adapter);
        expandableListView.setDividerHeight(10);
        pb.setVisibility(View.GONE);
        adapter.setMyOnClick(i->{
            Intent intent = new Intent(this, BusInfoActivity.class);
            intent.putExtra("id", partentRows.get(i).getId());
            startActivity(intent);
            Log.d("TAG", "getGroupView: "+partentRows.get(i).getId());
        });
    }

    private void initView() {
        expandableListView = findViewById(R.id.bus_home_list);
        pb = findViewById(R.id.item_progress);
    }
}