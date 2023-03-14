package com.rimark.retrofitpostapihit.Helper;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface MyApi {

    @Headers("Authorization: nispl-123")
    @POST("UserLogin")
    Call<JsonArray> login(@Body JsonObject jsonObject);


}
