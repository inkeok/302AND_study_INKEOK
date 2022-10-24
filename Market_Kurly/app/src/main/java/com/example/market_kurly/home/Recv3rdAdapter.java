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

public class Recv3rdAdapter extends RecyclerView.Adapter<Recv3rdAdapter.Recv3rdHolder> {
    LayoutInflater inflater;
    ArrayList<PrizeDTO> vege_list;
    MainActivity context;

    public Recv3rdAdapter(LayoutInflater inflater, ArrayList<PrizeDTO> vege_list, Activity context) {
        this.inflater = inflater;
        this.vege_list = vege_list;
        this.context =(MainActivity) context;
    }


    @NonNull
    @Override
    public Recv3rdHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Recv3rdHolder(inflater.inflate(R.layout.item_menu_small_recycler, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Recv3rdHolder h, @SuppressLint("RecyclerView") int i) {
        DecimalFormat df = new DecimalFormat("###,##0");
        if(vege_list.get(i).isBool_sale()){
            h.menu_small_pic.setImageResource(vege_list.get(i).getPic());
            h.menu_small_name.setText(vege_list.get(i).getName());
            h.menu_small_sale.setVisibility(View.VISIBLE);
            h.menu_small_salePer.setVisibility(View.VISIBLE);
            h.menu_small_sale.setText(vege_list.get(i).getSale()+"");
            h.menu_small_realPrice.setText(df.format(vege_list.get(i).getPrice() * (100 -vege_list.get(i).getSale())/100/10*10));
            h.menu_small_price.setVisibility(View.VISIBLE);
            h.menu_small_pricePer.setVisibility(View.VISIBLE);
            h.menu_small_price.setText(df.format(vege_list.get(i).getPrice()));
            h.menu_small_price.setPaintFlags(h.menu_small_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            h.menu_small_pricePer.setPaintFlags(h.menu_small_pricePer.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        }else if(!vege_list.get(i).isBool_sale()){
            h.menu_small_pic.setImageResource(vege_list.get(i).getPic());
            h.menu_small_name.setText(vege_list.get(i).getName());
            h.menu_small_sale.setVisibility(View.GONE);
            h.menu_small_salePer.setVisibility(View.GONE);
            h.menu_small_realPrice.setText(df.format(vege_list.get(i).getPrice()));
            h.menu_small_price.setVisibility(View.GONE);
            h.menu_small_pricePer.setVisibility(View.GONE);
        }
        h.menu_small_pic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (CartAddFragment.cartAddInfo == 1){
                    CartAddFragment.cartAddList.remove(0);
                }
                CartAddFragment.cartAddList.add(vege_list.get(i));
                CartAddFragment.cartAddInfo =1;

                CartAddFragment bottomSheet = new CartAddFragment();
                bottomSheet.show(context.getSupportFragmentManager(), bottomSheet.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return vege_list.size();
    }

    public class Recv3rdHolder extends RecyclerView.ViewHolder{
        ImageView menu_small_pic;
        TextView menu_small_name, menu_small_sale, menu_small_salePer, menu_small_realPrice, menu_small_price, menu_small_pricePer;
        public Recv3rdHolder(@NonNull View v) {
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

