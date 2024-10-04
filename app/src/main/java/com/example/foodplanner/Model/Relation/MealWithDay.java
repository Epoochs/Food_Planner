package com.example.foodplanner.Model.Relation;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import com.example.foodplanner.Model.Day;
import com.example.foodplanner.Model.Meals;

import java.util.List;

public class MealWithDay {
    @Embedded
    private Meals meals;

    @Relation(parentColumn = "idMeal", entityColumn = "day", associateBy = @Junction(MealAndDayCrossRef.class))

    public List<Day> days;

    public void setMeals(Meals meals) {
        this.meals = meals;
    }

    public void setDays(List<Day> days) {
        this.days = days;
    }
}
