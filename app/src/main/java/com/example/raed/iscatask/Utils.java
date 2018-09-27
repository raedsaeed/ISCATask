package com.example.raed.iscatask;

/**
 * Created by raed on 9/27/18.
 */

public class Utils {

    public static int getImage (String type) {
        if (type.equals("MEN")) {
            return R.drawable.men;
        }else if (type.equals("WOMEN")) {
            return R.drawable.women;
        }else if (type.equals("KIDS")) {
            return R.drawable.kids;
        }else {
            return -1;
        }
    }
}
