package com.huangxue.s01.Activity.LookJob;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import okhttp3.MediaType;

public class AddResumeActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText et_experience;
    private EditText et_mostEducation;
    private EditText et_address;
    private EditText et_positionId;
    private EditText et_money;
    private EditText et_education;
    private String token;
    private MediaType jsonType;
    private JsonObject jsonBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_resume);

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("新增简历");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();

    }

    private void initView() {
        et_experience = findViewById(R.id.add_resume_experience);
        et_mostEducation = findViewById(R.id.add_resume_mostEducation);
        et_address = findViewById(R.id.add_resume_address);
        et_positionId = findViewById(R.id.add_resume_positionId);
        et_money = findViewById(R.id.add_resume_money);
        et_education = findViewById(R.id.add_resume_education);
        findViewById(R.id.add_resume_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String experience = et_experience.getText().toString();
        String mostEducation = et_mostEducation.getText().toString();
        String address = et_address.getText().toString();
        String positionId = et_positionId.getText().toString();
        String money = et_money.getText().toString();
        String education = et_education.getText().toString();

        jsonType = MediaType.get("application/json;charset=utf-8");
        jsonBody = new JsonObject();
        jsonBody.addProperty("experience",experience);
        jsonBody.addProperty("mostEducation",mostEducation);
        jsonBody.addProperty("address",address);
        jsonBody.addProperty("positionId",positionId);
        jsonBody.addProperty("money",money);
        jsonBody.addProperty("education",education);

        new Thread(()->{
            initHttp();
        }).start();
    }

    private void initHttp() {
        String body = WorkOkHttp.post("/prod-api/api/job/resume", jsonBody, jsonType, token);
        Log.e("TAG", "initHttp: "+body);
        int code = new JsonParser().parse(body).getAsJsonObject().get("code").getAsInt();
        String msg = new JsonParser().parse(body).getAsJsonObject().get("msg").getAsString();
        if (code == 200){
            runOnUiThread(()->{
                Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
            });
        }else{
            runOnUiThread(()->{
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            });
        }
    }
}