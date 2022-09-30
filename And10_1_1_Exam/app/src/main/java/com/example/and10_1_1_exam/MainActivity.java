package com.example.and10_1_1_exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btn1, btn2, btn3, btn4, btn_insert, btn_result;
    EditText edt1;
    TextView tv1, tv2, tv3, tv4, tv_money;
    TextView tvn1, tvn2, tvn3, tvn4;
    ArrayList<DrinkDTO> alist = new ArrayList<>();
    DrinkDTO dto1, dto2, dto3, dto4;
    int money = 0;
    int allCnt;
    String result ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvn1 = findViewById(R.id.tvn1);
        tvn2 = findViewById(R.id.tvn2);
        tvn3 = findViewById(R.id.tvn3);
        tvn4 = findViewById(R.id.tvn4);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn_insert = findViewById(R.id.btn_insert);
        btn_result = findViewById(R.id.btn_result);

        edt1 = findViewById(R.id.edt1);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv_money = findViewById(R.id.tv_money);


    }


    @Override
    protected void onStart() {
        super.onStart();

        tv_money.setText("잔액 : " + money + "원");

        btn_insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 변수 = 에딧텍스트에 있는 숫자값을 넣는다
                // 텍스트뷰에 있는 글씨를 변수를 이용해서 바꾼다.
                moneyTest();
                tv_money.setText("잔액 : " + money + "원");
                btn_result.setText("잔돈 반환");


            }
        });
        for (int i = 0; i < alist.size(); i++) {
            allCnt += alist.get(i).getCnt();
        }



            btn_result.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for (int i = 0; i < alist.size(); i++) {
                        if(alist.get(i).getCnt() > 0){
                            result += alist.get(i).getName() + " : " + alist.get(i).getCnt() + "개  ";
                        }
                    }

                    Toast.makeText(MainActivity.this, result, Toast.LENGTH_LONG).show();
                    btn_result.setText("잔돈 : "+money+ "반환");
                    result = "";
                    money = 0;
                    tv_money.setText("어서오세요 돈을 넣어주세요.");
                    for (int i = 0; i < alist.size(); i++) {
                        alist.get(i).setCnt(0);
                    }
                }
            });



        //음료에 대한 정보를 저장해둘 DTO + 위젯을 저장해둠. (해당하는 정보를 표현 할 위젯)
        dto1 = new DrinkDTO("콜라", 1000, 11, tv1, tvn1, btn1,0);
        dto2 = new DrinkDTO("사이다", 800, 11, tv2, tvn2, btn2,0);
        dto3 = new DrinkDTO("환타", 700, 8, tv3, tvn3, btn3,0);
        dto4 = new DrinkDTO("데미소다", 700, 9, tv4, tvn4, btn4,0);

        //<E>규칙 : 해당하는 타입에 담을 수 있는 값("문자열", "숫자값", "생성자")
        //          해당하는 타입을 초기화한 변수
        //

        alist.add(dto1);
        alist.add(dto2);
        alist.add(dto3);
        alist.add(dto4);

        for (int i = 0; i < alist.size(); i++) {
            final int idx = i;
            alist.get(i).btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    if (money < alist.get(idx).getPrice()) {
                        //현재 입력한 금액이 음료의 금액보다 작으면, 음료는 나올수가 없음.
                        Toast.makeText(MainActivity.this, "금액부족", Toast.LENGTH_SHORT).show();
                    } else {
                        alist.get(idx).setQty(alist.get(idx).getQty() - 1);
                        money -= alist.get(idx).getPrice();
                        tv_money.setText("잔액 : " + money + "원");
                        alist.get(idx).setCnt(alist.get(idx).getCnt() + 1);
                    }
                    if (alist.get(idx).getQty() <= 0) {
                        alist.get(idx).tvn.setText("품절");
                        alist.get(idx).btn.setEnabled(false);
                    }
                }
            });
        }



        /*btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);*/



    }
    public void moneyTest(){
        try {
            if(Integer.parseInt(edt1.getText().toString()) < 1){
                Toast.makeText(MainActivity.this, "정수값을 입력 하시오", Toast.LENGTH_SHORT).show();

            }else {
                money += Integer.parseInt(edt1.getText() + "");
            }
        }catch (Exception e){
            Toast.makeText(MainActivity.this, "수치 입력값 오류", Toast.LENGTH_SHORT).show();
        }

    }
}