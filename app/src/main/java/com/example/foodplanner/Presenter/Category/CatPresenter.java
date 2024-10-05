package com.example.foodplanner.Presenter.Category;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.CountryCode;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Repository;
import com.example.foodplanner.Networking.Client;
import com.example.foodplanner.Networking.NetworkCallback;
import com.example.foodplanner.Presenter.Home.HomePresenter;
import com.example.foodplanner.Presenter.Home.HomeView;

import java.util.List;

public class CatPresenter implements NetworkCallback {

    CatView catView;
    Client client;
    Context context;
    static CatPresenter catPresenter = null;
    static List<Categories> categories;
    Repository repository;

    /* Need to be fixed , Context is not allowed only data */
    public CatPresenter(Context context, CatView catView){
        this.context = context;
        this.catView = catView;
        repository = Repository.getInstance(context);
    }

    public static CatPresenter getCatInstance(Context context, CatView catView){
        if(catPresenter == null){
            catPresenter = new CatPresenter(context,catView);
        }else{
            catView.showDataByCat(categories);
        }
        return catPresenter;
    }
    @Override
    public void onSuccessResult(List<Meals> mealsList) {}

    @Override
    public void onSuccessResultCat(List<Categories> categoriesList) {
        categories = categoriesList;
        catView.showDataByCat(categoriesList);
    }

    @Override
    public void onSuccessResultCount(List<Meals> mealsList) {

    }

    @Override
    public void onSuccessResultIngred(List<Meals> mealsList) {

    }

    @Override
    public void onSuccessResultName(List<Meals> mealsList) {

    }

    @Override
    public void onSuccessResultFilterCat(List<Meals> mealsList) {
        catView.showDataByCatDetailed(mealsList);
    }

    @Override
    public void onSuccessResultFilterIngred(List<Meals> mealsList) {

    }

    @Override
    public void onSuccessResultFilterCount(List<Meals> mealsList) {
    }

    @Override
    public void onSuccessResultFlags(CountryCode countryCode) {

    }

    @Override
    public void onFalureResult(String str) {
        /* Showing an alert Message as an Indication of Connection Problem */
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Keep Offline").setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onNotFound(String str) {
        Toast.makeText(context, "" + str + "is not found", Toast.LENGTH_SHORT).show();
        catView.clearData();
    }

    public void catInDetails(String category){
        client = Client.getInstance();
        client.makeNetworkCallbackByCategoryInDetails(this, category);
    }

    public void addMeal(Meals meals){
        if(meals != null) {
            repository.addProduct(meals);
        }
    }

    public void removeMeal(Meals meals){
        if(meals != null){
            repository.removeProduct(meals);
        }
    }
}
