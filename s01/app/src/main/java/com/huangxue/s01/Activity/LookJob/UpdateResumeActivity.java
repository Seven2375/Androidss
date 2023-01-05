package com.huangxue.s01.Activity.LookJob;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.Beans.MyInfoBean;
import com.huangxue.s01.Beans.ResumeInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import okhttp3.MediaType;

public class UpdateResumeActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText et_experience;
    private EditText et_mostEducation;
    private EditText et_address;
    private EditText et_positionId;
    private EditText et_money;
    private EditText et_education;
    private String token;
    private JsonObject jsonBody;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_resume);

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("修改简历");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();

    }

    private void initView() {
        et_experience = findViewById(R.id.update_resume_experience);
        et_mostEducation = findViewById(R.id.update_resume_mostEducation);
        et_address = findViewById(R.id.update_resume_address);
        et_positionId = findViewById(R.id.update_resume_positionId);
        et_money = findViewById(R.id.update_resume_money);
        et_education = findViewById(R.id.update_resume_education);
        findViewById(R.id.update_resume_btn).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String experience = et_experience.getText().toString();
        String mostEducation = et_mostEducation.getText().toString();
        String address = et_address.getText().toString();
        String positionId = et_positionId.getText().toString();
        String money = et_money.getText().toString();
        String education = et_education.getText().toString();

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
        Gson gson = new Gson();
        String userInfoBody = WorkOkHttp.get("/prod-api/api/common/user/getInfo", token);
        int userId = gson.fromJson(userInfoBody, MyInfoBean.class).getUser().getUserId();

        String resumeBody = WorkOkHttp.get("/prod-api/api/job/resume/queryResumeByUserId/" + userId, token);
        int id = gson.fromJson(resumeBody, ResumeInfoBean.class).getData().getId();

        jsonBody.addProperty("id",id);

        String body = WorkOkHttp.put("/prod-api/api/job/resume", token,jsonBody);
        Log.e("TAG", "initHttp: "+body);
        int code = new JsonParser().parse(body).getAsJsonObject().get("code").getAsInt();
        String msg = new JsonParser().parse(body).getAsJsonObject().get("msg").getAsString();
        if (code == 200){
            runOnUiThread(()->{
                Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
            });
        }else{
            runOnUiThread(()->{
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            });
        }
    }
}