package com.example.myapplication.weather.models;

import com.google.gson.annotations.SerializedName;

public class Sys {
    @SerializedName("type")
    private float type;
    @SerializedName("id")
    private float id;
    @SerializedName("message")
    private float message;
    @SerializedName("country")
    private String country;
    @SerializedName("sunrise")
    private float sunrise;
    @SerializedName("sunset")
    private float sunset;


    // Getter Methods

    public float getType() {
        return type;
    }

    public float getId() {
        return id;
    }

    public float getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public float getSunrise() {
        return sunrise;
    }

    public float getSunset() {
        return sunset;
    }

    // Setter Methods

    public void setType(float type) {
        this.type = type;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setMessage(float message) {
        this.message = message;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSunrise(float sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(float sunset) {
        this.sunset = sunset;
    }
}
