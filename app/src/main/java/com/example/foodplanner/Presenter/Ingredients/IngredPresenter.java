package com.example.foodplanner.Presenter.Ingredients;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Repository;
import com.example.foodplanner.Networking.Client;
import com.example.foodplanner.Networking.NetworkCallback;
import com.example.foodplanner.R;

import java.util.List;

public class IngredPresenter implements NetworkCallback {
    Context context;
    IngredView ingredView;
    Client client;
    static IngredPresenter ingredPresenter = null;
    Repository repository;
    List<Meals> mealsList1;
    List<Meals> mealsList2;

    public IngredPresenter(Context context, IngredView ingredView) {
        this.context = context;
        this.ingredView = ingredView;
        repository = Repository.getInstance(context);
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
        this.mealsList1 = mealsList;
        ingredView.showDataIngred(mealsList);
    }

    @Override
    public void onSuccessResultName(List<Meals> mealsList) {

    }

    @Override
    public void onSuccessResultFilterCat(List<Meals> mealsList) {

    }

    @Override
    public void onSuccessResultFilterIngred(List<Meals> mealsList) {
        mealsList2 = mealsList;
        if(mealsList != null){
            ingredView.showDataDetailedIngred(mealsList);
        }
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
        Toast.makeText(context, "" +  str + "is not Found", Toast.LENGTH_SHORT).show();
        ingredView.clearData();
    }

    public void getAllIngred(){
        client = Client.getInstance();
        client.makeNetworkCallbackByIngred(this);
    }

    public void getIngredFiltered(String ingredName){
        client = Client.getInstance();
        client.makeNetworkCallbackByIngredFiltered(this, ingredName);
    }

    public void addMeal(Meals meals){
        if(meals != null) {
            repository.addProduct(meals);
        }else{
            Toast.makeText(context, "Nothing to add", Toast.LENGTH_SHORT).show();
        }
    }

    public void removeMeal(Meals meals){
        if(meals != null) {
            repository.removeProduct(meals);
        }else{
            Toast.makeText(context, "Nothing to remove", Toast.LENGTH_SHORT).show();
        }
    }
}
