package com.example.foodplanner.Presenter.Ingredients;

import com.example.foodplanner.Model.Meals;

import java.util.List;

public interface IngredView {
    void showDataIngred(List<Meals> mealsList);
    void showDataDetailedIngred(List<Meals> mealsList);
    void clearData();
}
