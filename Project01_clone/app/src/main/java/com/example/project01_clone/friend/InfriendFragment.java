package com.example.project01_clone.friend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.project01_clone.R;

import java.util.ArrayList;


public class InfriendFragment extends Fragment {
    RecyclerView recv_f;
    ArrayList<FriendDTO> list = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_infriend, container, false);
        recv_f = v.findViewById(R.id.recv_friend);

        list.add(new FriendDTO(R.drawable.img_jsy, "주세영", "아브라카다브라카"));
        list.add(new FriendDTO(R.drawable.img_lsj, "임승진", "인혁씨 여섯신데 벌서 들어가세요?"));
        list.add(new FriendDTO(R.drawable.img_lsb, "이슬빈", "나 사진 잘나왔지롱~"));
        list.add(new FriendDTO(R.drawable.img_kky, "김강윤", "나의 생일은 아직끝나지 않았다"));

        FriendAdapter adapter = new FriendAdapter(inflater, list ,getContext());
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);

        recv_f.setAdapter(adapter);
        recv_f.setLayoutManager(manager);



        return v ;
    }
}