package com.ar.logbook.model.repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.ar.logbook.model.Converters;
import com.ar.logbook.model.dao.DailyLogDAO;
import com.ar.logbook.model.dao.DailyLogDAO_Impl;
import com.ar.logbook.model.entity.DailyLog;

import java.sql.Date;
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
                            .addCallback(sRoomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {

        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            // If you want to keep data through app restarts,
            // comment out the following block
            databaseWriteExecutor.execute(() -> {
                // Populate the database in the background.
                // If you want to start with more words, just add them.
                DailyLogDAO dao = INSTANCE.dailyLogDAO();
                dao.deleteAll();

                Date date = new Date(System.currentTimeMillis());

                DailyLog dailyLog = new DailyLog("DailyLog Test", date, 5, 5, "Lorem Ipsum");
                dao.insert(dailyLog);

                DailyLog dailyLog1 = new DailyLog("DailyLog Test 1", Date.valueOf("2022-01-08"), 4, 3, "Lorem Ipsum");
                dao.insert(dailyLog1);
            });
        }
    };
}