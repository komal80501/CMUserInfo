package com.example.cm.cmuserinfo.Services;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class CountryList {
    @SerializedName("result")
    private ArrayList<Country> countryList;

    public ArrayList<Country> getCountryList() {
        return countryList;
    }
    public void setCountryList(ArrayList<Country> countryList)
    {
        this.countryList=countryList;
    }
}
