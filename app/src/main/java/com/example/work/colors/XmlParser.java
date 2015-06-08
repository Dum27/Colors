package com.example.work.colors;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

/**
 * Created by Work on 06.06.2015.
 */
public class XmlParser
{
    ArrayList<Cell>items;
    Context context;

    public XmlParser(Context context)
    {
        this.context = context;
        items = new ArrayList<Cell>();
    }

    public ArrayList<Cell> parse()
    {
        try {
            XmlPullParser xpp=context.getResources().getXml(R.xml.color_data);
            while (xpp.getEventType()!=XmlPullParser.END_DOCUMENT) {
                Cell item = new Cell();
                if (xpp.getEventType()==XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("color"))
                    {
                        item.color_name = (xpp.getAttributeValue(0));
                        item.color_code = (xpp.getAttributeValue(1));
                        Log.i("RGB==>", item.color_name+"-"+ item.color_code);
                        items.add(item);
                    }
                }
                xpp.next();
            }
        }
        catch (Throwable t)
        {
            Toast.makeText(context, "Request failed: " + t.toString(), Toast.LENGTH_LONG).show();
        }
        return items;
    }
}
