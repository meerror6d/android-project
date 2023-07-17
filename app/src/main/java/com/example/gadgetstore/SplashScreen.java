package com.example.gadgetstore;

import static com.example.gadgetstore.R.layout.activity_splashscreen;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for vanishing status bar
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(activity_splashscreen);

        new Handler().postDelayed(() -> {
            //kotokkhon splashscreen thakbe....
            startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
            finish();
        },1500);
    }
}