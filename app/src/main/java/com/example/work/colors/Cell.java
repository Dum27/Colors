package com.example.work.colors;

/**
 * Created by Work on 06.06.2015.
 */
public class Cell
{
    private String colorName; // Color name
    private String colorCode; // RGB color code
    private int size = -1;     // Variable to determine the state of item in ListView (+1 Show / -1 minimized)

    public Cell() {}

    public void setSize(int size){this.size = size;}
    public void setColorName(String colorName){this.colorName = colorName;}
    public void setColorCode(String colorCode){this.colorCode = colorCode;}

    public String getColorName(){return colorName;}
    public String getColorCode(){return colorCode;}
    public int getSize(){return size;}
}
