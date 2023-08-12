package com.jokesapp.api;

import com.jokesapp.pojo.CategoryJoke;
import com.jokesapp.pojo.RandomJoke;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 *
 * @author AR
 */
public interface APIInterface {
    @GET("random")
    Call<RandomJoke> getRandomJoke();
    
    @GET("categories")
    Call<String[]> getCategories();
    
    @GET("random")
    Call<CategoryJoke> getRandomJokeOfCategory(@Query("category") String category);
}
