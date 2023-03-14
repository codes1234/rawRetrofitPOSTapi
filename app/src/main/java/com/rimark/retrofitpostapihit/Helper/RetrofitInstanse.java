package com.rimark.retrofitpostapihit.Helper;

import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstanse {
    public static Retrofit retrofit;
    public static Retrofit getRetrofitInstance(){

        if (retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(Constraints.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                    .build();
        }
        return retrofit;
    }

    //        HttpLoggingInterceptor httpLoggingInterceptor=new HttpLoggingInterceptor();
//        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        OkHttpClient okHttpClient=new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();
   /* public static ApiInterface getUserServices(){
        ApiInterface userservice=getRetrofitInstance().create(ApiInterface.class);
        return userservice;
    }*/
}
