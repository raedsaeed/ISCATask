package com.example.raed.iscatask.network;

import android.util.Log;

import com.example.raed.iscatask.data.ProList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by raed on 10/2/18.
 */

public class AndoraProListCallback implements Callback<ProList> {
    private static final String TAG = "AndoraProListCallback";

    private static final String BASE_URL = "http://isca-eg.com/task/";
    private static Retrofit retrofit;
    private ApiService apiService;
    private CompletedListListener listListener;

    public interface CompletedListListener {
        void onSuccessfulRequest (ProList list);
    }

    private AndoraProListCallback (CompletedListListener listListener) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        apiService = retrofit.create(ApiService.class);
        this.listListener = listListener;
    }

    public static AndoraProListCallback getInstance (CompletedListListener listListener) {
        return new AndoraProListCallback(listListener);
    }

    public void getListFromNetwork (String key) {
        Call<ProList> proListCall = apiService.getProList(key);
        proListCall.enqueue(this);
    }

    @Override
    public void onResponse(Call<ProList> call, Response<ProList> response) {
        ProList list = response.body();
        listListener.onSuccessfulRequest(list);
    }

    @Override
    public void onFailure(Call<ProList> call, Throwable t) {
        Log.d(TAG, "onFailure: " + t.toString());
    }
}
