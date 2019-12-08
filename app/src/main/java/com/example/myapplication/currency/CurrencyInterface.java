package com.example.myapplication.currency;


import com.example.myapplication.currency.model.CurrencyResponse;

import java.util.Currency;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrencyInterface {
    @GET("live")
    Call<CurrencyResponse> getCurrency(@Query("currencies") String currency  , @Query("access_key") String access_key);

}
