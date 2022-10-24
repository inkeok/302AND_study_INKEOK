package com.example.market_kurly;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.market_kurly.home.HomeFragment;
import com.example.market_kurly.home.PrizeDTO;
import com.example.market_kurly.menu.MainMenuFragment;
import com.example.market_kurly.person.Person_Fragment;
import com.example.market_kurly.person.Person_login_Fragment;
import com.example.market_kurly.search.SearchFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    BottomNavigationView btm_nav;
    public static int container_state = 0;
    ImageView top_img, top_cart, top_location;
    TextView top_text;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        top_img = findViewById(R.id.top_img);
        top_cart = findViewById(R.id.top_cart);
        top_location = findViewById(R.id.top_location);
        top_text = findViewById(R.id.top_text);
        top_text.setVisibility(View.GONE);

        top_location.setOnClickListener(this);
        top_cart.setOnClickListener(this);



        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
        btm_nav = findViewById(R.id.btm_nav);
        btm_nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // item
                if(item.getItemId() == R.id.home){
                    top_img.setVisibility(View.VISIBLE);
                    top_text.setVisibility(View.GONE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();
                }else if(item.getItemId() == R.id.menu){
                    top_img.setVisibility(View.GONE);
                    top_text.setText("카테고리");
                    top_text.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainMenuFragment()).commit();
                }else if(item.getItemId() == R.id.search){
                    top_img.setVisibility(View.GONE);
                    top_text.setText("검색");
                    top_text.setVisibility(View.VISIBLE);
                    getSupportFragmentManager().beginTransaction().replace(R.id.container, new SearchFragment()).commit();
                }else if(item.getItemId() == R.id.person){
                    top_img.setVisibility(View.GONE);
                    top_text.setText("마이컬리");
                    top_text.setVisibility(View.VISIBLE);
                    if(Person_Fragment.login_state == 0) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Person_Fragment()).commit();
                    }else if(Person_Fragment.login_state == 1){
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, new Person_login_Fragment()).commit();
                    }
                }
                return true;
            }
        });




    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK :
            if (container_state == 1) {
                getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainMenuFragment()).commit();
                container_state = 0;
                return true;
            }
                break;

        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.top_location){
            LocationSheetFragment location_bottomSheet = new LocationSheetFragment();
            location_bottomSheet.show(getSupportFragmentManager(), location_bottomSheet.getTag());

        }else if(v.getId() == R.id.top_cart){
            Intent intent = new Intent(this, CartActivity.class);

            startActivity(intent);
        }
    }
}