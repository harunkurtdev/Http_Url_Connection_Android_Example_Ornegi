package com.example.lab08.runnablehandlertimer;

import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;

import java.util.Calendar;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private Timer timer;
    private TimerTask timerTask;
    private Handler timerHandler = new Handler();
    int id=0;

    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        relativeLayout = findViewById(R.id.relative);

        final String color[] = {
                "#ce93d8",
                "#3949ab",
                "#ff80ab",
                "#ff5252",
                "#0043ca",
                "#ff844c",
                "#616161"

        };


        timer = new Timer();
        timerTask= new TimerTask() {
            public void run() {
                timerHandler.post(new Runnable() {
                    public void run(){
                        //Random random = new Random();
                        //relativeLayout.setBackgroundColor(Color.parseColor(color[random.nextInt(color.length)]));
                    }
                });
            }
        };
        // BELİRLİ PERİYOTLARDA BİR İŞİ TEKRARLAMAK
        timer.scheduleAtFixedRate(timerTask, 0, (1*1 * 1000));


        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Log.d("LOG","Bu bir logdur ->"+ Calendar.getInstance().getTime());
            }
        },0, 1000); // 1000 milisaniye  = 1 saniye




    }
}
