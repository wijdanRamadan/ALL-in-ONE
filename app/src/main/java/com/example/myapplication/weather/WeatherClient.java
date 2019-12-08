package com.example.myapplication.weather;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherClient {
    public static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";

    private static Retrofit retrofit = null;
    public static Retrofit getWeatherClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
