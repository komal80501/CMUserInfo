package com.example.cm.cmuserinfo.Services;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Country {

    @SerializedName("name")
    @Expose
    private String CountryName;
    @SerializedName("alpha2_code")
    @Expose
    private String alpha2Code;
    @SerializedName("alpha3_code")
    @Expose
    private String alpha3Code;

    public String getCountryName() {
        return CountryName;
    }

    public void setName(String name) {
        this.CountryName = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getAlpha3Code() {
        return alpha3Code;
    }

    public void setAlpha3Code(String alpha3Code) {
        this.alpha3Code = alpha3Code;
    }

}
