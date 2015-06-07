package com.example.work.colors;

/**
 * Created by Work on 06.06.2015.
 */
public class Item
{
    String color_name;
    String color_code;
    private int size = -1;

    public Item() {}

    public Item(String color_name, String color_code)
    {
        this.color_name = color_name;
        this.color_code = color_code;
    }
    public void setSize(int size){this.size = size;}
    public int getSize(){return size;}
}
