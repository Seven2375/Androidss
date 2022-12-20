package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.MedicalCardListAdapter;
import com.huangxue.s01.Beans.MedicalCardListBean;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

public class MedicalCardActivity extends AppCompatActivity {

    private TextView addCard;
    private String token;
    private List<MedicalCardListBean.RowsEntity> rows;
    private TextView cardMsg;
    private RecyclerView cardList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_card);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("就诊人卡片");
        toolbar.setNavigationOnClickListener(v->finish());

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        initView();
        new Thread(()->{
            initHttp();
        }).start();

    }

    private void initHttp() {
        String body = WorkOkHttp.get("/prod-api/api/hospital/patient/list", token);
        Gson gson = new Gson();
        MedicalCardListBean medicalCardListBean = gson.fromJson(body, MedicalCardListBean.class);
        int total = medicalCardListBean.getTotal();
        rows = medicalCardListBean.getRows();
        if (total==0){
            runOnUiThread(()->{
                cardMsg.setVisibility(View.VISIBLE);
            });

        }else {
            runOnUiThread(()->{
                initCardList();
            });
        }
    }

    private void initCardList() {
        MedicalCardListAdapter medicalCardListAdapter = new MedicalCardListAdapter(this,rows);
        cardList.setLayoutManager(new LinearLayoutManager(this));
        cardList.setAdapter(medicalCardListAdapter);
        medicalCardListAdapter.setMyOnClick(i->{

        });
    }

    private void initView() {
        cardList = findViewById(R.id.medical_card_list);
        cardMsg = findViewById(R.id.medical_card_msg);
        addCard = findViewById(R.id.medical_card_add);
        addCard.setOnClickListener(v->{
            startActivity(new Intent(this,MedicalCardAddActivity.class));
        });
    }
}