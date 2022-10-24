package com.example.market_kurly.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.market_kurly.R;

import java.util.ArrayList;


public class HomeBestFragment extends Fragment {
    RecyclerView recv_home_banner;
    ArrayList<Integer> best_list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_best, container, false);

        recv_home_banner = v.findViewById(R.id.recv_home_banner);
        best_list.add(R.drawable.best_01);
        best_list.add(R.drawable.best_02);
        best_list.add(R.drawable.best_03);
        best_list.add(R.drawable.best_04);
        best_list.add(R.drawable.best_05);
        best_list.add(R.drawable.best_06);
        best_list.add(R.drawable.best_07);
        best_list.add(R.drawable.best_08);
        best_list.add(R.drawable.best_09);
        best_list.add(R.drawable.best_10);


        HomeBestAdapter homeBestAdapter = new HomeBestAdapter(inflater, best_list, getActivity());
        recv_home_banner.setAdapter(homeBestAdapter);
        RecyclerView.LayoutManager homeBestManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recv_home_banner.setLayoutManager(homeBestManager);






        return v;
    }
}