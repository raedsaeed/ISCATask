package com.example.raed.iscatask.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raed on 10/2/18.
 */

public class ProList {
    private List<Item> Result;

    public ProList () {
        Result = new ArrayList<>();
    }

    public List<Item> getResult () {
        return Result;
    }
}
