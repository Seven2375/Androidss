package com.huangxue.s01.Activity.Subway;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.SubwayListAdapter;
import com.huangxue.s01.Beans.SubwayListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

public class SubwayHomeActivity extends AppCompatActivity {

    private RecyclerView rv;
    private String currentName = "建国门";
    private List<SubwayListBean.DataEntity> data;
    private TextView location;
    private LinearLayout map;
    private LinearLayout locationBtn;
    private SubwayListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway_home);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("地铁路线");
        toolbar.setNavigationOnClickListener(view -> finish());


        initView();
        new Thread(this::initHttp).start();
    }

    private void initHttp() {
        Gson gson = new Gson();
        String body = WorkOkHttp.get("/prod-api/api/metro/list?currentName=" + currentName);
        data = gson.fromJson(body, SubwayListBean.class).getData();

        runOnUiThread(()->{
            initData();
            initSubwayList();
        });

    }
    private void initData(){
        location.setText(currentName);
    }
    private void initSubwayList() {
        adapter = new SubwayListAdapter(data, this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        adapter.setMyOnClick(data1 -> {
            Intent intent = new Intent(this, SubwayInfoActivity.class);
            intent.putExtra("id",data1.getLineId());
            intent.putExtra("lineName",data1.getCurrentName());
            intent.putExtra("time",data1.getReachTime());
            startActivity(intent);
        });
    }

    private void initView() {
        rv = findViewById(R.id.subway_home_rv);
        location = findViewById(R.id.subway_home_location);
        map = findViewById(R.id.subway_home_map);
        map.setOnClickListener(v->{
            startActivity(new Intent(this,SubwayMapActivity.class));
        });
        locationBtn = findViewById(R.id.subway_home_location_btn);
        locationBtn.setOnClickListener(v->{
            Intent intent = new Intent(this, SubwayAllStationListActivity.class);
//            startActivity(intent);
            startActivityForResult(intent, 0);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==0&&resultCode== Activity.RESULT_OK){
            Bundle bundle = data.getExtras();
            currentName = bundle.getString("stationName");
            new Thread(this::initHttp).start();
        }
    }
}