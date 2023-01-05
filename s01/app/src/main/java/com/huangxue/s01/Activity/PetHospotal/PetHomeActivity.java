package com.huangxue.s01.Activity.PetHospotal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.AskListAdapter;
import com.huangxue.s01.Adatper.PetClassGridAdapter;
import com.huangxue.s01.Beans.AskListBean;
import com.huangxue.s01.Beans.PetClassGridBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

public class PetHomeActivity extends AppCompatActivity {

    private String token;
    private RecyclerView petGrid;
    private List<PetClassGridBean.DataEntity> petClassData;
    private List<AskListBean.RowsEntity> myAskRows;
    private RecyclerView myAskRv;
    private TextView myAskRvTitle;
    private List<AskListBean.RowsEntity> publicAskRows;
    private int num = 1;
    private RecyclerView publicAskRv;
    private TextView publicAskRvTitle;
    private AskListAdapter publicAdapter;
    private LinearLayoutManager publicManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet_home);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("宠物医院");
        toolbar.setNavigationOnClickListener(view -> finish());

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        initView();
        new Thread(this::initHttp).start();
    }

    private void initHttp() {
        Gson gson = new Gson();
        String petClassBody = WorkOkHttp.get("/prod-api/api/pet-hospital/pet-type/list", token);
        String myAskBody = WorkOkHttp.get("/prod-api/api/pet-hospital/inquiry/my-list", token);
        String publicAskBody = WorkOkHttp.get("/prod-api/api/pet-hospital/inquiry/list?pageNum=" + num + "&" + "pageSize=" + 20,token);

        petClassData = gson.fromJson(petClassBody, PetClassGridBean.class).getData();
        myAskRows = gson.fromJson(myAskBody, AskListBean.class).getRows();
        publicAskRows = gson.fromJson(publicAskBody, AskListBean.class).getRows();

        runOnUiThread(()->{
            initPetClassGrid();
            initMyAskList();
            initPublicAskList();
        });
    }

    private void initPublicAskList() {
        publicAdapter = new AskListAdapter(publicAskRows, this);
        publicManager = new LinearLayoutManager(this);
        publicAskRv.setLayoutManager(publicManager);
        publicAskRv.setAdapter(publicAdapter);
        publicAdapter.setMyOnClick(data -> {
            if (data.getDoctor()!=null){
                Intent intent = new Intent(this, AskInfoActivity.class);
                intent.putExtra("id",data.getId());
                intent.putExtra("desc",data.getQuestion());
                intent.putExtra("name",data.getDoctor().getName());
                intent.putExtra("imgUrl",data.getDoctor().getAvatar());
                intent.putExtra("jobName",data.getDoctor().getJobName());
                intent.putExtra("numberNo",data.getDoctor().getPracticeNo());
                startActivity(intent);
            }
        });
        publicAskRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    int lastVisibleItemPosition = publicManager.findLastVisibleItemPosition();
                    if (lastVisibleItemPosition >= publicManager.getItemCount()-1){
                        new Thread(()->{
                            initUpdatePublicAskList();
                        }).start();
                    }
                }
            }
        });
    }

    private void initUpdatePublicAskList() {
        num+=1;
        Gson gson = new Gson();
        String publicAskBody = WorkOkHttp.get("/prod-api/api/pet-hospital/inquiry/list?pageNum=" + num + "&" + "pageSize=" + 20,token);
        List<AskListBean.RowsEntity> rows = gson.fromJson(publicAskBody, AskListBean.class).getRows();
        for (AskListBean.RowsEntity data : rows) {
            publicAskRows.add(data);
        }
        runOnUiThread(()->{
            publicAdapter.notifyItemChanged(publicManager.getItemCount()-1);
        });

    }

    private void initMyAskList() {
        AskListAdapter adapter = new AskListAdapter(myAskRows, this);
        myAskRv.setLayoutManager(new LinearLayoutManager(this));
        myAskRv.setAdapter(adapter);
        adapter.setMyOnClick(data -> {
            if (data.getDoctor()!=null){
                Intent intent = new Intent(this, AskInfoActivity.class);
                intent.putExtra("id",data.getId());
                intent.putExtra("desc",data.getQuestion());
                intent.putExtra("name",data.getDoctor().getName());
                intent.putExtra("imgUrl",data.getDoctor().getAvatar());
                intent.putExtra("jobName",data.getDoctor().getJobName());
                intent.putExtra("numberNo",data.getDoctor().getPracticeNo());
                startActivity(intent);
            }
        });
    }

    private void initPetClassGrid() {
        PetClassGridAdapter petClassGridAdapter = new PetClassGridAdapter(this, petClassData);
        petGrid.setLayoutManager(new GridLayoutManager(this, 5));
        petGrid.setAdapter(petClassGridAdapter);
        myAskRvTitle.setVisibility(View.VISIBLE);
        publicAskRvTitle.setVisibility(View.VISIBLE);
        petClassGridAdapter.setMyOnClick(data -> {
            int id = data.getId();
            Intent intent = new Intent(this, LookDoctorActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
        });
    }

    private void initView() {
        petGrid = findViewById(R.id.pet_home_petClassGrid);

        myAskRv = findViewById(R.id.pet_home_myAskList);
        myAskRvTitle = findViewById(R.id.pet_home_myAskListTitle);

        publicAskRv = findViewById(R.id.pet_home_publicAskList);
        publicAskRvTitle = findViewById(R.id.pet_home_publicAskListTitle);
    }
}