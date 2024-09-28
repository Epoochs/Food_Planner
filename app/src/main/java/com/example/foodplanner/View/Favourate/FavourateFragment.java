package com.example.foodplanner.View.Favourate;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageButton;

import com.example.foodplanner.DB.MealDAO;
import com.example.foodplanner.DB.MealsDatabase;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Repository;
import com.example.foodplanner.Presenter.Favourate.FavPresenter;
import com.example.foodplanner.Presenter.Favourate.FavView;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Category.CatGridAdapter;

import java.util.ArrayList;
import java.util.List;

public class FavourateFragment extends Fragment implements FavView, OnUnFavClickListener {

    RecyclerView favRecycleView;
    GridLayoutManager gridLayoutManager;
    FavGridAdapter favGridAdapter;
    FavPresenter favPresenter;

    public interface FavButtonState{
        void favState(boolean favState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favourate, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        favRecycleView = view.findViewById(R.id.FavRecycleView);

        gridLayoutManager = new GridLayoutManager(requireContext(),2);
        favGridAdapter = new FavGridAdapter(requireContext(),new ArrayList<>(),this);
        favRecycleView.setLayoutManager(gridLayoutManager);
        favRecycleView.setAdapter(favGridAdapter);

        favPresenter = new FavPresenter(requireContext(), this);

        MealsDatabase mealsDatabase = MealsDatabase.getInstance(requireContext());
        MealDAO mealDAO = mealsDatabase.getMealDAO();
        LiveData<List<Meals>> mealslist = mealDAO.getAllMeals();
        mealslist.observe(requireActivity(), new Observer<List<Meals>>() {
            @Override
            public void onChanged(List<Meals> mealsList) {
                favGridAdapter.setList(mealsList);
            }
        });
    }

    @Override
    public void showData(List<Meals> mealsList) {
    }

    @Override
    public void onUnFavClick(Meals meal) {
        favPresenter.removeMeal(meal);
    }
}