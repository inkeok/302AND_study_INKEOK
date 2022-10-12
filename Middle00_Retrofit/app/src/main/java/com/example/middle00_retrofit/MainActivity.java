package com.example.middle00_retrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    EditText ed_id, ed_pw;
    Button btn_login, btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        ed_id = findViewById(R.id.ed_id);
        ed_pw = findViewById(R.id.ed_pw);
        btn_login = findViewById(R.id.btn_login);



        btn_login.setOnClickListener(v->{
            ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class); //Http통신을 위한 retrofit 객체 초기화

            HashMap<String, String> map = new HashMap<>();

            map.put( "email" , ed_id.getText()+"");
            map.put( "pw" , ed_pw.getText()+"");

            apiInterface.getData("andLogin", map).enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    Log.d("로그", "onResponse: "+response.body());
                    //toJson : String으로 바꿀때
                    //fromJson: String을 다시 원래 형태의 객체타입으로 바꿀때
                    Gson gson = new Gson();
                    AndMemberDTO dto = gson.fromJson(response.body(), AndMemberDTO.class);
                   // Log.d("로그", "onResponse: "+dto.getEmail());
                    if(dto != null) {
                        Log.d("로그", "로그인 됐습니다.");
                        }else {
                        Log.d("로그", "실패!");
                        }
                    }



                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });



        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface apiInterface = ApiClient.getApiClient().create(ApiInterface.class); //Http통신을 위한 retrofit 객체 초기화

                    HashMap<String, String> map = new HashMap<>();

                    map.put( "id" , ed_id.getText()+"");
                    map.put( "pw" , ed_pw.getText()+"");



                    apiInterface.getData("hanul302", map).enqueue(new Callback<String>() {
                        @Override
                        public void onResponse(Call<String> call, Response<String> response) {

                        }

                        @Override
                        public void onFailure(Call<String> call, Throwable t) {
                            Log.d("로그", "onResponse: 2");
                        }
                    });


            }
        });





    }
}