package com.example.foodplanner.Presenter.Details;

import android.app.AlertDialog;
import android.content.Context;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Repository;
import com.example.foodplanner.Networking.Client;
import com.example.foodplanner.Networking.NetworkCallback;
import com.example.foodplanner.Presenter.Category.CatView;

import java.util.List;

public class DetailsPresenter implements NetworkCallback {
    DetailedView detailedView;
    Client client;
    Context context;
    Repository repository;

    public DetailsPresenter(Context context, DetailedView detailedView, String name){
        this.detailedView = detailedView;
        this.context = context;

        repository = Repository.getInstance(context);

        client = new Client();
        client.makeNetworkCallbackByName(this,name);
    }

    @Override
    public void onSuccessResult(List<Meals> mealsList) {

    }

    @Override
    public void onSuccessResultCat(List<Categories> categoriesList) {

    }

    @Override
    public void onSuccessResultName(List<Meals> mealsList) {
        detailedView.showData(mealsList.get(0));
    }

    @Override
    public void onFalureResult(String str) {
        /* Showing an alert Message as an Indication of Connection Problem */
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Error").setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void insertMeal(Meals meal){
        repository.addProduct(meal);
    }

    public void removeMeal(Meals meal)
    {
        repository.removeProduct(meal);
    }
}
