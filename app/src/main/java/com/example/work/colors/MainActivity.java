
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
    ArrayList<Cell> itemsAr;
    CustomAdapter customAdapter;
    Context context;

    /** Called when the activity is first created. */
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        XmlParser parser = new XmlParser(this);
        itemsAr = parser.parse();

        customAdapter = new CustomAdapter(this, itemsAr);
        lvMain = (ListView) findViewById(R.id.lvMain);
        lvMain.setAdapter(customAdapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                SizeChanger size = new SizeChanger(context);
                // Check the condition of the element ( open / closed )
                if (itemsAr.get(position).getSize() == -1)
                {
                    // Call the zoom function of the cell and pass it the view and color.
                    size.biggerSlow(Color.parseColor(itemsAr.get(position).getColorCode()), view);
                    itemsAr.get(position).setSize(1);
                    customAdapter.itemsAr.get(position).setSize(1);
                } else
                {
                    // Call functions reduce cell.
                    size.smaller(Color.parseColor(itemsAr.get(position).getColorCode()), Color.parseColor(itemsAr.get(0).getColorCode()), view);
                    itemsAr.get(position).setSize(-1);
                    customAdapter.itemsAr.get(position).setSize(-1);
                }
            }
        });
    }
}
