package com.thougthworks.vozdamulher.activity;


import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;


import com.thougthworks.vozdamulher.R;

import java.io.IOException;


public class MainActivity extends AppCompatActivity {

    // Constants
    private static final String TAG = "MainActivity";    //Views
    private ImageView mMicrophoneImg;
    private ImageButton mPlayBt;    private boolean isPlayingChangedVoice = false;
    private boolean isPlayingNormalVoice = false;    private MediaPlayer mMediaPlayer1;
    private MediaPlayer mMediaPlayer2;
    ImageView imgCheck;
    private MediaPlayer mNormalPlayer;
    private MediaPlayer mChangedPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        imgCheck = (ImageView) findViewById(R.id.img_check);

        imgCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

   //     initViews();

    }

    private void initViews() {
        // MicrophoneImg
        mMicrophoneImg = (ImageView) findViewById(R.id.img_microphone);
        mMicrophoneImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlayingNormalVoice) {
                    mNormalPlayer.pause();
                    mNormalPlayer.release();
                    mNormalPlayer = null;
                    isPlayingNormalVoice = false;
                } else {
                    try {
                        playNormalVoice();
                        isPlayingNormalVoice = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });        // PlayBt
        mPlayBt = (ImageButton) findViewById(R.id.play_bt);
        mPlayBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlayingChangedVoice) {
                    mChangedPlayer.pause();
                    mChangedPlayer.release();
                    mChangedPlayer = null;
                    isPlayingChangedVoice = false;
                } else {
                    try {
                        playChangedVoice();
                        isPlayingChangedVoice = true;
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }    private void playNormalVoice() throws IOException {
        String url =  "http://iagobelo.com.br/projects/voz-da-mulher/denuncia.m4a";
        mNormalPlayer = new MediaPlayer();
        mNormalPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mNormalPlayer.setDataSource(url);
        mNormalPlayer.prepare();
        mNormalPlayer.start();
    }    private void playChangedVoice() throws IOException {
        String url = "http://iagobelo.com.br/projects/voz-da-mulher/denuncia_alterada.m4a";
        mChangedPlayer = new MediaPlayer();
        mChangedPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mChangedPlayer.setDataSource(url);
        mChangedPlayer.prepare();
        mChangedPlayer.start();
    }

    //@Override
//    protected void onDestroy() {
//        super.onDestroy();        mChangedPlayer.release();
//        mNormalPlayer.release();        mNormalPlayer = null;
//        mChangedPlayer = null;
//    }

}


