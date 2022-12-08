package com.huangxue.s01;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.huangxue.s01.Fragment.AllServicesFragment;
import com.huangxue.s01.Fragment.HomeFragment;
import com.huangxue.s01.Fragment.MyFragment;
import com.huangxue.s01.Fragment.NewsFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        replaceFragment(new HomeFragment());
        findViewById(R.id.home_page).setOnClickListener(this);
        findViewById(R.id.all_page).setOnClickListener(this);
        findViewById(R.id.xinwen_page).setOnClickListener(this);
        findViewById(R.id.my_page).setOnClickListener(this);

    }

    private void replaceFragment(Fragment fragment) {
        //使用getSupportFragmentManager获取一个fragment管理类
        FragmentManager fragmentManager = getSupportFragmentManager();
        //但是切换fragment是需要beginTransaction来完成
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        //直接使用replace方法来替换掉fragment
        transaction.replace(R.id.fragment, fragment);
        //提交事件才能执行
        transaction.commit();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.home_page:
                replaceFragment(new HomeFragment());
                break;
            case R.id.all_page:
                replaceFragment(new AllServicesFragment());
                break;
            case R.id.xinwen_page:
                replaceFragment(new NewsFragment());
                break;
            case R.id.my_page:
                replaceFragment(new MyFragment());
                break;
        }
    }

}