package com.example.market_kurly.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.market_kurly.R;

import java.util.ArrayList;


public class HomeAlFragment extends Fragment {
    GridView grid_home_al;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_al, container, false);
        grid_home_al = v.findViewById(R.id.grid_home_new);

        ArrayList<PrizeDTO> al_list = new DtoParty().dtoParty().get("al");

        HomeAlAdapter alAdapter = new HomeAlAdapter(inflater, al_list);
        grid_home_al.setAdapter(alAdapter);

        return v;
    }
}