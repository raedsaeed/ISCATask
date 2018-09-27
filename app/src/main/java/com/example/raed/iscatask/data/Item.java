package com.example.raed.iscatask.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by raed on 9/27/18.
 */

public class Item implements Parcelable{
    private String name;
    private double price;
    private int imageId;
    private int sale;
    private String description;

    public Item(String name, double price, int imageId, String description) {
        this.name = name;
        this.price = price;
        this.imageId = imageId;
        this.description = description;
        sale = 0;
    }

    protected Item(Parcel in) {
        name = in.readString();
        price = in.readDouble();
        imageId = in.readInt();
        sale = in.readInt();
        description = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getImageId() {
        return imageId;
    }

    public int getSale() {
        return sale;
    }

    public String getDescription() {
        return description;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeDouble(price);
        dest.writeInt(imageId);
        dest.writeInt(sale);
        dest.writeString(description);
    }
}
