package com.example.work.colors;

import android.content.Context;
import android.widget.Toast;
import org.xmlpull.v1.XmlPullParser;
import java.util.ArrayList;

/**
 * Created by Work on 06.06.2015.
 */

// This is class parse XML file with colors. Function parse() return
public class XmlParser
{
    ArrayList<Cell>items;
    Context context;

    public XmlParser(Context context)
    {
        this.context = context;
        items = new ArrayList<Cell>();
    }

    // this method will return  full Array List with names of colors and  RGB codes of colors
    public ArrayList<Cell> parse()
    {
        try {
            XmlPullParser xpp = context.getResources().getXml(R.xml.color_data);
            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {
                Cell item = new Cell();
                if (xpp.getEventType()==XmlPullParser.START_TAG) {
                    if (xpp.getName().equals("color"))
                    {
                        item.setColorName(xpp.getAttributeValue(null,"name"));
                        item.setColorCode(xpp.getAttributeValue(null,"color"));
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
