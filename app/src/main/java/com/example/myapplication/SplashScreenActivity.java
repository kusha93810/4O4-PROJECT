package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen); // Ensure this layout is correct

        // Delay to transition to HomeActivity after 2 seconds
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the HomeActivity
                Intent intent = new Intent(SplashScreenActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();  // Finish the SplashScreenActivity so the user can't return to it
            }
        }, 2000);  // 2000 ms = 2 seconds
    }
}
