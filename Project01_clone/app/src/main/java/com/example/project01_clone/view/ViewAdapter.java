package com.example.project01_clone.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {
LayoutInflater inflater;

    public ViewAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 3;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
            TextView v_tv_title, v_tv_title_main, v_tv_title_sub;
            ImageView v_img_title, v_img_content;
        public ViewHolder(@NonNull View v) {
            super(v);
            v_img_title  = v.findViewById(R.id.v_img_title);
            v_tv_title = v.findViewById(R.id.v_tv_title);
            v_tv_title_main = v.findViewById(R.id.v_tv_title_main);
            v_tv_title_sub = v.findViewById(R.id.v_tv_title_sub);
            v_img_content = v.findViewById(R.id.v_img_content);


        }
    }
}
