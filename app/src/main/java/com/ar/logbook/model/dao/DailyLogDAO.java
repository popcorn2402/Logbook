package com.ar.logbook.model.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ar.logbook.model.entity.DailyLog;

import java.sql.Date;
import java.util.List;

@Dao
public interface DailyLogDAO {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    void insert(DailyLog dailyLog);

    @Query("DELETE FROM daily_log_table WHERE date = :date")
    void deleteByDate(Date date);

    @Query("DELETE FROM daily_log_table")
    void deleteAll();

    @Query("SELECT * FROM daily_log_table ORDER BY date ASC")
    LiveData<List<DailyLog>> getAlphabetizedWords();
}
