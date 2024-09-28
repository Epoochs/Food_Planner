package com.example.foodplanner.Networking;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;

import java.util.List;

public interface NetworkCallback {
    void onSuccessResult(List<Meals> mealsList);
    void onSuccessResultCat(List<Categories> categoriesList);

    void onFalureResult(String str);
}
