package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.MyStopListAdapter;
import com.huangxue.s01.Beans.StopListBean;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.IOException;
import java.util.List;

public class StopListActivity extends AppCompatActivity implements MyStopListAdapter.onMyClickListener {

    private RecyclerView stop_recyclerview;
    private List<StopListBean.RowsEntity> rows;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_list);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("附近停车场");
        toolbar.setNavigationOnClickListener(v->finish());

        new Thread(()->{try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }}).start();

    }

    private void init() throws IOException {

        String body = WorkOkHttp.get("/prod-api/api/park/lot/list");
        Gson gson = new Gson();
        rows = gson.fromJson(body, StopListBean.class).getRows();
        runOnUiThread(()->{
            initList(0);
        });
        btn = findViewById(R.id.stop_list_btn);
                btn.setOnClickListener(v->{
            runOnUiThread(()->{
                initList(1);
                btn.setVisibility(View.GONE);
            });
        });
    }

    private void initList(int id) {
        stop_recyclerview = findViewById(R.id.stop_list_recyclerview);
        MyStopListAdapter adapter = new MyStopListAdapter(this, rows,id);
        stop_recyclerview.setLayoutManager(new StaggeredGridLayoutManager(1, LinearLayout.VERTICAL));
        stop_recyclerview.setAdapter(adapter);
        adapter.setMyOnClickListener(this);
    }

    @Override
    public void mOnClick(View view,int position) {
        switch (view.getId()){
            case R.id.stop_list_item_ll:
                int id = rows.get(position).getId();
                Intent intent1 = new Intent(this, StopInfoActivity.class);
                intent1.putExtra("id",id);
                startActivity(intent1);
                Log.e("wwwwwwwwwwwwwww",""+position);
                break;
            case R.id.stop_list_item_rl:
                String parkName = rows.get(position).getParkName();
                Intent intent2 = new Intent(this,StopRecordActivity.class);
                intent2.putExtra("name",parkName);
                Log.e("TAG", "mOnClick: "+parkName );
                startActivity(intent2);
                break;
        }

    }
}