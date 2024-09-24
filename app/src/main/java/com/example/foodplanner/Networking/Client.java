package com.example.foodplanner.Networking;

import android.util.Log;

import androidx.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {
    private static final String BASE_URL = "https://www.themealdb.com/api/json/v1/1/";
    private MealInterface mealInterface;
    private static Client client = null;
    Retrofit retrofit;

    public Client() {
        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();
        mealInterface = retrofit.create(MealInterface.class);
    }

    public static Client getInstance() {
        if (client == null) {
            client = new Client();
        }
        return client;
    }

    public void makeNetworkCallback(NetworkCallback networkCallback) {
        Call<MealResponse> call = mealInterface.getRandomMeal();
        System.out.println("CallBack");
        call.enqueue(new Callback<MealResponse>() {
            @Override
            public void onResponse(@NonNull Call<MealResponse> call, @NonNull Response<MealResponse> response) {
                System.out.println("Response");
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
}
