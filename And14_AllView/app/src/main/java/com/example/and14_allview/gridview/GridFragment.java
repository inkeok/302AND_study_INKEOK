package com.example.and14_allview.gridview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.and14_allview.R;

import java.util.ArrayList;


public class GridFragment extends Fragment {

    ListView gridview;
    ArrayList<GridDTO> glist = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_grid,  container,               false);
       // View(타입)        inflate(@LayoutRes int resource, @Nullable ViewGroup root, boolean attachToRoot)

        glist.add(new GridDTO(R.drawable.img5, "잠자는 강윤씨", "운천역 포장마차"));
        glist.add(new GridDTO(R.drawable.img4, "세영씨와 사막여우", "서구청 국밥집 앞"));
        glist.add(new GridDTO(R.drawable.img3, "서인씨", "한울 횡단보도"));
        glist.add(new GridDTO(R.drawable.img2, "수진씨", "한울 횡단보도"));
        glist.add(new GridDTO(R.drawable.img1, "강윤씨", "한울 302호"));

        gridview =  view.findViewById(R.id.gridview);

        GridAdapter gadapter = new GridAdapter(inflater, glist);
        gridview.setAdapter(gadapter);




        return view;
    }
}