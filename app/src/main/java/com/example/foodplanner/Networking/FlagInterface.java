package com.example.foodplanner.Networking;

import com.example.foodplanner.Model.CountryCode;

import retrofit2.Call;
import retrofit2.http.GET;

interface FlagInterface {
    @GET("en/codes.json")
    Call<CountryCode> getAllFlags();
}
