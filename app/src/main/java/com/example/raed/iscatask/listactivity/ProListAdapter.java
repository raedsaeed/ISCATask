package com.example.raed.iscatask.listactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raed.iscatask.R;
import com.example.raed.iscatask.Utils;
import com.example.raed.iscatask.data.Item;
import com.example.raed.iscatask.detailactivity.DetailActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.example.raed.iscatask.detailactivity.DetailActivity.EXTRA_ITEM;

/**
 * Created by raed on 9/27/18.
 */

public class ProListAdapter extends RecyclerView.Adapter<ProListAdapter.ProListHolder>{

    private Context context;
    private List<Item> itemList;

    public ProListAdapter (Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ProListHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new ProListHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull ProListHolder holder, int position) {
        Item item = itemList.get(position);
        if (item != null) {
            Picasso.with(context)
                    .load(item.getImage())
                    .into(holder.image);

            holder.price.setText(String.format(context.getString(R.string.price_format), String.valueOf(item.getPrice())));
            holder.name.setText(item.getName());
            if (item.getSale() == 0){
                holder.sale.setText(R.string.new_item);
            }else {
                holder.sale.setText(String.format(context.getString(R.string.sale_format), item.getSale()));
                holder.sale.setTextColor(context.getColor(R.color.color_accent_dark));
            }
        }
    }

    @Override
    public int getItemCount() {
        return (itemList == null) ? 0 : itemList.size();
    }


    public void loadList (List<Item> list) {
        itemList = list;
        notifyDataSetChanged();
    }

    class ProListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CardView cardView;
        TextView sale, name, price;
        ImageView image;
        public ProListHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_view);
            sale = itemView.findViewById(R.id.item_sale);
            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
            image = itemView.findViewById(R.id.item_image);
            cardView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, DetailActivity.class);
            Item item = itemList.get(getAdapterPosition());
            intent.putExtra(EXTRA_ITEM, item);
            context.startActivity(intent);
        }
    }
}
