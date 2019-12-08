package com.example.myapplication.currency.model;

import com.google.gson.annotations.SerializedName;

public class Quotes {

        @SerializedName("USDTRY")
        private float USDTRY;
        @SerializedName("USDEUR")
        private float USDEUR;
        @SerializedName("USDAMD")
        private float USDMAD;
        @SerializedName("USDGPB")
        private float USDGPB;
        @SerializedName("USDPLN")
        private float USDPLN;

    public float getUSDEUR() {
        return USDEUR;
    }

    public void setUSDEUR(float USDEUR) {
        this.USDEUR = USDEUR;
    }

    public float getUSDMAD() {
        return USDMAD;
    }

    public void setUSDMAD(float USDMAD) {
        this.USDMAD = USDMAD;
    }

    public float getUSDGPB() {
        return USDGPB;
    }

    public void setUSDGPB(float USDGPB) {
        this.USDGPB = USDGPB;
    }

    public float getUSDPLN() {
        return USDPLN;
    }

    public void setUSDPLN(float USDPLN) {
        this.USDPLN = USDPLN;
    }



    public float getEUR() {
        return USDEUR;
    }

    public void setEUR(float EUR) {
        this.USDEUR = EUR;
    }



        // Getter Methods

        public float getUSDTRY() {
            return USDTRY;
        }

        // Setter Methods

        public void setUSDTRY(float USDTRY) {
            this.USDTRY = USDTRY;
        }
}
