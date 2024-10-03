package com.example.foodplanner.Presenter.Details;

import com.example.foodplanner.Model.Meals;

import java.util.ArrayList;
import java.util.List;

public interface DetailedView {
    void showData(Meals meals);
    void showData(List<Meals> mealsList);
}
