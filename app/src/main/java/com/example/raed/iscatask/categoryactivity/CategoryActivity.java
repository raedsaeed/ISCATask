package com.example.raed.iscatask.categoryactivity;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.raed.iscatask.R;
import com.example.raed.iscatask.data.Category;
import com.example.raed.iscatask.data.Results;
import com.example.raed.iscatask.network.AndoraCallBack;

import java.util.List;

public class CategoryActivity extends AppCompatActivity implements AndoraCallBack.CompletedRequestListener {
    private static final String TAG = "CategoryActivity";

    SwipeRefreshLayout refreshLayout;
    AndoraCallBack callBack;
    CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        callBack = AndoraCallBack.getInstance(this);
        callBack.getData();

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setReverseLayout(true);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new CategoryAdapter(this);
        recyclerView.setAdapter(adapter);

        refreshLayout = findViewById(R.id.refresh_layout);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(true);
                callBack.getData();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_cart:
                Toast.makeText(this, "Cart message", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_search:
                Toast.makeText(this, "Search message", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCompleteRequest(Results categories) {
        Log.d(TAG, "onCompleteRequest: " + categories.getResults().size());
        refreshLayout.setRefreshing(false);
        adapter.loadData(categories.getResults());
    }
}
