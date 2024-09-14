package com.example.restaurant;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash_screen extends AppCompatActivity {


    private static final int SPLASH_DELAY = 5000; // 1 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout to the splash screen layout file
        setContentView(R.layout.splash_screen);

        // Delay the activity transition using a Handler
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the next activity after the delay
                Intent intent = new Intent(splash_screen.this, MainActivity2.class);
                startActivity(intent);

                // Close the splash screen activity
                finish();
            }
        }, SPLASH_DELAY);
    }
}