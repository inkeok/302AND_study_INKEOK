package com.example.market_kurly.home;

import android.graphics.Paint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.example.market_kurly.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;


public class HomeMainFragment extends Fragment {
    CountDownTimer countDownTimer;
    TextView menu_time_hour, menu_time_min, menu_time_sec, text_cancel;
    TimeDTO dto = new TimeDTO();
    RecyclerView recv_1st, recv_2nd, recv_3rd, recv_4th;
    HashMap<String, ArrayList<PrizeDTO>> map;
    ArrayList<PrizeDTO> al_list, fru_list, meat_list, milk_list, new_list, pop_list, sea_list, vege_list;
    ViewFlipper benner_flipper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home_main, container, false);

        ImageView menu_timer = (ImageView) v.findViewById(R.id.menu_timer);
        Glide.with(this).load(R.drawable.time).into(menu_timer);


        menu_time_hour = v.findViewById(R.id.menu_time_hour);
        menu_time_min = v.findViewById(R.id.menu_time_min);
        menu_time_sec = v.findViewById(R.id.menu_time_sec);
        text_cancel = v.findViewById(R.id.text_cancel);
        text_cancel.setPaintFlags(text_cancel.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        recv_1st = v.findViewById(R.id.recv_1st);
        recv_2nd = v.findViewById(R.id.recv_2nd);
        recv_3rd = v.findViewById(R.id.recv_3rd);
        recv_4th = v.findViewById(R.id.recv_4th);

        countDownTimer = new CountDownTimer(200000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                getTime();
                menu_time_hour.setText(dto.getHour());
                menu_time_min.setText(dto.getMin());
                menu_time_sec.setText(dto.getSec());

            }
            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();


        int benner_img[] = {
                R.drawable.benner_01,
                R.drawable.benner_02,
                R.drawable.benner_03,
                R.drawable.benner_04,
                R.drawable.benner_05,
                R.drawable.benner_06
        };      //배너 플리퍼 리스트
        benner_flipper = v.findViewById(R.id.flipper);
        for(int image : benner_img) {
            flipperImages(image);
        }   //리스트를 플리퍼 실행 메소드에 반복



        DtoParty dto = new DtoParty();
        map = dto.dtoParty();
        pop_list = map.get("pop");
        al_list = map.get("al");
        vege_list = map.get("vege");
        new_list = map.get("new");

        Recv1stAdapter recv_1st_Adapter = new Recv1stAdapter(inflater, pop_list,getActivity());
        RecyclerView.LayoutManager recv_1st_manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recv_1st.setAdapter(recv_1st_Adapter);
        recv_1st.setLayoutManager(recv_1st_manager);

        Recv2ndAdapter recv_2nd_Adapter = new Recv2ndAdapter(inflater, al_list, getActivity());
        RecyclerView.LayoutManager recv_2nd_manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recv_2nd.setAdapter(recv_2nd_Adapter);
        recv_2nd.setLayoutManager(recv_2nd_manager);

        Recv3rdAdapter recv_3rd_Adapter = new Recv3rdAdapter(inflater, vege_list, getActivity());
        RecyclerView.LayoutManager recv_3rd_manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recv_3rd.setAdapter(recv_3rd_Adapter);
        recv_3rd.setLayoutManager(recv_3rd_manager);

        Recv4thAdapter recv_4th_Adapter = new Recv4thAdapter(inflater, new_list, getActivity());
        RecyclerView.LayoutManager recv_4th_manager = new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false);
        recv_4th.setAdapter(recv_4th_Adapter);
        recv_4th.setLayoutManager(recv_4th_manager);






        return v;
    }

    private void getTime(){
        Date date = new Date();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int c_hour = calendar.get(Calendar.HOUR_OF_DAY);
        int c_min = calendar.get(Calendar.MINUTE);
        int c_sec = calendar.get(Calendar.SECOND);

        Calendar baseCal = new GregorianCalendar(year,month,day,c_hour,c_min,c_sec);
        Calendar targetCal = new GregorianCalendar(year,month,day+1,0,0,0);  //비교대상날짜

        long diffSec = (targetCal.getTimeInMillis() - baseCal.getTimeInMillis()) / 1000;
        long diffDays = diffSec / (24*60*60);

        targetCal.add(Calendar.DAY_OF_MONTH, (int)(-diffDays));

        int hourTime = (int)Math.floor((double)(diffSec/3600));
        int minTime = (int)Math.floor((double)(((diffSec - (3600 * hourTime)) / 60)));
        int secTime = (int)Math.floor((double)(((diffSec - (3600 * hourTime)) - (60 * minTime))));

        String hour = String.format("%02d", hourTime);
        String min = String.format("%02d", minTime);
        String sec = String.format("%02d", secTime);

        dto.setHour(hour);
        dto.setMin(min);
        dto.setSec(sec);

    }
    public void flipperImages(int image) {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(image);
        benner_flipper.addView(imageView);
        benner_flipper.setFlipInterval(3000);       // 자동 이미지 슬라이드 딜레이시간(1000 당 1초)
        benner_flipper.setAutoStart(true);          // 자동 스타트




    }

}