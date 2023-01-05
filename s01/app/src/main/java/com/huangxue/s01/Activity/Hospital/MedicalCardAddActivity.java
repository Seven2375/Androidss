package com.huangxue.s01.Activity.Hospital;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import okhttp3.MediaType;

public class MedicalCardAddActivity extends AppCompatActivity {

    private EditText etName;
    private EditText etSex;
    private EditText etPhone;
    private EditText etAddress;
    private EditText etBDay;
    private EditText etCardID;
    private Button etSubmit;
    private String name;
    private String sex;
    private String phone;
    private String address;
    private String bDay;
    private String cardId;
    private String token;
    private int code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_card_add);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("新增就诊卡片");
        toolbar.setNavigationOnClickListener(view -> finish());
        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        initView();
    }

    private void initView() {
        etName = findViewById(R.id.add_card_name);
        etSex = findViewById(R.id.add_card_sex);
        etPhone = findViewById(R.id.add_card_phone);
        etAddress = findViewById(R.id.add_card_address);
        etBDay = findViewById(R.id.add_card_bDay);
        etBDay.setOnClickListener(view -> {
            new DatePickerDialog(this, android.R.style.Theme_Holo_Light_Dialog, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                    etBDay.setText(i+"-"+(i1+1)+"-"+i2);
                }
            },2000,1,1).show();
        });
        etCardID = findViewById(R.id.add_card_cardId);
        etSubmit = findViewById(R.id.add_card_submit);
        etSubmit.setOnClickListener(v->{

            name = etName.getText().toString();
            sex = etSex.getText().toString();
            phone = etPhone.getText().toString();
            address = etAddress.getText().toString();
            bDay = etBDay.getText().toString();
            cardId = etCardID.getText().toString();

            if (name.isEmpty()||sex.isEmpty()||phone.isEmpty()||address.isEmpty()||bDay.isEmpty()||cardId.isEmpty()){
                Toast.makeText(this, "请输入完整信息", Toast.LENGTH_SHORT).show();
            }else{
                new Thread(()->{initHttp();}).start();
            }

        });
    }

    private void initHttp() {
        JsonObject jsonBody = new JsonObject();
        jsonBody.addProperty("address",address);
        jsonBody.addProperty("sex",sex.equals("男") ? "0":"1");
        jsonBody.addProperty("tel",phone);
        jsonBody.addProperty("birthday",bDay);
        jsonBody.addProperty("cardId",cardId);
        jsonBody.addProperty("name",name);
        MediaType jsonType = MediaType.get("application/json;charset=utf-8");
        String body = WorkOkHttp.post("/prod-api/api/hospital/patient", jsonBody, jsonType, token);
        code = new JsonParser().parse(body).getAsJsonObject().get("code").getAsInt();
        Log.d("TAG", "initHttp: "+body);
        runOnUiThread(()->{
            if (code != 200){
                Toast.makeText(this, "操作失败", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "添加成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

}