package com.example.foodplanner.View.Home;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodplanner.Model.Categories;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Presenter.Home.HomePresenter;
import com.example.foodplanner.Presenter.Home.HomeView;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Category.Adapters.CatGridAdapter;
import com.example.foodplanner.View.Country.Adapter.CountGridAdapter;
import com.example.foodplanner.View.Home.Adapters.MyInspirationAdapter;
import com.example.foodplanner.View.Home.Adapters.OnFavClickListener;
import com.example.foodplanner.View.Ingredient.Adapter.MyIngredAdapterSearch;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements HomeView, OnFavClickListener {

    View view;

    HomePresenter homePresenter;

    /* Inspiration */
    RecyclerView recyclerViewMealInsp;
    MyInspirationAdapter myInspirationAdapter;
    LinearLayoutManager insplayoutManager;

    /* Category */
    RecyclerView recyclerViewMealCat;
    CatGridAdapter catGridAdapter;
    LinearLayoutManager CatlinearLayoutManager;

    /* Ingredients */
    RecyclerView recyclerViewMealIngred;
    MyIngredAdapterSearch myIngredAdapter;
    LinearLayoutManager ingredlinearLayoutManager;

    /* Country */
    RecyclerView recyclerViewCount;
    CountGridAdapter countGridAdapter;
    LinearLayoutManager countlinearLayoutManager;

    boolean btnFavState;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.home2, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /* Getting the state of FavButton */
        if(savedInstanceState != null){
            btnFavState = savedInstanceState.getBoolean("favState");
        }

        /* Init UI */
        init();

        /* Recycle preparation of Meal Inspiration */
        insplayoutManager = new LinearLayoutManager(requireContext());
        insplayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewMealInsp.setLayoutManager(insplayoutManager);
        myInspirationAdapter = new MyInspirationAdapter(requireContext(), new ArrayList<Meals>(), this, btnFavState);
        recyclerViewMealInsp.setAdapter(myInspirationAdapter);

        /* Recycle preparation of Meal Category */
        CatlinearLayoutManager = new LinearLayoutManager(requireContext());
        CatlinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewMealCat.setLayoutManager(CatlinearLayoutManager);
        catGridAdapter = new CatGridAdapter(requireContext(),new ArrayList<Categories>());
        recyclerViewMealCat.setAdapter(catGridAdapter);

        /* Recycle preparation of Meal Ingredients */
        ingredlinearLayoutManager = new LinearLayoutManager(requireContext());
        ingredlinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewMealIngred.setLayoutManager(ingredlinearLayoutManager);
        myIngredAdapter = new MyIngredAdapterSearch(requireContext(),new ArrayList<>());
        recyclerViewMealIngred.setAdapter(myIngredAdapter);

        /* Recycle preparation of Meal Country */
        countlinearLayoutManager = new LinearLayoutManager(requireContext());
        countlinearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerViewCount.setLayoutManager(countlinearLayoutManager);
        countGridAdapter = new CountGridAdapter(requireContext(),new ArrayList<>());
        recyclerViewCount.setAdapter(countGridAdapter);

        /* Init a Presenter that would be the middleman between View and Model
        * We made it only one instance so that we can keep the last picked-up random meal through
        * the Application */
       homePresenter = HomePresenter.getHomeInstance(requireContext(),this);;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    /* Saving the last state of the FavButton */
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBoolean("favState", btnFavState);
    }

    private void init(){
        if (view != null) {
            recyclerViewMealInsp = view.findViewById(R.id.MealInspirationRecycleView);
            recyclerViewMealCat = view.findViewById(R.id.recyclerViewMealByCat);
            recyclerViewMealIngred = view.findViewById(R.id.rvIngredients);
            recyclerViewCount = view.findViewById(R.id.rvCountry);
        }
    }

    @Override
    public void showDataMealInsp(List<Meals> meals) {
        myInspirationAdapter.setList(meals);
    }

    @Override
    public void showDataMealCat(List<Categories> categories) {
        catGridAdapter.setList(categories);
    }

    @Override
    public void showDataMealIng(List<Meals> meals) {
        myIngredAdapter.setList(meals);
    }

    @Override
    public void showDataMealCount(List<Meals> meals) {
        countGridAdapter.setMealsList(meals);
    }

    @Override
    public void onFavClick(Meals meals, boolean btnFavState) {
        if(meals != null) {
            meals.setIsFavourate(true);
            homePresenter.addMeal(meals);
        }
        this.btnFavState = btnFavState;
    }

    @Override
    public void onUnFavClick(Meals meals){
        if(meals != null) {
            meals.setIsFavourate(false);
            homePresenter.removeMeal(meals);
        }
    }
}