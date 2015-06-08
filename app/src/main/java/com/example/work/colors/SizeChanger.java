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

// Класc выполняет функцию изменения размеров компонентов ListView
public class SizeChanger
{
    Context context;
    public SizeChanger(Context context)
    {
        this.context = context;
    }

    // используется для увеличения компонента ListView при клике
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
    }
    // используется в перерисовки компонентов ListView при скроллинге...
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void biggerQuickly(int background_color, View view)
    {
        // C помощью ObjectAnimator увеличиваем TextView и меняем в нем цвет текста
        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view.findViewById(R.id.tv_color),"minimumHeight",300);
        objectAnimator.setDuration(1);
        objectAnimator.start();
        ((TextView) view.findViewById(R.id.tv_color)).setTextColor(Color.parseColor("#D3D3D3"));

        // Добавляем прямоугольнику ColorFilter и ставим его на фон TextView
        Drawable rect = context.getResources().getDrawable(R.drawable.rectangle);
        ColorFilter filter = new LightingColorFilter(background_color,background_color);
        rect.setColorFilter(filter);
        ((TextView)view.findViewById(R.id.tv_color)).setBackground(rect);
    }
    // используется для уменьшения компонента ListView при повторном клике
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public void smaller(int background_color, int txt_color, View view)
    {
        // приводим цвет и размер к исходному состоянию
        ((TextView) view.findViewById(R.id.tv_color)).setBackground(context.getResources().getDrawable(R.drawable.rectangle));
        ((TextView) view.findViewById(R.id.tv_color)).setTextColor(background_color);

        ObjectAnimator objectAnimator = ObjectAnimator.ofInt(view.findViewById(R.id.tv_color),"minimumHeight",0);
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }
}
