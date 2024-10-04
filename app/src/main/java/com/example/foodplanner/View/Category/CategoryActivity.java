package com.example.foodplanner.View.Category;

import android.os.Bundle;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Presenter.Category.CatPresenter;
import com.example.foodplanner.Presenter.Category.CatView;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Category.Adapters.CatGridAdapter;
import com.example.foodplanner.View.Listener.OnFavMealClickListener;
import com.example.foodplanner.View.Ingredient.Adapter.DetailedIngredAdapter;

import java.util.List;

public class CategoryActivity extends AppCompatActivity implements CatView, OnFavMealClickListener {

    RecyclerView gridView;
    CatGridAdapter catGridAdapter;
    DetailedIngredAdapter detailedIngredAdapter;
    List<Categories> categoriesList;
    List<Meals> mealsList;
    CatPresenter catPresenter;
    GridLayoutManager gridLayoutManager;
    SearchView searchView;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        searchView = findViewById(R.id.svCatDetails);

        gridView = findViewById(R.id.catRecycleView);
        gridLayoutManager = new GridLayoutManager(this, 2);
        detailedIngredAdapter = new DetailedIngredAdapter(this, mealsList, this);
        gridView.setLayoutManager(gridLayoutManager);
        gridView.setAdapter(detailedIngredAdapter);

        catPresenter = new CatPresenter(this, this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                if (!s.isEmpty()) {
                    updateMeals(s);
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
    public void showDataByCat(List<Categories> categories) {
        this.categoriesList = categories;
        catGridAdapter.setList(categories);
    }

    @Override
    public void showDataByCatDetailed(List<Meals> mealsList) {
        this.mealsList = mealsList;
        if (mealsList != null) {
            detailedIngredAdapter.setDetailedIngredList(mealsList);
        }
    }

    @Override
    public void clearData() {
        detailedIngredAdapter.setClear();
    }

    @Override
    public void onFavClick(Meals meals, boolean btnBtnState) {
        if (meals != null) {
            meals.setIsFavourate(true);
            catPresenter.addMeal(meals);
        }
    }

    @Override
    public void onUnFavClick(Meals meals) {
        if (meals != null) {
            meals.setIsFavourate(false);
            catPresenter.removeMeal(meals);
        }
    }

    public void updateMeals(String catName) {
        catPresenter.catInDetails(catName);
    }
}