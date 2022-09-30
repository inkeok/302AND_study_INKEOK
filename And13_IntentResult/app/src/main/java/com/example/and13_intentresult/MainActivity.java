package com.example.and13_intentresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // 안드로이드의 4대 컴포넌트 : 액티비티, ※ 컴포넌트들은 전부 Manifest에 기재 되어 있어야 한다.
    // intent(인텐트) : 4가지 컴포넌트들간의 통신을 담당하고 있는 객체(전달)

    Button btn_new, btn_call, btn_web, btn_gps;
    ArrayList<LoginDTO> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_new = findViewById(R.id.btn_new);
        btn_new.setOnClickListener(this);
        btn_call = findViewById(R.id.btn_call);
        btn_call.setOnClickListener(this);
        btn_web = findViewById(R.id.btn_web);
        btn_web.setOnClickListener(this);
        btn_gps = findViewById(R.id.btn_gps);
        btn_gps.setOnClickListener(this);


    }
    // Context <= 제일 넓은 범위에 AppicationContext
    // 기능제한을 화면 단위에 따라서 클래스 단위에 따라서 나눠놨음.

    //개발자의 사용범위 (바운더리) 안에서 제어가 가능한 인텐트 : 명시적 인텐트.

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_new) {
            Intent intent = new Intent(MainActivity.this, SubActivity.class);
            
            intent.putExtra("sKey","임승진의 토스트");
            intent.putExtra("inKey", 00001101);

            LoginDTO dto = new LoginDTO("id", "pw" );
            intent.putExtra("dto",  dto);
            list.add(new LoginDTO("AAA", "BBB"));
            list.add(new LoginDTO("CCC", "DDD"));
            list.add(new LoginDTO("EEE", "FFF"));
            list.add(new LoginDTO("GGG", "HHH"));
            list.add(new LoginDTO("III", "JJJ"));
            list.add(new LoginDTO("KKK", "LLL"));
            list.add(new LoginDTO("MMM", "NNN"));
            list.add(new LoginDTO("OOO", "PPP"));
            list.add(new LoginDTO("QQQ", "RRR"));
            list.add(new LoginDTO("SSS", "TTT"));

            intent.putExtra("list" , list);


            //현재위치 (액티비티)             갈위치(class)
            startActivity(intent); //startActivity<프래그먼트나 일반 클래스에서 실행 x
        }else if(v.getId() == R.id.btn_call){
            Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:/01040724040"));
            startActivity(intent);
        }else if(v.getId() == R.id.btn_web){
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.naver.com"));
            startActivity(intent);
        }else if(v.getId()==R.id.btn_gps){
            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.google.com/maps?q="+35.1486193+","+126.9225754+"&z="+15));
            startActivity(intent);

        }
    }
}