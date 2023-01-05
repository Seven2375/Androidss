package com.huangxue.s01.Activity.Subway;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.google.gson.Gson;
import com.huangxue.s01.Adatper.SubwayAllStationListAdapter;
import com.huangxue.s01.Beans.SubwayAllStationListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;

import java.util.List;

public class SubwayAllStationListActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private List<SubwayAllStationListBean.DataEntity> data;
    private SearchView searchView;
    private RecyclerView rv;
    private ProgressBar pb;
    private SubwayAllStationListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subway_all_station_list);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("选择站点");
        toolbar.setNavigationOnClickListener(view -> finish());

        rv = findViewById(R.id.subway_station_list);
        searchView = findViewById(R.id.subway_station_search);
        pb = findViewById(R.id.item_progress);

        searchView.setOnQueryTextListener(this);

        new Thread(this::initHttp).start();

    }

    private void initHttp() {
        String body = WorkOkHttp.get("/prod-api/api/metro/step/list");
        Gson gson = new Gson();
        data = gson.fromJson(body, SubwayAllStationListBean.class).getData();

        runOnUiThread(this::initList);

    }

    private void initList() {
        adapter = new SubwayAllStationListAdapter(data, this);
        rv.setLayoutManager(new GridLayoutManager(this,3));
        rv.setAdapter(adapter);
        pb.setVisibility(View.GONE);
        adapter.setMyOnClick(data1 -> {
            SubwayAllStationListBean.DataEntity nb = (SubwayAllStationListBean.DataEntity) data1;
            Bundle bundle = new Bundle();
            bundle.putString("stationName",nb.getName());
            Intent intent = new Intent();
            intent.putExtras(bundle);
            setResult(Activity.RESULT_OK,intent);
            finish();
        });
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.getFilter().filter(s);
        return false;
    }
}