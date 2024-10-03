package com.example.foodplanner.View.Ingredient;

import android.os.Bundle;
import android.widget.SearchView;

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

public class IngredActivity extends AppCompatActivity implements IngredView, OnFavMealClickListener {

    RecyclerView recyclerViewIngred;
    GridLayoutManager gridLayoutManagerIngred;
    DetailedIngredAdapter detailedIngredAdapter;
    IngredPresenter ingredPresenter;
    List<Meals> mealsList;
    SearchView searchView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ingred);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        searchView = findViewById(R.id.svDetailedIngred);

        recyclerViewIngred = findViewById(R.id.rvIngred);
        gridLayoutManagerIngred = new GridLayoutManager(this,2);
        detailedIngredAdapter = new DetailedIngredAdapter(this, mealsList,this);
        recyclerViewIngred.setLayoutManager(gridLayoutManagerIngred);
        recyclerViewIngred.setAdapter(detailedIngredAdapter);

        ingredPresenter = new IngredPresenter(this,this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if(count < 1) {
                    if (!s.isEmpty()) {
                        updateIngredDetails(s);
                    }
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        count = 0;
    }

    @Override
    public void showDataIngred(List<Meals> mealsList) {
    }

    @Override
    public void showDataDetailedIngred(List<Meals> mealsList) {
        this.mealsList = mealsList;
        if(mealsList != null) {
            detailedIngredAdapter.setDetailedIngredList(mealsList);
        }
    }

    @Override
    public void clearData() {
        detailedIngredAdapter.setClear();
    }

    public void updateIngredDetails(String ingredName){
        ingredPresenter.getIngredFiltered(ingredName);
    }

    @Override
    public void onFavClick(Meals meals, boolean btnBtnState) {
        ingredPresenter.addMeal(meals);
    }

    @Override
    public void onUnFavClick(Meals meals) {
        ingredPresenter.removeMeal(meals);
    }
}