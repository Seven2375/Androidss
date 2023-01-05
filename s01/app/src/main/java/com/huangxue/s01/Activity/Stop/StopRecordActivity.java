package com.huangxue.s01.Activity.Stop;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.MyStopRecordAdapter;
import com.huangxue.s01.Beans.StopRecordBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.IOException;
import java.util.List;

public class StopRecordActivity extends AppCompatActivity {

    private String name;
    private String Url = "/prod-api/api/park/lot/record/list?";
    private String urlParkName = "parkName=";
    private List<StopRecordBean.RowsEntity> rows;
    private RecyclerView viewlist;
    private Button btn;
    private EditText et_statime;
    private EditText et_endtime;
    private String endtime;
    private String statime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_record);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("停车记录");
        toolbar.setNavigationOnClickListener(view -> finish());

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        new Thread(()->{try {
            init();
        } catch (IOException e) {
            e.printStackTrace();
        }}).start();

    }

    private void init() throws IOException {

        String body = WorkOkHttp.get(Url + urlParkName + name);
        Gson gson = new Gson();
        rows = gson.fromJson(body, StopRecordBean.class).getRows();
        runOnUiThread(()->{
            initList(0);
        });
        initUI();
    }

    private void initUI(){

        btn = findViewById(R.id.stop_record_btn);
        btn.setOnClickListener(v->{
            runOnUiThread(()->{
                initList(1);
                btn.setVisibility(View.GONE);
            });
        });


        et_statime = findViewById(R.id.stop_record_et_statime);
        et_endtime = findViewById(R.id.stop_record_et_endtime);

        et_statime.setOnClickListener(view -> {
            new DatePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog,new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    et_statime.setText(i+"-"+(i1+1)+"-"+i2);
                }
            },2021,8,29).show();
        });
        et_endtime.setOnClickListener(view -> {
            new DatePickerDialog(this,android.R.style.Theme_Holo_Light_Dialog,new DatePickerDialog.OnDateSetListener(){
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    et_endtime.setText(i+"-"+(i1+1)+"-"+i2);
                }
            },2021,8,29).show();
        });


        findViewById(R.id.stop_record_btn_look).setOnClickListener(v->{
            endtime = et_endtime.getText().toString();
            statime = et_statime.getText().toString();
            new Thread(()->{

                String s = WorkOkHttp.get(Url + urlParkName + name + "&" + "entryTime=" + statime + "&" + "outTime=" + endtime);
                Gson gson = new Gson();
                rows = gson.fromJson(s, StopRecordBean.class).getRows();
                runOnUiThread(()->{
                    btn.setVisibility(View.GONE);
                    initList(1);
                });
            }).start();

        });
    }


    private void initList(int id){

        viewlist = findViewById(R.id.stop_record_list);
        MyStopRecordAdapter adapter = new MyStopRecordAdapter(this,rows,id);
        viewlist.setLayoutManager(new LinearLayoutManager(this));
        viewlist.setAdapter(adapter);
    }
}