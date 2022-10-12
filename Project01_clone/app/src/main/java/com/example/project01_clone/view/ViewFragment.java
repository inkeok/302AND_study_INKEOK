package com.example.project01_clone.view;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class ViewFragment extends Fragment {
    //kakaoTalk 하단메뉴 3번째 뷰를 구현하기.
    //상단 메뉴 : 탭 레이아웃(My뷰, 발견, 카카오TV)
    //RecyclerView 구현
    TabLayout tabs;
    RecyclerView recv_view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_view, container, false);
        tabs = v.findViewById(R.id.tabs);
        recv_view = v.findViewById(R.id.recv_view);


        /*tabLayout에 탭 메뉴를 추가하기 (My뷰, 발견, 카카오TV)*/
        //메인 액치비티에서 3번재 하단메뉴 선택시 현재 플레그가 보이게 해보기.
        tabs.addTab(tabs.newTab().setText("My뷰"));
        tabs.addTab(tabs.newTab().setText("발견"));
        tabs.addTab(tabs.newTab().setText("카카오TV"));
        tabs.addTab(tabs.newTab().setText("코로나19"));
        tabs.addTab(tabs.newTab().setText("잔여백신"));

        //Layout파일 만들기 (한칸)
        //Adapter 만들기
        //Recycle뷰 연결
        //LayoutManager 연결




        //ViewAdapter adapter = new ViewAdapter(inflater);
        recv_view.setAdapter(new ViewAdapter(inflater));

       // RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        recv_view.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));


        return v;
    }
}