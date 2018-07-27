package com.example.cm.cmuserinfo.Services;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface CountryDataService {

    @Headers("Content-Type: application/json")
    @GET("country/get/all")
    Call<Sample> getCountryData();
}
