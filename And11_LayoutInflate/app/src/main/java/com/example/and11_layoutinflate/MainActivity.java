package com.example.and11_layoutinflate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    Button btn_inflate;
    LinearLayout ll_layout;
    RelativeLayout rl_layout;
    FrameLayout container;

    //자바 <- 안드로이드가 어려운점 : 대부분의 기능들이 구현이 되어 있음.
    //어느정도의 커스터마이징은 되지만, 그 이상은 개인정보침해나 해킹의 위험요소

    //에이아웃 인플레이트(인플레이션 과정을 통한 화면 붙이기) 과정
    //1. 화면이 붙을 공간(레이아웃)을 액티비티 내부에 미리 만들어 놓는다.
    //(현재: 리니어, 릴레이티브)
    //2. 화면에 붙일 레이아웃을 별도로 만든다(현재 : main_sub1.xml 을 위에 마련한 공간에 붙일 예정)
    //3. 자바코드를 이용해서 레이아웃 인플레이트 시키기 <= 프래그먼트

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_inflate =findViewById(R.id.btn_inflate);
        ll_layout = findViewById(R.id.ll_layout);
        rl_layout = findViewById(R.id.rl_layout);

        LayoutInflater inflater = getLayoutInflater();//OS(Android, SDK)제공

        btn_inflate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflater.inflate(R.layout.main_sub1 , ll_layout , true);
                //              어떤화면을 붙일지     어디에       지금 할건지.
                inflater.inflate(R.layout.main_sub2,rl_layout,true);
            }
        });

        //Transaction(DB) => COMMIT, ROLLBACK (작업을 확정지을건지 아니면 되돌릴건지)
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new MainFragment()).commit();

        /*서브 레이아웃을 불러오지 않은 상태에서 서브 레이아웃의 위젯을 불러올수 없다*/
    }
}