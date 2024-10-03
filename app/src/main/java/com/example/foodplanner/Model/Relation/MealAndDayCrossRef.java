package com.example.foodplanner.Model.Relation;

import androidx.room.Entity;

@Entity(tableName = "mealAndDay",primaryKeys = {"MealID","DayID"})
public class MealAndDayCrossRef {
    private int mealID;
    private int dayID;

    public MealAndDayCrossRef(int mealID, int dayID) {
        this.mealID = mealID;
        this.dayID = dayID;
    }

    public int getMealID() {
        return mealID;
    }
    public int getDayID() {
        return dayID;
    }

    public void setMealID(int mealID) {
        this.mealID = mealID;
    }
    public void setDayID(int dayID) {
        this.dayID = dayID;
    }
}
