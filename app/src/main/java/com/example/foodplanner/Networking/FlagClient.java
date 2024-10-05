package com.example.foodplanner.Networking;

import android.util.Log;

import androidx.annotation.NonNull;

import com.example.foodplanner.Model.CountryCode;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlagClient {
    private static final String BASE_URL = "https://flagcdn.com/";
    private FlagInterface flagInterface;
    private static FlagClient flagclient = null;
    Retrofit retrofit;

    public FlagClient() {
        retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();
        flagInterface = retrofit.create(FlagInterface.class);
    }

    public static FlagClient getInstance() {
        if (flagclient == null) {
            flagclient = new FlagClient();
        }
        return flagclient;
    }

    public void makeNetworkCallbackFlag(NetworkCallback networkCallback) {
        Call<CountryCode> call = flagInterface.getAllFlags();
        call.enqueue(new Callback<CountryCode>() {
            @Override
            public void onResponse(@NonNull Call<CountryCode> call, @NonNull Response<CountryCode> response) {
                System.out.println("----------------------------Response----------------------------------");
                System.out.println(response.body());
                networkCallback.onSuccessResultFlags(response.body());
                Log.i("AllProduct", "OnResponse: CallBack " + response.raw() + response.body());
            }

            @Override
            public void onFailure(Call<CountryCode> call, Throwable throwable) {
                networkCallback.onFalureResult("Fail");
                Log.e("API Error", "Failed to fetch meal", throwable);
            }
        });
    }
}
