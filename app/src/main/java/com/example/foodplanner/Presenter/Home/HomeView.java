package com.example.foodplanner.Presenter.Home;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;

import java.util.Calendar;
import java.util.List;

public interface HomeView {
    void showDataMealInsp(List<Meals> meals);
    void showDataMealCat(List<Categories> categories);
    void showDataMealIng(List<Meals> meals);
    void showDataMealCount(List<Meals> meals);
}
