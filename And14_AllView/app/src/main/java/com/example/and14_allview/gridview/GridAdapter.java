package com.example.and14_allview.gridview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.and14_allview.R;

import java.util.ArrayList;


public class GridAdapter extends BaseAdapter {

    LayoutInflater inflater;
    ArrayList<GridDTO> glist;

    public GridAdapter(LayoutInflater inflater, ArrayList<GridDTO> glist) {
        this.inflater = inflater;
        this.glist = glist;
    }

    @Override
    public int getCount() {
        return glist.size();
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
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.item_gridview,parent,false);

        ImageView img = convertView.findViewById(R.id.img);
        TextView tv1 = convertView.findViewById(R.id.tv1);
        TextView tv2 = convertView.findViewById(R.id.tv2);

        img.setImageResource(glist.get(position).getImg());
        tv1.setText(glist.get(position).getTv1());
        tv2.setText(glist.get(position).getTv2());



        return convertView;
    }
}
