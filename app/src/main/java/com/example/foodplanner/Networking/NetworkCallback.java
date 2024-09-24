package com.example.foodplanner.Networking;

import com.example.foodplanner.Model.Meals;

import java.util.List;

public interface NetworkCallback {
    void onSuccessResult(List<Meals> mealsList);

    void onFalureResult(String str);
}
