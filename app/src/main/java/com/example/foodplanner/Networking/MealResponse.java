package com.example.foodplanner.Networking;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;

import java.util.List;

public class MealResponse {
    private List<Meals> meals;
    private List<Categories> categories;

    public MealResponse(List<Meals> mealsList, List<Categories> categoriesList) {
        this.meals = mealsList;
        this.categories = categoriesList;
    }
    public MealResponse(){}

    public List<Meals> getMealsList() {
        return meals;
    }

    public List<Categories> getCategories(){
        return categories;
    }

    public void setMealsList(List<Meals> mealsList) {
        this.meals = mealsList;
    }

    public void setCategories(List<Categories> categoriesList){
        this.categories = categoriesList;
    }
}
