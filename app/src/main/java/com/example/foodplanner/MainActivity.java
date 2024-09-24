package com.example.foodplanner;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.foodplanner.View.FavourateFragment;
import com.example.foodplanner.View.HomeFragment;
import com.example.foodplanner.View.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    HomeFragment homeFragment;
    SearchFragment searchFragment;
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


        /* Init my UI components */
        init();

        /* BottomBar Navigation Handler through Fragments */
     /*   bottomNavigationView.setOnItemSelectedListener(item -> {

            int itemID = item.getItemId();

            if(R.id.navigation_home == itemID){
                replaceFragment(new HomeFragment());
            }else{
                if(R.id.navigation_search == itemID){
                    replaceFragment(new SearchFragment());
                }else{
                    if(R.id.navigation_favorite == itemID){
                        replaceFragment(new FavourateFragment());
                    }
                }
            }
            return true;
        });*/

        replaceFragment(new HomeFragment());
    }

    private void replaceFragment(Fragment fragment){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView,fragment);
        fragmentTransaction.commit();
    }
    private void init(){
        fragmentContainerView = findViewById(R.id.fragmentContainerView);
        bottomNavigationView = findViewById(R.id.bottomNavBar);
    }
}