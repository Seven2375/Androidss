package com.huangxue.s01.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.Beans.BannerListBean;
import com.huangxue.s01.Beans.NewsContentBean;
import com.huangxue.s01.Beans.ServicesListBean;
import com.huangxue.s01.Beans.NewsListBean;
import com.huangxue.s01.NewsDetailsActivity;
import com.youth.banner.Banner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Request;

public class WorkOkHttp {

    public static final OkHttpClient okHttpClient = new OkHttpClient();
    private final static String Url = "http://124.93.196.45:10001";

    public static List<ServicesListBean.RowsEntity> getHomeServicesListDatas(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        String body = okHttpClient.newCall(request).execute().body().string();
        Gson gson = new Gson();
        ServicesListBean json = gson.fromJson(body, ServicesListBean.class);
        List<ServicesListBean.RowsEntity> rows = json.getRows();
        return rows;
    }
    public static List<NewsListBean.RowsEntity> getHomeNewsListDatas(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        String body = okHttpClient.newCall(request).execute().body().string();
        Gson gson = new Gson();
        NewsListBean json = gson.fromJson(body, NewsListBean.class);
        List<NewsListBean.RowsEntity> rows = json.getRows();
        return rows;
    }
    public static NewsContentBean.DataEntity getNewsContent(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        String body = okHttpClient.newCall(request).execute().body().string();
        Gson gson = new Gson();
        NewsContentBean json = gson.fromJson(body, NewsContentBean.class);
        NewsContentBean.DataEntity data = json.getData();
        return data;
    }


    //获取轮播图每张图片的url
    public static List<String> getBannerImgUrl(String url) throws IOException {
        Request request = new Request.Builder().url(url).build();
        String body = okHttpClient.newCall(request).execute().body().string();
        JsonObject asJsonObject = new JsonParser().parse(body).getAsJsonObject();
        JsonArray rows = asJsonObject.getAsJsonArray("rows");
        //创建一个列表来存放每个图片url
        List<String> imgurl = new ArrayList<>();
        for (int i = 0; i < rows.size(); i++) {
            imgurl.add(Url+rows.get(i).getAsJsonObject().get("advImg").getAsString());
        }
        return imgurl;
    }

    public static List<BannerListBean.RowsEntity> getBannerDatas(String url) throws IOException {
        Request request = new Request.Builder().url(url).get().build();
        String string = okHttpClient.newCall(request).execute().body().string();
        Gson gson = new Gson();
        BannerListBean fromJson = gson.fromJson(string, BannerListBean.class);
        List<BannerListBean.RowsEntity> rows = fromJson.getRows();
        return rows;
    }

}
