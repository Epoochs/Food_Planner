package com.example.foodplanner.DB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.foodplanner.Model.Day;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Relation.MealAndDayCrossRef;

import kotlin.jvm.Volatile;


@Database(entities = {Meals.class, Day.class, MealAndDayCrossRef.class}, version = 2)
public abstract class MealsDatabase extends RoomDatabase {
    @Volatile
    private static MealsDatabase mealsDatabase = null;

    public abstract MealDAO getMealDAO();

    public static synchronized MealsDatabase getInstance(Context context) {
        if (mealsDatabase == null) {
            mealsDatabase = Room.databaseBuilder(context.getApplicationContext(), MealsDatabase.class, "mealsdp").build();

        }
        return mealsDatabase;
    }
}
