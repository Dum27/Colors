package com.example.work.colors;

/**
 * Created by Work on 06.06.2015.
 */
public class Cell
{
    String color_name; // Название цвета
    String color_code; // RGB код цвета
    private int size = -1; // переменная для определения состояния елемента ListView (+1 развернут/ -1 свернут)

    public Cell() {}

    public Cell(String color_name, String color_code)
    {
        this.color_name = color_name;
        this.color_code = color_code;
    }
    public void setSize(int size){this.size = size;}
    public int getSize(){return size;}
}
