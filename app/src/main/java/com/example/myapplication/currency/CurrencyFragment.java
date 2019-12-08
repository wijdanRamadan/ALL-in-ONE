package com.example.myapplication.currency;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.currency.model.CurrencyResponse;
import com.example.myapplication.currency.model.Quotes;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyFragment extends Fragment {
    TextView turkishLira , euro , AMD , PLN,GPB;
    final String access_key = "e94fab2eda3b50953acd1683348bc6b6";

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.currency_fragment_layout,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        turkishLira=getActivity().findViewById(R.id.lira);
        euro=getActivity().findViewById(R.id.euro);
        AMD=getActivity().findViewById(R.id.armenia);
        GPB=getActivity().findViewById(R.id.uk);
        PLN=getActivity().findViewById(R.id.poland);

        final CurrencyInterface currencyService = CurrencyClient.getClient().create(CurrencyInterface.class);
        Call<CurrencyResponse> call =      currencyService.getCurrency("TRY,EUR,PLN,GPB,AMD" , access_key);
        call.enqueue(new Callback<CurrencyResponse>() {
            @Override
            public void onResponse(Call<CurrencyResponse> call, Response<CurrencyResponse> response) {
                if(response!=null) {
                    turkishLira.setText(String.valueOf(response.body().getQuotes().getUSDTRY()));
                    euro.setText(String.valueOf(response.body().getQuotes().getEUR()));
                    AMD.setText(String.valueOf(response.body().getQuotes().getUSDMAD()));
                    GPB.setText(String.valueOf(response.body().getQuotes().getUSDGPB()));
                    PLN.setText(String.valueOf(response.body().getQuotes().getUSDPLN()));
                }
            }

            @Override
            public void onFailure(Call<CurrencyResponse> call, Throwable t) {

            }
        });
    }
}
