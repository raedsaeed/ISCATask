package com.example.raed.iscatask.network;

import com.example.raed.iscatask.data.Category;
import com.example.raed.iscatask.data.ProList;
import com.example.raed.iscatask.data.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by raed on 9/27/18.
 */

public interface ApiService {
    @GET("cat_list.php")
    Call<Results> getCategory ();

    @FormUrlEncoded
    @POST("pro_list.php")
    Call<ProList> getProList(@Field("category") String key);
}
