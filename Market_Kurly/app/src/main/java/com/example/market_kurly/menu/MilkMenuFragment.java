package com.example.market_kurly.menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.market_kurly.R;
import com.example.market_kurly.home.DtoParty;
import com.example.market_kurly.home.HomeNewAdapter;
import com.example.market_kurly.home.PrizeDTO;

import java.util.ArrayList;


public class MilkMenuFragment extends Fragment {
    GridView grid_menu_milk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_milk_menu, container, false);

        grid_menu_milk = v.findViewById(R.id.grid_menu_milk);

        ArrayList<PrizeDTO> new_list = new DtoParty().dtoParty().get("milk");

        HomeNewAdapter newAdapter = new HomeNewAdapter(inflater, new_list,getActivity());
        grid_menu_milk.setAdapter(newAdapter);



        return v;
    }
}