package com.example.yhuan.customerviewdemo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MusicActivity extends AppCompatActivity {

    @Bind(R.id.music_icon)
    MusicIcon musicIcon;
    @Bind(R.id.btn_progress)
    Button btnProgress;
    Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        ButterKnife.bind(this);
        mHandler.postDelayed(runnable,100);
    }

    @OnClick(R.id.btn_progress)
    public void onClick() {
        musicIcon.insertProgress();
    }

    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            musicIcon.insertProgress();
            mHandler.postDelayed(runnable,100);
        }
    };
}
