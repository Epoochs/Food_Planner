package com.example.foodplanner.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.foodplanner.Model.Meals;


@Database(entities = {Meals.class}, version = 1)
public abstract class MealsDatabase extends RoomDatabase {
    private static MealsDatabase mealsDatabase = null;

    public abstract MealDAO getMealDAO();

    public static synchronized MealsDatabase getInstance(Context context) {
        if (mealsDatabase == null) {
            mealsDatabase = Room.databaseBuilder(context.getApplicationContext(), MealsDatabase.class, "mealsdp").build();

        }
        return mealsDatabase;
    }
}
