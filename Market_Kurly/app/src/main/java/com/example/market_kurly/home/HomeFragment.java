package com.example.market_kurly.home;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



import com.example.market_kurly.R;


import com.google.android.material.tabs.TabLayout;


public class HomeFragment extends Fragment {
    TabLayout tabs_menu;


    FragmentActivity activity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        activity = HomeFragment.super.getActivity();

        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frag_home_main, new HomeMainFragment()).commit();

        tabs_menu = v.findViewById(R.id.tabs_menu);

        tabs_menu.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if(tab.getPosition() == 0){

                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frag_home_main, new HomeMainFragment()).commit();
                }else if (tab.getPosition()==1){
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frag_home_main, new HomeNewFragment()).commit();

                }else if (tab.getPosition()==2){
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frag_home_main, new HomePopFragment()).commit();

                }else if (tab.getPosition()==3){

                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frag_home_main, new HomeAlFragment()).commit();
                }else if (tab.getPosition()==4){

                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.frag_home_main, new HomeBestFragment()).commit();
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });





        return v;
    }

}
