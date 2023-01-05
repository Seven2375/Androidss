package com.huangxue.s01.Activity.LifePay;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.huangxue.s01.Activity.LifePay.PhonePayActivity;
import com.huangxue.s01.R;

public class PhoneBillHomeActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, View.OnClickListener {

    private RadioGroup rg;
    private RadioButton rb1;
    private RadioButton rb2;
    private RadioButton rb3;
    private String operator = null;
    private Button btn;
    private EditText etPhone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_bill_home);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("手机缴费");
        toolbar.setNavigationOnClickListener(v->finish());

        initView();

    }

    private void initView() {
        rg = findViewById(R.id.phone_bill_home_rg);
        rg.setOnCheckedChangeListener(this);
        rb1 = findViewById(R.id.phone_bill_home_rbtn1);
        rb2 = findViewById(R.id.phone_bill_home_rbtn2);
        rb3 = findViewById(R.id.phone_bill_home_rbtn3);
        btn = findViewById(R.id.phone_bill_home_btn);
        etPhone = findViewById(R.id.phone_bill_home_phone);
        btn.setOnClickListener(this);
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i){
            case R.id.phone_bill_home_rbtn1:
                operator = "中国移动";
                break;
            case R.id.phone_bill_home_rbtn2:
                operator = "中国联通";
                break;
            case R.id.phone_bill_home_rbtn3:
                operator = "中国电信";
                break;
        }
    }

    @Override
    public void onClick(View view) {
        String phone = etPhone.getText().toString();
        if (phone.isEmpty()||operator.isEmpty()){
            Toast.makeText(this, "输入需要查询的参数", Toast.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this, PhonePayActivity.class);
            intent.putExtra("phone",phone);
            intent.putExtra("operator",operator);
            startActivity(intent);
        }
    }
}