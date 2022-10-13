package com.example.middle01_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.middle01_retrofit.Middle.ApiClient;
import com.example.middle01_retrofit.Middle.ApiInterface;
import com.example.middle01_retrofit.Middle.CommonAskTask;

public class MainActivity extends AppCompatActivity {
    Button btn_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_result = findViewById(R.id.btn_result);


        btn_result.setOnClickListener(v -> {
            CommonAskTask askTask = new CommonAskTask("list" , this);
            askTask.executeAsk(new CommonAskTask.AsynkTaskCallback() {
                @Override
                public void onResult(String data, boolean inResult) {
                    Log.d("로그", "onResult: "+data);
                }
            });

        });



    }
}