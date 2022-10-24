package com.example.market_kurly;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.market_kurly.home.PrizeDTO;
import com.example.market_kurly.person.Person_Fragment;
import com.example.market_kurly.person.Person_login_Fragment;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {
    public static ArrayList<PrizeDTO> cart_list = new ArrayList<>();
    RecyclerView recv_cart;
    TextView cart_price, cart_sale, cart_realPrice, cart_point, point_info, cart_allDelete;
    Button btn_cart;
    int price, realPrice, sale, point;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        recv_cart = findViewById(R.id.recv_cart);
        cart_price = findViewById(R.id.cart_price);
        cart_sale = findViewById(R.id.cart_sale);
        cart_realPrice = findViewById(R.id.cart_realPrice);
        cart_point = findViewById(R.id.cart_point);
        btn_cart = findViewById(R.id.btn_cart);
        point_info = findViewById(R.id.point_info);
        cart_allDelete = findViewById(R.id.cart_allDelete);



        for (int i = 0; i < cart_list.size(); i++) {
            price += cart_list.get(i).getPrice();
            sale += (cart_list.get(i).getPrice() * (cart_list.get(i).getSale())/100/10*10);
        }
        realPrice = price-sale;
        DecimalFormat df = new DecimalFormat("###,##0");
        cart_price.setText(df.format(price));
        cart_sale.setText(df.format(sale));
        if (cart_list.size()==0) {
            cart_realPrice.setText("0");
            btn_cart.setText("주문하기");
        }else {
            cart_realPrice.setText(df.format(realPrice+3000));
            btn_cart.setText(df.format(realPrice + 3000) + "원 주문하기");
        }
        point = realPrice / 100;
        cart_point.setText(point+"");



        if(Person_Fragment.login_state == 0){
            point_info.setText("로그인으로 적립가능합니다");
        }else{
            point_info.setText(Person_Fragment.person_info.getName()+"님 1% 적립 가능합니다.");
        }


        cart_allDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart_list.clear();
                finish();//인텐트 종료
                overridePendingTransition(0, 0);//인텐트 효과 없애기
                Intent intent = getIntent(); //인텐트
                startActivity(intent); //액티비티 열기
                overridePendingTransition(0, 0);//인텐트 효과 없애기
            }
        });

        btn_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CartActivity.this, "구매 완료!!!!!!!!!!! .", Toast.LENGTH_SHORT).show();
                cart_list.clear();
                finish();//인텐트 종료
                overridePendingTransition(0, 0);//인텐트 효과 없애기
                Intent intent = getIntent(); //인텐트
                startActivity(intent); //액티비티 열기
                overridePendingTransition(0, 0);//인텐트 효과 없애기
            }
        });


        recv_cart.setAdapter(new CartAdapter());
        RecyclerView.LayoutManager cart_manager = new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        recv_cart.setLayoutManager(cart_manager);










    }
}