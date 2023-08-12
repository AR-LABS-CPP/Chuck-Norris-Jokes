package com.jokesapp.pojo;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author AR
 */
public class RandomJoke {
    @SerializedName("icon_url")
    public String icon_url;
    
    @SerializedName("id")
    public String id;
    
    @SerializedName("url")
    public String url;
    
    @SerializedName("value")
    public String value;

    @Override
    public String toString() {
        return "icon_url: " + icon_url 
                + ", id: " + id
                + ", url: " + url
                + ", value: " + value;
    }
}
