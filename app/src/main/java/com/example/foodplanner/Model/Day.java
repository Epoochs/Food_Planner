package com.example.foodplanner.Model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "Day")
public class Day {
    @NonNull
    @PrimaryKey(autoGenerate = false)
    private String day;

    public Day(){}
    public void setDay(String date) {
        this.day = date;
    }
    public String getDay() {
        return day;
    }
}
