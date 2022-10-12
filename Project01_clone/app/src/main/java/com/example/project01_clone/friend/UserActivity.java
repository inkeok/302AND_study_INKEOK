package com.example.project01_clone.friend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.project01_clone.MainActivity;
import com.example.project01_clone.R;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        int img = getIntent().getIntExtra("사진",0);
        String name = getIntent().getStringExtra("이름");
        String stateMess = getIntent().getStringExtra("상메");

        ImageView rimg = findViewById(R.id.R_img);
        TextView rname = findViewById(R.id.R_name);
        TextView rstateMess = findViewById(R.id.R_stateMess);
        TextView tv_close = findViewById(R.id.tv_close);

        rimg.setImageResource(img);
        rname.setText(name);
        rstateMess.setText(stateMess);

        tv_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });



    }
}