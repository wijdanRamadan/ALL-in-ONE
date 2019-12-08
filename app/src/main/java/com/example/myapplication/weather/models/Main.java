package com.example.myapplication.weather.models;

import com.google.gson.annotations.SerializedName;

public class Main {

        @SerializedName("temp")
        private String temp;
        @SerializedName("pressure")
        private float pressure;
        @SerializedName("humidity")
        private float humidity;
        @SerializedName("temp_min")
        private float temp_min;
        @SerializedName("temp_max")
        private float temp_max;


        // Getter Methods

        public String getTemp() {
            return temp;
        }

        public float getPressure() {
            return pressure;
        }

        public float getHumidity() {
            return humidity;
        }

        public float getTemp_min() {
            return temp_min;
        }

        public float getTemp_max() {
            return temp_max;
        }

        // Setter Methods

        public void setTemp(String temp) {
            this.temp = temp;
        }

        public void setPressure(float pressure) {
            this.pressure = pressure;
        }

        public void setHumidity(float humidity) {
            this.humidity = humidity;
        }

        public void setTemp_min(float temp_min) {
            this.temp_min = temp_min;
        }

        public void setTemp_max(float temp_max) {
            this.temp_max = temp_max;
        }
    }
