package com.example.and11_layoutinflate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

//1.onCreateView메소드를 제외한 모든 코드 삭제.(주석 등등)
        //Activity(onCreate) == Fragment(onCreateView)
        //setContView(Layout) == inflater.inflate(Layout)
        //디자인 연결        == 디자인 연결

        //기능제한 Context가 분리되어있다.
        //inflater.inflater => return view타입

public class MainFragment extends Fragment {
    Button btn_frag;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View v = inflater.inflate(R.layout.fragment_main, container, false);
        btn_frag = v.findViewById(R.id.btn_frag);

        btn_frag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("플래그먼트", "onClick: ㅎㅇㅎㅇㅎㅇ");
            }
        });

        return v;
    }

}