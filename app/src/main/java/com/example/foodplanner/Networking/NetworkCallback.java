package com.example.foodplanner.Networking;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.CountryCode;
import com.example.foodplanner.Model.Meals;

import java.util.List;

public interface NetworkCallback {
    /* Random Meals */
    void onSuccessResult(List<Meals> mealsList);

    /* Lists */
    void onSuccessResultCat(List<Categories> categoriesList);
    void onSuccessResultCount(List<Meals> mealsList);
    void onSuccessResultIngred(List<Meals> mealsList);

    /* Specific Items */
    void onSuccessResultName(List<Meals> mealsList);
    void onSuccessResultFilterCat(List<Meals> mealsList);
    void onSuccessResultFilterIngred(List<Meals> mealsList);
    void onSuccessResultFilterCount(List<Meals> mealsList);

    /* Flag Response */
    void onSuccessResultFlags(CountryCode countryCode);


    /* Shared Error */
    void onFalureResult(String str);
    void onNotFound(String str);
}
