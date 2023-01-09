package com.ar.logbook.model.entity;

import androidx.annotation.NonNull;

import java.sql.Date;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "daily_log_table")
public class DailyLog {

    @ColumnInfo(name = "title")
    private String title;

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "date")
    private Date date;

    @ColumnInfo(name = "mood")
    private int mood;

    @ColumnInfo(name = "energy")
    private int energy;

    @ColumnInfo(name = "notes")
    private String notes;

    public DailyLog(String title, @NonNull Date date, int mood, int energy, String notes) {
        this.title = title;
        this.date = date;
        this.mood = mood;
        this.energy = energy;
        this.notes = notes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getMood() {
        return mood;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

}
