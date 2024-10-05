package com.example.foodplanner.Networking;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class ConnectivityRepository {
    private final ConnectivityManager connectivityManager;
    private final MutableLiveData<Boolean> isConnected = new MutableLiveData<>(false);

    public ConnectivityRepository(Context context) {
        connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        // Observe network connectivity changes
        connectivityManager.registerDefaultNetworkCallback(new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(Network network) {
                isConnected.postValue(true);
            }

            @Override
            public void onLost(Network network) {
                isConnected.postValue(false);
            }
        });
    }

    public LiveData<Boolean> getIsConnected() {
        return isConnected;
    }
}
