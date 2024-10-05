package com.example.foodplanner.DB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.foodplanner.Model.Day;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Relation.DayWithMeal;
import com.example.foodplanner.Model.Relation.MealAndDayCrossRef;
import com.example.foodplanner.Model.Relation.MealWithDay;

import java.util.List;

@Dao
public interface MealDAO {
    @Query("SELECT * FROM meal WHERE isFavourate = 1")
    //List<Products> getAllProducts();
    //This to get the favourate meals
    LiveData<List<Meals>> getAllMeals();

    @Query("SELECT * FROM meal WHERE isPlanned = 1")
    LiveData<List<Meals>> getAllPlanned00Meals();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //This to insert Fav Meals
    long insertMeal(Meals meals);

    // to insert a day
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insertDay(Day day);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMealDay(MealAndDayCrossRef mealAndDayCrossRef);

    @Query("SELECT * FROM Day WHERE day = :day")
    LiveData<List<DayWithMeal>> getMealsOfDay(String day);

    @Query("SELECT * FROM meal WHERE idMeal = :mealID")
    LiveData<List<MealWithDay>> getDaysOfMeal(int mealID);

    @Delete
    // To remove fav meals
    void deleteMeal(Meals meals);
}
