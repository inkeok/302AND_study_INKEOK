package com.example.project01_clone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.project01_clone.friend.InfriendFragment;
import com.example.project01_clone.intalk.InTalkFragment;
import com.example.project01_clone.view.ViewFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ActionBar actionBar;
    BottomNavigationView btm_nav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        actionBar = getSupportActionBar(); // 기본적으로 안드로이드는 액션바가 있음.
                                            //가져오기 (메모리에 있는 객체를 가져옴)
      //  actionBar.setTitle("작은 세영");

        getSupportFragmentManager().beginTransaction().replace(R.id.container, new InfriendFragment()).commit();


        btm_nav = findViewById(R.id.btm_nav);
        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // item
                if      (item.getItemId() == R.id.menu1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new InfriendFragment()).commit();
                }else if(item.getItemId() == R.id.menu2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new InTalkFragment()).commit();
                }else if(item.getItemId() == R.id.menu3){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new ViewFragment()).commit();
                }else if(item.getItemId() == R.id.menu4){

                }else if(item.getItemId() == R.id.menu5){

                }

                return true; //false를 리턴하면 선택된것을 취소함.
            }
        });

           


    }


}