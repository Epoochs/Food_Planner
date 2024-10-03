package com.example.foodplanner.Presenter.Category;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;

import java.util.List;

public interface CatView {
    void showDataByCat(List<Categories> categoriesList);
    void showDataByCatDetailed(List<Meals> mealsList);
    void clearData();
}
