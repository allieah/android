package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start=findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
               Intent i=new Intent(getApplicationContext(),MainActivity2.class);
               startActivity(i);
                Toast.makeText(getApplicationContext(),"strtyt", Toast.LENGTH_SHORT).show();
            }
        });
    }
}