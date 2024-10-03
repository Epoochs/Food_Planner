package com.example.foodplanner.View.Country;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Presenter.Country.CountPresenter;
import com.example.foodplanner.Presenter.Country.CountView;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Country.Adapter.DetailedCountAdapter;
import com.example.foodplanner.View.Listener.OnFavMealClickListener;

import java.util.List;

public class DetailedCountActivity extends AppCompatActivity implements CountView, OnFavMealClickListener {

    RecyclerView recyclerViewDetailedCount;
    GridLayoutManager gridLayoutManager;
    List<Meals> mealsList;
    DetailedCountAdapter detailedCountAdapter;
    CountPresenter countPresenter;
    boolean btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detailed_count);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Intent intent = getIntent();
        String countName = intent.getStringExtra("CountName");



        recyclerViewDetailedCount = findViewById(R.id.rvDetailedCountry);
        gridLayoutManager = new GridLayoutManager(this,2);
        detailedCountAdapter = new DetailedCountAdapter(this,mealsList,this);
        recyclerViewDetailedCount.setLayoutManager(gridLayoutManager);
        recyclerViewDetailedCount.setAdapter(detailedCountAdapter);

        countPresenter = new CountPresenter(this,this);
        countPresenter.getSpecificCount(countName);

    }

    @Override
    public void showData(List<Meals> meals) {
        this.mealsList = meals;
        detailedCountAdapter.setMealsList(meals);
    }

    @Override
    public void showDataCountFilterd(List<Meals> meals) {
    }

    @Override
    public void onFavClick(Meals meals, boolean btnBtnState) {
        btnSave = btnBtnState;
        countPresenter.addMeal(meals);
    }

    @Override
    public void onUnFavClick(Meals meals) {
        countPresenter.removeMeal(meals);
    }
}