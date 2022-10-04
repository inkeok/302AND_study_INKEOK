package com.example.and14_allview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.and14_allview.gridview.GridFragment;
import com.example.and14_allview.listview.ListFragment;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_listview, btn_gridview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // package 추가 이름 listview
        // 패키지 안쪽에 ListFragment 추가 하기.
        // 메인 액티비티에서 해당하는 프래그먼트가 보이게 처리해보기.( 메인액티비티에 프래그먼트 붙이기 )
        // 메인은 붙일 공간을 마련 (container) 액티비티메인에 id container로 프레임레이아웃 만듬
        // 프로그먼트를 코드를 이용해서 container 에 붙이기 처리를 함 transaction



        btn_listview = findViewById(R.id.btn_listview);
        btn_gridview = findViewById(R.id.btn_gridview);

        btn_listview.setOnClickListener(this);
        btn_gridview.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_listview){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new ListFragment()).commit();
                                                         //replace(@IdRes int containerViewId, @NonNull Fragment fragment)


        }else if (v.getId() == R.id.btn_gridview){
            getSupportFragmentManager().beginTransaction().replace(R.id.container, new GridFragment()).commit();


        }


    }
}