package com.example.market_kurly.home;

import android.app.Activity;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.market_kurly.CartAddFragment;
import com.example.market_kurly.MainActivity;
import com.example.market_kurly.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class HomePopAdapter extends BaseAdapter {
    LayoutInflater inflater;
    ArrayList<PrizeDTO> pop_list;
    MainActivity context;

    public HomePopAdapter(LayoutInflater inflater, ArrayList<PrizeDTO> pop_list, Activity context) {
        this.inflater = inflater;
        this.pop_list = pop_list;
        this.context =(MainActivity) context;
    }

    @Override
    public int getCount() {
        return pop_list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View c, ViewGroup parent) {
        c = inflater.inflate(R.layout.item_grid_new, parent, false);

        ImageView menu_small_pic = c.findViewById(R.id.menu_small_pic);
        TextView menu_small_name = c.findViewById(R.id.menu_small_name);
        TextView menu_small_sale = c.findViewById(R.id.menu_small_sale);
        TextView menu_small_salePer = c.findViewById(R.id.menu_small_salePer);
        TextView menu_small_realPrice = c.findViewById(R.id.menu_small_realPrice);
        TextView menu_small_price = c.findViewById(R.id.menu_small_price);
        TextView menu_small_pricePer = c.findViewById(R.id.menu_small_pricePer);

        DecimalFormat df = new DecimalFormat("###,##0");
        if(pop_list.get(i).isBool_sale()){
            menu_small_pic.setImageResource(pop_list.get(i).getPic());
            menu_small_name.setText(pop_list.get(i).getName());
            menu_small_sale.setVisibility(View.VISIBLE);
            menu_small_salePer.setVisibility(View.VISIBLE);
            menu_small_sale.setText(pop_list.get(i).getSale()+"");
            menu_small_realPrice.setText(df.format(pop_list.get(i).getPrice() * (100 -pop_list.get(i).getSale())/100/10*10));
            menu_small_price.setVisibility(View.VISIBLE);
            menu_small_pricePer.setVisibility(View.VISIBLE);
            menu_small_price.setText(df.format(pop_list.get(i).getPrice()));
            menu_small_price.setPaintFlags(menu_small_price.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            menu_small_pricePer.setPaintFlags(menu_small_pricePer.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);


        }else if(!pop_list.get(i).isBool_sale()){
            menu_small_pic.setImageResource(pop_list.get(i).getPic());
            menu_small_name.setText(pop_list.get(i).getName());
            menu_small_sale.setVisibility(View.GONE);
            menu_small_salePer.setVisibility(View.GONE);
            menu_small_realPrice.setText(df.format(pop_list.get(i).getPrice()));
            menu_small_price.setVisibility(View.GONE);
            menu_small_pricePer.setVisibility(View.GONE);
        }






        return c;
    }
}
