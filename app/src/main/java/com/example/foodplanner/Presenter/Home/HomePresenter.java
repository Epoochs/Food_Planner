package com.example.foodplanner.Presenter.Home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Repository;
import com.example.foodplanner.Networking.Client;
import com.example.foodplanner.Networking.NetworkCallback;

import java.util.List;

public class HomePresenter implements NetworkCallback {
    Repository repository;
    HomeView homeView;
    Context context;
    static HomePresenter homePresenter = null;
    static List<Meals> meals;
    static List<Meals> meals2;
    static List<Meals> meals3;
    static List<Categories> categories;
    Client client;

    public HomePresenter(Context context, HomeView homeView){
        this.context = context;
        this.homeView = homeView;
        repository = Repository.getInstance(context);

        getRandomMeal();
        getAllCat();
        getAllIngred();
        getAllCount();
    }

    public static HomePresenter getHomeInstance(Context context, HomeView homeView){
        if(homePresenter == null){
            homePresenter = new HomePresenter(context,homeView);
        }else{
            homeView.showDataMealInsp(meals);
            homeView.showDataMealCat(categories);
            homeView.showDataMealCount(meals2);
            homeView.showDataMealIng(meals3);
        }
        return homePresenter;
    }

    public void addMeal(Meals meals){
        repository.addProduct(meals);
    }

    public void removeMeal(Meals meals){
        repository.removeProduct(meals);
    }

    @Override
    public void onSuccessResult(List<Meals> mealsList) {
        meals = mealsList;
        if(meals != null)
            homeView.showDataMealInsp(mealsList);
        else{
            System.out.println("Meals are null -> OnSuccessResult");
        }
    }

    @Override
    public void onSuccessResultCat(List<Categories> categoriesList) {
        categories = categoriesList;
        if (categories != null){
            homeView.showDataMealCat(categoriesList);
        }
    }

    @Override
    public void onSuccessResultCount(List<Meals> mealsList) {
        meals2 = mealsList;
        if(meals2 != null) {
            homeView.showDataMealCount(mealsList);
        }
    }

    @Override
    public void onSuccessResultIngred(List<Meals> mealsList) {
        meals3 = mealsList;
        if(meals3 != null) {
            homeView.showDataMealIng(mealsList);
        }
    }

    @Override
    public void onSuccessResultName(List<Meals> mealsList) {
    }

    @Override
    public void onSuccessResultFilterCat(List<Meals> mealsList) {

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
        builder.setMessage("Error").setTitle("An Error Occurred").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked Yes button
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User clicked No button
                dialog.dismiss();
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onNotFound(String str) {

    }

    public void getRandomMeal(){
        client = Client.getInstance();
        client.makeNetworkCallbackRandom(this);
    }

    public void getAllCat(){
        client = Client.getInstance();
        client.makeNetworkCallbackByCategory(this);
    }

    public void getAllIngred(){
        client = Client.getInstance();
        client.makeNetworkCallbackByIngred(this);
    }

    public void getAllCount(){
        client = Client.getInstance();
        client.makeNetworkCallbackByCountry(this);
    }
}
