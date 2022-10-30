package com.unix.radiojavan.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private ApiClient() {
    }

    public static Retrofit retrofit = null;

    public static Retrofit getRetrofit() {

        if (retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl("http://flutterapps.ir/apps/radiojavan/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();}

        return retrofit;
    }

}
