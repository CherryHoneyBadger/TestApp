package com.example.apptest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import java.io.IOException;

//동영상 플레이어 엑티비티
public class MediaActivity extends AppCompatActivity {

    private VideoView videoview; //영상 뷰
    private MediaController mediaController; //영상화면 컨트롤러
    private String videoUrl = "http://yuhan7110.cafe24.com/andong/vr2.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);

        videoview = findViewById(R.id.videoView); //비디오 뷰 연결
        mediaController = new MediaController(this);
        mediaController.setAnchorView(videoview);
        Uri uri = Uri.parse(videoUrl);
        videoview.setMediaController(mediaController); //제어 버튼 세팅
        videoview.setVideoURI(uri); //비디오 영상 세팅
        videoview.start();


    }
}