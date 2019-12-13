package com.example.myapplication.news;

import com.example.myapplication.news.models.NewsModel;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsInterface {
    @GET("top-headlines")
    Observable<NewsModel> getLatestNews(@Query("top-headlines") String topHeadlines
            , @Query("country") String country
            , @Query("apiKey") String apiKey);
}
