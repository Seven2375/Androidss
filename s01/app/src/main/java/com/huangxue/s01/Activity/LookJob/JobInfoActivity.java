package com.huangxue.s01.Activity.LookJob;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.Beans.CompanyInfoBean;
import com.huangxue.s01.Beans.JobInfoBean;
import com.huangxue.s01.Beans.MyInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.Calendar;

import okhttp3.MediaType;

public class JobInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private int companyId;
    private int id;
    private TextView professionName;
    private TextView salary;
    private TextView need;
    private TextView contacts;
    private TextView address;
    private TextView obligation;
    private TextView companyName;
    private TextView introductory;
    private JobInfoBean.DataEntity jobData;
    private CompanyInfoBean.DataEntity companyData;
    private Button btn;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_info);

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        id = getIntent().getIntExtra("id", 0);
        companyId = getIntent().getIntExtra("companyId", 0);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("招聘详情");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();
        new Thread(this::initHttp).start();

    }

    private void initHttp() {
        Gson gson = new Gson();
        String jobBody = WorkOkHttp.get("/prod-api/api/job/post/" + id);
        String companyBody = WorkOkHttp.get("/prod-api/api/job/company/" + companyId);
        jobData = gson.fromJson(jobBody, JobInfoBean.class).getData();
        companyData = gson.fromJson(companyBody, CompanyInfoBean.class).getData();

        runOnUiThread(()->{
            initData();
        });

    }

    @SuppressLint("SetTextI18n")
    private void initData() {
        professionName.setText(jobData.getName());
        salary.setText("薪资："+jobData.getSalary());
        need.setText("需求"+jobData.getNeed());
        contacts.setText("联系人："+jobData.getContacts());
        address.setText("地点："+jobData.getAddress());
        obligation.setText("描述：\n"+jobData.getObligation());
        companyName.setText("公司："+companyData.getCompanyName());
        introductory.setText("描述：\n"+companyData.getIntroductory());
    }

    private void initView() {
        professionName = findViewById(R.id.job_info_professionName);
        salary = findViewById(R.id.job_info_salary);
        need = findViewById(R.id.job_info_need);
        contacts = findViewById(R.id.job_info_contacts);
        address = findViewById(R.id.job_info_address);
        obligation = findViewById(R.id.job_info_obligation);
        companyName = findViewById(R.id.job_info_companyName);
        introductory = findViewById(R.id.job_info_introductory);
        btn = findViewById(R.id.job_info_btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        new Thread(()->{
            initIsOk();
        }).start();

    }

    private void initIsOk() {
        Gson gson = new Gson();
        String userInfoBody = WorkOkHttp.get("/prod-api/api/common/user/getInfo", token);
        int userId = gson.fromJson(userInfoBody, MyInfoBean.class).getUser().getUserId();

        String resumeBody = WorkOkHttp.get("/prod-api/api/job/resume/queryResumeByUserId/" + userId, token);
        if (resumeBody.contains("data")){

            initPost();
        }else{
            runOnUiThread(()->{
                Toast.makeText(this, "你还没有简历，请先添加简历", Toast.LENGTH_SHORT).show();
            });
        }
    }

    private void initPost() {
        Calendar instance = Calendar.getInstance();
        int y = instance.get(Calendar.YEAR);
        int m = instance.get(Calendar.MONTH);
        int d = instance.get(Calendar.DAY_OF_MONTH);
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("companyId",companyId);
        jsonBody.addProperty("postId",jobData.getProfessionId());
        jsonBody.addProperty("postName",jobData.getProfessionName());
        jsonBody.addProperty("satrTime",y+"-"+m+"-"+d);
        MediaType jsonType = MediaType.get("application/json");
        String body = WorkOkHttp.post("/prod-api/api/job/deliver", jsonBody, jsonType, token);
        int code = new JsonParser().parse(body).getAsJsonObject().get("code").getAsInt();
        String msg = new JsonParser().parse(body).getAsJsonObject().get("msg").getAsString();
        if (code==200){
            runOnUiThread(()->{
                Toast.makeText(this, "投递成功", Toast.LENGTH_SHORT).show();
            });
        }else{
            runOnUiThread(()->{
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            });
        }
    }
}