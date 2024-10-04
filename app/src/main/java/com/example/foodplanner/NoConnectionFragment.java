package com.example.foodplanner;

import static androidx.core.content.ContextCompat.getSystemService;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class NoConnectionFragment extends Fragment {

    View view;
    Button btnRetry;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_no_connection, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnRetry = view.findViewById(R.id.btnRetry);

        btnRetry.setOnClickListener(v -> {
            if(checkConnection()){
                Intent intent = new Intent(getContext(), MainActivity.class);
                intent.putExtra("NetState", true);
                requireContext().startActivity(intent);
            }else{
                Toast.makeText(requireContext(), "No internet Connection", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private boolean checkConnection(){
        ConnectivityManager connectivityManager = (ConnectivityManager) requireContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        if(activeNetworkInfo == null)
            return false;

        return activeNetworkInfo.isConnected();
    }
}