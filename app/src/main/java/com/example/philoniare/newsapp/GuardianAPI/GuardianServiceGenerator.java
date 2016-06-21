package com.example.philoniare.newsapp.GuardianAPI;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GuardianServiceGenerator {
    public static final String API_BASE_URL = "http://content.guardianapis.com/";
    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Gson gson = new GsonBuilder()
            .create();

    private static Retrofit.Builder retroBuilder = new Retrofit.Builder()
            .baseUrl(API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson));

    public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = retroBuilder.client(httpClient.build()).build();
        return retrofit.create(serviceClass);
    }
}
