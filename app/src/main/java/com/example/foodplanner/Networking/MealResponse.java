package com.example.foodplanner.Networking;

import com.example.foodplanner.Model.Meals;

import java.util.List;

public class MealResponse {
    private List<Meals> meals;

    public MealResponse(List<Meals> mealsList) {
        this.meals = mealsList;
    }
    public MealResponse(){}

    public List<Meals> getMealsList() {
        return meals;
    }

    public void setMealsList(List<Meals> mealsList) {
        this.meals = mealsList;
    }
}
