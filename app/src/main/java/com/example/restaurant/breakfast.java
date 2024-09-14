package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;

public class breakfast extends AppCompatActivity implements MyListAdapter.OnItemChangedListener {

    ListView list;
    String[] iconTitle={
            "Pancake", "Burrito","Waffle"
    };
    Integer[] iconPrice={
            60,100,120
    };
    Integer[] icons={
            R.drawable.pancake,R.drawable.burrito,R.drawable.waffle
    };
    double totalPrice = 0.0;
    private Button back;
    private Button pay;
    private ArrayList<String> itemNamesAdded = new ArrayList<>();
    private ArrayList<Integer> itemPricesAdded = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.breakf);

        MyListAdapter adapter = new MyListAdapter(this, iconTitle, iconPrice, icons, this);
        list = findViewById(R.id.breakfastlist);
        list.setAdapter(adapter);

        pay = findViewById(R.id.pay);
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (itemNamesAdded.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Please add items before clicking on Pay",
                            Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(breakfast.this, bill.class);
                    intent.putExtra("itemNames", itemNamesAdded);
                    intent.putExtra("itemPrices", itemPricesAdded);
                    intent.putExtra("totalPrice", totalPrice);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onItemAdded(String itemName, int itemPrice) {
        itemNamesAdded.add(itemName);
        itemPricesAdded.add(itemPrice);
        totalPrice += itemPrice;
    }

    @Override
    public void onItemSubtracted(String itemName, int itemPrice) {
        int index = itemNamesAdded.indexOf(itemName);
        if (index != -1) {
            itemNamesAdded.remove(index);
            itemPricesAdded.remove(index);
            totalPrice -= itemPrice;
        }
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.item1:
                Toast.makeText(getApplicationContext(),"You are in breakfast class",
                        Toast.LENGTH_SHORT).show();

            case R.id.item2:
                Intent l=new Intent(getApplicationContext(),lunch.class);
                startActivity(l);
                Toast.makeText(getApplicationContext(), "lunch menu", Toast.LENGTH_SHORT).show();
                return true;

            case R.id.item3:
                Intent s=new Intent(getApplicationContext(),snacks.class);
                startActivity(s);
                Toast.makeText(getApplicationContext(), "snacks menu", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.item4:
                Intent d=new Intent(getApplicationContext(),desserts.class);
                startActivity(d);
                Toast.makeText(getApplicationContext(), "desserts menu", Toast.LENGTH_SHORT).show();

                return true;

        }
        return(super.onOptionsItemSelected(item));
    }
}

