package com.jokesapp.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *
 * @author AR
 */
public class APIClient {
    private APIClient() {}
    
    private static Retrofit INSTANCE;
    
    public static Retrofit getClient() {
        if(INSTANCE == null) {
            INSTANCE = new Retrofit.Builder()
                    .baseUrl("https://api.chucknorris.io/jokes/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        
        return INSTANCE;
    }
}
