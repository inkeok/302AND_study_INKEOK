package com.example.and10_1_1_exam;

import android.widget.Button;
import android.widget.TextView;

public class DrinkDTO {
    //음료명, 음료가격, 음료갯수.

    //각각의 데이터들을 따로 변수를 여러개 만들어서 관리하는 것보다
    //하나의 객체에 대한 변수들을 클래스 아래 모아놓고 사용하면 데이터 관리가 높고 정확성이 높음




    private String name;
    private int price, qty;
    TextView tv, tvn;
    Button btn;
    private int cnt;
    //신신규 : tv + Button까지 하나로 묶어서 관리하기 편하다
    public DrinkDTO(String name, int price, int qty, TextView tv, TextView tvn, Button btn, int cnt) {

        this.name = name;
        this.price = price;
        this.qty = qty;
        this.tv = tv;
        this.tvn = tvn;
        this.btn = btn;
        this.cnt= cnt;

        tv.setText(name + price + "원");
        tvn.setText(qty + "남음");
        btn.setText(name + "주문");

    }

    public Button getBtn() {
        return btn;
    }

    public void setBtn(Button btn) {
        this.btn = btn;
    }
    //신규DTO + 화면에 보이는 위젯까지 묶어서 가지고 있음.

   /* public DrinkDTO(String name, int price, int qty, TextView tv, TextView tvn) {
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.tv = tv;
        this.tvn = tvn;

        tv.setText(name + price + "원");
        tvn.setText(qty + "남음");
    }


    //기존 DTO : 이름 가격 수량만 있는 DTO
    public DrinkDTO(String name, int price, int qty) {
        this.name = name;
        this.price = price;
        this.qty = qty;
    }*/





    public TextView getTv() {
        return tv;
    }

    public void setTv(TextView tv) {
        this.tv = tv;
    }

    public TextView getTvn() {
        return tvn;
    }

    public void setTvn(TextView tvn) {
        this.tvn = tvn;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
        this.tvn.setText(qty+"개 남음");
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}
