package com.example.myapplication;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.ads.mediationtestsuite.activities.HomeActivity;

public class FlashActivity extends AppCompatActivity {
    private static final int SPLASH_TIME_OUT = 2000; // 2000 milliseconds = 2 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);  // Reference to the XML layout

        // Handler to delay the navigation to HomeActivity
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the HomeActivity after 2 seconds
                Intent homeIntent = new Intent(FlashActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish(); // Finish FlashActivity so the user cannot go back to it
            }
        }, SPLASH_TIME_OUT);
    }
}