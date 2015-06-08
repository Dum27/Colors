// http://developer.alexanderklimov.ru/android/theory/shape.php figures
// http://stackoverflow.com/questions/10138156/set-drawable-listview-background-per-item

package com.example.work.colors;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class MainActivity extends Activity
{
    ListView lvMain;
    ArrayList<Cell> items;
    CustomAdapter customAdapter;
    Context context;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        XmlParser parser = new XmlParser(this);
        items = parser.parse();

        customAdapter = new CustomAdapter(this, items);
        lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(customAdapter);
        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SizeChanger size = new SizeChanger(context);
                // ѕроверка в каком состо€нии находитьс€ елемент (открытом/закрытом)
                if (items.get(position).getSize() == -1)
                {
                    // вызываем функци€ увеличени€ €чейки и передаем ей view и цвет.
                    size.biggerSlow(Color.parseColor(items.get(position).color_code), view);
                    items.get(position).setSize(1);
                    customAdapter.items.get(position).setSize(1);
                } else
                {
                    // вызываем функци€ уменьшени€ €чейки.
                    size.smaller(Color.parseColor(items.get(position).color_code), Color.parseColor(items.get(0).color_code), view);
                    items.get(position).setSize(-1);
                    customAdapter.items.get(position).setSize(-1);
                }
            }
        });
    }
}