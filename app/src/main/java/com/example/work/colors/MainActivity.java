// http://developer.alexanderklimov.ru/android/theory/shape.php figures
// http://stackoverflow.com/questions/10138156/set-drawable-listview-background-per-item

package com.example.work.colors;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends Activity
{
    ListView lvMain;
    ArrayList<Item> items;
    BoxAdapter boxAdapter;
    Context context;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = this;

        ParseXmlColors parser = new ParseXmlColors(this);
        items = parser.parse();

        boxAdapter = new BoxAdapter(this, items);
        lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(boxAdapter);
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                ChangeSize size = new ChangeSize(context);
Log.d("onClick","position-> "+position+" id-> "+id);
                // Проверка в каком состоянии находиться елемент (открытом/закрытом)
                if(items.get(position).getSize() == -1)
                {
                    // вызываем функция увеличения ячейки и передаем ей view и цвет.
                    size.bigger(Color.parseColor(items.get(position).color_code),view);
                    items.get(position).setSize(1);
                }
                else
                {
                    // вызываем функция уменбшения ячейки.
                    size.smaller(Color.parseColor(items.get(position).color_code),Color.parseColor(items.get(0).color_code),view);
                    items.get(position).setSize(-1);
                }
            }
       });
    }
}