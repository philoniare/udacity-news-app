package com.example.philoniare.newsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.philoniare.newsapp.NewsApi.NewsApiClient;
import com.example.philoniare.newsapp.NewsApi.NewsApiEntry;
import com.example.philoniare.newsapp.NewsApi.NewsApiResponse;
import com.example.philoniare.newsapp.NewsApi.NewsApiResult;
import com.example.philoniare.newsapp.NewsApi.NewsApiServiceGenerator;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static List<NewsApiEntry> newsArticles;
    @Bind(R.id.news_list) RecyclerView newsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        newsArticles= new ArrayList<>();
        newsList.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter rcAdapter = new NewsAdapter(MainActivity.this, newsArticles);
        fetchNewsArticles("technology");
    }

    private void fetchNewsArticles(String topic) {
        NewsApiClient client = NewsApiServiceGenerator.createService(NewsApiClient.class);

        Call<NewsApiResponse> call = client.fetchNews("1.1", topic);
        call.enqueue(new Callback<NewsApiResponse>() {
            @Override
            public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                if(response.isSuccessful()) {
                    NewsApiResponse res = response.body();
                    NewsApiResult resEntries = res.getResponseData();
                    for(NewsApiEntry newsArticle : resEntries.getEntries()) {
                        Log.d("API NEWS ENTRY TITLE: ", newsArticle.getTitle());
                        newsArticles.add(newsArticle);
                    }
                } else {
                    int statusCode = response.code();
                    ResponseBody errorBody = response.errorBody();
                    Log.e("Network Error: ", errorBody.toString());
                }
            }

            @Override
            public void onFailure(Call<NewsApiResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
