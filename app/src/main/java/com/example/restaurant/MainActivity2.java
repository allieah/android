package com.example.restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    private ImageButton breakfastV;
    private ImageButton lunchV;
    private ImageButton snacksV;
    private ImageButton dessertsV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        breakfastV=findViewById(R.id.breakfastV);

        breakfastV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent b=new Intent(getApplicationContext(),breakfast.class);
                startActivity(b);
                Toast.makeText(getApplicationContext(), "breakfast menu", Toast.LENGTH_SHORT).show();
            }
        });
        lunchV=findViewById(R.id.lunchV);

        lunchV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent l=new Intent(getApplicationContext(),lunch.class);
                startActivity(l);
                Toast.makeText(getApplicationContext(), "breakfast menu", Toast.LENGTH_SHORT).show();
            }
        });
        snacksV=findViewById(R.id.snacksV);
        snacksV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent s=new Intent(getApplicationContext(),snacks.class);
                startActivity(s);
                Toast.makeText(getApplicationContext(), "breakfast menu", Toast.LENGTH_SHORT).show();
            }
        });

        dessertsV=findViewById(R.id.dessertsV);
        dessertsV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent d=new Intent(getApplicationContext(),desserts.class);
                startActivity(d);
                Toast.makeText(getApplicationContext(), "breakfast menu", Toast.LENGTH_SHORT).show();
            }
        });


    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.item1:
                Intent b=new Intent(getApplicationContext(),breakfast.class);
                startActivity(b);
                Toast.makeText(getApplicationContext(),"You are in breakfast class",
                        Toast.LENGTH_SHORT).show();

                return true;

            case R.id.item2:
                Intent l=new Intent(getApplicationContext(),lunch.class);
                startActivity(l);
                Toast.makeText(getApplicationContext(), " You are in lunch class", Toast.LENGTH_SHORT).show();
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