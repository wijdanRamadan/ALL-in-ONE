package com.example.myapplication.currency.model;

import com.google.gson.annotations.SerializedName;

public class CurrencyResponse{
    @SerializedName("success")
    private boolean success;
    @SerializedName("terms")
    private String terms;
    @SerializedName("privacy")
    private String privacy;
    @SerializedName("timestamp")
    private float timestamp;
    @SerializedName("source")
    private String source;
    @SerializedName("quotes")
    Quotes quotes;


    // Getter Methods

    public boolean getSuccess() {
        return success;
    }

    public String getTerms() {
        return terms;
    }

    public String getPrivacy() {
        return privacy;
    }

    public float getTimestamp() {
        return timestamp;
    }

    public String getSource() {
        return source;
    }

    public Quotes getQuotes() {
        return quotes;
    }

    // Setter Methods

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTerms(String terms) {
        this.terms = terms;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public void setTimestamp(float timestamp) {
        this.timestamp = timestamp;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setQuotes(Quotes quotesObject) {
        this.quotes = quotesObject;
    }
}

