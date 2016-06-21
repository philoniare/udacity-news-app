package com.example.philoniare.newsapp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.philoniare.newsapp.GuardianAPI.GuardianClient;
import com.example.philoniare.newsapp.GuardianAPI.GuardianMain;
import com.example.philoniare.newsapp.GuardianAPI.GuardianResponse;
import com.example.philoniare.newsapp.GuardianAPI.GuardianResult;
import com.example.philoniare.newsapp.GuardianAPI.GuardianServiceGenerator;
import com.example.philoniare.newsapp.R;
import com.example.philoniare.newsapp.adapter.NewsAdapter;
import com.example.philoniare.newsapp.model.NewsArticle;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    public static List<NewsArticle> newsArticles;
    @Bind(R.id.news_list) RecyclerView newsList;
    @Bind(R.id.empty_view) TextView emptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        newsArticles= new ArrayList<>();
        newsList.setLayoutManager(new LinearLayoutManager(this));
        NewsAdapter newsAdapter = new NewsAdapter(MainActivity.this, newsArticles);
        newsList.setAdapter(newsAdapter);
        fetchNewsArticles("artificialintelligenceai");
    }

    private void reDrawRecyclerView() {
        if(newsArticles.isEmpty()) {
            newsList.setVisibility(View.GONE);
            emptyView.setVisibility(View.VISIBLE);
        } else {
            newsList.setVisibility(View.VISIBLE);
            emptyView.setVisibility(View.GONE);
        }
        newsList.getAdapter().notifyDataSetChanged();
    }

    private void fetchNewsArticles(String topic) {
        GuardianClient client = GuardianServiceGenerator.createService(GuardianClient.class);
        String API_KEY = "4d5e77df-caa0-4fdd-9e96-eae89d4f8276";
        String SHOW_FIELDS = "thumbnail";
        Call<GuardianMain> call = client.fetchNews(topic, API_KEY, SHOW_FIELDS);
        call.enqueue(new Callback<GuardianMain>() {
            @Override
            public void onResponse(Call<GuardianMain> call, Response<GuardianMain> mainResponse) {
                if(mainResponse.isSuccessful()) {
                    GuardianResponse res = mainResponse.body().getResponse();
                    List<GuardianResult> apiResults = res.getResults();
                    for(GuardianResult apiResult: apiResults) {
                        String thumbnail = "";
                        if (apiResult.getFields() != null) {
                            thumbnail = apiResult.getFields().getThumbnail();
                        }

                        newsArticles.add(new NewsArticle(apiResult.getWebTitle(),
                                apiResult.getSectionName(), thumbnail,
                                apiResult.getWebUrl()));
                    }
                    reDrawRecyclerView();
                } else {
                    int statusCode = mainResponse.code();
                    ResponseBody errorBody = mainResponse.errorBody();
                    Log.e("Network Error: ", errorBody.toString());
                }
            }

            @Override
            public void onFailure(Call<GuardianMain> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
