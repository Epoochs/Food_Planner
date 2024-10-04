package com.example.foodplanner.View.Category;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Presenter.Details.DetailedView;
import com.example.foodplanner.Presenter.Details.DetailsPresenter;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Category.Adapters.MyFilteredCat;
import com.example.foodplanner.View.Listener.OnFavMealClickListener;

import java.util.ArrayList;
import java.util.List;

public class FilteredCategoryActivity extends AppCompatActivity implements DetailedView, OnFavMealClickListener {

    RecyclerView recyclerViewDetailedCat;
    GridLayoutManager gridLayoutManager;
    MyFilteredCat myFilteredCatAdapter;

    DetailsPresenter detailsPresenter;
    List<Meals> mealsList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_filtered_category);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Intent intent = getIntent();
        String catName = intent.getStringExtra("Categ");

        recyclerViewDetailedCat = findViewById(R.id.gvDetailedCategory);
        gridLayoutManager = new GridLayoutManager(this,2);
        myFilteredCatAdapter = new MyFilteredCat(this,(ArrayList<Meals>) mealsList,this);
        recyclerViewDetailedCat.setLayoutManager(gridLayoutManager);
        recyclerViewDetailedCat.setAdapter(myFilteredCatAdapter);

        detailsPresenter = DetailsPresenter.getInstance(this,this);
        detailsPresenter.getDetailedCat(catName);
    }

    @Override
    public void onFavClick(Meals meals, boolean btnBtnState) {
        if(meals != null) {
            meals.setIsFavourate(true);
            detailsPresenter.insertMeal(meals);
        }
    }

    @Override
    public void onUnFavClick(Meals meals) {
        if(meals != null) {
            meals.setIsFavourate(false);
            detailsPresenter.removeMeal(meals);
        }
    }

    @Override
    public void showData(Meals meals) {

    }

    @Override
    public void showData(List<Meals> mealsList) {
        System.out.println("FilterCatShowDate");
        System.out.println(mealsList.get(0).getStrMeal());
        myFilteredCatAdapter.setMealsList(mealsList);
    }
}