package com.example.foodplanner.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Presenter.Home.HomePresenter;
import com.example.foodplanner.Presenter.Home.HomeView;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Favourate.FavourateFragment;

import java.util.List;


public class HomeFragment extends Fragment implements HomeView, FavourateFragment.FavButtonState {

    ImageButton imageButton;
    View view;
    ImageView imageView;
    TextView tvName;
    boolean btnFavState = false;
    HomePresenter homePresenter;
    Meals meal;

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

        /* Setting the previous state of the button */
        imageButton.setSelected(btnFavState);

        /* Init a Presenter that would be the middleman between View and Model
        * We made it only one instance so that we can keep the last picked-up random meal through
        * the Application */
        homePresenter = HomePresenter.getHomeInstance(requireContext(),this);

        /* Handling the clicks on ImageButton */
        imageButton.setOnClickListener(v -> {

            /* Changing the state of button */
            btnFavState = !btnFavState;
            imageButton.setSelected(btnFavState);

            /* Adding or Removing the meal into/from the database based on the state of imageButton */
            if(btnFavState) {
                homePresenter.addMeal(meal);
            }else{
                homePresenter.removeMeal(meal);
            }
        });
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
            imageButton = view.findViewById(R.id.imgBtnUnFav);
            imageView = view.findViewById(R.id.imgy);
            tvName = view.findViewById(R.id.tvNamy);
        }
    }

    @Override
    public void showData(List<Meals> meals) {
        meal = meals.get(0);
        tvName.setText(meal.getStrMeal());
        Glide.with(this).load(meal
                .getStrMealThumb())
                .apply(new RequestOptions().override(200,200))
                .placeholder(R.drawable.baseline_downloading_24)
                .error(R.drawable.baseline_downloading_24).into(imageView);
    }

    @Override
    public void favState(boolean favState) {

    }
}