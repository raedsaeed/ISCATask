package com.example.raed.iscatask;

import com.example.raed.iscatask.data.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raed on 9/27/18.
 */

public class Utils {

    public static int getImage (String type) {
        if (type.equalsIgnoreCase("MEN")) {
            return R.drawable.men;
        }else if (type.equalsIgnoreCase("WOMEN")) {
            return R.drawable.women;
        }else if (type.equalsIgnoreCase("KIDS")) {
            return R.drawable.kids;
        }else {
            return -1;
        }
    }

//    public static List<Item> getFakeItems () {
//        List<Item> items = new ArrayList<>();
//        Item item1 = new Item("ipsome name", 250d, R.drawable.one, "this is description");
//        items.add(item1);
//
//        Item item2 = new Item("ipsome name", 240d, R.drawable.two, "this is description");
//        item2.setSale(25);
//        items.add(item2);
//
//        Item item3 = new Item("ipsome name", 300d, R.drawable.three, "this is description");
//        item3.setSale(10);
//        items.add(item3);
//
//        Item item4 = new Item("ipsome name", 180d, R.drawable.four, "this is description");
//        items.add(item4);
//
//        Item item5 = new Item("ipsome name", 190d, R.drawable.five, "this is description");
//        item5.setSale(25);
//        items.add(item5);
//
//        Item item6 = new Item("ipsome name", 290d, R.drawable.six, "this is description");
//        item6.setSale(10);
//        items.add(item6);
//
//        Item item7 = new Item("ipsome name", 200d, R.drawable.seven, "this is description");
//        items.add(item7);
//
//        Item item8 = new Item("ipsome name", 160d, R.drawable.one, "this is description");
//        item8.setSale(25);
//        items.add(item8);
//
//        Item item9 = new Item("ipsome name", 150d, R.drawable.two, "this is description");
//        item9.setSale(10);
//        items.add(item9);
//
//        return items;
//    }
}
