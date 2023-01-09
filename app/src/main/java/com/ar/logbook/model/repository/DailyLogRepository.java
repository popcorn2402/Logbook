package com.ar.logbook.model.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.ar.logbook.model.dao.DailyLogDAO;
import com.ar.logbook.model.entity.DailyLog;

import java.sql.Date;
import java.util.List;

public class DailyLogRepository {

    private DailyLogDAO mDailyLogDao;
    private LiveData<List<DailyLog>> mAllDailyLog;

    public DailyLogRepository(Application application) {
        DailyLogRoomDatabase db = DailyLogRoomDatabase.getDatabase(application);
        mDailyLogDao = db.dailyLogDAO();
        mAllDailyLog = mDailyLogDao.getAlphabetizedWords();
    }

    public LiveData<List<DailyLog>> getAllDailyLog() {
        return mAllDailyLog;
    }

    public void insert(DailyLog dailyLog) {
        DailyLogRoomDatabase.databaseWriteExecutor.execute(() -> {
            mDailyLogDao.insert(dailyLog);
        });
    }

    public void deleteByDate(Date date) {
        DailyLogRoomDatabase.databaseWriteExecutor.execute(() -> {
            mDailyLogDao.deleteByDate(date);
        });
    }
}
