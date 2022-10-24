package com.example.market_kurly.person;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.market_kurly.R;
import com.navercorp.nid.NaverIdLoginSDK;

public class Person_login_Fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_person_login_, container, false);
        TextView tv_memberName = v.findViewById(R.id.tv_memberName);

            tv_memberName.setText(Person_Fragment.person_info.getName());
            v.findViewById(R.id.person_logout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    NaverIdLoginSDK.INSTANCE.logout();
                    Person_Fragment.login_state = 0;
                    FragmentTransaction fragmentTransaction = getParentFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.container, new Person_Fragment()).commit();
                    Person_Fragment.person_info.setName("");
                    Person_Fragment.person_info.setEmail("");
                    Person_Fragment.person_info.setPhone("");
                }
            });


        return v;
    }
}