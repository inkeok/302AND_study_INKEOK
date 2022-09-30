package com.example.and12_lifectcle;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Test_Frag extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //View v 한 이유는 < 프래그먼트에 있는 위젯을 찾아서 사용하기 위함. findViewById

        return inflater.inflate(R.layout.fragment_test_, container, false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("수명주기", "onCreate: F");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d("수명주기", "onStart:F ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("수명주기", "onDestroy:F ");
    }
}