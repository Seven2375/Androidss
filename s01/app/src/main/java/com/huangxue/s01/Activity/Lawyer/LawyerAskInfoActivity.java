package com.huangxue.s01.Activity.Lawyer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.Adatper.LawyerExpertiseListAdapter;
import com.huangxue.s01.Beans.LawyerExpertiseListBean;
import com.huangxue.s01.Beans.LawyerInfoBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.Tools;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import java.util.List;

import okhttp3.MediaType;

public class LawyerAskInfoActivity extends AppCompatActivity implements View.OnClickListener, TextWatcher {

    private int id;
    private String token;
    private LawyerInfoBean.DataEntity data;
    private ImageView img;
    private TextView name;
    private TextView workingYear;
    private TextView expertise;
    private TextView askNumber;
    private TextView goodRate;
    private Button selectBtn;
    private ImageView typeImg;
    private TextView typeName;
    private EditText etPhone;
    private EditText etDesc;
    private List<LawyerExpertiseListBean.RowsEntity> expertiseData;
    private TextView record;
    private int length;
    private Button submit;
    private String legalExpertiseId = null;
    private String phone;
    private String desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_ask_info);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("咨询");
        toolbar.setNavigationOnClickListener(v->finish());

        id = getIntent().getIntExtra("id", 0);
        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        initView();

        new Thread(this::initHttp).start();

    }

    private void initHttp() {
        Gson gson = new Gson();
        String infoBody = WorkOkHttp.get("/prod-api/api/lawyer-consultation/lawyer/" + id, token);
        String expertiseBody = WorkOkHttp.get("/prod-api/api/lawyer-consultation/legal-expertise/list", token);

        data = gson.fromJson(infoBody, LawyerInfoBean.class).getData();
        expertiseData = gson.fromJson(expertiseBody, LawyerExpertiseListBean.class).getRows();

        runOnUiThread(()->{
            initData();

        });

    }

    private void initData() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        LocalDate startTime = LocalDate.parse(data.getWorkStartAt());
        LocalDate endTime = LocalDate.parse(simpleDateFormat.format(date));
        Period period = Period.between(startTime, endTime);

        name.setText(data.getName());
        askNumber.setText("咨询人数："+data.getServiceTimes());
        goodRate.setText("好评率："+data.getFavorableRate()+"%");
        expertise.setText("专长："+data.getLegalExpertiseName());
        workingYear.setText("从业时长："+period.getYears()+"年");
        Tools.setImg(this,data.getAvatarUrl(),img);
    }

    private void initView() {
        img = findViewById(R.id.lawyer_ask_img);
        name = findViewById(R.id.lawyer_ask_name);
        workingYear = findViewById(R.id.lawyer_ask_workingYear);
        expertise = findViewById(R.id.lawyer_ask_expertise);
        askNumber = findViewById(R.id.lawyer_ask_askNumber);
        goodRate = findViewById(R.id.lawyer_ask_goodRate);

        typeImg = findViewById(R.id.lawyer_ask_typeImg);
        typeName = findViewById(R.id.lawyer_ask_typeName);

        etPhone = findViewById(R.id.lawyer_ask_phone);
        etDesc = findViewById(R.id.lawyer_ask_desc);
        record = findViewById(R.id.lawyer_ask_record);
        submit = findViewById(R.id.lawyer_ask_submit);
        submit.setOnClickListener(v->{
            initSubmit();
        });
        etDesc.addTextChangedListener(this);

        selectBtn = findViewById(R.id.lawyer_ask_selectBtn);
        selectBtn.setOnClickListener(this);
    }

    private void initSubmit() {
        phone = etPhone.getText().toString();
        desc = etDesc.getText().toString();
        if (phone.isEmpty()|| desc.isEmpty() || legalExpertiseId.isEmpty()){
            Toast.makeText(this, "请输入完整信息", Toast.LENGTH_SHORT).show();
        }else{
            new Thread(()->{
                isOK();
                finish();
            }).start();
        }
    }

    private void isOK() {
        MediaType jsonType = MediaType.get("application/json");
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("lawyerId",id);
        jsonObject.addProperty("legalExpertiseId",legalExpertiseId);
        jsonObject.addProperty("content",desc);
        jsonObject.addProperty("phone",phone);
        String body = WorkOkHttp.post("/prod-api/api/lawyer-consultation/legal-advice", jsonObject, jsonType, this.token);
        int code = new JsonParser().parse(body).getAsJsonObject().get("code").getAsInt();
        if (code==200){
            runOnUiThread(()->{
                Toast.makeText(this, "咨询成功！", Toast.LENGTH_SHORT).show();
            });
        }else {
            runOnUiThread(()->{
                Toast.makeText(this, "失败！", Toast.LENGTH_SHORT).show();
            });
        }
    }

    @Override
    public void onClick(View view) {
        View mView = View.inflate(this, R.layout.item_dialog_grid, null);
        RecyclerView rv = mView.findViewById(R.id.dialog_rv);
        LawyerExpertiseListAdapter adapter = new LawyerExpertiseListAdapter(expertiseData, this);
        rv.setLayoutManager(new GridLayoutManager(this,4));
        rv.setAdapter(adapter);
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setView(mView)
                .create();
        dialog.show();
        adapter.setMyOnClick(data->{
            LawyerExpertiseListBean.RowsEntity origin = (LawyerExpertiseListBean.RowsEntity) data;
            Tools.setImg(this,origin.getImgUrl(),typeImg);
            typeName.setText(origin.getName());
            legalExpertiseId = String.valueOf(origin.getId());
            dialog.dismiss();
        });
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        String s = etDesc.getText().toString();
        length = s.length();
        record.setText(length +"/500");
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}