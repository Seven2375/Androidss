package com.huangxue.s01.Activity.Lawyer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.LawyerListAdapter;
import com.huangxue.s01.Adatper.SpinnerImgTextListAdapter;
import com.huangxue.s01.Beans.LawyerExpertiseListBean;
import com.huangxue.s01.Beans.LawyerListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.MyOnClick;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.ArrayList;
import java.util.List;

public class LawyerListActivity extends AppCompatActivity implements MyOnClick {

    private RecyclerView rv;
    private String token;
    private List<LawyerListBean.RowsEntity> rows;
    private String id = "";
    private String sort = "";
    private Spinner spinnerSort;
    private Spinner spinnerFilter;
    private ProgressBar pb;
    private List<LawyerExpertiseListBean.RowsEntity> spinnerRows;
    private Gson gson = new Gson();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_list);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("律师列表");
        toolbar.setNavigationOnClickListener(v->finish());

        token = getSharedPreferences("token", MODE_PRIVATE).getString("token", "");

        initGetIntent();
        initView();
        initSpinnerSort();
        new Thread(()->{
            initSpinnerFilterHttp();
            initHttp();
        }).start();
    }

    private void initSpinnerFilterHttp() {
        String spinnerBody = WorkOkHttp.get("/prod-api/api/lawyer-consultation/legal-expertise/list", token);
        spinnerRows = gson.fromJson(spinnerBody, LawyerExpertiseListBean.class).getRows();
        spinnerRows.add(0,new LawyerExpertiseListBean.RowsEntity("全部"));
        runOnUiThread(()->{
            initSpinnerFilter();
            pb.setVisibility(View.GONE);
        });
    }

    private void initSpinnerSort() {
        List<String> sortName = new ArrayList<>();
        sortName.add("默认排序");
        sortName.add("从业年限");
        sortName.add("服务人数");
        sortName.add("好评率");
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this,R.layout.item_spinner_text,sortName);
        spinnerSort.setAdapter(arrayAdapter);
        spinnerSort.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (sortName.get(i)){
                    case "默认排序":
                        sort = "";
                        initSortOk();
                        break;
                    case "从业年限":
                        sort = "workStartAt";
                        initSortOk();
                        break;
                    case "服务人数":
                        sort = "serviceTimes";
                        initSortOk();
                        break;
                    case "好评率":
                        sort = "favorableRate";
                        initSortOk();
                        break;
                }
            }@Override public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    private void initSortOk(){
        pb.setVisibility(View.VISIBLE);
        new Thread(()->{
            initHttp();
        }).start();
    }

    private void initGetIntent() {
        id = getIntent().getStringExtra("id");
        if (id==null){
            id = "";
        }
    }

    private void initHttp() {

        String body = WorkOkHttp.get("/prod-api/api/lawyer-consultation/lawyer/list?legalExpertiseId="+id+"&"+"sort="+sort, token);

        rows = gson.fromJson(body, LawyerListBean.class).getRows();

        runOnUiThread(()->{
            initList();
            pb.setVisibility(View.GONE);
        });

    }

    private void initSpinnerFilter(){
        int[] flag = {0};
        SpinnerImgTextListAdapter adapter = new SpinnerImgTextListAdapter(spinnerRows, this);
        spinnerFilter.setAdapter(adapter);
        spinnerFilter.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (flag[0]==0){
                    flag[0] = flag[0]+1;
                    return;
                }
                if (i==0){
                    id="";
                    initSortOk();
                }
                if (i!=0){
                    id = String.valueOf(spinnerRows.get(i).getId());
                    initSortOk();
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    private void initList() {
        LawyerListAdapter adapter = new LawyerListAdapter(rows, this);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        adapter.setMyOnClick(this);
    }

    private void initView() {
        rv = findViewById(R.id.lawyerList_rv);
        pb = findViewById(R.id.item_progress);
        spinnerSort = findViewById(R.id.lawyerList_spinnerSort);
        spinnerFilter = findViewById(R.id.lawyerList_spinnerFilter);
    }

    @Override
    public void onClick(Object data) {
        Intent intent = new Intent(this, LawyerInfoActivity.class);
        LawyerListBean.RowsEntity origin = (LawyerListBean.RowsEntity)data;
        intent.putExtra("id",origin.getId());
        startActivity(intent);
    }
}