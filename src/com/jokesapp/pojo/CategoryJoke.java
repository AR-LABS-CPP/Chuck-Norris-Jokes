package com.jokesapp.pojo;

import com.google.gson.annotations.SerializedName;

/**
 *
 * @author AR
 */
public class CategoryJoke {
    @SerializedName("categories")
    public String[] categories;
    
    @SerializedName("created_at")
    public String created_at;
    
    @SerializedName("updated_at")
    public String updated_at;
    
    @SerializedName("icon_url")
    public String icon_url;
    
    @SerializedName("id")
    public String id;
    
    @SerializedName("url")
    public String url;
    
    @SerializedName("value")
    public String value;
}
