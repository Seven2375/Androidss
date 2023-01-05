package com.huangxue.s01.Activity.LookJob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.huangxue.s01.Beans.MyInfoBean;
import com.huangxue.s01.Beans.ResumeInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

public class QueryResumeActivity extends AppCompatActivity {
    private TextView et_experience;
    private TextView et_mostEducation;
    private TextView et_address;
    private TextView et_positionId;
    private TextView et_money;
    private TextView et_education;
    private String token;
    private ResumeInfoBean.DataEntity data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_resume);

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("我的简历");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();
        new Thread(()->{
            initHttp();
        }).start();
    }

    private void initHttp() {
        Gson gson = new Gson();
        String userInfoBody = WorkOkHttp.get("/prod-api/api/common/user/getInfo", token);
        int userId = gson.fromJson(userInfoBody, MyInfoBean.class).getUser().getUserId();

        String resumeBody = WorkOkHttp.get("/prod-api/api/job/resume/queryResumeByUserId/" + userId, token);
        data = gson.fromJson(resumeBody, ResumeInfoBean.class).getData();

        runOnUiThread(()->{
            initData();
        });

    }

    private void initData() {
        et_experience.setText(data.getExperience());
        et_mostEducation.setText(data.getMostEducation());
        et_address.setText(data.getAddress());
        et_positionId.setText(data.getPositionId()+"");
        et_money.setText(data.getMoney());
        et_education.setText(data.getEducation());
    }

    private void initView() {
        et_experience = findViewById(R.id.query_resume_experience);
        et_mostEducation = findViewById(R.id.query_resume_mostEducation);
        et_address = findViewById(R.id.query_resume_address);
        et_positionId = findViewById(R.id.query_resume_positionId);
        et_money = findViewById(R.id.query_resume_money);
        et_education = findViewById(R.id.query_resume_education);
    }
}