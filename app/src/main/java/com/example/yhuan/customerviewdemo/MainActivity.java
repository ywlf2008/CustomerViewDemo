package com.example.yhuan.customerviewdemo;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.color_view)
    ColorTrackView colorView;
    @Bind(R.id.btn_left)
    Button btnLeft;
    @Bind(R.id.btn_right)
    Button btnRight;
    @Bind(R.id.btn_up)
    Button btnUp;
    @Bind(R.id.btn_down)
    Button btnDown;
    @Bind(R.id.btn_side)
    Button btnSide;
    @Bind(R.id.btn_center)
    Button btnCenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        colorView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TabActivity.class));
            }
        });
    }

    @OnClick({R.id.btn_left, R.id.btn_right, R.id.btn_up, R.id.btn_down, R.id.btn_side, R.id.btn_center})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_left:
                colorView.setDirection(0);
                ObjectAnimator.ofFloat(colorView, "progress", 0, 1).setDuration(2000)
                        .start();
                break;
            case R.id.btn_right:
                colorView.setDirection(1);
                ObjectAnimator.ofFloat(colorView, "progress", 0, 1).setDuration(2000)
                        .start();
                break;
            case R.id.btn_up:
                colorView.setDirection(2);
                ObjectAnimator.ofFloat(colorView, "progress", 0, 1).setDuration(2000)
                        .start();
                break;
            case R.id.btn_down:
                colorView.setDirection(3);
                ObjectAnimator.ofFloat(colorView, "progress", 0, 1).setDuration(2000)
                        .start();
                break;
            case R.id.btn_side:
                colorView.setDirection(4);
                ObjectAnimator.ofFloat(colorView, "progress", 0, 1).setDuration(2000)
                        .start();
                break;
            case R.id.btn_center:
                colorView.setDirection(5);
                ObjectAnimator.ofFloat(colorView, "progress", 0, 1).setDuration(2000)
                        .start();
                break;
        }
    }


}
