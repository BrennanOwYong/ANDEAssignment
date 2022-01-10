package com.example.andeassignment;

import android.graphics.drawable.Drawable;

public class FoodItem {
    private String category;
    private String name;
    private String price;
    private Drawable image;

    public FoodItem(String category, String name, String price, Drawable image)
    {
        this.category = category;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getCategory() { return category; }

    public String getName()
    {
        return name;
    }

    public String getPrice()
    {
        return price;
    }

    public Drawable getImage()
    {
        return image;
    }
}
