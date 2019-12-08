package com.example.myapplication.weather;

import com.example.myapplication.weather.models.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherInterface {
    @GET("weather")
    Call<Response> getWeather(@Query("q") String q ,  @Query("appid") String appID);

}
