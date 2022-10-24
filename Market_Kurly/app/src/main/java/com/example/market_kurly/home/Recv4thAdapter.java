package com.example.market_kurly.home;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.market_kurly.CartAddFragment;
import com.example.market_kurly.MainActivity;
import com.example.market_kurly.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Recv4thAdapter extends RecyclerView.Adapter<Recv4thAdapter.Recv4thHolder> {
    LayoutInflater inflater;
    ArrayList<PrizeDTO> new_list;
    MainActivity context;

    public Recv4thAdapter(LayoutInflater inflater, ArrayList<PrizeDTO> new_list, Activity context) {
        this.inflater = inflater;
        this.new_list = new_list;
        this.context =(MainActivity) context;
    }

    @NonNull
    @Override
    public Recv4thHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Recv4thHolder(inflater.inflate(R.layout.item_menu_small_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Recv4thHolder h, @SuppressLint("RecyclerView") int i) {
        DecimalFormat df = new DecimalFormat("###,##0");
        if(new_list.get(i).isBool_sale()){
            h.menu_small_pic.setImageResource(new_list.get(i).getPic());
            h.menu_small_name.setText(new_list.get(i).getName());
            h.menu_small_sale.setVisibility(View.VISIBLE);
            h.menu_small_salePer.setVisibility(View.VISIBLE);
            h.menu_small_sale.setText(new_list.get(i).getSale()+"");
            int num = new_list.get(i).getPrice() * (100 -new_list.get(i).getSale())/100;
            h.menu_small_realPrice.setText(df.format(num/10*10));
            h.menu_small_price.setVisibility(View.VISIBLE);
            h.menu_small_pricePer.setVisibility(View.VISIBLE);
            h.menu_small_price.setText(df.format(new_list.get(i).getPrice()));
            h.menu_small_price.setPaintFlags(h.menu_small_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            h.menu_small_pricePer.setPaintFlags(h.menu_small_pricePer.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        }else if(!new_list.get(i).isBool_sale()){
            h.menu_small_pic.setImageResource(new_list.get(i).getPic());
            h.menu_small_name.setText(new_list.get(i).getName());
            h.menu_small_sale.setVisibility(View.GONE);
            h.menu_small_salePer.setVisibility(View.GONE);
            h.menu_small_realPrice.setText(df.format(new_list.get(i).getPrice()));
            h.menu_small_price.setVisibility(View.GONE);
            h.menu_small_pricePer.setVisibility(View.GONE);
        }
        h.menu_small_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CartAddFragment.cartAddInfo == 1){
                    CartAddFragment.cartAddList.remove(0);
                }
                CartAddFragment.cartAddList.add(new_list.get(i));
                CartAddFragment.cartAddInfo =1;

                CartAddFragment bottomSheet = new CartAddFragment();
                bottomSheet.show(context.getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return new_list.size();
    }

    public class Recv4thHolder extends RecyclerView.ViewHolder{
        ImageView menu_small_pic;
        TextView menu_small_name, menu_small_sale, menu_small_salePer, menu_small_realPrice, menu_small_price, menu_small_pricePer;
        public Recv4thHolder(@NonNull View v) {
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
