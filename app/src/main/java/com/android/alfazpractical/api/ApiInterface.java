package com.android.alfazpractical.api;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("images/latest")
    Call<JsonObject> getImages();


}
