package com.huangxue.s01.Utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class NetworkHandler {
    private static String API = "http://124.93.196.45:10001";
    private static String IP = "124.93.196.45:10001";
    public static boolean setIP(String url) {
        if(Pattern.matches("(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\.(\\d{1,2}|1\\d\\d|2[0-4]\\d|25[0-5])\\:([0-9]|[1-9]\\d{1,3}|[1-5]\\d{4}|6[0-5]{2}[0-3][0-5])", url)){
            IP = url;
            API = "http://" + url;
            return true;
        }
        return false;
    } // 用于设置ip页
    public static String getIP() {
        return IP;
    }

    private static final OkHttpClient client = new OkHttpClient.Builder()
            .callTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build();;
    // json数据的请求类型
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    public static String uploadFile(String token, File file) {
        Request request = new Request.Builder()
                .url(API+"/prod-api/common/upload")
                .headers(new Headers.Builder().add("Authorization", token).build())
                .post(new MultipartBody.Builder()
                        .setType(MultipartBody.FORM)
                        .addFormDataPart("file", file.getName(),
                                RequestBody.create(MediaType.parse("multipart/form-data"), file))
                        .build())
                .build();

        String url = null;
        try {
            String result = client.newCall(request).execute().body().string();
            if(check(result)){
                url = API + JsonParser.parseString(result).getAsJsonObject().get("fileName").getAsString();
            }
        }catch (Exception e){e.printStackTrace();}
        return url;
    }

    public static void put(Handler handler, int what, String url, Headers.Builder heads, JsonObject json) {
        new Thread(()->{
            try {
                Message.obtain(handler, what, put(url, heads, json)).sendToTarget();
            } catch (IOException e) {
                e.printStackTrace();
                Message.obtain(handler, 404).sendToTarget();
            }
        }).start();
    }

    public static String put(String url, Headers.Builder heads, JsonObject json) throws IOException {
        url = checkURL(url);
        Request.Builder request = new Request.Builder()
                .url(url)
                .put(RequestBody.create(JSON, String.valueOf(json)));// 将数据放入body

        if(heads!=null) request.headers(heads.build());

        return client.newCall(request.build()).execute().body().string();
    }

    public static void get(Handler handler, int what, String url) {
        new Thread(()->{
            try {
                Message.obtain(handler, what, get(url)).sendToTarget();
            } catch (IOException e) {
                e.printStackTrace();
                Message.obtain(handler, 404).sendToTarget();
            }
        }).start();
    }

    public static String get(String url) throws IOException {
        url = checkURL(url);
        Request request = new Request.Builder()
                .url(url)
                .build();
        return client.newCall(request).execute().body().string();
    }

    // 使用异步处理请求并发送到handler
    public static void post(Handler handler, int what, String url, JsonObject json) {
        new Thread(()->{
            try {
                Message.obtain(handler, what, post(url, json)).sendToTarget();
            } catch (IOException e) {
                e.printStackTrace();
                Message.obtain(handler, 404).sendToTarget();
            }
        }).start();
    }

    public static String post(String url, JsonObject json) throws IOException {
        url = checkURL(url);
        Request request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON, String.valueOf(json)))// 将数据放入body
                .build();
        return client.newCall(request).execute().body().string();
    }

    public static String post(String url, Headers.Builder heads, FormBody.Builder form) throws IOException {
        url = checkURL(url);
        Request.Builder request = new Request.Builder()
                .url(url)
                .post(form.build());// 将数据放入body
        if(heads!=null){
            request.headers(heads.build());
        }
        return client.newCall(request.build()).execute().body().string();
    }

    public static String post(String url, Headers.Builder heads, JsonObject json) throws IOException {
        url = checkURL(url);
        Request.Builder request = new Request.Builder()
                .url(url)
                .post(RequestBody.create(JSON, String.valueOf(json)));// 将数据放入body
        if(heads!=null){
            request.headers(heads.build());
        }
        return client.newCall(request.build()).execute().body().string();
    }

    public static String get(String url, Headers.Builder heads) throws IOException {
        url = checkURL(url);
        Request.Builder request = new Request.Builder()
                .url(url);// 将数据放入body
        if(heads!=null){
            request.headers(heads.build());
        }
        return client.newCall(request.build()).execute().body().string();
    }

    // 获取失败后返回的图片
    public static final Bitmap failBitmap = BitmapFactory.decodeResource(Resources.getSystem(), android.R.drawable.ic_menu_report_image);
    public static void getBitmap(Handler handler, int what, String imgUrl){
        new Thread(()->{
            try {
                Message.obtain(handler, what, getBitmap(imgUrl)).sendToTarget();
            } catch (IOException e) {
                e.printStackTrace();
                Message.obtain(handler, 404).sendToTarget();
            }
        }).start();
    }

    public static Bitmap getBitmap(JsonObject json, String key) {
        Bitmap bitmap;
        try{
            bitmap = getBitmap(json.get(key).getAsString());
        }catch (Exception e){
            e.printStackTrace();
            bitmap = failBitmap;
        }
        return bitmap;
    }

    public static Bitmap getBitmap(String urlStr) throws IOException {
        urlStr = checkURL(urlStr);

        URLConnection conn = new URL(urlStr).openConnection();// 创建网络连接
        conn.setDoInput(true);
        conn.connect();
        Bitmap bitmap;
        try{
            try(InputStream is = conn.getInputStream()){// 使用try-resource获取图像的字符流并自动关闭
                bitmap = BitmapFactory.decodeStream(is);// 从流反序列为bitmap
            }
        }catch (Exception e){
            e.printStackTrace();
            bitmap = failBitmap;
        }
        return bitmap;
    }

    public static boolean check(String result) {
        if(result==null
        || result.isEmpty()
        || "null".equalsIgnoreCase(result)) {
            return false;
        } // 检查返回的是否是404 not found
        JsonObject json;
        try {
            json = JsonParser.parseString(result).getAsJsonObject();
        }catch (Exception e){return false;}
        return json.has("code") && json.get("code").getAsInt() == 200;
    }

    private static String checkURL(String url){
        url = url.startsWith("http") ? url : url.startsWith("/") ? url : "/"+url;
        url = url.startsWith("http") ? url : API+url;

        if(!url.startsWith(API)){
            String url_t = url.substring(url.indexOf("://"));
            url_t = url_t.substring(url_t.indexOf("/"));
            url = API + url_t;
        }
        return url;
    }
}
