package com.example.raed.iscatask.detailactivity;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raed.iscatask.R;
import com.example.raed.iscatask.data.Item;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_ITEM = "com.example.raed.iscatask.EXTRA_ITEM";
    private static final String SAVED_ITEM = "com.example.raed.iscatask.SAVED_ITEM";

    private Item item;

    ImageView imageView;
    TextView name, price, description, sale;
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        getSupportActionBar().setHomeButtonEnabled(true);

        imageView = findViewById(R.id.image);
        name = findViewById(R.id.name);
        price = findViewById(R.id.price);
        description = findViewById(R.id.description);
        sale = findViewById(R.id.sale);

        Intent intent = getIntent();
        if (intent != null) {
            item = intent.getParcelableExtra(EXTRA_ITEM);
            imageView.setImageResource(item.getImageId());
            name.setText(item.getName());
            description.setText(item.getDescription());
            price.setText(String.format(getString(R.string.price_format), String.valueOf(item.getPrice())));
            if (item.getSale() == 0){
                sale.setText(R.string.new_item);
            }else {
                sale.setText(String.format(getString(R.string.sale_format), item.getSale()));
                sale.setTextColor(getColor(R.color.color_accent_dark));
            }
        }
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
}
