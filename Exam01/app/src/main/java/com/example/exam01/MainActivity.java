package com.example.exam01;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
//메소드안에 메소드를 넣을 수가 없음,.
    //인터페이스 클래스 지역이라서
int num1 = 0;
    //지역 == 메소드 안에서 뭔가를 만드는 것.
    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button b = findViewById(R.id.lim);
        bSetText(b);
        //메소드 (기능) : 호출 (Method Call) 했을때 어떤 기능들을 실행하고 결과값이 필요하면 결과값을 명시해주면됨.
        //어떤것이든 메소드의 파라메터가 될 수 있고 어떤것이든 return 할 수 있음.


    }
    void bSetText(Button b){
        b.setText("임승진 짱나네");
    }



    //데이터를 묶어놓은것  == DTO , VO
    public class viewHolder {
        Button b1, b2;

        //위젯의 갯수가 viewHolder마다 다르기 때문에 표준을 레이아웃을 붙이고 나서 안에있는 모든것들이 들어있는 view 객체로 해놓음.
        public viewHolder(){
            b1 = findViewById(R.id.lim);
        }

    }

    //DTO생성자, String으로 된 값이 필요함.
    public class DTO{
        String val1, val2;

        public DTO(String val1, String val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }
}