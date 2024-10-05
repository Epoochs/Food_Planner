package com.example.foodplanner.Presenter.Country;

import android.app.AlertDialog;
import android.content.Context;
import android.widget.Toast;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.CountryCode;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Repository;
import com.example.foodplanner.Networking.Client;
import com.example.foodplanner.Networking.FlagClient;
import com.example.foodplanner.Networking.NetworkCallback;

import java.util.List;

public class CountPresenter implements NetworkCallback {
    CountView countView;
    Context context;
    Client client;
    FlagClient flagClient;
    Repository repository;

    public CountPresenter(Context context, CountView countView){
        this.countView = countView;
        this.context = context;
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
        countView.showData(mealsList);
    }

    @Override
    public void onSuccessResultIngred(List<Meals> mealsList) {

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
        countView.showData(mealsList);
    }

    @Override
    public void onSuccessResultFlags(CountryCode countryCode){
        countView.showFlag(countryCode);
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
        Toast.makeText(context, str + " Not Found", Toast.LENGTH_SHORT).show();
    }

    public void getAllCount(){
        client = Client.getInstance();
        client.makeNetworkCallbackByCountry(this);
    }

    public void getSpecificCount(String count){
        client = Client.getInstance();
        client.makeNetworkCallbackByCountFiltered(this, count);
    }

    public void addMeal(Meals meals){
        repository.addProduct(meals);
    }

    public void removeMeal(Meals meals){
        repository.removeProduct(meals);
    }

    public void getFlags(){
        flagClient = FlagClient.getInstance();
        flagClient.makeNetworkCallbackFlag(this);
    }
}
