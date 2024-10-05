package com.example.foodplanner;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import com.example.foodplanner.Networking.ConnectivityRepository;
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
    NoConnectionFragment noConnectionFragment;
    FragmentTransaction fragmentTransaction;
    FragmentManager fragmentManager;
    BottomNavigationView bottomNavigationView;
    FragmentContainerView fragmentContainerView;
    boolean networkState = false;
    ConnectivityRepository connectivityRepository;
    int count = 0;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        Intent intent = getIntent();
        networkState = intent.getBooleanExtra("NetState", true);

        /* Init my UI components */
        init();

        /* BottomBar Navigation Handler through Fragments */
        bottomNavigationView.setOnItemSelectedListener(item -> {

            int itemID = item.getItemId();

            if(R.id.navigation_home == itemID){
                if(networkState) {
                    replaceFragment(homeFragment == null ? homeFragment = new HomeFragment() : homeFragment);
                }else{
                    replaceFragment(noConnectionFragment == null ? noConnectionFragment = new NoConnectionFragment() : noConnectionFragment);
                }
            }else{
                if(R.id.navigation_search == itemID){
                    if(networkState) {
                        replaceFragment(searchFragment == null ? searchFragment = new SearchFragment() : searchFragment);
                    }else{
                        replaceFragment(noConnectionFragment == null ? noConnectionFragment = new NoConnectionFragment() : noConnectionFragment);
                    }
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

       /* if(checkConnection()){
            networkState = true;
        }else{
            Toast.makeText(MainActivity.this, "Connection is Lost", Toast.LENGTH_SHORT).show();
            networkState = false;
        }*/
        connectivityRepository = new ConnectivityRepository(getApplicationContext());
        connectivityRepository.getIsConnected().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    Toast.makeText(MainActivity.this, "Network is available", Toast.LENGTH_SHORT).show();
                    networkState = true;
                    if(count < 1){
                        showUnAvailableDialog();
                    }
                    count++;
                }else{
                    Toast.makeText(MainActivity.this, "No network available", Toast.LENGTH_SHORT).show();
                    networkState = false;
                }
            }
        });

        if(networkState){
            replaceFragment(homeFragment == null ? homeFragment = new HomeFragment() : homeFragment);
        }else{
            replaceFragment(noConnectionFragment == null ? noConnectionFragment = new NoConnectionFragment() : noConnectionFragment);
        }
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

    private void showUnAvailableDialog() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Network Status");
        builder.setMessage("Connection is not available, would you to proceed with your Favourites?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                replaceFragment(favourateFragment == null ? favourateFragment = new FavourateFragment() : favourateFragment);
                bottomNavigationView.setSelectedItemId(R.id.navigation_favorite);
            }
        });

        // Set negative button
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

   /* private void checkConnection1(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(MainActivity.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        NetworkRequest networkRequest = new NetworkRequest.Builder()
                .addCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
                .build();

        connectivityManager.registerNetworkCallback(networkRequest, new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(Network network) {
                System.out.println("Available");
                if(isLost > 0) {
                    Toast.makeText(MainActivity.this, "Connection restored", Toast.LENGTH_SHORT).show();
                    isLost = 0;
                }
                networkState = true;
            }

            @Override
            public void onUnavailable() {
                networkState = false;
                System.out.println("UnAvailable");
                showUnAvailableDialog();
            }

            @Override
            public void onLost(Network network) {
                System.out.println("Lost");
                Toast.makeText(MainActivity.this, "Connection is Lost", Toast.LENGTH_SHORT).show();
                isLost++;
            }
        });
    }*/

   /* private boolean checkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(MainActivity.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if(activeNetworkInfo == null)
            return false;

        return activeNetworkInfo.isConnected();
    }*/
}