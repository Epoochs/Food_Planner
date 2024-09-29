package com.example.foodplanner.Model;

import androidx.lifecycle.LiveData;

import com.example.foodplanner.Networking.Client;
import com.example.foodplanner.Networking.NetworkCallback;

import java.util.List;
/* Meal Data Layer */
public class MealRepository {
    private Client client;
    private Repository repository;
    private static MealRepository mealRepository;

    public MealRepository(Client client, Repository repository){
        this.client = client;
        this.repository = repository;
    }

    public static MealRepository getInstance(Client client, Repository repository){
        if(mealRepository == null){
            mealRepository = new MealRepository(client,repository);
        }
        return  mealRepository;
    }

    /* Local Data Storage Implementations */
    public LiveData<List<Meals>> getStoredMeals() {return repository.getMealsList();}
    public void insertMeal(Meals meals){
        repository.addProduct(meals);
    }
    public void removeMeal(Meals meals){
        repository.removeProduct(meals);
    }

    /*******************************************************************************************/

    /* Random Meal API */
    public void getRandomMeals(NetworkCallback networkCallback){
        client.makeNetworkCallbackRandom(networkCallback);
    }
    /*******************************************************************************************/

    /* Categories APIs */
    public void getAllCategories(NetworkCallback networkCallback){
        client.makeNetworkCallbackByCategory(networkCallback);
    }
    public void getCategoryInDetails(NetworkCallback networkCallback, Meals catMealName){
        client.makeNetworkCallbackByCategoryInDetails(networkCallback,catMealName);
    }

    /******************************************************************************************/
}
