package com.example.market_kurly.menu;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.market_kurly.MainActivity;
import com.example.market_kurly.R;
import com.example.market_kurly.home.HomeFragment;


public class MainMenuFragment extends Fragment implements View.OnClickListener {
    RelativeLayout vege_menu1,vege_menu2, vege_menu3,milk_menu1,milk_menu2,milk_menu3,meat_menu1,meat_menu2,meat_menu3,sea_menu1,sea_menu2,sea_menu3,fru_menu1,fru_menu2,fru_menu3;

    FragmentActivity activity;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_main_menu, container, false);

        vege_menu1 = v.findViewById(R.id.vege_menu1);
        vege_menu2 = v.findViewById(R.id.vege_menu2);
        vege_menu3 = v.findViewById(R.id.vege_menu3);
        milk_menu1 = v.findViewById(R.id.milk_menu1);
        milk_menu2 = v.findViewById(R.id.milk_menu2);
        milk_menu3 = v.findViewById(R.id.milk_menu3);
        meat_menu1 = v.findViewById(R.id.meat_menu1);
        meat_menu2 = v.findViewById(R.id.meat_menu2);
        meat_menu3 = v.findViewById(R.id.meat_menu3);
        sea_menu1 = v.findViewById(R.id.sea_menu1);
        sea_menu2 = v.findViewById(R.id.sea_menu2);
        sea_menu3 = v.findViewById(R.id.sea_menu3);
        fru_menu1 = v.findViewById(R.id.fru_menu1);
        fru_menu2 = v.findViewById(R.id.fru_menu2);
        fru_menu3 = v.findViewById(R.id.fru_menu3);

        vege_menu1.setOnClickListener(this);
        vege_menu2.setOnClickListener(this);
        vege_menu3.setOnClickListener(this);
        milk_menu1.setOnClickListener(this);
        milk_menu2.setOnClickListener(this);
        milk_menu3.setOnClickListener(this);
        meat_menu1.setOnClickListener(this);
        meat_menu2.setOnClickListener(this);
        meat_menu3.setOnClickListener(this);
        sea_menu1 .setOnClickListener(this);
        sea_menu2 .setOnClickListener(this);
        sea_menu3 .setOnClickListener(this);
        fru_menu1 .setOnClickListener(this);
        fru_menu2 .setOnClickListener(this);
        fru_menu3 .setOnClickListener(this);

        activity = MainMenuFragment.super.getActivity();



        return v;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.vege_menu1 || v.getId()==R.id.vege_menu2 || v.getId()==R.id.vege_menu3){
            MainActivity.container_state = 1;
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new VegeMenuFragment()).commit();
        }else if(v.getId()==R.id.milk_menu1 || v.getId()==R.id.milk_menu2 || v.getId()==R.id.milk_menu3){
            MainActivity.container_state = 1;
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new MilkMenuFragment()).commit();
        }else if(v.getId()==R.id.meat_menu1 || v.getId()==R.id.meat_menu2 || v.getId()==R.id.meat_menu3){
            MainActivity.container_state = 1;
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new MeatMenuFragment()).commit();
        }else if(v.getId()==R.id.sea_menu1 || v.getId()==R.id.sea_menu2 || v.getId()==R.id.sea_menu3){
            MainActivity.container_state = 1;
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new SeaMenuFragment()).commit();
        }else if(v.getId()==R.id.fru_menu1 || v.getId()==R.id.fru_menu2 || v.getId()==R.id.fru_menu3){
            MainActivity.container_state = 1;
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, new FruMenuFragment()).commit();
        }


    }

}