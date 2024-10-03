package com.example.foodplanner.Networking;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MealInterface {
    @GET("random.php")
    Call<MealResponse> getRandomMeal();

    @GET("list.php?i=list")
    Call<MealResponse> getByIngredients();

    @GET("list.php?a=list")
    Call<MealResponse> getByCountry();

    @GET("categories.php")
    Call<MealResponse> getByCategory();

    @GET("search.php")
    Call<MealResponse> getByName(@Query("s") String name);

    @GET("filter.php")
    Call<MealResponse> getByFilteredIngredients(@Query("i") String ingredients);

    @GET("filter.php")
    Call<MealResponse> getByFilteredCountry(@Query("a") String Country);

    @GET("filter.php")
    Call<MealResponse> getByFilteredCategory(@Query("c") String Category);
}
