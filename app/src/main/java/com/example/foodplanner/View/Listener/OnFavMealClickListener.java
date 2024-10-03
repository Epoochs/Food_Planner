package com.example.foodplanner.View.Listener;

import com.example.foodplanner.Model.Meals;

public interface OnFavMealClickListener {
    void onFavClick(Meals meals, boolean btnBtnState);
    void onUnFavClick(Meals meals);
}
