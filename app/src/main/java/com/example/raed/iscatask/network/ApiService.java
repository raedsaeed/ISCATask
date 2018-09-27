package com.example.raed.iscatask.network;

import com.example.raed.iscatask.data.Category;
import com.example.raed.iscatask.data.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by raed on 9/27/18.
 */

public interface ApiService {
    @GET("cat_list.php")
    Call<Results> getCategory ();
}
