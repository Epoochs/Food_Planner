package com.example.foodplanner.Model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.foodplanner.DB.MealDAO;
import com.example.foodplanner.DB.MealsDatabase;

import java.util.List;

public class Repository {
    private static Repository repository = null;
    private LiveData<List<Meals>> mealsList;
    MealDAO mealDAO;

    private Repository(Context context){
        MealsDatabase mealsDatabase = MealsDatabase.getInstance(context.getApplicationContext());
        mealDAO = mealsDatabase.getMealDAO();
        mealsList = mealDAO.getAllMeals();
    }


    public LiveData<List<Meals>> getMealsList(){ return mealsList; }

    public static Repository getInstance(Context context){
        if(repository == null){
            repository = new Repository(context);
        }
        return repository;
    }

    public void addProduct(Meals meal){
        new Thread(){
            public void run(){
                mealDAO.insertMeal(meal);
                //productsList.add(product);
            }
        }.start();
    }

    public void removeProduct(Meals meal){
        new Thread(){
            public void run(){
                mealDAO.deleteMeal(meal);
                //productsList.remove(product);
            }
        }.start();
    }
}
