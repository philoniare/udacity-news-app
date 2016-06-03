package com.example.philoniare.newsapp;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.philoniare.newsapp.NewsApi.NewsApiEntry;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter {
    private List<NewsApiEntry> newsArticles;
    private Context context;

    public NewsAdapter(Context context, List<NewsApiEntry> newsArticles) {
        this.newsArticles = newsArticles;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_card_list_item, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185";
        Picasso.with(context).load(BASE_IMAGE_URL + movies.get(position).getPosterPath()).into(holder.movie_poster);
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }
}
