package com.example.project01_clone.friend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;

import java.util.ArrayList;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendHolder>{

    LayoutInflater inflater;
    ArrayList<FriendDTO> list;
    Context context;

    public FriendAdapter(LayoutInflater inflater, ArrayList<FriendDTO> list, Context context) {
        this.inflater = inflater;
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public FriendHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FriendHolder(inflater.inflate(R.layout.item_friend_list, parent ,false));
    }


    @Override
    public void onBindViewHolder(@NonNull FriendHolder h,  @SuppressLint("RecyclerView")int i) {
        h.f_img.setImageResource(list.get(i).getF_img());
        h.f_name.setText(list.get(i).getF_name());
        h.f_msg.setText(list.get(i).getF_msg());

        h.lay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //새로운 액티비티를 띄우는 코드로 수정

                //Activity에 통신을 통해서 startActivity라는 메소드 자체는 액티비티만 가능함.
                //화면에 떠 있는 객체끼리 통신을 하게 만들어둠
                //Context: ActivityContext <= 프래그먼트 매니저, 액티비티를 띄우는 메소드 등등의 기능을 가진 권한.
                //          ApplicationContext <= 파일관리, 위험권한 (카메라..) 등의 기능을 가진 권한.
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("사진", list.get(i).getF_img());
                intent.putExtra("이름", list.get(i).getF_name());
                intent.putExtra("상메", list.get(i).getF_msg());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class FriendHolder extends RecyclerView.ViewHolder {
        ImageView f_img;
        TextView f_name, f_msg;
        LinearLayout lay;
        public FriendHolder(@NonNull View v) {
            super(v);
            f_img = v.findViewById(R.id.f_img);
            f_name = v.findViewById(R.id.f_name);
            f_msg = v.findViewById(R.id.f_msg);
            lay = v.findViewById(R.id.lay);
        }
    }
}
