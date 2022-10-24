package com.example.etc_api;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;

public class MainActivity extends AppCompatActivity {
    ImageView imgv_glide1, imgv_glide2;
    NidOAuthLoginButton btn_naver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Glide < Android 에서 이미지 뷰에 url이나 여러가지 이미지 파일을 붙일때 사용하는 API
        imgv_glide1 = findViewById(R.id.imgv_glide1);
        imgv_glide2 = findViewById(R.id.imgv_glide2);

        //https://img.hankyung.com/photo/201907/AA.20071674.1.jpg
        //https://cdn.clien.net/web/api/file/F01/3647408/00e17608bf1d413196c.GIF

        Glide.with(this)
                .load("https://img-cf.kurly.com/cdn-cgi/image/width=400,format=auto/shop/data/goods/1657238925434l0.jpg")
                .into(imgv_glide1);

        Glide.with(this)
                .load("https://cdn.clien.net/web/api/file/F01/3647408/00e17608bf1d413196c.GIF")
                .into(imgv_glide2);

        NaverIdLoginSDK.INSTANCE.initialize(this, "vvyxVKhZZitRqXi2f9JK", "1PxQNlDAiv", "Etc_API");

        btn_naver = findViewById(R.id.btn_naver);
        btn_naver.setOAuthLoginCallback(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                Log.d("로그", "onSuccess: ");
                NidOAuthLogin authLogin = new NidOAuthLogin();
                authLogin.callProfileApi(new NidProfileCallback<NidProfileResponse>() {
                    @Override
                    public void onSuccess(NidProfileResponse res) {
                        Log.d("로그", ""+ res.getProfile().getEmail());
                        Log.d("로그", ""+ res.getProfile().getNickname());
                        Log.d("로그", ""+ res.getProfile().getMobile());
                        Intent intent = new Intent(MainActivity.this, SubActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onFailure(int i, @NonNull String s) {

                    }

                    @Override
                    public void onError(int i, @NonNull String s) {

                    }
                });
            }

            @Override
            public void onFailure(int i, @NonNull String s) {
                Log.d("로그", "onFailure: ");
            }

            @Override
            public void onError(int i, @NonNull String s) {
                Log.d("로그", "onError: ");
            }
        });
        NaverIdLoginSDK.INSTANCE.logout();


    }
}