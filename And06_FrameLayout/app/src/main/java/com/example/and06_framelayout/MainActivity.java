package com.example.and06_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.ArrayList;

//인터페이스 안에 있는 메소드들은 전부다 구현해야하는 강제성을 가지고 있음

//무조건 만들어야 하는 메소드 부분
public class MainActivity extends AppCompatActivity  {
//안드로이드에 들어가는 모든 리소스 res 하위 경로에서 관리함
    //리소스 (이미지, 동영상, 글꼴, Layout 등등)
    //이미지 > drawble
    //res경로에서는 유효성 검사를 함(파일명)
    //특수문자 x 대문자 x 숫자시작 x
    int i = 3;
    @Override   //setContentView <= XML과 자바 파일을 연결 시킨다. 액티비티(화면)가 처음 실행될때 한번 실행함.
                //위젯들을 find로 찾아서 초기화 시키거나 이벤트로 연결..
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //디자인 파일(xml)에 만들어둔 위젯(객체)을 찾는 방법 findViewById 메소드 이용
        //태그 열렸을때 썼던 종류 Button

        Button btn_back = findViewById(R.id.btn_back);  //<return View(widget);
        //버튼이 클릭 되는 시점을 자바코드에서 받아오려면 interface (View.onclickListener)
        Button btn_go = findViewById(R.id.btn_go);

        ArrayList<ImageView> list = new ArrayList<>();
        list.add(findViewById(R.id.pic1));
        list.add(findViewById(R.id.pic2));
        list.add(findViewById(R.id.pic3));
        list.add(findViewById(R.id.pic4));



        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i <3){
                    list.get(i+1).setVisibility(View.VISIBLE);
                    i++;
                }else if (i == 3){
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setVisibility(View.INVISIBLE);
                    }
                    i=0;
                    list.get(i).setVisibility(View.VISIBLE);

                }
            }
        });

        btn_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i > 0) {
                    list.get(i).setVisibility(View.INVISIBLE);
                    i--;
                }else {
                    i = 3;
                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setVisibility(View.VISIBLE);
                    }
                }
            }
        });

        //ImageView[] arr = new ImageView[4];
        //ArrayList<ImageView> list = new ArrayList<>();

    }



}
