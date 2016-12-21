package com.example.yhuan.customerviewdemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class BitmapActivity extends AppCompatActivity {

    @Bind(R.id.imageView)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        Bitmap bitmap = MarkerWithText.drawTextToBitmap(this, R.drawable.daoshi, "-*-道士下山-*-");
        bitmap = MarkerWithText.drawBitmapToBitmap(this, bitmap, R.drawable.ic_menu_places);
        imageView.setImageBitmap(bitmap);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BitmapActivity.this,MusicActivity.class));
            }
        });
    }
}
