package com.example.foodplanner.Networking;

import com.example.roommvp.Model.Products;

import java.util.List;

public interface NetworkCallback {
    public void onSuccessResult(List<Products> movies);

    public void onFalureResult(String str);
}
