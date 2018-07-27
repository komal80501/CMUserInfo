package com.example.cm.cmuserinfo.Services;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sample {
    @SerializedName("RestResponse")
    @Expose
    private RestResponse restResponse;

    public RestResponse getRestResponse() {
        return restResponse;
    }

    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }
}
