package com.example.httprequest.Utils;

import com.example.httprequest.Interfaces.MyDes;
import com.example.httprequest.Model.Ciudad;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Utils {

    public static String getApikey() {
        return "7eda2944abdd88769b6f0429651d744b";
    }
    public static String getCity(){return "Tokyo";}
    public static String getUrl(){return "http://api.openweathermap.org/data/2.5/";}

    public static Retrofit getRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Utils.getUrl())
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static Retrofit getRetrofitDeserialize(){
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Ciudad.class, new MyDes());
        return new Retrofit.Builder()
                .baseUrl(Utils.getUrl())
                .addConverterFactory(GsonConverterFactory.create(builder.create()))
                .build();
    }
}
