package com.example.foodplanner.Presenter.Category;

import android.app.AlertDialog;
import android.content.Context;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Repository;
import com.example.foodplanner.Networking.Client;
import com.example.foodplanner.Networking.NetworkCallback;

import java.util.List;

public class CatPresenter implements NetworkCallback {

    CatView catView;
    Client client;
    Context context;

    /* Need to be fixed , Context is not allowed only data */
    public CatPresenter(Context context, CatView catView){
        this.catView = catView;

        client = Client.getInstance();
        client.makeNetworkCallbackByCategory(this);
    }

    @Override
    public void onSuccessResult(List<Meals> mealsList) {}

    @Override
    public void onSuccessResultCat(List<Categories> categoriesList) {
        catView.showData(categoriesList);
    }

    @Override
    public void onFalureResult(String str) {
        /* Showing an alert Message as an Indication of Connection Problem */
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Keep Offline").setTitle("An Error Occurred");
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void catInDetails(Meals meals){
        client.makeNetworkCallbackByCategoryInDetails(this, meals);
    }
}
