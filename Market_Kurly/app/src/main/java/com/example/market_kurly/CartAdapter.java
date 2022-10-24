package com.example.market_kurly;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.DecimalFormat;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartHolder> {


    @NonNull
    @Override
    public CartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.item_cart, parent, false);
        return new CartHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CartHolder h, @SuppressLint("RecyclerView") int i) {
        DecimalFormat df = new DecimalFormat("###,##0");
        if(CartActivity.cart_list.get(i).isBool_sale()) {
            h.cart_list_name.setText(CartActivity.cart_list.get(i).getName());
            h.cart_list_pic.setImageResource(CartActivity.cart_list.get(i).getPic());
            h.cart_list_price.setText(CartActivity.cart_list.get(i).getPic());
            h.cart_list_realPrice.setText(df.format(CartActivity.cart_list.get(i).getPrice() * (100 - CartActivity.cart_list.get(i).getSale()) / 100 / 10 * 10));
            h.cart_list_price.setPaintFlags(h.cart_list_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            h.cart_list_price.setText(df.format(CartActivity.cart_list.get(i).getPrice()));
            h.cart_list_pricePer.setPaintFlags(h.cart_list_pricePer.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            h.cart_list_price.setVisibility(View.VISIBLE);
            h.cart_list_pricePer.setVisibility(View.VISIBLE);
        }else{
            h.cart_list_pic.setImageResource(CartActivity.cart_list.get(i).getPic());
            h.cart_list_name.setText(CartActivity.cart_list.get(i).getName());
            h.cart_list_realPrice.setText(df.format(CartActivity.cart_list.get(i).getPrice()));
            h.cart_list_price.setVisibility(View.GONE);
            h.cart_list_pricePer.setVisibility(View.GONE);
        }
        h.cart_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CartActivity.cart_list.remove(i);
                Toast.makeText(v.getContext(), "삭제 되었습니다.", Toast.LENGTH_SHORT).show();
                Intent intent = ((Activity)v.getContext()).getIntent();
                ((Activity)v.getContext()).finish(); //현재 액티비티 종료 실시
                ((Activity)v.getContext()).overridePendingTransition(0, 0); //효과 없애기
                ((Activity)v.getContext()).startActivity(intent); //현재 액티비티 재실행 실시
                ((Activity)v.getContext()).overridePendingTransition(0, 0); //효과 없애기
            }
        });
    }

    @Override
    public int getItemCount() {
        return CartActivity.cart_list.size();
    }

    public class CartHolder extends RecyclerView.ViewHolder{
        TextView cart_list_name, cart_list_realPrice, cart_list_price ,cart_list_pricePer;
        ImageView cart_list_pic, cart_delete;

        public CartHolder(@NonNull View v) {
            super(v);
            cart_list_name = v.findViewById(R.id.cart_list_name);
            cart_list_realPrice = v.findViewById(R.id.cart_list_realPrice);
            cart_list_price = v.findViewById(R.id.cart_list_price);
            cart_list_pic = v.findViewById(R.id.cart_list_pic);
            cart_list_pricePer = v.findViewById(R.id.cart_list_pricePer);
            cart_delete = v.findViewById(R.id.cart_delete);


        }
    }
}
