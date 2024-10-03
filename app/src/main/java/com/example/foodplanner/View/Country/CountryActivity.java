package com.example.foodplanner.View.Country;

import android.content.Intent;
import android.os.Bundle;
import android.widget.SearchView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Presenter.Country.CountPresenter;
import com.example.foodplanner.Presenter.Country.CountView;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Country.Adapter.CountGridAdapter;
import com.example.foodplanner.View.Country.Adapter.DetailedCountAdapter;

import java.util.List;

public class CountryActivity extends AppCompatActivity implements CountView {

    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    List<Meals> mealsList;
    CountGridAdapter countGridAdapter;
    CountPresenter countPresenter;
    SearchView searchViewCount;
    DetailedCountAdapter detailedCountAdapter;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_country);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }


        recyclerView = findViewById(R.id.rvDetailedCountry);
        gridLayoutManager = new GridLayoutManager(this,2);
        countGridAdapter = new CountGridAdapter(this,mealsList);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(countGridAdapter);

        searchViewCount = findViewById(R.id.svDetailedIngred);
        count = 0;

        // Set listener to handle query submissions
        searchViewCount.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                if(count < 1) {
                    updateList(query);
                    System.out.println(query + " Hi");
                    count++;
                }
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText != null){
                 //   updateList(newText);
                    System.out.println(newText);
                }
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
    public void showData(List<Meals> meals) {
        this.mealsList = meals;
        countGridAdapter.setMealsList(mealsList);
        System.out.println("CountryActivity");
    }

    @Override
    public void showDataCountFilterd(List<Meals> meals) {
        this.mealsList = meals;

    }

    public void updateList(String count){
        Intent intent = new Intent(CountryActivity.this, DetailedCountActivity.class);
        intent.putExtra("CountName",count);
        startActivity(intent);
    }
}