package com.example.and14_allview.listview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.and14_allview.R;

import java.util.ArrayList;
import java.util.zip.Inflater;


public class ListFragment extends Fragment {

    // Fragment 비어있는 것 추가 후 반드시 있어야 되는 부분 ↓

    //1. 칸마다 보여질 정보를 (Layout) 어떤식으로 보여줄지 미리 만들어 놓는다. (1칸,반복)
    //ex) 카카오톡 친구목록, 친구 숫자에 따라서 아이템이 20~ 친구 숫자 만큼 가변적으로 변환


    //2. Adapter
    //-안드로이드 자체에서 사용자가 어떤 모양의 정보를 보여주는 화면 구성을 할지 전부다 미리 만들어 놓을수가 없음.
    // 따라서 사용자가 만든 화면과 위젯을 연결해줄(브릿지)
    // (BaseAdapter - 가장 기본적인 형태의 어댑터 )
    ListView listView;
    ArrayList<ListDTO> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View v = inflater.inflate(R.layout.fragment_list, container, false);




        list.add(new ListDTO(R.drawable.img1, "강윤씨", "한울 302호"));
        list.add(new ListDTO(R.drawable.img2, "수진씨", "한울 횡단보도"));
        list.add(new ListDTO(R.drawable.img3, "서인씨", "한울 횡단보도"));
        list.add(new ListDTO(R.drawable.img4, "세영씨와 사막여우", "서구청 국밥집 앞"));
        list.add(new ListDTO(R.drawable.img5, "잠자는 강윤씨", "운천역 포장마차"));


        listView = v.findViewById(R.id.listview);

        ListAdapter adapter = new ListAdapter(inflater , list);//기본적으로 프래그먼트는 LayoutInflater를 무조건 가지고 있음.
        listView.setAdapter(adapter);









if (listView == null){
    Log.d("테스트", "onCreateView: ?");

}else{
    Log.d("테스트", "onCreateView: ????");
}


        return v;
    }
}