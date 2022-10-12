package com.example.project01_clone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class SplashActivity extends AppCompatActivity {
    //1. 액티비티 메인이 맨 처음에 실행되는 이유가 있음.
    // 안드로이드 앱(Meta_data) 실행 시 어떤 설정이나 권한등을 설정해놓은 xml파일.
    // => AndroidMainfest.xml




    //Splash - 몇초정도 지연을 시켰다가 다음 화면인 메인 액티비티로 이동을 해야함.
    //Thread <- 자바쓰레드
    //Handler <- 안드에서 사용하는 비동기 쓰레드
    //RunOnUiThread <- 안드에서 사용하는 비동기 쓰레드



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        //내가 사용하려는 메소드의 파라메터가 Interface 타입인경우
        /*ProgressDialog dialog = new ProgressDialog(this);
        dialog.setTitle("데이터 로딩중..");
        dialog.setMessage("로딩중");
        dialog.show();*/


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //dialog.dismiss();// show 반대 안보이게 하는 처리
                //3초뒤에 실행되는 부분

                Log.d("로그", "1.5초뒤");
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
                finish(); //현재 액티비티를 닫는 처리
            }
        }, 1500);
    }


}