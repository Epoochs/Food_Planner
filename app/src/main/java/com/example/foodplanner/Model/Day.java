package com.example.foodplanner.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "days")
public class Day {
    @PrimaryKey
    private int dayID;

    private Date date;

    public Day(int dayID, Date date) {
        this.dayID = dayID;
        this.date = date;
    }

    public void setID(int ID) {
        this.dayID = ID;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public int getID() {
        return dayID;
    }
    public Date getDate() {
        return date;
    }
}
