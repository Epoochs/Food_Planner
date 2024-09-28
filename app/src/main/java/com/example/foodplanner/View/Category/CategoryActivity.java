package com.example.foodplanner.View.Category;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Presenter.Category.CatPresenter;
import com.example.foodplanner.Presenter.Category.CatView;
import com.example.foodplanner.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity implements CatView {

    RecyclerView gridView;
    CatGridAdapter catGridAdapter;
    List<Categories> categoriesList;
    CatPresenter catPresenter;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_category);

        gridView = findViewById(R.id.catRecycleView);
        gridLayoutManager = new GridLayoutManager(this,2);
        catGridAdapter = new CatGridAdapter(this,new ArrayList<>());
        gridView.setLayoutManager(gridLayoutManager);
        gridView.setAdapter(catGridAdapter);

        catPresenter = new CatPresenter(this,this);
    }

    @Override
    public void showData(List<Categories> categories) {
        this.categoriesList = categories;
        catGridAdapter.setList(categories);
    }
}