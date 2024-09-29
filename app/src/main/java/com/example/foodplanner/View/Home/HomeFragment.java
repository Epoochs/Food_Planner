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
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Presenter.Home.HomePresenter;
import com.example.foodplanner.Presenter.Home.HomeView;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Favourate.FavourateFragment;
import com.example.foodplanner.View.Home.Adapters.MyInspirationAdapter;
import com.example.foodplanner.View.Home.Adapters.OnFavClickListener;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment implements HomeView, OnFavClickListener {

    View view;

    HomePresenter homePresenter;

    RecyclerView recyclerViewMealInsp;
    MyInspirationAdapter myInspirationAdapter;
    LinearLayoutManager insplayoutManager;
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
        System.out.println(btnFavState);
        myInspirationAdapter = new MyInspirationAdapter(requireContext(), new ArrayList<Meals>(), this, btnFavState);
        recyclerViewMealInsp.setAdapter(myInspirationAdapter);


        /* Init a Presenter that would be the middleman between View and Model
        * We made it only one instance so that we can keep the last picked-up random meal through
        * the Application */
       homePresenter = HomePresenter.getHomeInstance(requireContext(),this);

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
        }
    }

    @Override
    public void showData(List<Meals> meals) {
        myInspirationAdapter.setList(meals);
    }

    @Override
    public void onFavClick(Meals meals, boolean btnFavState) {
        homePresenter.addMeal(meals);
        this.btnFavState = btnFavState;
    }

    @Override
    public void onUnFavClick(Meals meals){
        homePresenter.removeMeal(meals);
    }
}