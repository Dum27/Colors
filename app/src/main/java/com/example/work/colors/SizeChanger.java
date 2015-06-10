package com.example.work.colors;

import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Work on 07.06.2015.*
 */

// Class of resizing components of ListView
public class SizeChanger
{
    Context context;
    public SizeChanger(Context context)
    {
        this.context = context;
    }

    // Increase component ListView by clicking
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void biggerSlow(int background_color, View view)
    {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view.findViewById(R.id.tv_color),"minimumHeight",300);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
        ((TextView) view.findViewById(R.id.tv_color)).setTextColor(context.getResources().getColor(R.color.lightGray));

        Drawable rect = context.getResources().getDrawable(R.drawable.rectangle);
        ColorFilter filter = new LightingColorFilter(background_color,background_color);
        rect.setColorFilter(filter);
        (view.findViewById(R.id.tv_color)).setBackground(rect);
    }
    // Used in redrawing components ListView when scrolling ...
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void biggerQuickly(int background_color, View view)
    {
        // ObjectAnimator was increasing  TextView and change the color of text in it
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view.findViewById(R.id.tv_color),"minimumHeight",300);
        objectAnimator.setDuration(1);
        objectAnimator.start();
        ((TextView) view.findViewById(R.id.tv_color)).setTextColor(Color.parseColor("#D3D3D3"));

        // puts in rectangle ColorFilter and put it on the background TextView
        Drawable rect = context.getResources().getDrawable(R.drawable.rectangle);
        ColorFilter filter = new LightingColorFilter(background_color,background_color);
        rect.setColorFilter(filter);
        (view.findViewById(R.id.tv_color)).setBackground(rect);
    }
    // used to reduce component ListView when clicked again
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void smaller(int background_color, int txt_color, View view)
    {
        // give color and size to the original state
        (view.findViewById(R.id.tv_color)).setBackground(context.getResources().getDrawable(R.drawable.rectangle));
        ((TextView) view.findViewById(R.id.tv_color)).setTextColor(background_color);

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view.findViewById(R.id.tv_color),"minimumHeight",0);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }
}
