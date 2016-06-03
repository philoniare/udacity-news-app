package com.example.philoniare.newsapp.NewsApi;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsApiEntry {
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("contentSnippet")
    @Expose
    private String contentSnippet;
    @SerializedName("link")
    @Expose
    private String link;

    /**
     *
     * @return
     * The url
     */
    public String getUrl() {
        return url;
    }

    /**
     *
     * @param url
     * The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The contentSnippet
     */
    public String getContentSnippet() {
        return contentSnippet;
    }

    /**
     *
     * @param contentSnippet
     * The contentSnippet
     */
    public void setContentSnippet(String contentSnippet) {
        this.contentSnippet = contentSnippet;
    }

    /**
     *
     * @return
     * The link
     */
    public String getLink() {
        return link;
    }

    /**
     *
     * @param link
     * The link
     */
    public void setLink(String link) {
        this.link = link;
    }

}
