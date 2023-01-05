package com.huangxue.s01.Activity.PetHospotal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.Adatper.AskInfoListAdapter;
import com.huangxue.s01.Beans.MyAskInfoListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import okhttp3.MediaType;

public class AskInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private String numberNo;
    private String jobName;
    private String name;
    private String imgUrl;
    private int id;
    private String token;
    private ImageView img;
    private TextView tvName;
    private TextView tvJobName;
    private TextView tvDesc;
    private TextView tvNumberNo;
    private RecyclerView rv;
    private EditText edit;
    private Button btn;
    private String desc;
    private List<MyAskInfoListBean.RowsEntity> askListData;
    private List<String> msg;
    private AskInfoListAdapter adapter;
    private String avatarUrl;
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_ask_info);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("问诊详情");
        toolbar.setNavigationOnClickListener(v->finish());

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        id = getIntent().getIntExtra("id", 0);
        imgUrl = getIntent().getStringExtra("imgUrl");
        name = getIntent().getStringExtra("name");
        jobName = getIntent().getStringExtra("jobName");
        numberNo = getIntent().getStringExtra("numberNo");
        desc = getIntent().getStringExtra("desc");

        initView();
        initDoctorInfo();
        new Thread(this::initHttp).start();
    }

    private void initHttp() {
        Gson gson = new Gson();
        String body = WorkOkHttp.get("/prod-api/api/pet-hospital/inquiry-message/list?inquiryId=" + id,token);
        String info = WorkOkHttp.get("/prod-api/api/common/user/getInfo", token);

        avatarUrl = new JsonParser().parse(info).getAsJsonObject().get("user").getAsJsonObject().get("avatar").getAsString();

        askListData = gson.fromJson(body, MyAskInfoListBean.class).getRows();
        msg = new ArrayList<>();
        for (MyAskInfoListBean.RowsEntity data : askListData) {
            msg.add(data.getContent());
        }
        runOnUiThread(()->{
            initAskList();
            pb.setVisibility(View.GONE);
        });


    }

    private void initAskList() {
        Collections.reverse(msg);
        adapter = new AskInfoListAdapter(msg, this,avatarUrl);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
        rv.scrollToPosition(msg.size()-1);

    }

    private void initDoctorInfo() {
        Tools.setImg(this,imgUrl,img);
        tvName.setText(name);
        tvJobName.setText("职称"+jobName);
        tvDesc.setText("描述："+desc);
        tvNumberNo.setText("编号："+numberNo);
    }

    private void initView() {
        pb = findViewById(R.id.my_ask_info_pb);
        img = findViewById(R.id.my_ask_info_img);
        tvName = findViewById(R.id.my_ask_info_name);
        tvJobName = findViewById(R.id.my_ask_info_jobName);
        tvDesc = findViewById(R.id.my_ask_info_desc);
        tvNumberNo = findViewById(R.id.my_ask_info_numberNo);
        rv = findViewById(R.id.my_ask_info_recordRv);
        edit = findViewById(R.id.my_ask_info_edit);
        btn = findViewById(R.id.my_ask_info_btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new Thread(()->{
            String etMsg = edit.getText().toString();
            if (!etMsg.isEmpty()){
                JsonObject jsonObject = new JsonObject();
                jsonObject.addProperty("inquiryId",id);
                jsonObject.addProperty("content",etMsg);
                MediaType jsonType = MediaType.get("application/json;charset=utf-8");
                String body = WorkOkHttp.post("/prod-api/api/pet-hospital/inquiry-message", jsonObject, jsonType, token);
                int code = new JsonParser().parse(body).getAsJsonObject().get("code").getAsInt();
                if (code==200){
                    runOnUiThread(()->{
                        msg.add(etMsg);
                        adapter.notifyItemInserted(msg.size());
                        rv.scrollToPosition(msg.size()-1);
                        edit.setText("");
                    });
                }else{
                    Log.d("wwwwwww", "onClick: "+"失败");
                }
            }
        }).start();

    }



}