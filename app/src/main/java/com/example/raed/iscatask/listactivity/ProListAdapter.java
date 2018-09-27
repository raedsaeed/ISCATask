package com.example.raed.iscatask.listactivity;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.raed.iscatask.R;
import com.example.raed.iscatask.Utils;
import com.example.raed.iscatask.data.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by raed on 9/27/18.
 */

public class ProListAdapter extends RecyclerView.Adapter<ProListAdapter.ProListHolder>{

    private Context context;
    private List<Item> itemList = new ArrayList<>();

    public ProListAdapter (Context context) {
        this.context = context;
        itemList = Utils.getFakeItems();
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
            holder.image.setImageResource(item.getImageId());
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


    class ProListHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView sale, name, price;
        ImageView image;
        public ProListHolder(View itemView) {
            super(itemView);
            sale = itemView.findViewById(R.id.item_sale);
            name = itemView.findViewById(R.id.item_name);
            price = itemView.findViewById(R.id.item_price);
            image = itemView.findViewById(R.id.item_image);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
