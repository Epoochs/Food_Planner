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

    @GET("list.php?c=list")
    Call<MealResponse> getByCategory();

    @GET("list.php")
    Call<MealResponse> getByFilteredIngredients(@Query("i") String ingredients);

    @GET("list.php")
    Call<MealResponse> getByFilteredCountry(@Query("a") String Country);

    @GET("list.php")
    Call<MealResponse> getByFilteredCategory(@Query("c") String Category);
}
