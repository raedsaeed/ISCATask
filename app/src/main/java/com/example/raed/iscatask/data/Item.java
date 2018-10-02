package com.example.raed.iscatask.data;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by raed on 9/27/18.
 */

public class Item implements Parcelable{
    int id;
    private String product_name;
    private double price;
    private String category;
    private String description;
    private String image;
    private int sale;

    public Item(int id, String product_name, double price, String category, String description, String image) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.category = category;
        this.description = description;
        this.image = image;
        sale = 0;
    }

    protected Item(Parcel in) {
        id = in.readInt();
        product_name = in.readString();
        price = in.readDouble();
        category = in.readString();
        description = in.readString();
        image = in.readString();
        sale = in.readInt();
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

    public int getId () {
        return id;
    }

    public String getName() {
        return product_name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory () {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public String getImage () {
        return image;
    }

    public int getSale() {
        return sale;
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
        dest.writeInt(id);
        dest.writeString(product_name);
        dest.writeDouble(price);
        dest.writeString(category);
        dest.writeString(description);
        dest.writeString(image);
        dest.writeInt(sale);
    }
}
