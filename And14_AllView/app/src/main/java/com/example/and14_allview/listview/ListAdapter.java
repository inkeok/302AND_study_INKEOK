package com.example.and14_allview.listview;

//1. 상속을 받는다 (일반 클래스 ==> Adapter )
//많은 어댑터 종류가 있지만 가장 기본적이고 많이 사용되는 어댑터 => BaseAdapter


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and14_allview.R;

import java.util.ArrayList;

public class ListAdapter extends BaseAdapter {
    // ※ 어댑터라는 클래스는 화면을 붙이는 기능인 LayoutInflater 사용 불가 ※

    LayoutInflater inflater;
    ArrayList<ListDTO> list;

    public ListAdapter(LayoutInflater inflater, ArrayList<ListDTO> list) {
        this.inflater = inflater;
        this.list = list;
    }

    // 보여질 아이템의 갯수를 지정하는 곳 (0 아이템이 없음)
    // Collection, Array Size
    @Override
    public int getCount() {
        return list.size();
    }


    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    //칸마다 보여질 데이터를 실제로 붙이는 처리를 하는 부분.
    //LayoutInflater < 칸마다 데이터 붙이기 처리를 해야함.

    @Override
    public View getView(int position, View v, ViewGroup parent) {
        v = inflater.inflate(R.layout.item_listview, parent, false); //붙이는 처리는 return이 되고 나서
                                                                                    //나중에 알아서 처리함. 바로 붙이기 x
        ImageView img = v.findViewById(R.id.img);

        TextView tv1 = v.findViewById(R.id.tv1);
        TextView tv2 = v.findViewById(R.id.tv2);


        img.setImageResource(list.get(position).getImg());

        tv1.setText(list.get(position).getTv1());
        tv2.setText(list.get(position).getTv2());




        return v;
    }
}
