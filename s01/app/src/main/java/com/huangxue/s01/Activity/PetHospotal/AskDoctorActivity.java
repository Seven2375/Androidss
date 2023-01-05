package com.huangxue.s01.Activity.PetHospotal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;

import okhttp3.MediaType;

public class AskDoctorActivity extends AppCompatActivity implements View.OnClickListener {

    private String numberNo;
    private String jobName;
    private String name;
    private int id;
    private String imgUrl;
    private ImageView img;
    private TextView tvName;
    private TextView tvJobName;
    private TextView tvNumberNo;
    private EditText edit;
    private Button btn;
    private String msg;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_doctor);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("问诊");
        toolbar.setNavigationOnClickListener(v->finish());

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        id = getIntent().getIntExtra("id", 0);
        name = getIntent().getStringExtra("name");
        jobName = getIntent().getStringExtra("jobName");
        numberNo = getIntent().getStringExtra("numberNo");
        imgUrl = getIntent().getStringExtra("imgUrl");

        initView();
        initDoctorData();

    }

    private void initDoctorData() {
        Tools.setImg(this,imgUrl,img);
        tvName.setText(name);
        tvJobName.setText("职称："+jobName);
        tvNumberNo.setText("执业编号："+numberNo);
    }

    private void initView() {
        img = findViewById(R.id.ask_doctor_img);
        tvName = findViewById(R.id.ask_doctor_name);
        tvJobName = findViewById(R.id.ask_doctor_jobName);
        tvNumberNo = findViewById(R.id.ask_doctor_numberNo);
        edit = findViewById(R.id.ask_doctor_edit);
        btn = findViewById(R.id.ask_doctor_btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        msg = edit.getText().toString();
        if (msg.isEmpty()){
            Toast.makeText(this, "请输入你的问题", Toast.LENGTH_SHORT).show();
        }else {
            new Thread(this::initSendMsg).start();
        }
    }

    private void initSendMsg() {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("doctorId",id);
        jsonBody.addProperty("question",msg);
        MediaType jsonType = MediaType.get("application/json;charset=utf-8");
        String bodyMsg = WorkOkHttp.post("/prod-api/api/pet-hospital/inquiry", jsonBody, jsonType, token);
        int code = new JsonParser().parse(bodyMsg).getAsJsonObject().get("code").getAsInt();
        if (code == 200){
            runOnUiThread(()->{
                Toast.makeText(this, "成功", Toast.LENGTH_SHORT).show();
            });
        }else{
            runOnUiThread(()->{
                Toast.makeText(this, "失败", Toast.LENGTH_SHORT).show();
            });
        }

    }
}