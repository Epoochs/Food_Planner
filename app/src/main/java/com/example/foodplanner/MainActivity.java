package com.example.foodplanner;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodplanner.View.Favourate.FavourateFragment;
import com.example.foodplanner.View.Home.HomeFragment;
import com.example.foodplanner.View.Planner.PlannerFragment;
import com.example.foodplanner.View.Search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    SearchFragment searchFragment;
    FavourateFragment favourateFragment;
    PlannerFragment plannerFragment;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    BottomNavigationView bottomNavigationView;
    FragmentContainerView fragmentContainerView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        /* Init my UI components */
        init();

        /* BottomBar Navigation Handler through Fragments */
        bottomNavigationView.setOnItemSelectedListener(item -> {

            int itemID = item.getItemId();

            if(R.id.navigation_home == itemID){
                replaceFragment(homeFragment == null ? homeFragment = new HomeFragment() : homeFragment);
            }else{
                if(R.id.navigation_search == itemID){
                    replaceFragment(searchFragment == null ? searchFragment = new SearchFragment() : searchFragment);
                }else{
                    if(R.id.navigation_favorite == itemID){
                        replaceFragment(favourateFragment == null ? favourateFragment = new FavourateFragment() : favourateFragment);
                    }else{
                        if(R.id.navigation_cal == itemID){
                            replaceFragment(plannerFragment == null ? plannerFragment = new PlannerFragment() : plannerFragment);
                        }
                    }
                }
            }
            return true;
        });

        replaceFragment(homeFragment == null ? homeFragment = new HomeFragment() : homeFragment);
    }

    private void replaceFragment(Fragment fragment){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        Fragment ifExist = fragmentManager.findFragmentByTag(fragment.getClass().getSimpleName());

        if(ifExist == null){
            fragmentTransaction.replace(R.id.fragmentContainerView,fragment, fragment.getClass().getSimpleName());
        }else{
            fragmentTransaction.replace(R.id.fragmentContainerView,ifExist);
        }
        fragmentTransaction.commit();
    }
    private void init(){
        fragmentContainerView = findViewById(R.id.fragmentContainerView);
        bottomNavigationView = findViewById(R.id.bottomNavBar);
    }
}