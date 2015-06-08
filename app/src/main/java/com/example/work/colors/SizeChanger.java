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
 * Created by Work on 07.06.2015.
 */
public class SizeChanger
{
    Context context;

    public SizeChanger(Context context)
    {
        this.context = context;
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void biggerSlow(int background_color, View view)
    {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view.findViewById(R.id.tv_color),"minimumHeight",300);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
        ((TextView) view.findViewById(R.id.tv_color)).setTextColor(Color.parseColor("#D3D3D3"));

        Drawable rect = context.getResources().getDrawable(R.drawable.rectangle);
        ColorFilter filter = new LightingColorFilter(background_color,background_color);
        rect.setColorFilter(filter);
        ((TextView)view.findViewById(R.id.tv_color)).setBackground(rect);
    }@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void biggerQuickly(int background_color, View view)
    {
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view.findViewById(R.id.tv_color),"minimumHeight",300);
        objectAnimator.setDuration(1);
        objectAnimator.start();
        ((TextView) view.findViewById(R.id.tv_color)).setTextColor(Color.parseColor("#D3D3D3"));

        Drawable rect = context.getResources().getDrawable(R.drawable.rectangle);
        ColorFilter filter = new LightingColorFilter(background_color,background_color);
        rect.setColorFilter(filter);
        ((TextView)view.findViewById(R.id.tv_color)).setBackground(rect);
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void smaller(int background_color, int txt_color, View view)
    {
        ((TextView) view.findViewById(R.id.tv_color)).setBackground(context.getResources().getDrawable(R.drawable.rectangle));
        ((TextView) view.findViewById(R.id.tv_color)).setTextColor(background_color);

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view.findViewById(R.id.tv_color),"minimumHeight",0);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }
}
