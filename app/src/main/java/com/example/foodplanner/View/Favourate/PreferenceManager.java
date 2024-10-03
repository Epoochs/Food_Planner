package com.example.foodplanner.View.Favourate;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceManager {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static final String PREF_NAME = "MyPrefs";

    private PreferenceManager() {}

    public static void getSharedInstance(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
            editor = sharedPreferences.edit();
        }
    }

    // Method to save a string value
    public static void saveBoolean(String key, boolean value) {
        editor.putBoolean(key, value);
        editor.apply();
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        return sharedPreferences.getBoolean(key, defaultValue);
    }

    // Method to remove a value
    public static void remove(String key) {
        editor.remove(key);
        editor.apply();
    }

    // Method to clear all data
    public static void clearAll() {
        editor.clear();
        editor.apply();
    }
}

