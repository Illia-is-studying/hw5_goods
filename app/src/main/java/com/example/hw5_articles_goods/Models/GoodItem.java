package com.example.hw5_articles_goods.Models;

public class GoodItem {
    private String shortDescription;
    private String fullDescription;
    private int imageDrawable;
    private double price;

    public GoodItem(String shortDescription, String fullDescription,
                    int imageDrawable, double price) {
        this.shortDescription = shortDescription;
        this.fullDescription = fullDescription;
        this.imageDrawable = imageDrawable;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFullDescription() {
        return fullDescription;
    }

    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public int getImageDrawable() {
        return imageDrawable;
    }

    public void setImageDrawable(int imageDrawable) {
        this.imageDrawable = imageDrawable;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }
}
