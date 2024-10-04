package com.example.foodplanner.Model.Relation;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.foodplanner.Model.Day;
import com.example.foodplanner.Model.Meals;

import java.util.List;

public class DayWithMeal {
    @Embedded
    private Day day;

    @Relation(parentColumn = "day", entityColumn = "idMeal", associateBy = @Junction(MealAndDayCrossRef.class))

    private List<Meals> mealsList;

    public void setDay(Day day) {
        this.day = day;
    }

    public void setMealsList(List<Meals> mealsList) {
        this.mealsList = mealsList;
    }

    public List<Meals> getMealsList(){
        return mealsList;
    }

    public Day getDay(){
        return day;
    }
}
