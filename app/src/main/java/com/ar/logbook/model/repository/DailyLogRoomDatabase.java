package com.ar.logbook.model.repository;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.ar.logbook.model.Converters;
import com.ar.logbook.model.dao.DailyLogDAO;
import com.ar.logbook.model.entity.DailyLog;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {DailyLog.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class DailyLogRoomDatabase extends RoomDatabase {

    public abstract DailyLogDAO dailyLogDAO();

    private static volatile DailyLogRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static DailyLogRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (DailyLogRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    DailyLogRoomDatabase.class, "daily_log_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}