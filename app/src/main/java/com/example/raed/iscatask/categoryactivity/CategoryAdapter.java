package com.example.raed.iscatask.categoryactivity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raed.iscatask.R;
import com.example.raed.iscatask.Utils;
import com.example.raed.iscatask.data.Category;
import com.example.raed.iscatask.listactivity.ListActivity;

import java.util.List;

/**
 * Created by raed on 9/27/18.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    private static final String TAG = "CategoryAdapter";

    private List<Category> categories;
    private Context context;

    public CategoryAdapter (Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.cat_item, parent, false);
        return new CategoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryHolder holder, int position) {
        if (categories.get(position) !=  null) {
            Log.d(TAG, "onBindViewHolder: " + categories.get(position).getCategory());
            int imageId = Utils.getImage(categories.get(position).getCategory());
            String type = categories.get(position).getCategory();
            holder.catImage.setImageResource(imageId);
            holder.catText.setText(type);
        }
    }

    @Override
    public int getItemCount() {
        return (categories == null) ? 0 : categories.size();
    }

    public void loadData (List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    class CategoryHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView catImage;
        TextView catText;
        public CategoryHolder(View itemView) {
            super(itemView);
            catImage = itemView.findViewById(R.id.cat_image);
            catText = itemView.findViewById(R.id.cat_text);
            catImage.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Intent intent = new Intent(context, ListActivity.class);
            context.startActivity(intent);
        }
    }
}
