package com.example.philoniare.newsapp.GuardianAPI;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GuardianClient {
    @GET("search")
    Call<GuardianMain> fetchNews(@Query("q") String topic,
                                     @Query("api-key") String API_KEY,
                                     @Query("show-fields") String SHOW_FIELDS);
}
