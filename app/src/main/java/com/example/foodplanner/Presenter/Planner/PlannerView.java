package com.example.foodplanner.Presenter.Planner;

import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Relation.DayWithMeal;

import java.util.List;

public interface PlannerView {
    void showDate(List<Meals> meals);
}
