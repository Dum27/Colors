package com.example.work.colors;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter
{
    Context ctx;
    LayoutInflater lInflater;
    ArrayList<Item> items;
    SizeChanger sc;

    CustomAdapter(Context context, ArrayList<Item> items)
    {
        this.ctx = context;
        this.items = items;
        sc = new SizeChanger(ctx);
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

     //���-�� ���������
     @Override public int getCount() {return items.size();}

     // ������� �� �������
     @Override public Object getItem(int position) {return items.get(position);}

     //id �� �������
     @Override public long getItemId(int position) {return position;}


     @Override public View getView(int position, View convertView, ViewGroup parent)
     {
         View view = convertView;

         view = lInflater.inflate(R.layout.item, parent, false);
         Item i = getProduct(position);

         // ��������� View � ������ ������ �������.
         ((TextView) view.findViewById(R.id.tv_color)).setText(i.color_name);
         ((TextView) view.findViewById(R.id.tv_color)).setTextColor(Color.parseColor(i.color_code));

         if (items.get(position).getSize() == 1)
         {
             sc.biggerQuickly(Color.parseColor(items.get(position).color_code), view);
         }
         return view;

     }
    // ������ �� �������
    Item getProduct(int position)
    {
        return ((Item) getItem(position));
    }
}