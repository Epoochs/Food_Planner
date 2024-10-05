package com.example.foodplanner.Presenter.Home;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.CountryCode;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Relation.MealAndDayCrossRef;
import com.example.foodplanner.Model.Repository;
import com.example.foodplanner.Networking.Client;
import com.example.foodplanner.Networking.FlagClient;
import com.example.foodplanner.Networking.NetworkCallback;
import com.example.foodplanner.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomePresenter implements NetworkCallback {
    Repository repository;
    HomeView homeView;
    Context context;
    static HomePresenter homePresenter = null;
    static List<Meals> meals;
    static List<Meals> meals2;
    static List<Meals> meals3;
    static List<Categories> categories;
    static CountryCode countryCodey;
    Client client;
    static Map<String, Integer> flags;

    public HomePresenter(Context context, HomeView homeView){
        this.context = context;
        this.homeView = homeView;
        repository = Repository.getInstance(context);

        getFlags();
        getRandomMeal();
        getAllCat();
        getAllIngred();
        getAllCount();
    }

    public static HomePresenter getHomeInstance(Context context, HomeView homeView){
        if(homePresenter == null){
            homePresenter = new HomePresenter(context,homeView);
        }else{
            homeView.showFlag(flags);
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
            homeView.showFlag(flags);
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
    public void onSuccessResultFlags(CountryCode countryCode) {
    }

    @Override
    public void onFalureResult(String str) {
        /* Showing an alert Message as an Indication of Connection Problem */
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage("Error").setTitle("An Error Occurred").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
            }
        }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
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

    public void addMealWithDay(MealAndDayCrossRef mealAndDayCrossRef){
        repository.addMealDay(mealAndDayCrossRef);
    }

    public void getFlags(){
        Map<String, Integer> countryCodes = new HashMap<>();

        countryCodes.put("American", R.drawable.us);
        countryCodes.put("British", R.drawable.gb);
        countryCodes.put("Canadian", R.drawable.ca);
        countryCodes.put("Chinese", R.drawable.cn);
        countryCodes.put("Croatian", R.drawable.hr);
        countryCodes.put("Dutch", R.drawable.nl);
        countryCodes.put("Egyptian", R.drawable.eg);
        countryCodes.put("Filipino", R.drawable.ph);
        countryCodes.put("French", R.drawable.fr);
        countryCodes.put("Greek", R.drawable.gr);
        countryCodes.put("Indian", R.drawable.in);
        countryCodes.put("Irish", R.drawable.ie);
        countryCodes.put("Italian", R.drawable.it);
        countryCodes.put("Jamaican", R.drawable.jm);
        countryCodes.put("Japanese", R.drawable.jp);
        countryCodes.put("Kenyan", R.drawable.ke);
        countryCodes.put("Malaysian", R.drawable.my);
        countryCodes.put("Mexican", R.drawable.mx);
        countryCodes.put("Moroccan", R.drawable.ma);
        countryCodes.put("Polish", R.drawable.pl);
        countryCodes.put("Portuguese", R.drawable.pt);
        countryCodes.put("Russian", R.drawable.ru);
        countryCodes.put("Spanish", R.drawable.es);
        countryCodes.put("Thai", R.drawable.th);
        countryCodes.put("Tunisian", R.drawable.tn);
        countryCodes.put("Turkish", R.drawable.tr);
        countryCodes.put("Ukrainian", R.drawable.ua);
        countryCodes.put("Vietnamese", R.drawable.vn);

        flags = countryCodes;
    }
}
