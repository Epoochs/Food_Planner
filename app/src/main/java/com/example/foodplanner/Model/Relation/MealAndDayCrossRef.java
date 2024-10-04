package com.example.foodplanner.Model.Relation;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity(tableName = "mealAndDay",primaryKeys = {"idMeal","day"})
public class MealAndDayCrossRef {
    private int idMeal;
    @NonNull
    private String day;

    public MealAndDayCrossRef(int mealID, String day) {
        this.idMeal = mealID;
        this.day = day;
    }

    public MealAndDayCrossRef(){}

    public int getIdMeal() {
        return idMeal;
    }
    public String getDay() {
        return day;
    }

    public void setIdMeal(int mealID) {
        this.idMeal = mealID;
    }
    public void setDay(String day) {
        this.day = day;
    }
}
