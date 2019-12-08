package com.example.myapplication.weather;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.weather.models.Response;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

import retrofit2.Call;
import retrofit2.Callback;


public class WeatherFragment extends Fragment {

    TextView temperature, country;
    private final String appID = "74c590fcb188a399bab5c205c69a9227";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.test, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        temperature = getActivity().findViewById(R.id.city_temperature);
        country = getActivity().findViewById(R.id.city_name);

        WeatherInterface weatherService = WeatherClient.getWeatherClient().create(WeatherInterface.class);

        Call<Response> call =  weatherService.getWeather("Istanbul" , appID);
        call.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(response.body().getMain()!=null)
                temperature.setText(String.valueOf(response.body().getMain().getTemp()));
                country.setText(String.valueOf(response.body().getName()));
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {

            }
        });




    }
}

