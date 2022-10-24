package com.example.market_kurly;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.market_kurly.home.PrizeDTO;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.io.Closeable;
import java.text.DecimalFormat;
import java.util.ArrayList;


public class CartAddFragment extends BottomSheetDialogFragment {
    public static ArrayList<PrizeDTO> cartAddList = new ArrayList<>();
    public static int cartAddInfo = 0;

    ImageView cartAdd_pic;
    TextView cartAdd_name, cartAdd_realPrice, cartAdd_price;
    Button btn_addCart;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cart_add, container, false);

        cartAdd_pic = v.findViewById(R.id.cartAdd_pic);
        cartAdd_name = v.findViewById(R.id.cartAdd_name);
        cartAdd_realPrice = v.findViewById(R.id.cartAdd_realPrice);
        cartAdd_price = v.findViewById(R.id.cartAdd_price);
        btn_addCart = v.findViewById(R.id.btn_addCart);

        DecimalFormat df = new DecimalFormat("###,##0");


        cartAdd_pic.setImageResource(cartAddList.get(0).getPic());
        cartAdd_name.setText(cartAddList.get(0).getName());
        cartAdd_realPrice.setText(df.format(cartAddList.get(0).getPrice() * (100 -cartAddList.get(0).getSale())/100/10*10)+"원");
        cartAdd_price.setText(df.format(cartAddList.get(0).getPrice()));

        btn_addCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cartAddInfo = 0;
                CartActivity.cart_list.add(cartAddList.get(0));
                Toast.makeText(getContext(), "장바구니에 상품이 담겼습니다.", Toast.LENGTH_SHORT).show();
                cartAddList.clear();
            }
        });


        return v;
    }

    @Override
    public void onViewCreated(@NonNull View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);


    }

}