package com.example.raed.iscatask.listactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.raed.iscatask.R;
import com.example.raed.iscatask.data.ProList;
import com.example.raed.iscatask.data.Results;
import com.example.raed.iscatask.network.AndoraCategoryCallBack;
import com.example.raed.iscatask.network.AndoraProListCallback;

public class ListActivity extends AppCompatActivity implements AndoraProListCallback.CompletedListListener{

    public static final String EXTRA_CATEGORY_KEY = "com.example.raed.iscatask.CATEGORY_KEY";
    private SwipeRefreshLayout refreshLayout;
    private ProListAdapter adapter;
    private String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        final AndoraProListCallback callback = AndoraProListCallback.getInstance(this);
        Intent intent = getIntent();
        if (intent != null) {
            key = intent.getStringExtra(EXTRA_CATEGORY_KEY);
            callback.getListFromNetwork(key);
        }

        RecyclerView recyclerView = findViewById(R.id.pro_rv);
        adapter = new ProListAdapter(this);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


        refreshLayout = findViewById(R.id.refresh_layout);
        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshLayout.setRefreshing(true);
                callback.getListFromNetwork(key);
            }
        });
    }

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
    public void onSuccessfulRequest(ProList list) {
        refreshLayout.setRefreshing(false);
        adapter.loadList(list.getResult());
    }
}
