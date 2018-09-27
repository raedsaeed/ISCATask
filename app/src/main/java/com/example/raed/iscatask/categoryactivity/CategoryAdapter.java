package com.example.raed.iscatask.categoryactivity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raed.iscatask.R;
import com.example.raed.iscatask.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raed on 9/27/18.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryHolder> {
    private List<String> categories;
    private Context context;

    public CategoryAdapter (Context context) {
        this.context = context;
        categories = new ArrayList<>();
        categories.add(context.getString(R.string.men));
        categories.add(context.getString(R.string.women));
        categories.add(context.getString(R.string.kids));
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
            int imageId = Utils.getImage(categories.get(position));
            String type = categories.get(position);
            holder.catImage.setImageResource(imageId);
            holder.catText.setText(type);
        }
    }

    @Override
    public int getItemCount() {
        return (categories == null) ? 0 : categories.size();
    }

    class CategoryHolder extends RecyclerView.ViewHolder {
        ImageView catImage;
        TextView catText;
        public CategoryHolder(View itemView) {
            super(itemView);
            catImage = itemView.findViewById(R.id.cat_image);
            catText = itemView.findViewById(R.id.cat_text);
        }
    }
}
