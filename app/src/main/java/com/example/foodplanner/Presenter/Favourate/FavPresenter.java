package com.example.foodplanner.Presenter.Favourate;

import android.content.Context;

import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Repository;

public class FavPresenter {
    FavView favView;
    Repository repository;

    public FavPresenter(Context context, FavView favView){
        repository = Repository.getInstance(context);
        this.favView = favView;
    }

    public void removeMeal(Meals meal){
        repository.removeProduct(meal);
    }
}
