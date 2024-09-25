package com.example.foodplanner.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "meals_table")
public class Meals {
    @PrimaryKey
    private int idMeal;
    private String strMeal;
    private String strInstructions;
    private String strMealThumb;
    private String strCategory;

    public Meals(String strMeal, String strInstructions, String strMealThumb, String strCategory) {
        this.strMeal = strMeal;
        this.strInstructions = strInstructions;
        this.strMealThumb = strMealThumb;
        this.strCategory = strCategory;
    }

    /* Getters */
    public String getStrMeal() {
        return strMeal;
    }
    public String getStrInstructions() {
        return strInstructions;
    }
    public String getStrMealThumb() {
        return strMealThumb;
    }
    public String getStrCategory() {
        return strCategory;
    }
    public int getIdMeal(){ return idMeal; }

    /* Setters */
    public void setStrMeal(String strMeal) {
        this.strMeal = strMeal;
    }
    public void setStrInstructions(String strInstructions) {
        this.strInstructions = strInstructions;
    }
    public void setStrMealThumb(String strMealThumb) {
        this.strMealThumb = strMealThumb;
    }
    public void setStrCategory(String strCategory) {
        this.strCategory = strCategory;
    }
    public void setIdMeal(int idMeal) { this.idMeal = idMeal; }
}
