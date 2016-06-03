package com.example.philoniare.newsapp.NewsApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class NewsApiResult {
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("entries")
    @Expose
    private List<NewsApiEntry> entries = new ArrayList<NewsApiEntry>();

    /**
     *
     * @return
     * The query
     */
    public String getQuery() {
        return query;
    }

    /**
     *
     * @param query
     * The query
     */
    public void setQuery(String query) {
        this.query = query;
    }

    /**
     *
     * @return
     * The entries
     */
    public List<NewsApiEntry> getEntries() {
        return entries;
    }

    /**
     *
     * @param entries
     * The entries
     */
    public void setEntries(List<NewsApiEntry> entries) {
        this.entries = entries;
    }

}
