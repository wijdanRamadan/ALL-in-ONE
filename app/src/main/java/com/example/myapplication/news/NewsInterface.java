package com.example.myapplication.news;

import com.example.myapplication.news.models.NewsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsInterface {
    @GET("top-headlines")
    Call<NewsModel> getLatestNews(@Query("top-headlines") String topHeadlines,@Query("country") String country ,@Query("apiKey") String apiKey);
}
