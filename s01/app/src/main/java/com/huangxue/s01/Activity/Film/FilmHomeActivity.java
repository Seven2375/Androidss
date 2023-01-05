package com.huangxue.s01.Activity.Film;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.SearchView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.huangxue.s01.Adatper.FilmListAdapter;
import com.huangxue.s01.Beans.FilmListBean;
import com.huangxue.s01.R;
import com.huangxue.s01.Utils.WorkOkHttp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

public class FilmHomeActivity extends AppCompatActivity {

    private Banner banner;
    private RecyclerView filmList;
    private SearchView search;
    private List<FilmListBean.RowsEntity> filmListRows;
    private ProgressBar pb;
    private List<String> bannerUrl;
    private FilmListAdapter filmListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_home);

        Toolbar toolbar = findViewById(R.id.toolbar_back);
        toolbar.setTitle("看电影");
        toolbar.setNavigationOnClickListener(view -> finish());

        initView();

        new Thread(()->{
            initHttp();
        }).start();
    }

    private void initHttp() {
        String bannerBody = WorkOkHttp.get("/prod-api/api/movie/rotation/list");
        String filmBody = WorkOkHttp.get("/prod-api/api/movie/film/list");
        String Url = "http://124.93.196.45:10001";
        Gson gson = new Gson();
        filmListRows = gson.fromJson(filmBody, FilmListBean.class).getRows();
        bannerUrl = new ArrayList<>();
        JsonArray bannerRows = new JsonParser().parse(bannerBody).getAsJsonObject().get("rows").getAsJsonArray();
        for (int i = 0; i < bannerRows.size(); i++) {
            bannerUrl.add(Url+bannerRows.get(i).getAsJsonObject().get("advImg").getAsString());
        }
        runOnUiThread(()->{
            initBanner();
            initFilmList();
            pb.setVisibility(View.GONE);
        });

    }

    private void initBanner() {
        ImageLoader imageLoader = new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                Glide.with(context)
                        .load(path)
                        .apply(RequestOptions.bitmapTransform(new RoundedCorners(30)))
                        .into(imageView);
            }
        };
        banner.setImageLoader(imageLoader)
                .setImages(bannerUrl)
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .start();
    }

    private void initFilmList() {
        filmListAdapter = new FilmListAdapter(filmListRows,this);
        filmList.setLayoutManager(new StaggeredGridLayoutManager(2, LinearLayout.VERTICAL));
        filmList.setAdapter(filmListAdapter);
        filmListAdapter.setMyOnClick((i, data)->{
            int id = data.getId();
//            Log.d("TAG", "initFilmList: "+id);
            Intent intent = new Intent(this, FilmInfoActivity.class);
            intent.putExtra("id",id);
            startActivity(intent);
        });
    }

    private void initView() {
        banner = findViewById(R.id.film_home_banner);
        filmList = findViewById(R.id.film_home_filmList);
        search = findViewById(R.id.film_home_search);
        pb = findViewById(R.id.item_progress);
        SearchView sv = findViewById(R.id.film_home_search);
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                filmListAdapter.getFilter().filter(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }
}