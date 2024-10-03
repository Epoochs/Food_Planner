package com.example.foodplanner.View.Search;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.foodplanner.R;
import com.example.foodplanner.View.Category.CategoryActivity;
import com.example.foodplanner.View.Country.CountryActivity;
import com.example.foodplanner.View.Ingredient.IngredActivity;

public class SearchFragment extends Fragment {

    Button btnCategor, btnArea, btnIngredients;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnCategor = view.findViewById(R.id.btnSearchCat);
        btnArea = view.findViewById(R.id.btnSearchCntry);
        btnIngredients = view.findViewById(R.id.btnSearchIng);

        btnCategor.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), CategoryActivity.class);
            startActivity(intent);
        });

        btnArea.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), CountryActivity.class);
            startActivity(intent);
        });

        btnIngredients.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), IngredActivity.class);
            startActivity(intent);
        });
    }
}