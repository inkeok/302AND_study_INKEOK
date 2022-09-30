package com.example.ex10_vendingmachine;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {

   TextView text1, text2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);

        Intent intent = getIntent();

        int insert_money = intent.getIntExtra("insert_money",0);
        int money_sum = intent.getIntExtra("money_sum",0);
        int coke_cnt = intent.getIntExtra("coke_cnt",0);
        int cidar_cnt = intent.getIntExtra("cidar_cnt",0);
        int fanta_cnt = intent.getIntExtra("fanta_cnt",0);
        int demisoda_cnt = intent.getIntExtra("demisoda_cnt",0);

        text1.setText("잔액 : "+ (insert_money - money_sum)+"원");
        text2.setText("콜라 : "+coke_cnt+"개, "+"사이다 : "+cidar_cnt+"개, "+"환타 : "+fanta_cnt+"개, "+"데미소다 : "+demisoda_cnt+"개");



    }
}
