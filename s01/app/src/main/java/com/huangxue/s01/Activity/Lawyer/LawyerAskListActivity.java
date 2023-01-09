package com.huangxue.s01.Activity.Lawyer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.LawyerAskListAdapter;
import com.huangxue.s01.Beans.LawyerAskListBean;
import com.huangxue.s01.Beans.LawyerInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.ArrayList;
import java.util.List;

public class LawyerAskListActivity extends AppCompatActivity {

    private RecyclerView rv;
    private String state = "0";
    private String token;
    private List<LawyerAskListBean.RowsEntity> rows;
    private List<LawyerInfoBean.DataEntity> lawyerData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_ask_list);

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("我的咨询");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();
        new Thread(()->{
            initHttp();
        }).start();
    }

    private void initHttp() {
        Gson gson = new Gson();
        String body = WorkOkHttp.get("/prod-api/api/lawyer-consultation/legal-advice/list?state=" + state,token);

        rows = gson.fromJson(body, LawyerAskListBean.class).getRows();

        lawyerData = new ArrayList<>();
        for (LawyerAskListBean.RowsEntity data : rows) {
            String s = WorkOkHttp.get("/prod-api/api/lawyer-consultation/lawyer/" + data.getLawyerId(), token);
            lawyerData.add(gson.fromJson(s,LawyerInfoBean.class).getData());
        }
        runOnUiThread(()->{
            initAskList();
        });

    }

    private void initAskList() {
        LawyerAskListAdapter adapter = new LawyerAskListAdapter(rows, lawyerData, this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
    }

    private void initView() {
        rv = findViewById(R.id.lawyerAskList_rv);
    }
}