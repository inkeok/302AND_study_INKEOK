package com.example.ex10_vendingmachine;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button coke_btn, cidar_btn, fanta_btn, demisoda_btn, money, edt_btn;
    TextView coke_text, cidar_text, fanta_text, demisoda_text, result_money;
    EditText edt;
    ArrayList<resultDTO> beverList = new ArrayList<>();
    int insert_money, coke_cnt=0, cidar_cnt=0, fanta_cnt=0, demisoda_cnt=0, total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        beverList.add(new resultDTO(10,800,"콜라"));
        beverList.add(new resultDTO(10,800,"사이다"));
        beverList.add(new resultDTO(10,700,"환타"));
        beverList.add(new resultDTO(10,700,"데미소다"));


        coke_btn = findViewById(R.id.coke_btn);
        coke_btn.setOnClickListener(this);
        cidar_btn = findViewById(R.id.cidar_btn);
        cidar_btn.setOnClickListener(this);
        fanta_btn = findViewById(R.id.fanta_btn);
        fanta_btn.setOnClickListener(this);
        demisoda_btn = findViewById(R.id.demisoda_btn);
        demisoda_btn.setOnClickListener(this);
        money = findViewById(R.id.money);
        money.setOnClickListener(this);
        edt_btn = findViewById(R.id.edt_btn);
        edt_btn.setOnClickListener(this);
        coke_text = findViewById(R.id.coke_text);
        cidar_text = findViewById(R.id.cidar_text);
        fanta_text = findViewById(R.id.fanta_text);
        demisoda_text = findViewById(R.id.demisoda_text);
        result_money = findViewById(R.id.result_money);
        edt = findViewById(R.id.edt);


    }


    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.coke_btn){
            
            if(beverList.get(0).getNum() > 0 && total >= beverList.get(0).getMoney()) {
                beverList.get(0).setNum(beverList.get(0).getNum() - 1);
                coke_text.setText("콜라 800원\n  " + beverList.get(0).getNum() + "개남음");
                coke_cnt++;
                total -= beverList.get(0).getMoney();
                result_money.setText(total+"원");
                coke_btn.setText("주문하기");
            }else if(insert_money == 0) {
                coke_btn.setText("돈을 넣으세요");
            }else {
                coke_btn.setText("매진");
            }




        }else if(v.getId() == R.id.cidar_btn){
            if(beverList.get(1).getNum() > 0 && total >= beverList.get(1).getMoney()) {
                beverList.get(1).setNum(beverList.get(1).getNum() - 1);
                cidar_text.setText("사이다 800원\n    " + beverList.get(1).getNum() + "개남음");
                cidar_cnt++;
                total -= beverList.get(1).getMoney();
                result_money.setText(total+"원");
                coke_btn.setText("주문하기");
            }else if(insert_money == 0 && total < beverList.get(1).getMoney()) {
                cidar_btn.setText("돈을 넣으세요");
            }else {
                cidar_btn.setText("매진");
            }
        }else if(v.getId() == R.id.fanta_btn){
            if(beverList.get(2).getNum() > 0 && total >= beverList.get(2).getMoney()) {
                beverList.get(2).setNum(beverList.get(2).getNum() - 1);
                fanta_text.setText("환타 700원\n  " + beverList.get(2).getNum() + "개남음");
                fanta_cnt++;
                total -= beverList.get(2).getMoney();
                result_money.setText(total+"원");
                coke_btn.setText("주문하기");
            }else if(insert_money == 0 && total < beverList.get(2).getMoney()) {
                fanta_btn.setText("돈을 넣으세요");
            }else {
                fanta_btn.setText("매진");
            }


        }else if(v.getId() == R.id.demisoda_btn){
            if(beverList.get(3).getNum() > 0 && total >= beverList.get(3).getMoney()) {
                beverList.get(3).setNum(beverList.get(3).getNum() - 1);
                demisoda_text.setText("데미소다 700원\n     " + beverList.get(3).getNum() + "개남음");
                demisoda_cnt++;
                total -= beverList.get(3).getMoney();
                result_money.setText(total+"원");
                coke_btn.setText("주문하기");
            }else if(insert_money == 0 && total < beverList.get(3).getMoney()) {
                demisoda_btn.setText("돈을 넣으세요");
            }else {
                demisoda_btn.setText("매진");
            }


        }else if(v.getId() == R.id.edt_btn){

            try {
                insert_money = Integer.parseInt(edt.getText()+"");
                total  += Integer.parseInt(edt.getText()+"");
                result_money.setText("잔액 : "+total+"원");

            }catch (Exception e){
                edt.setHint("정확한 수치를 입력하시오");
            }

        }else if(v.getId() == R.id.money){

            Intent intent = new Intent(MainActivity.this, SubActivity.class);

            int sum = (coke_cnt*beverList.get(0).getMoney()) + (cidar_cnt*beverList.get(1).getMoney()) + (fanta_cnt*beverList.get(2).getMoney()) + (demisoda_cnt*beverList.get(3).getMoney());

                    intent.putExtra("insert_money", insert_money);
                    intent.putExtra("money_sum", sum);
                    intent.putExtra("coke_cnt", coke_cnt);
                    intent.putExtra("cidar_cnt", cidar_cnt);
                    intent.putExtra("fanta_cnt", fanta_cnt);
                    intent.putExtra("demisoda_cnt", demisoda_cnt);


                    startActivity(intent);
        }

    }
}