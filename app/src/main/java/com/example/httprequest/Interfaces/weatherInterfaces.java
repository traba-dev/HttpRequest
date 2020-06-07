package com.example.httprequest.Interfaces;

import com.example.httprequest.Model.City;
import com.example.httprequest.Model.Ciudad;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface weatherInterfaces {

    @GET("weather")
    Call<City> getCity(@Query("q") String city, @Query("appid") String key);

    @GET("weather")
    Call<City> getCityCelsius(@Query("q") String city, @Query("appid") String key,@Query("units") String value);

    @GET("weather")
    Call<Ciudad> getCiudadCelsius(@Query("q") String city, @Query("appid") String key, @Query("units") String value);
}
