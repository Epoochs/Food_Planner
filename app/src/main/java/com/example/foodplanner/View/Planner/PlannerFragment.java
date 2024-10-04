package com.example.foodplanner.View.Planner;

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
import android.widget.CalendarView;

import com.example.foodplanner.DB.MealDAO;
import com.example.foodplanner.DB.MealsDatabase;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Model.Relation.DayWithMeal;
import com.example.foodplanner.Model.Relation.MealWithDay;
import com.example.foodplanner.Presenter.Favourate.FavPresenter;
import com.example.foodplanner.Presenter.Planner.PlannerPresenter;
import com.example.foodplanner.Presenter.Planner.PlannerView;
import com.example.foodplanner.R;
import com.example.foodplanner.View.Favourate.Adapter.FavGridAdapter;
import com.example.foodplanner.View.Listener.OnFavMealClickListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class PlannerFragment extends Fragment implements PlannerView, OnFavMealClickListener {

    CalendarView calendarView;
    RecyclerView recyclerView;
    GridLayoutManager gridLayoutManager;
    MyPlannerAdapter myPlannerAdapter;
    PlannerPresenter plannerPresenter;
    LiveData<List<DayWithMeal>> mealWithDay;
    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_planner, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        calendarView = view.findViewById(R.id.calendarView);
        calendarView.setMinDate(System.currentTimeMillis() - 1000); // Medium
        recyclerView = view.findViewById(R.id.rvCalendaredMeals);

        gridLayoutManager = new GridLayoutManager(requireContext(),2);
        myPlannerAdapter = new MyPlannerAdapter(requireContext(),new ArrayList<>(), this);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(myPlannerAdapter);
        plannerPresenter = new PlannerPresenter(requireContext(),this);


        /**************************************************************************************/
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int dayOfMonth) {
                String selectedDate = dayOfMonth + "/" + (month + 1) + "/" + year;
                MealsDatabase mealsDatabase = MealsDatabase.getInstance(requireContext());
                MealDAO mealDAO = mealsDatabase.getMealDAO();
                mealWithDay = mealDAO.getMealsOfDay(selectedDate);
                mealWithDay.observe(getViewLifecycleOwner(), new Observer<List<DayWithMeal>>() {
                    @Override
                    public void onChanged(List<DayWithMeal> dayWithMeals) {
                        if(dayWithMeals != null && !dayWithMeals.isEmpty()) {
                            System.out.println("Number of DayWithMeals: " + dayWithMeals.size());
                            for (DayWithMeal dayWithMeal : dayWithMeals) {
                                System.out.println("Day: " + dayWithMeal.getDay().getDay());
                                System.out.println("Number of Meals: " + dayWithMeal.getMealsList().size());
                                for (Meals meal : dayWithMeal.getMealsList()) {
                                    System.out.println("Meal: " + meal.getStrMeal());
                                }
                            }
                            myPlannerAdapter.setList(dayWithMeals.get(0).getMealsList());
                        } else {
                            System.out.println("Bye");
                            myPlannerAdapter.setList(new ArrayList<>());
                        }
                    }
                });
            }
        });
    }

    @Override
    public void showDate(List<Meals> meals) {
        if(meals != null){
            myPlannerAdapter.setList(meals);
        }
    }

    @Override
    public void onFavClick(Meals meals, boolean btnBtnState) {

    }

    @Override
    public void onUnFavClick(Meals meals) {
        if (meals != null) {
            plannerPresenter.removeFromPlanner(meals);
        }
    }
}