package com.huangxue.s01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BusUserActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etName;
    private EditText etPhone;
    private EditText etStaName;
    private EditText etEndName;
    private EditText etGetOn;
    private EditText etGetOff;
    private Button submit;
    private String name;
    private String phone;
    private String staName;
    private String endName;
    private String getOn;
    private String getOff;
    private String date;
    private int price;
    private String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_user);

        date = getIntent().getStringExtra("date");
        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("班车定制");
        toolbar.setNavigationOnClickListener(view -> finish());
        price = getIntent().getIntExtra("price", 2);
        path = getIntent().getStringExtra("path");

        initView();
    }

    private void initView() {
        etName = findViewById(R.id.bus_user_name);
        etPhone = findViewById(R.id.bus_user_phone);
        etStaName = findViewById(R.id.bus_user_staName);
        etEndName = findViewById(R.id.bus_user_endName);
        etGetOn = findViewById(R.id.bus_user_getOn);
        etGetOff = findViewById(R.id.bus_user_getOff);
        submit = findViewById(R.id.bus_user_submit);

        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        name = etName.getText().toString();
        phone = etPhone.getText().toString();
        staName = etStaName.getText().toString();
        endName = etEndName.getText().toString();
        getOn = etGetOn.getText().toString();
        getOff = etGetOff.getText().toString();
        if (name.isEmpty()||phone.isEmpty()||staName.isEmpty()||endName.isEmpty()||getOn.isEmpty()||getOff.isEmpty()){
            Toast.makeText(this, "请输入完整信息", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, BusSubmitActivity.class);
            intent.putExtra("date",date);
            intent.putExtra("name",name);
            intent.putExtra("phone",phone);
            intent.putExtra("getOn",getOn);
            intent.putExtra("getOff",getOff);
            intent.putExtra("price",price);
            intent.putExtra("path",path);
            startActivity(intent);
        }
    }
}