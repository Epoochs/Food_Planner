package com.example.foodplanner.View.Ingredient;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Presenter.Ingredients.IngredPresenter;
import com.example.foodplanner.Presenter.Ingredients.IngredView;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Ingredient.Adapter.DetailedIngredAdapter;
import com.example.foodplanner.View.Listener.OnFavMealClickListener;

import java.util.List;

public class DetailedIngredActivity extends AppCompatActivity implements OnFavMealClickListener, IngredView {

    RecyclerView recyclerViewDetailedIngred;
    GridLayoutManager gridLayoutManager;
    List<Meals> mealsList;
    DetailedIngredAdapter detailedIngredAdapter;
    IngredPresenter ingredPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_detailed_ingred);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Intent intent = getIntent();
        String IngredName = intent.getStringExtra("IngredName");

        recyclerViewDetailedIngred = findViewById(R.id.rvDetailedIngred);
        gridLayoutManager = new GridLayoutManager(this,2);
        detailedIngredAdapter = new DetailedIngredAdapter(this,mealsList,this);
        recyclerViewDetailedIngred.setLayoutManager(gridLayoutManager);
        recyclerViewDetailedIngred.setAdapter(detailedIngredAdapter);

        ingredPresenter = new IngredPresenter(this, this);
        ingredPresenter.getIngredFiltered(IngredName);
    }

    @Override
    public void onFavClick(Meals meals, boolean btnBtnState) {
        if(meals != null) {
            meals.setIsFavourate(true);
            ingredPresenter.addMeal(meals);
        }
    }

    @Override
    public void onUnFavClick(Meals meals) {
        if(meals != null) {
            meals.setIsFavourate(false);
            ingredPresenter.removeMeal(meals);
        }
    }

    @Override
    public void showDataIngred(List<Meals> mealsList) {
    }

    @Override
    public void showDataDetailedIngred(List<Meals> mealsList) {
        detailedIngredAdapter.setDetailedIngredList(mealsList);
    }

    @Override
    public void clearData() {

    }
}