package com.example.and13_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class SubActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        //메인 액티비티 => 인텐트 > 서브액티비티
        Intent intent = getIntent(); //메인에서 보내준 인텐트 객체를 인스턴스화 시킴(사용준비)
        LoginDTO loginDTO = (LoginDTO) intent.getSerializableExtra("dto");

        Log.d("TAG", "onCreate: "+loginDTO.getId() + loginDTO.getPw());

        String sKey = intent.getStringExtra("sKey");
        int inKey = intent.getIntExtra("inKey", 0);
        int tempInt = intent.getIntExtra("iKey33", -1);
        ArrayList<String> list = (ArrayList<String>) intent.getSerializableExtra("list");
        Log.d("TAG", "onCreate: "+ list.size());
        //int형 변수에는 null을 넣을수 없기 때문에 iKey값을 찾아서 해당하는 키를 사용하는
        //데이터가 없다면 return을 줄수가 없음 따라서 기본으로 담을 값을 지정해둠.


        Toast.makeText(SubActivity.this , sKey, Toast.LENGTH_SHORT).show();
                            //현재화면 액티비티 , 값(출력), 보여주는 시간
        Toast.makeText(SubActivity.this, inKey+"", Toast.LENGTH_SHORT).show();
        Toast.makeText(SubActivity.this, tempInt+"", Toast.LENGTH_SHORT).show();


    }
}