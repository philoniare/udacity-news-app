package com.example.philoniare.newsapp.GuardianAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GuardianFields {
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    /**
     *
     * @return
     * The thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     *
     * @param thumbnail
     * The thumbnail
     */
    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
