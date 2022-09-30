package com.example.and08_testlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn1, btn3;
    ImageView img1, img3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn3 = findViewById(R.id.btn3);

        img1 = findViewById(R.id.img1);
        img3 = findViewById(R.id.img3);

        btn1.setTag("1");
        btn3.setTag("1");
        btn1.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }
    // View < Java Object(객체)를 상속받은 객체 (화면에 보이는 모든것들은 View의 자식 클래스이다)
    // Object < 자바에서 사용되는 대부분의 타입은 Object의 자식 클래스이다.
    @Override
    public void onClick(View v) {
        //btn1과 btn3가 똑같은 onClick이라는 메소드가 실행됨에 따라 구분해주어야함
        if(v.getId() == R.id.btn1){
            if (v.getTag().equals("1")) {
                img1.setImageResource(R.drawable.ic_launcher_foreground);
                v.setTag("2");
            }else{
                img1.setImageResource(R.drawable.ic_launcher_background);
                v.setTag("1");
            }
        }else if(v.getId() == R.id.btn3){
            if (v.getTag().equals("1")) {
                img3.setImageResource(R.drawable.ic_launcher_foreground);
                v.setTag("2");
            }else{
                img3.setImageResource(R.drawable.ic_launcher_background);
                v.setTag("1");
            }
        }
    }
}
