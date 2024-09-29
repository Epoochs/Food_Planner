package com.example.foodplanner.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodplanner.Model.Meals;

import java.util.List;

@Dao
public interface MealDAO {
    @Query("SELECT * FROM favorites")
    //List<Products> getAllProducts();
    LiveData<List<Meals>> getAllMeals();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertMeal(Meals meals);

    @Delete
    void deleteMeal(Meals meals);
}
