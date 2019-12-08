package com.example.myapplication.weather.models;

import com.google.gson.annotations.SerializedName;

public class Clouds {

        @SerializedName("all")
        private float all;

        // Getter Methods

    public float getAll() {
            return all;
        }

        // Setter Methods

        public void setAll(float all) {
            this.all = all;
        }
    }

