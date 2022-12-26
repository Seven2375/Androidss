package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.PetClassGridAdapter;
import com.huangxue.s01.Beans.PetClassGridBean;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

public class PetHomeActivity extends AppCompatActivity {

    private String token;
    private RecyclerView petGrid;
    private List<PetClassGridBean.DataEntity> petClassData;

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
        String petClassBody = WorkOkHttp.get("/prod-api/api/pet-hospital/pet-type/list", token);
        Gson gson = new Gson();
        petClassData = gson.fromJson(petClassBody, PetClassGridBean.class).getData();
        runOnUiThread(this::initPetClassGrid);
    }

    private void initPetClassGrid() {
        PetClassGridAdapter petClassGridAdapter = new PetClassGridAdapter(this, petClassData);
        petGrid.setLayoutManager(new GridLayoutManager(this, 5));
        petGrid.setAdapter(petClassGridAdapter);
        petClassGridAdapter.setMyOnClick(data -> {
            int id = data.getId();
            Intent intent = new Intent(this,LookDoctorActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
        });
    }

    private void initView() {
        petGrid = findViewById(R.id.pet_home_petClassGrid);
    }
}