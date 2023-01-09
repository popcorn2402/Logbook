package com.ar.logbook.viewmodel;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.ar.logbook.model.entity.DailyLog;
import com.ar.logbook.model.repository.DailyLogRepository;

import java.sql.Date;
import java.util.List;

public class DailyLogViewModel extends AndroidViewModel {

    private DailyLogRepository mRepository;

    private final LiveData<List<DailyLog>> mAllDailyLog;

    public DailyLogViewModel (Application application) {
        super(application);
        mRepository = new DailyLogRepository(application);
        mAllDailyLog = mRepository.getAllDailyLog();
    }

    LiveData<List<DailyLog>> getAllDailyLog() { return mAllDailyLog; }

    public void insert(DailyLog dailyLog) { mRepository.insert(dailyLog); }

    public void deleteByDate(Date date) { mRepository.deleteByDate(date); }
}
