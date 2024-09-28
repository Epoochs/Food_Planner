package com.example.foodplanner.Presenter.Home;

import android.app.AlertDialog;
import android.content.Context;

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

    public HomePresenter(Context context, HomeView homeView){
        this.context = context;
        this.homeView = homeView;
        repository = Repository.getInstance(context);

        Client client = Client.getInstance();
        client.makeNetworkCallbackRandom(this);
    }

    public static HomePresenter getHomeInstance(Context context, HomeView homeView){
        if(homePresenter == null){
            homePresenter = new HomePresenter(context,homeView);
        }else{
            homeView.showData(meals);
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
            homeView.showData(mealsList);
        else{
            System.out.println("Meals are null -> OnSuccessResult");
        }
    }

    @Override
    public void onSuccessResultCat(List<Categories> categoriesList) {

    }

    @Override
    public void onFalureResult(String str) {
        /* Showing an alert Message as an Indication of Connection Problem */
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Error").setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
