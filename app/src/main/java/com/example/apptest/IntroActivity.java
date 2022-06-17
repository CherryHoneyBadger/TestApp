package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

//모바일 접속 시 첫 화면 인트로
public class IntroActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

    final Intent i = new Intent(this, QRscanActivity.class);
        Thread timer = new Thread() {
            public void run() {
                try {
                    sleep(4000);//3초동안 실행
                } catch (InterruptedException e) {

                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }


}