package com.example.csaper6.jsongamehearthstone;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;
import android.widget.TextView;

/**
 * Created by csaper6 on 12/15/16.
 */

public class SplashActivity extends AppCompatActivity {
    private ProgressBar progressBarStartup;

    private TextView countdownTimer;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        progressBarStartup = (ProgressBar) findViewById(R.id.progressBar_startup);
        progressBarStartup.setMax(100);
        countdownTimer = (TextView) findViewById(R.id.text_timer);

        new CountDownTimer(1000, 10) {

            public void onTick(long millisUntilFinished) {
                countdownTimer.setText("Loading: " + (100-(millisUntilFinished / 10)+1));
                progressBarStartup.setProgress(100-(int)millisUntilFinished/10);
            }

            public void onFinish() {

                launch();
                finish();
            }
        }.start();
    }



    private void launch() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
