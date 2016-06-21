package com.example.philoniare.newsapp.GuardianAPI;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GuardianMain {
    @SerializedName("response")
    @Expose
    private GuardianResponse response;

    /**
     *
     * @return
     * The response
     */
    public GuardianResponse getResponse() {
        return response;
    }

    /**
     *
     * @param response
     * The response
     */
    public void setResponse(GuardianResponse response) {
        this.response = response;
    }
}
