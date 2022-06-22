package com.example.apptest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;

import org.json.JSONException;
import org.json.JSONObject;


public class QRscanActivity extends AppCompatActivity {
    private CodeScanner mCodeScanner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView;
        setContentView(R.layout.activity_qrscan);
        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        textView = findViewById(R.id.tv_textview);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(QRscanActivity.this, result.getText(), Toast.LENGTH_SHORT).show();
                        //QR 코드 데이터 얻음
                        try {
                            //data를 json으로 변환
                            JSONObject obj = new JSONObject(result.getText());
                            textView.setText(obj.getString("userPassword"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                            //Toast.makeText(MainActivity.this, result.getContents(), Toast.LENGTH_LONG).show();
                            textView.setText(result.getText()); //받은 데이터를 TextView에 넣음
                        }
                    }
                });
            }

        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mCodeScanner.startPreview();
    }

    @Override
    protected void onPause() {
        mCodeScanner.releaseResources();
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent i = new Intent(QRscanActivity.this, MainActivity.class);
        startActivity(i);
    }
}