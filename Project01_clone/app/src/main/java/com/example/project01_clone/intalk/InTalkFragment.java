package com.example.project01_clone.intalk;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;

import java.util.ArrayList;


public class InTalkFragment extends Fragment {

    RecyclerView recv;
    ArrayList<inTalkDTO> list1 = new ArrayList<>();
    //1. Layout에 한 칸에 들어갈 정보 레이아웃 만들기 (나중에 리사이클러뷰가 반복 시켜줌)

    //2. Adapter 만들기 - 2.1: 뷰홀더, 2.2: 어댑터 <뷰홀더> 상속

    //3. 리사이클러뷰와 어댑터 연결

    //4. 리사이클러뷰와 레이아웃 매니저 (방향) 연결

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_in_talk, container, false);
        recv = v.findViewById(R.id.recv_intalk);


        list1.add(new inTalkDTO(R.drawable.img1, "김강윤", "인왜씨 왜가리 룰루랄라"));
        list1.add(new inTalkDTO(R.drawable.img2, "박수진", "히히히히 승진이 괴롭혀야지"));
        list1.add(new inTalkDTO(R.drawable.img3, "김서인", "아오 승진씨 저좀 그만 괴롭혀요"));
        list1.add(new inTalkDTO(R.drawable.img4, "주세영", "왜요?"));
        list1.add(new inTalkDTO(R.drawable.img5, "임승진", "ㅋ"));
        list1.add(new inTalkDTO(R.drawable.img1, "김강윤", "인왜씨 왜가리 룰루랄라"));
        list1.add(new inTalkDTO(R.drawable.img2, "박수진", "히히히히 승진이 괴롭혀야지"));
        list1.add(new inTalkDTO(R.drawable.img3, "김서인", "아오 승진씨 저좀 그만 괴롭혀요"));
        list1.add(new inTalkDTO(R.drawable.img4, "주세영", "왜요?"));
        list1.add(new inTalkDTO(R.drawable.img5, "임승진", "ㅋ"));

        Context context = getContext();


        /*Intent intent = new Intent(getContext(), UserActivity.class);
        startActivity(intent);*/



        InTalkAdapter adapter = new InTalkAdapter(inflater, context);
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false );

        adapter.setList1(list1);
        recv.setAdapter(adapter);
        recv.setLayoutManager(manager);

        //플래그먼트는 단독적으로 화면위에 떠있을 수가 없음
        //무조건 Activity를 통해서 Activity안에 붙어있음. (현: MainActivity)
        //해당하는 규칙때문에 getContext를 하면 Activity로부터 권한을 얻어올수 있음.

        //리턴타입이 주어진 것은 무조건 해당하는 타입에 담을 수 있음.



        return v;
    }

}