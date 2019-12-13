package com.example.myapplication.weather;

import com.example.myapplication.weather.models.Response;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherInterface {
    @GET("weather")
    Observable<Response> getWeather(@Query("q") String q
            , @Query("appid") String appID);

}
