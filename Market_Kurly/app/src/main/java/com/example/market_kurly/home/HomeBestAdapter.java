package com.example.market_kurly.home;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market_kurly.MainActivity;
import com.example.market_kurly.R;

import java.util.ArrayList;

public class HomeBestAdapter extends RecyclerView.Adapter<HomeBestAdapter.HomeBestHolder> {

    LayoutInflater inflater;
    ArrayList<Integer> best_list;
    MainActivity context;

    public HomeBestAdapter(LayoutInflater inflater, ArrayList<Integer> best_list, Activity context) {
        this.inflater = inflater;
        this.best_list = best_list;
        this.context =(MainActivity) context;
    }

    @NonNull
    @Override
    public HomeBestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeBestHolder(inflater.inflate(R.layout.item_home_banner, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeBestHolder h, int i) {
        h.home_best_img.setImageResource(best_list.get(i));
    }

    @Override
    public int getItemCount() {
        return best_list.size();
    }

    public class HomeBestHolder extends RecyclerView.ViewHolder{
          ImageView home_best_img;
        public HomeBestHolder(@NonNull View v) {
            super(v);
            home_best_img =  v.findViewById(R.id.home_best_img);
        }
    }
}
