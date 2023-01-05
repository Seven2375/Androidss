package com.huangxue.s01.Activity.Subway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.SubwayInfoTimeLineAdapter;
import com.huangxue.s01.Beans.SubwayInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

public class SubwayInfoActivity extends AppCompatActivity {

    private String lineName;
    private int id;
    private RecyclerView rv;
    private SubwayInfoBean.DataEntity lineInfoData;
    private List<SubwayInfoBean.DataEntity.MetroStepListEntity> metroStepList;
    private TextView time;
    private TextView firstName;
    private TextView endName;
    private int reachTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway_info);

        id = getIntent().getIntExtra("id", 0);
        lineName = getIntent().getStringExtra("lineName");
        reachTime = getIntent().getIntExtra("time",0);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle(lineName);
        toolbar.setNavigationOnClickListener(view -> finish());

        initView();
        new Thread(this::initHttp).start();
    }

    private void initHttp() {
        Gson gson = new Gson();
        String lineInfoBody = WorkOkHttp.get("/prod-api/api/metro/line/" + id);
        lineInfoData = gson.fromJson(lineInfoBody, SubwayInfoBean.class).getData();
        metroStepList = lineInfoData.getMetroStepList();

        runOnUiThread(()->{
            initInfo();
            initTimeLine();
        });

    }

    private void initInfo() {
        time.setText("距离你还有"+reachTime+"分钟");
        firstName.setText("始发站："+lineInfoData.getFirst());
        endName.setText("终点站："+lineInfoData.getEnd());
    }

    private void initTimeLine() {
        SubwayInfoTimeLineAdapter adapter = new SubwayInfoTimeLineAdapter(metroStepList, this,lineName);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        gridLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(gridLayoutManager);
        rv.setAdapter(adapter);
    }

    private void initView() {
        rv = findViewById(R.id.subway_info_rv);
        time = findViewById(R.id.subway_info_time);
        firstName = findViewById(R.id.subway_info_firstName);
        endName = findViewById(R.id.subway_info_endName);
    }
}