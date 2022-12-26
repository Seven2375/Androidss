package com.huangxue.s01.Utils;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.huangxue.s01.Beans.BannerListBean;
import com.huangxue.s01.Beans.NewsContentBean;
import com.huangxue.s01.Beans.NewsListBean;
import com.huangxue.s01.Beans.ServicesListBean;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class WorkOkHttp {

    public static final OkHttpClient okHttpClient = new OkHttpClient();
    private final static String Url = "http://124.93.196.45:10001";

    public static String get(String path){
        Request request = new Request.Builder().url(Url + path).build();
        String string = null;
        try {
            string = okHttpClient.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
    public static String get(String path,String token){
        Request request = new Request.Builder().url(Url + path).header("Authorization",token).build();
        String string = null;
        try {
            string = okHttpClient.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static String post(String path, JsonObject jsonObject, MediaType type, String token){
        String string = null;
        Request request = new Request.Builder()
                .url(Url + path)
                .header("Authorization",token)
                .post(RequestBody.create(type, String.valueOf(jsonObject)))
                .build();
        try {
            string = okHttpClient.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }

    public static String upload(String path, File file,String token){
        String string = null;
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file",file.getName(),
                        RequestBody.create(MediaType.parse("multipart/form-data"),file))
                .build();
        Request request = new Request.Builder()
                .post(requestBody)
                .header("Authorization",token)
                .url(Url+path)
                .build();
        try {
            string = okHttpClient.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG", "upload: "+e.toString());
        }
        return string;
    }

    public static String put(String path, String token,JsonObject jsonObject){
        String string = null;
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, String.valueOf(jsonObject));
        Request request = new Request.Builder()
                .url(Url + path)
                .put(body)
                .header("Authorization",token)
                .build();
        try {
            string = okHttpClient.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG", "put: "+e.toString());
        }
        return string;
    }
    public static String put(String path, String token){
        String string = null;
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, "JsonString");
        Request request = new Request.Builder()
                .url(Url + path)
                .put(body)
                .header("Authorization",token)
                .build();
        try {
            string = okHttpClient.newCall(request).execute().body().string();
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("TAG", "put: "+e.toString());
        }
        return string;
    }

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
