package com.example.raed.iscatask.network;

import android.util.Log;

import com.example.raed.iscatask.data.Category;
import com.example.raed.iscatask.data.Results;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by raed on 9/27/18.
 */

public class AndoraCallBack implements Callback<Results> {
    private static final String TAG = "AndoraCallBack";

    private static final String BASE_URL = "http://isca-eg.com/task/";

    private static Retrofit retrofit;
    private CompletedRequestListener listener;
    private ApiService apiService;

    public interface CompletedRequestListener {
        void onCompleteRequest (Results categories);
    }

    private AndoraCallBack (CompletedRequestListener listener) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            apiService = retrofit.create(ApiService.class);
        }
        this.listener = listener;
    }

    public static AndoraCallBack getInstance (CompletedRequestListener listener) {
        return new AndoraCallBack(listener);
    }

    public void getData () {
        Call<Results> response = apiService.getCategory();
        response.enqueue(this);
    }

    @Override
    public void onResponse(Call<Results> call, Response<Results> response) {
        Log.d(TAG, "onResponse: " + response.toString());
        Results results = response.body();
        listener.onCompleteRequest(results);
    }

    @Override
    public void onFailure(Call<Results> call, Throwable t) {
        Log.d(TAG, "onFailure: " + t.toString());
    }
}
