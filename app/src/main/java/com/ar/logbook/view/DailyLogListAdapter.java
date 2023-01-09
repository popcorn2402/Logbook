package com.ar.logbook.view;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.ar.logbook.model.entity.DailyLog;

public class DailyLogListAdapter extends ListAdapter<DailyLog, DailyLogViewHolder> {

    public DailyLogListAdapter(@NonNull DiffUtil.ItemCallback<DailyLog> diffCallback) {
        super(diffCallback);
    }

    @Override
    public DailyLogViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return DailyLogViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(DailyLogViewHolder holder, int position) {
        DailyLog current = getItem(position);
        holder.bind(current);
    }

    static class DailyLogDiff extends DiffUtil.ItemCallback<DailyLog> {

        @Override
        public boolean areItemsTheSame(@NonNull DailyLog oldItem, @NonNull DailyLog newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull DailyLog oldItem, @NonNull DailyLog newItem) {
            return oldItem.getTitle().equals(newItem.getTitle());
        }
    }
}
