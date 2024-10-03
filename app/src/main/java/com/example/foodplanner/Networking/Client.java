package com.example.foodplanner.Networking;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.foodplanner.Model.Meals;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* Meal Remote Data Storage */
public class Client {
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private MealInterface mealInterface;
    private static Client client = null;
    Retrofit retrofit;
    Date date;

    public Client() {
        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();
        mealInterface = retrofit.create(MealInterface.class);
        date = new Date();
        date.getTime();
    }

    public static Client getInstance() {
        if (client == null) {
            client = new Client();
        }
        return client;
    }

    public void makeNetworkCallbackRandom(NetworkCallback networkCallback) {
        Call<MealResponse> call = mealInterface.getRandomMeal();
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                System.out.println("----------------------------Response----------------------------------");
                networkCallback.onSuccessResult(response.body().getMealsList());
                Log.i("AllProduct", "OnResponse: CallBack " + response.raw() + response.body());
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                networkCallback.onFalureResult("Fail");
                Log.e("API Error", "Failed to fetch meal", throwable);
            }
        });

    }

    public void makeNetworkCallbackByCategory(NetworkCallback networkCallback) {
        Call<MealResponse> call = mealInterface.getByCategory();
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                System.out.println("Response");
                networkCallback.onSuccessResultCat(response.body().getCategories());
                Log.i("AllProduct", "OnResponse: CallBack " + response.raw() + response.body());
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                networkCallback.onFalureResult("Fail");
                Log.e("API Error", "Failed to fetch meal", throwable);
            }
        });
    }

    public void makeNetworkCallbackByName(NetworkCallback networkCallback, String name) {
        Call<MealResponse> call = mealInterface.getByName(name);
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                System.out.println("Response");
                networkCallback.onSuccessResultName(response.body().getMealsList());
                Log.i("AllProduct", "OnResponse: CallBack " + response.raw() + response.body());
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                networkCallback.onFalureResult("Fail");
                Log.e("API Error", "Failed to fetch meal", throwable);
            }
        });
    }

    public void makeNetworkCallbackByCategoryInDetails(NetworkCallback networkCallback, String category) {
        Call<MealResponse> call = mealInterface.getByFilteredCategory(category);
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().getMealsList() != null) {
                        System.out.println("Response");
                        networkCallback.onSuccessResultFilterCat(response.body().getMealsList());
                        System.out.println(response.body().getMealsList().get(0).getStrMeal());
                        Log.i("AllProduct", "OnResponse: CallBack " + response.raw() + response.body());
                    }else{
                        System.out.println(category + "is not found");
                        networkCallback.onNotFound(category);
                    }
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                networkCallback.onFalureResult("Fail");
                Log.e("API Error", "Failed to fetch meal", throwable);
            }
        });
    }

    public void makeNetworkCallbackByCountry(NetworkCallback networkCallback) {
        Call<MealResponse> call = mealInterface.getByCountry();
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                System.out.println("Response");
                networkCallback.onSuccessResultCount(response.body().getMealsList());
                Log.i("AllProduct", "OnResponse: CallBack " + response.raw() + response.body());
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                networkCallback.onFalureResult("Fail");
                Log.e("API Error", "Failed to fetch meal", throwable);
            }
        });
    }

    public void makeNetworkCallbackByIngred(NetworkCallback networkCallback) {
        Call<MealResponse> call = mealInterface.getByIngredients();
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                System.out.println("Response");
                networkCallback.onSuccessResultIngred(response.body().getMealsList());
                Log.i("AllProduct", "OnResponse: CallBack " + response.raw() + response.body());
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                networkCallback.onFalureResult("Fail");
                Log.e("API Error", "Failed to fetch meal", throwable);
            }
        });
    }

    public void makeNetworkCallbackByIngredFiltered(NetworkCallback networkCallback, String ingredName) {
        Call<MealResponse> call = mealInterface.getByFilteredIngredients(ingredName);
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                System.out.println("Response");
                if(response.isSuccessful() && response.body() != null) {
                    if(response.body().getMealsList() != null) {
                        networkCallback.onSuccessResultFilterIngred(response.body().getMealsList());
                        Log.i("AllProduct", "OnResponse: CallBack " + response.raw() + response.body());
                        System.out.println(response.body().getMealsList().get(0).getStrMeal());
                    }else{
                        networkCallback.onNotFound(ingredName);
                    }
                }
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                networkCallback.onFalureResult("Fail");
                Log.e("API Error", "Failed to fetch meal", throwable);
            }
        });
    }

    public void makeNetworkCallbackByCountFiltered(NetworkCallback networkCallback, String count) {
        Call<MealResponse> call = mealInterface.getByFilteredCountry(count);
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                System.out.println("Response");
                if(response.isSuccessful() && response.body() != null) {
                    if(response.body().getMealsList() != null) {
                        networkCallback.onSuccessResultFilterCount(response.body().getMealsList());
                        System.out.println(response.body().getMealsList().get(0).getStrMeal());
                        //System.out.println(response.body().getMealsList().get(0).getStrMealThumb());
                    }else{
                        networkCallback.onNotFound(count);
                    }
                }else{
                    System.out.println("Not Found");
                }
                Log.i("AllProduct", "OnResponse: CallBack " + response.raw() + response.body());
            }

            @Override
            public void onFailure(Call<MealResponse> call, Throwable throwable) {
                networkCallback.onFalureResult("Fail");
                Log.e("API Error", "Failed to fetch meal", throwable);
            }
        });
    }
}