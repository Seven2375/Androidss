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
import com.google.gson.JsonParser;
import com.huangxue.s01.Beans.MyInfoBean;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.io.File;

import okhttp3.OkHttpClient;

public class MyInfoActivity extends AppCompatActivity implements View.OnClickListener {

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
    private MyInfoBean.UserEntity userInfoData;
    private LinearLayout updateImg;
    private PopupWindow popupWindow;
    private String picPath;
    private String Url = "http://124.93.196.45:10001";
    private String fileName;
    private File file;

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
        json_body.addProperty("avatar","/prod-api"+fileName);
        json_body.addProperty("phonenumber",et_phone.getText().toString());
        json_body.addProperty("sex",et_sex.getText().toString().equals("男") ? "0":"1");
        String code = WorkOkHttp.put("/prod-api/api/common/user", token,json_body);
        Log.d("TAG", "UpdateInfo: "+code);
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
                //上传图片
                UpLoad();
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
    //上传图片
    private void UpLoad() {
        String upload = WorkOkHttp.upload("/prod-api/common/upload", file, token);
//        Log.d("TAG", "onActivityResult: "+upload);
        fileName = new JsonParser().parse(upload).getAsJsonObject().get("fileName").getAsString();
//        Log.d("TAG", "onActivityResult: "+ fileName);
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
                    .load(Url+img_url)
                    .apply(RequestOptions.bitmapTransform(new RoundedCorners(1000)))
                    .into(img_avatar);
            et_name.setText(name);
            et_sex.setText(sex.equals("0") ? "男":"女");
            et_phone.setText(phone);
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.userInfo_pop_btn1:
                popupWindow.dismiss();
                //跳转到相册
                Intent intent = new Intent();
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(intent, 0);
                break;
            case R.id.userInfo_pop_btn2:
                popupWindow.dismiss();
                break;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 0:
                if (data != null) {
                    if (requestCode == 0 && resultCode == Activity.RESULT_OK) {
                        //获取图片的URI地址
                        Uri selectedImage = data.getData();
                        img_avatar.setImageURI(selectedImage);
                        //调用URL转file方法
                        file = uriToFile(selectedImage);
                        //上传图片
                        break;
                    }
                }
                break;
        }
    }
    private File uriToFile(Uri uri) {
        String img_path;
        String[] proj = {MediaStore.Images.Media.DATA};
        Cursor actualimagecursor = managedQuery(uri, proj, null,
                null, null);
        if (actualimagecursor == null) {
            img_path = uri.getPath();
        } else {
            int actual_image_column_index = actualimagecursor
                    .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            actualimagecursor.moveToFirst();
            img_path = actualimagecursor.getString(actual_image_column_index);
        }
        File toFile = new File(img_path);
        return toFile;
    }
}