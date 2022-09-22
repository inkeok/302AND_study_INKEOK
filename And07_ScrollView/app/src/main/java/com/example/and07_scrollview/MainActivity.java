package com.example.and07_scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.btn);
        TextView text = findViewById(R.id.text);

        //줄바꿈 처리를 어떻게 했었는 가==이스케이프문장
        //for문을 이용해서 택스트뷰어에 append라는 메소드를 이용하여 글씨 붙히기
        HorizontalScrollView hsc = findViewById(R.id.hsc);
        ScrollView sc = findViewById(R.id.sc);






        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hsc.smoothScrollTo(hsc.getScrollX()+100, 0);
                for (int i = 1; i < 30; i++) {
                    text.append("\n임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진임임임승승승진진진.");
                }


            }
        });


    }
}