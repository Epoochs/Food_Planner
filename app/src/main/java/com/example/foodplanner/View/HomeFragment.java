package com.example.foodplanner.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.foodplanner.Model.Meals;
import com.example.foodplanner.Networking.Client;
import com.example.foodplanner.Networking.NetworkCallback;
import com.example.foodplanner.R;

import java.util.List;


public class HomeFragment extends Fragment implements NetworkCallback {

    Button btnFav;
    RatingBar ratingBar;
    View view;
    ImageView imageView;
    TextView tvName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Client client = Client.getInstance();
        client.makeNetworkCallback(this);
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init();
    }

    private void init(){
        btnFav = view.findViewById(R.id.btnFav1);
        ratingBar = view.findViewById(R.id.ratingBar);
        imageView = view.findViewById(R.id.imageView);
        tvName = view.findViewById(R.id.tvMealName);
    }

    @Override
    public void onSuccessResult(List<Meals> meals) {
        tvName.setText(meals.get(0).getStrMeal());
        ratingBar.setRating(5);
    }

    @Override
    public void onFalureResult(String str) {
        System.out.println("La");
    }
}