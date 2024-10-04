package com.example.foodplanner.Presenter.Planner;

import android.content.Context;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Repository;
import com.example.foodplanner.Networking.Client;
import com.example.foodplanner.Networking.NetworkCallback;

import java.util.List;

public class PlannerPresenter{
    PlannerView plannerView;
    Context context;
    List<Meals> mealsList;
    Repository repository;

    public PlannerPresenter(Context context, PlannerView plannerView){
        this.context = context;
        this.plannerView = plannerView;
        repository = Repository.getInstance(context);
    }

    public void removeFromPlanner(Meals meals){
        /* removing item from an entity will cause the junction table to delete the record related to the id of that item*/
        repository.removeProduct(meals);
    }
}
