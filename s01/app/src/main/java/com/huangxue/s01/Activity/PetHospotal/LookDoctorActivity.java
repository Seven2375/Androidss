package com.huangxue.s01.Activity.PetHospotal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.gson.Gson;
import com.huangxue.s01.Activity.PetHospotal.AskDoctorActivity;
import com.huangxue.s01.Adatper.DoctorListAdapter;
import com.huangxue.s01.Beans.DoctorListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

public class LookDoctorActivity extends AppCompatActivity {

    private int id;
    private ProgressBar pb;
    private RecyclerView rv;
    private String token;
    private List<DoctorListBean.RowsEntity> rows;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_look_doctor);
        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");
        id = getIntent().getIntExtra("id", 0);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("宠物医生");
        toolbar.setNavigationOnClickListener(view -> finish());

        initView();
        new Thread(this::initHttp).start();
    }

    private void initHttp() {
        String body = WorkOkHttp.get("/prod-api/api/pet-hospital/pet-doctor/list?typeId=" + id, token);
        Gson gson = new Gson();
        rows = gson.fromJson(body, DoctorListBean.class).getRows();
        runOnUiThread(this::initList);
    }

    private void initList() {
        DoctorListAdapter doctorListAdapter = new DoctorListAdapter(this, rows);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(doctorListAdapter);
        try {
            Thread.sleep(1000);
            pb.setVisibility(View.GONE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        doctorListAdapter.setMyOnClick(data->{
            Intent intent = new Intent(this, AskDoctorActivity.class);
            intent.putExtra("id",data.getId());
            intent.putExtra("name",data.getName());
            intent.putExtra("imgUrl",data.getAvatar());
            intent.putExtra("jobName",data.getJobName());
            intent.putExtra("numberNo",data.getPracticeNo());
            startActivity(intent);
        });
    }

    private void initView() {
        rv = findViewById(R.id.look_doctor_list);
        pb = findViewById(R.id.item_progress);
    }
}