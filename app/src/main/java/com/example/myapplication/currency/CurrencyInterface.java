package com.example.myapplication.currency;

import com.example.myapplication.currency.model.CurrencyResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CurrencyInterface {
    @GET("live")
    Observable<CurrencyResponse> getCurrency(@Query("currencies") String currency
            , @Query("access_key") String access_key);

}
