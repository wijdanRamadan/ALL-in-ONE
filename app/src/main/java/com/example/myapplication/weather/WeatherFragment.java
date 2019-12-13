package com.example.myapplication.weather;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

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

        weatherService.getWeather("Istanbul" , appID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(response -> {temperature.setText(String.valueOf(response.getMain().getTemp()));
                                        country.setText(String.valueOf(response.getName()));});




    }
}

