package com.huangxue.s01;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.LookRoomListAdapter;
import com.huangxue.s01.Beans.LookRoomListBean;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.IOException;
import java.util.List;

public class LookRoomHomeActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, LookRoomListAdapter.MyOnClick {

    private RadioGroup rg;
    private List<LookRoomListBean.RowsEntity> rows;
    private RecyclerView rv;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_room_home);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("找房子");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();
    }

    private void initHttp(String type){
            String body = WorkOkHttp.get("/prod-api/api/house/housing/list?" + "houseType=" + type);
            Gson gson = new Gson();
            rows = gson.fromJson(body, LookRoomListBean.class).getRows();
            runOnUiThread(()-> {
                LookRoomListAdapter adapter = new LookRoomListAdapter(rows, this);
                rv.setLayoutManager(new LinearLayoutManager(this));
                rv.setAdapter(adapter);
                adapter.setMyOnClick(this);
                pb.setVisibility(View.GONE);
            });

    }

    private void initView() {
        rv = findViewById(R.id.look_room_rv);
        rg = findViewById(R.id.look_room_rg);
        pb = findViewById(R.id.look_room_pb);
        rg.setOnCheckedChangeListener(this);
        RadioButton rb1 = findViewById(R.id.look_room_rb1);
        rb1.setChecked(true);
    }

    private void initPB(){
        runOnUiThread(()->{
            pb.setVisibility(View.VISIBLE);
        });
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        new Thread(()->{
            switch (i){
                case R.id.look_room_rb1:
                    initPB();
                    initHttp("楼盘");
                    break;
                case R.id.look_room_rb2:
                    initPB();
                    initHttp("租房");
                    break;
                case R.id.look_room_rb3:
                    initPB();
                    initHttp("二手");
                    break;
                case R.id.look_room_rb4:
                    initPB();
                    initHttp("中介");
                    break;
            }}).start();

    }

    @Override
    public void onClick(int position) {
        int id = rows.get(position).getId();
        Intent intent = new Intent(this,LookRoomInfoActivity.class);
        intent.putExtra("id",id);
        startActivity(intent);
    }
}