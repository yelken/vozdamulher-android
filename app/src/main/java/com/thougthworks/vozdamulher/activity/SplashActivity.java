package com.thougthworks.vozdamulher.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.thougthworks.vozdamulher.R;

public class SplashActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().hide();

        Handler handler = new Handler();
        handler.postDelayed(this, 2500);

    }

    @Override
    public void run() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

}
