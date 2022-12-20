package com.huangxue.s01;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.huangxue.s01.Beans.MyInfoBean;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.File;

import okhttp3.OkHttpClient;

public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView img_avatar;
    private EditText et_name;
    private EditText et_sex;
    private EditText et_phone;
    private String name;
    private String sex;
    private String phone;
    private String img_url;
    private SharedPreferences sp;
    private String token;
    private OkHttpClient okHttpClient = new OkHttpClient();
    private MyInfoBean.UserEntity userInfoData;
    private LinearLayout updateImg;
    private PopupWindow popupWindow;
    private String picPath;
    private String Url = "http://124.93.196.45:10001";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("个人信息");
        toolbar.setNavigationOnClickListener(view -> finish());

        sp = getSharedPreferences("token", Context.MODE_PRIVATE);
        token = sp.getString("token", "");

        initView();

        new Thread(()->{
            initHttp();
        }).start();


    }

    private void UpdateInfo(){
        JsonObject json_body = new JsonObject();
        json_body.addProperty("nickName",et_name.getText().toString());
        json_body.addProperty("phonenumber",et_phone.getText().toString());
        json_body.addProperty("sex",et_sex.getText().toString().equals("男") ? "0":"1");
        WorkOkHttp.put("/prod-api/api/common/user",token);
        runOnUiThread(()->{
            Toast.makeText(this, "修改成功", Toast.LENGTH_SHORT).show();
        });

    }

    private void initView() {
        img_avatar = findViewById(R.id.myinfo_img_avatar);
        et_name = findViewById(R.id.myinfo_et_name);
        et_sex = findViewById(R.id.myinfo_et_sex);
        et_phone = findViewById(R.id.myinfo_et_phone);
        updateImg = findViewById(R.id.my_info_update_img);
        findViewById(R.id.myinfo_btn_update_info).setOnClickListener(v->{
            new Thread(()->{
                UpdateInfo();
            }).start();
        });
        findViewById(R.id.my_info_update_img).setOnClickListener(view -> {
            View item = getLayoutInflater().inflate(R.layout.item_userinfo_popwindow, null);
            popupWindow = new PopupWindow(item, ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,true);
            popupWindow.showAsDropDown(updateImg);
            item.findViewById(R.id.userInfo_pop_btn1).setOnClickListener(this);
            item.findViewById(R.id.userInfo_pop_btn2).setOnClickListener(this);

        });
    }
    private void initHttp(){

        String body = WorkOkHttp.get("/prod-api/api/common/user/getInfo", token);
        Gson gson = new Gson();
        userInfoData = gson.fromJson(body, MyInfoBean.class).getUser();
        initData();
    }
    private void initData(){
        name = userInfoData.getNickName();
        sex = userInfoData.getSex();
        phone = userInfoData.getPhonenumber();
        img_url = userInfoData.getAvatar();
        runOnUiThread(()->{
            Glide.with(this)
                    .load(img_url)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(1000)))
                    .into(img_avatar);
            et_name.setText(name);
            et_sex.setText(sex.equals("0") ? "男":"女");
            et_phone.setText(phone);
        });

    }

    private void initPhoto(){
        Intent intent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(intent,1);
    }
    private void takePhoto() {
        // 执行拍照前，应该先判断SD卡是否存在
        String SDState = Environment.getExternalStorageState();
        if (SDState.equals(Environment.MEDIA_MOUNTED)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);// "android.media.action.IMAGE_CAPTURE"
            File path = Environment
                    .getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            File file = new File(path, "image.jpg");
            Uri takePhoto = Uri.fromFile(file);
            intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, takePhoto);
            startActivityForResult(intent, 2);
        } else {
            Toast.makeText(getApplicationContext(), "内存卡不存在",
                    Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.userInfo_pop_btn1:
                popupWindow.dismiss();
                initPhoto();
                break;
            case R.id.userInfo_pop_btn2:
                popupWindow.dismiss();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode != Activity.RESULT_OK){
            Log.e("TAG","无数据");
            return;
        }
        switch (requestCode){
            case 1:
                Uri uri = data.getData();
                Cursor cursor = getContentResolver().query(
                        uri, new String[]{MediaStore.Images.Media.DATA},
                        null, null, null);
                if (cursor == null){
                    return;
                }
                cursor.moveToFirst();
                picPath = cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA));
                Log.e("TAG", "onActivityResult: "+picPath);
                break;
        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}