package com.example.timertask;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.example.timertask.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;

    TimerTask timerTask;
    Timer timer;


    SimpleDateFormat simpleDateFormat=new SimpleDateFormat("hh:mm:ss aaa");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControl();
    }

    private void addControl() {
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());
        Random random=new Random();
        timerTask=new TimerTask() {
            @Override
            public void run() {
             runOnUiThread(new Runnable() {
                 @Override
                 public void run() {
                     Calendar calendar=Calendar.getInstance();
                     String value=simpleDateFormat.format(calendar.getTime());
                     mainBinding.txtView.setText(value+"");

                     int alpha=288;
                     int red= random.nextInt(256);
                     int green= random.nextInt(256);
                     int blue= random.nextInt(256);
                     int color= Color.argb(alpha,red,green,blue);

                     mainBinding.txtView2.setBackgroundColor(color);
                 }
             });
            }
        };

        timer=new Timer();
        timer.schedule(timerTask,0,1000);
    }
}