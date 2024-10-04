package com.example.foodplanner.Presenter.Details;

import android.app.AlertDialog;
import android.content.Context;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Day;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Relation.MealAndDayCrossRef;
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
    static DetailsPresenter detailsPresenter = null;

    public DetailsPresenter(Context context, DetailedView detailedView){
        this.detailedView = detailedView;
        this.context = context.getApplicationContext();

        repository = Repository.getInstance(context);
    }

    public static DetailsPresenter getInstance(Context context, DetailedView detailedView){
        //if(detailsPresenter == null){
            detailsPresenter = new DetailsPresenter(context,detailedView);
       // }
        return detailsPresenter;
    }

    @Override
    public void onSuccessResult(List<Meals> mealsList) {

    }

    @Override
    public void onSuccessResultCat(List<Categories> categoriesList) {

    }

    @Override
    public void onSuccessResultCount(List<Meals> mealsList) {

    }

    @Override
    public void onSuccessResultIngred(List<Meals> mealsList) {

    }

    @Override
    public void onSuccessResultName(List<Meals> mealsList) {
        detailedView.showData(mealsList.get(0));
    }

    @Override
    public void onSuccessResultFilterCat(List<Meals> mealsList) {
        detailedView.showData(mealsList);
    }

    @Override
    public void onSuccessResultFilterIngred(List<Meals> mealsList) {

    }

    @Override
    public void onSuccessResultFilterCount(List<Meals> mealsList) {

    }

    @Override
    public void onFalureResult(String str) {
        /* Showing an alert Message as an Indication of Connection Problem */
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Error").setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onNotFound(String str) {

    }

    public void insertMeal(Meals meal){
        repository.addProduct(meal);
    }

    public void removeMeal(Meals meal)
    {
        repository.removeProduct(meal);
    }

    public void getDetailedCat(String category){
        client = Client.getInstance();
        client.makeNetworkCallbackByCategoryInDetails(this,category);
    }

    public void getMealByName(String name){
        client = new Client();
        client.makeNetworkCallbackByName(this,name);
    }

    public void addMealDay(Meals meals, Day day){
        System.out.println(day.getDay());
        repository.addMealDay(new MealAndDayCrossRef(meals.getIdMeal(), day.getDay()));
    }

    public void insertDay(Day day){
        repository.addDay(day);
    }
}
