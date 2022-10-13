package com.example.middle01_retrofit.Middle;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class ApiClient {

    private static final String BASEURL = "http://192.168.0.113/Middle/";
    private static Retrofit retrofit;

    public static Retrofit getApiClient(){
        if(retrofit == null) { //최초로 Retrofit객체를 사용할때 초기화가 안되어있다면 그때 한번만 초기화되게함.
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASEURL)   //스프링 미들웨어의 홈 주소를 의미함.
                    .addConverterFactory(ScalarsConverterFactory.create())  //json String 형태 사용가능하게 함.
                    .build();
        }
        return retrofit;
    }
}
