package com.rimark.retrofitpostapihit.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.rimark.retrofitpostapihit.Helper.MyApi;
import com.rimark.retrofitpostapihit.Helper.RetrofitInstanse;
import com.rimark.retrofitpostapihit.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveUser();
    }

    private void saveUser() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("EmailId", "nispllko@gmail.com");
        jsonObject.addProperty("Password", "Nispl@123");

        MyApi myApi = RetrofitInstanse.getRetrofitInstance().create(MyApi.class);
        Call<JsonArray> call = myApi.login(jsonObject);
        call.enqueue(new Callback<JsonArray>() {
            @Override
            public void onResponse(Call<JsonArray> call, Response<JsonArray> response) {
                if (response.isSuccessful()) {
                    try {
                        Log.d("jdshgtu", "onResponse:" + response.body().toString());
                        JSONArray jsonArray= new JSONArray(new Gson().toJson(response.body()));
                        JSONObject jsonObject1 = jsonArray.getJSONObject(0);
                        jsonObject1.getString("UserId");
                        jsonObject1.getString("Id");
                        jsonObject1.getString("Msg");
                        Log.d("dkhgij", "onResponse: "+jsonObject1.getString("UserId"));

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
            }

            @Override
            public void onFailure(Call<JsonArray> call, Throwable t) {
                Log.d("dgsdfg", "onResponse:" + t.getLocalizedMessage());
            }
        });
    }
}