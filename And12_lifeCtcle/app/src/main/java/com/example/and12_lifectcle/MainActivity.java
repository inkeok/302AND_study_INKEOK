package com.example.and12_lifectcle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //메인액티비티에 프래그먼트 하나 붙여보기.
        //1. 붙일 공간을 마련함(container)
        //2. 프래그먼트 하나 만듬
        //3. getSupportFragmentManger.BeginTransaction().replace()??.commit();

        Test_Frag fg = new Test_Frag();
        getSupportFragmentManager().beginTransaction().replace(R.id.container , fg).commit();

        Log.d("수명주기", "onCreate: ");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("수명주기", "onStart: ");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("수명주기", "onResume: ");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("수명주기", "onPause: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("수명주기", "onStop: ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("수명주기", "onDestroy: ");
    }
}