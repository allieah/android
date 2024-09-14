package com.example.restaurant;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyListAdapter extends ArrayAdapter<String> {
    double totalPrice = 0.0;
    private Context context;
    private String[] iconTitle;
    private Integer[] iconPrice;
    private Integer[] icons;
    private OnItemChangedListener mListener;

    public MyListAdapter(Context context, String[] iconTitle, Integer[] iconPrice, Integer[] icons, OnItemChangedListener listener) {
        super(context, R.layout.mylist, iconTitle);
        this.context = context;
        this.iconTitle = iconTitle;
        this.iconPrice = iconPrice;
        this.icons = icons;
        this.mListener = listener;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItem = convertView;
        if (listItem == null) {
            listItem = LayoutInflater.from(context).inflate(R.layout.mylist, parent, false);
        }

        ImageView icon = listItem.findViewById(R.id.icons);
        TextView title = listItem.findViewById(R.id.icontitle);
        TextView price = listItem.findViewById(R.id.iconprice);
        Button addButton = listItem.findViewById(R.id.add);
        Button subtractButton = listItem.findViewById(R.id.subtract);

        icon.setImageResource(icons[position]);
        title.setText(iconTitle[position]);
        price.setText("Rs." + iconPrice[position]);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              totalPrice =totalPrice+iconPrice[position] ;
                mListener.onItemAdded(iconTitle[position], iconPrice[position]);
                Toast.makeText(context.getApplicationContext(),iconTitle[position]+"has been added. Total="+ totalPrice,
                        Toast.LENGTH_SHORT).show();
            }
        });

        subtractButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                totalPrice =totalPrice-iconPrice[position] ;
                mListener.onItemSubtracted(iconTitle[position], iconPrice[position]);
                Toast.makeText(context.getApplicationContext(),iconTitle[position]+" has been removed Total="+ totalPrice,
                        Toast.LENGTH_SHORT).show();
            }
        });

        return listItem;
    }

    public interface OnItemChangedListener {
        void onItemAdded(String itemName, int itemPrice);
        void onItemSubtracted(String itemName, int itemPrice);
    }
}