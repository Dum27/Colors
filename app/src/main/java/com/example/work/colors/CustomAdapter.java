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
    ArrayList<Item> objects;

    CustomAdapter(Context context, ArrayList<Item> products)
    {
        ctx = context;
        objects = products;
        lInflater = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

     // кол-во элементов
     @Override public int getCount() {return objects.size();}

     // элемент по позиции
     @Override public Object getItem(int position) {return objects.get(position);}

     //id по позиции
     @Override public long getItemId(int position) {
        return position;
    }


     @Override public View getView(int position, View convertView, ViewGroup parent) // пункт списка
     {
        // используем созданные, но не используемые view
        View view = convertView;
        if (view == null)
        {
            view = lInflater.inflate(R.layout.item, parent, false);
        }
        Item i = getProduct(position);
        // заполняем View в пункте списка данными.
        ((TextView) view.findViewById(R.id.tv_color)).setText(i.color_name);
        ((TextView) view.findViewById(R.id.tv_color)).setTextColor(Color.parseColor(i.color_code));
        return view;
     }
    // ячейка по позиции
    Item getProduct(int position)
    {
        return ((Item) getItem(position));
    }
}