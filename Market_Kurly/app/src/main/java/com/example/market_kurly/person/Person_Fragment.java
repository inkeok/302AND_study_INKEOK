package com.example.market_kurly.person;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.market_kurly.R;
import com.navercorp.nid.NaverIdLoginSDK;
import com.navercorp.nid.oauth.NidOAuthLogin;
import com.navercorp.nid.oauth.OAuthLoginCallback;
import com.navercorp.nid.oauth.view.NidOAuthLoginButton;
import com.navercorp.nid.profile.NidProfileCallback;
import com.navercorp.nid.profile.data.NidProfileResponse;


public class Person_Fragment extends Fragment {
    NidOAuthLoginButton btn_naver;
    public static int login_state = 0;
    public static PersonDTO person_info;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_person_, container, false);

        //aYCZiFsCFPOpN56OHPJq
        //ImhzRaw54Q
        NaverIdLoginSDK.INSTANCE.initialize(v.getContext(), "aYCZiFsCFPOpN56OHPJq", "ImhzRaw54Q", "Market_Kurly");

        btn_naver = v.findViewById(R.id.btn_naver);
        btn_naver.setOAuthLoginCallback(new OAuthLoginCallback() {
            @Override
            public void onSuccess() {
                NidOAuthLogin authLogin = new NidOAuthLogin();
                authLogin.callProfileApi(new NidProfileCallback<NidProfileResponse>() {
                    @Override
                    public void onSuccess(NidProfileResponse nidProfileResponse) {
                        FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                        login_state = 1;
                        person_info = new PersonDTO(nidProfileResponse.getProfile().getName(),nidProfileResponse.getProfile().getEmail(), nidProfileResponse.getProfile().getMobile() );


                        fragmentTransaction.replace(R.id.container, new Person_login_Fragment()).commit();


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

            }

            @Override
            public void onError(int i, @NonNull String s) {

            }
        });
        return v;

    }
}