package com.example.philoniare.newsapp.NewsApi;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface NewsApiClient {
    @GET("find")
    Call<NewsApiResponse> fetchNews(@Query("v") String version, @Query("q") String topic);
}
