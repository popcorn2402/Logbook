package com.ar.logbook.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.ar.logbook.R;

import java.sql.Date;

public class DailyLogViewHolder extends RecyclerView.ViewHolder {
    private final TextView dailyLogTitleView;
    private final TextView dailyLogMoodView;
    private final TextView dailyLogEnergyView;
    private final TextView dailyLogNotesView;
    private final TextClock dailyLogDateView;

    private DailyLogViewHolder(View itemView) {
        super(itemView);
        dailyLogTitleView = itemView.findViewById(R.id.title_tv);
        dailyLogMoodView = itemView.findViewById(R.id.mood_tv);
        dailyLogEnergyView = itemView.findViewById(R.id.energy_tv);
        dailyLogNotesView = itemView.findViewById(R.id.notes_tv);
        dailyLogDateView = itemView.findViewById(R.id.date_tc);
    }

    public void bind(String title, Date date, int mood, int energy, String notes) {
        dailyLogTitleView.setText(title);
        dailyLogDateView.setText(date.toString());
        dailyLogMoodView.setText(mood);
        dailyLogEnergyView.setText(energy);
        dailyLogNotesView.setText(notes);
    }

    static DailyLogViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new DailyLogViewHolder(view);
    }
}