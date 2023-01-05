package com.huangxue.s01.Utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class Tools {

    public static void setImg(Context context, Object path, ImageView imageView){
        String Url = "http://124.93.196.45:10001";
        Glide.with(context).load(Url+path).into(imageView);
    }
    public static void setUserImg(Context context, Object path, ImageView imageView){
        String Url = "http://124.93.196.45:10001";
        String imgUrl = (String) path;

        if (imgUrl.contains("/prod-api")){
            imgUrl = imgUrl;
        }else{
            imgUrl = "/prod-api"+imgUrl;
        }

        Glide.with(context).load(Url+imgUrl).into(imageView);
    }

}
