package com.example.project01_clone.intalk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.project01_clone.R;
import com.example.project01_clone.friend.UserActivity;

import java.util.ArrayList;

public class InTalkAdapter extends RecyclerView.Adapter<InTalkAdapter.InTalkHolder> {
    LayoutInflater inflater;
    ArrayList<inTalkDTO> list1;
    Context context;

    public void setList1(ArrayList<inTalkDTO> list1) {
        this.list1 = list1;
    }

    //모든종류의 어댑터는 직접 화면을 붙일 권한이나 기능이 없음
    //LayoutInflater : 필수로 필요함.
    public InTalkAdapter(LayoutInflater inflater, Context context) {
        this.inflater = inflater;
        this.context = context;
    }

    @NonNull
    @Override
    public InTalkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_intalk_friend, parent, false);


        return new InTalkHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InTalkHolder h, @SuppressLint("RecyclerView") int position) {

        h.img.setImageResource(list1.get(position).getImg());
        h.name.setText(list1.get(position).getName());
        h.statemess.setText(list1.get(position).getStateMess());
        
        h.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //새로운 액티비티를 띄우는 코드로 수정

                //Activity에 통신을 통해서 startActivity라는 메소드 자체는 액티비티만 가능함.
                //화면에 떠 있는 객체끼리 통신을 하게 만들어둠
                //Context: ActivityContext <= 프래그먼트 매니저, 액티비티를 띄우는 메소드 등등의 기능을 가진 권한.
                //          ApplicationContext <= 파일관리, 위험권한 (카메라..) 등의 기능을 가진 권한.
               Intent intent = new Intent(context, UserActivity.class);
               intent.putExtra("사진", list1.get(position).getImg());
               intent.putExtra("이름", list1.get(position).getName());
               intent.putExtra("상메", list1.get(position).getStateMess());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list1.size();
    }
    //위젯을 묶어 놓은 DTO : 뷰홀더 자체가 위젯 갯수부터 모든것이 사용자가 임의로 만든것.
    public class InTalkHolder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView name,statemess, btn_close;

        public InTalkHolder(@NonNull View v) {
            super(v);

            img = v.findViewById(R.id.img);
            name = v.findViewById(R.id.name);
            statemess = v.findViewById(R.id.statemess);

        }


    }
}
