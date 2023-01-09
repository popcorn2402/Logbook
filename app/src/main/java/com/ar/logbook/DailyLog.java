package com.ar.logbook;

import androidx.annotation.NonNull;

import java.io.File;
import java.util.Date;

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

    @ColumnInfo(name = "photos")
    private File photo;

    public DailyLog(String title, @NonNull Date date, int mood, int energy, String notes, File photo) {
        this.title = title;
        this.date = date;
        this.mood = mood;
        this.energy = energy;
        this.notes = notes;
        this.photo = photo;
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

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }
}
