package com.example.and09_widget;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn_check;
    TextView tv1;
    EditText edt1, edt2;
    View v1;
    String num;
    RadioButton rd_man, rd_woman, rbtn1, rbtn2, rbtn3, rbtn4, rbtn5;
    RadioGroup rd_grp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1 = findViewById(R.id.tv1);
        tv1.setOnClickListener(this);
        edt1 = findViewById(R.id.edt1);
        edt1.setOnClickListener(this);
        v1 = findViewById(R.id.v1);
        v1.setOnClickListener(this);

        btn_check = findViewById(R.id.btn_check);
        edt2 = findViewById(R.id.edt2);
        btn_check.setOnClickListener(this);

        rd_man = findViewById(R.id.rd_man);
        rd_woman = findViewById(R.id.rd_woman);



        rd_man.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    //Radio버튼 man이 체크 상태일때 실행되는 메소드
                    Log.d("뷰", "남성 : " + isChecked);
                    if (rd_man.isChecked()) {
                        rd_woman.setChecked(false);
                    }
                }
            });
        rd_woman.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //Radio버튼 woman이 체크 상태일때 실행되는 메소드
                Log.d("뷰", "여성 : " + isChecked);
                if (rd_woman.isChecked()) {
                    rd_man.setChecked(false);
                }
            }
        });
        rd_grp = findViewById(R.id.rd_grp);
        rbtn1=findViewById(R.id.rbtn1);
        rbtn2=findViewById(R.id.rbtn2);
        rbtn3=findViewById(R.id.rbtn3);
        rbtn4=findViewById(R.id.rbtn4);
        rbtn5=findViewById(R.id.rbtn5);

        rd_grp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                Log.d("뷰", "속성 살펴보기(디버그) : " + checkedId);
                RadioButton temp_rdo = (RadioButton) group.getChildAt(0);
                if(checkedId == R.id.rbtn1){
                    Log.d("뷰", checkedId + rbtn1.getText().toString());
                }else if(checkedId == R.id.rbtn2){
                    Log.d("뷰", checkedId + rbtn2.getText().toString());
                }else if(checkedId == R.id.rbtn3){
                    Log.d("뷰", checkedId + rbtn3.getText().toString());
                }else if(checkedId == R.id.rbtn4){
                    Log.d("뷰", checkedId + rbtn4.getText().toString());
                }else if(checkedId == R.id.rbtn5){
                    Log.d("뷰", checkedId + rbtn5.getText().toString());
                }
            }
        });


        }//메소드 안에서 만든 어떠한 변수나 객체등등은 전부 메소드 안에서만 사용이 가능하다
        //return < 메소드 안에서 어떠한 처리가 되고나서 결과가 필요할때.
        //전역변수 = 보라색, 지역변수 = 흰색
        //NullPointException < 위젯이 아직 디자인과 연결되어서 초기화가 안된상태 > 사용

        // ↓
        @Override
        public void onClick (View v){
            if (v.getId() == R.id.tv1)
                tv1.setText("임승진 또르르 주세영");
            else if (v.getId() == R.id.edt1)
                edt1.setText("최인혁 또르르 ");
            else if (v.getId() == R.id.v1) {
                Log.d("뷰", "뷰를 눌러서 이게 바뀜");
                v1.setBackgroundColor(Color.parseColor("#f3f3f3"));
            } else if (v.getId() == R.id.btn_check) {
                num = edt2.getText().toString();
                try {
                    if (Integer.parseInt(num) < 0) {
                        Log.d("뷰", "실패");
                        btn_check.setText("실패(" + num + ")");
                    } else if (Integer.parseInt(num) > 0) {
                        Log.d("뷰", "성공");
                        btn_check.setText("성공(" + num + ")");
                    }
                } catch (Exception e) {
                    Log.d("뷰", "실패");
                    btn_check.setText("실패(" + num + ")");
                }


            }
        }

    }
