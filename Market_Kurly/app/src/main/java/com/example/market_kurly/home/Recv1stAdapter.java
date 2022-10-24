package com.example.market_kurly.home;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market_kurly.CartAddFragment;
import com.example.market_kurly.LocationSheetFragment;
import com.example.market_kurly.MainActivity;
import com.example.market_kurly.R;

import java.text.DecimalFormat;
import java.util.ArrayList;


public class Recv1stAdapter extends RecyclerView.Adapter<Recv1stAdapter.Recv1stHolder> {
    LayoutInflater inflater;
    ArrayList<PrizeDTO> pop_list;
    MainActivity context;

    public Recv1stAdapter(LayoutInflater inflater, ArrayList<PrizeDTO> pop_list, Activity context) {
        this.inflater = inflater;
        this.pop_list = pop_list;
        this.context =(MainActivity) context;
    }

    @NonNull
    @Override
    public Recv1stHolder onCreateViewHolder(@NonNull ViewGroup parent,int viewType) {
        View v = inflater.inflate(R.layout.item_menu_small_recycler, parent, false);
        return new Recv1stHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Recv1stHolder h, @SuppressLint("RecyclerView") int i) {
        DecimalFormat df = new DecimalFormat("###,##0");
        if(pop_list.get(i).isBool_sale()){
            h.menu_small_pic.setImageResource(pop_list.get(i).getPic());
            h.menu_small_name.setText(pop_list.get(i).getName());
            h.menu_small_sale.setVisibility(View.VISIBLE);
            h.menu_small_salePer.setVisibility(View.VISIBLE);
            h.menu_small_sale.setText(pop_list.get(i).getSale()+"");
            h.menu_small_realPrice.setText(df.format(pop_list.get(i).getPrice() * (100 -pop_list.get(i).getSale())/100/10*10));
            h.menu_small_price.setVisibility(View.VISIBLE);
            h.menu_small_pricePer.setVisibility(View.VISIBLE);
            h.menu_small_price.setText(df.format(pop_list.get(i).getPrice()));
            h.menu_small_price.setPaintFlags(h.menu_small_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            h.menu_small_pricePer.setPaintFlags(h.menu_small_pricePer.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        }else if(!pop_list.get(i).isBool_sale()){
            h.menu_small_pic.setImageResource(pop_list.get(i).getPic());
            h.menu_small_name.setText(pop_list.get(i).getName());
            h.menu_small_sale.setVisibility(View.GONE);
            h.menu_small_salePer.setVisibility(View.GONE);
            h.menu_small_realPrice.setText(df.format(pop_list.get(i).getPrice()));
            h.menu_small_price.setVisibility(View.GONE);
            h.menu_small_pricePer.setVisibility(View.GONE);
        }
        h.menu_small_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CartAddFragment.cartAddInfo == 1){
                    CartAddFragment.cartAddList.remove(0);
                }
                CartAddFragment.cartAddList.add(pop_list.get(i));
                CartAddFragment.cartAddInfo =1;

                CartAddFragment bottomSheet = new CartAddFragment();
                bottomSheet.show(context.getSupportFragmentManager(), bottomSheet.getTag());
            }
        });


    }

    @Override
    public int getItemCount() {
        return pop_list.size();
    }

    public class Recv1stHolder extends RecyclerView.ViewHolder{
            ImageView menu_small_pic;
            TextView menu_small_name, menu_small_sale, menu_small_salePer, menu_small_realPrice, menu_small_price, menu_small_pricePer;
        public Recv1stHolder(@NonNull View v) {
            super(v);
            menu_small_pic = v.findViewById(R.id.menu_small_pic);
            menu_small_name = v.findViewById(R.id.menu_small_name);
            menu_small_sale = v.findViewById(R.id.menu_small_sale);
            menu_small_salePer = v.findViewById(R.id.menu_small_salePer);
            menu_small_realPrice = v.findViewById(R.id.menu_small_realPrice);
            menu_small_price = v.findViewById(R.id.menu_small_price);
            menu_small_pricePer = v.findViewById(R.id.menu_small_pricePer);

        }
    }
}
