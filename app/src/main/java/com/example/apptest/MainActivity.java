package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button qrscan, mediaplayer, webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        qrscan = (Button) findViewById(R.id.qr_scan);
        mediaplayer = (Button) findViewById(R.id.media_player);
        webView = (Button) findViewById(R.id.webView);

        qrscan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, QRscanActivity.class);
                startActivity(i);
            }
        });

        mediaplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MediaActivity.class);
                startActivity(i);
            }
        });

        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, WebViewActivity.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish(); //앱 종료
    }


}