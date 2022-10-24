package com.example.market_kurly.home;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.market_kurly.R;

import java.util.ArrayList;


public class HomeNewFragment extends Fragment {
    GridView grid_home_new;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home_new, container, false);
        grid_home_new = v.findViewById(R.id.grid_home_new);

        ArrayList<PrizeDTO> new_list = new DtoParty().dtoParty().get("new");

        HomeNewAdapter newAdapter = new HomeNewAdapter(inflater, new_list,getActivity());
        grid_home_new.setAdapter(newAdapter);





        return v;
    }
}