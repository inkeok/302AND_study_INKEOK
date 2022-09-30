package com.example.and08_middletest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    int cnt = 2;
    int cnt2 = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_change = findViewById(R.id.btn_change);

        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<ImageView> list = new ArrayList<>();
                list.add(findViewById(R.id.pic1));
                list.add(findViewById(R.id.pic2));
                list.add(findViewById(R.id.pic3));

                if (cnt == 2 || cnt == 1){
                    list.get(cnt).setVisibility(View.INVISIBLE);
                    cnt--;
                }else if(cnt == 0) {
                    list.get(cnt).setVisibility(View.INVISIBLE);
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setVisibility(View.VISIBLE);
                    }
                    cnt = 2;
                }
            }
        }); //btn_change

        Button btn_move = findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<ImageView> list2 = new ArrayList<>();
                list2.add(findViewById(R.id.pic4));
                list2.add(findViewById(R.id.pic5));
                if(cnt2 == 1){
                    list2.get(cnt2).setVisibility(View.INVISIBLE);
                    cnt2--;
                }else{
                    list2.get(cnt2+1).setVisibility(View.VISIBLE);
                    cnt2++;
                }
            }
        });
    }
}