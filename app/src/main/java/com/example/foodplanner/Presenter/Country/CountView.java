package com.example.foodplanner.Presenter.Country;

import com.example.foodplanner.Model.CountryCode;
import com.example.foodplanner.Model.Meals;

import java.util.List;

public interface CountView {
    void showData(List<Meals> meals);
    void showDataCountFilterd(List<Meals> meals);
    void showFlag(CountryCode countryCode);
}
