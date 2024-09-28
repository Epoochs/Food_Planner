package com.example.foodplanner.View.Home.Adapters;

import com.example.foodplanner.Model.Meals;

public interface OnFavClickListener {
    void onFavClick(Meals meals, boolean btnBtnState);
    void onUnFavClick(Meals meals);
}
