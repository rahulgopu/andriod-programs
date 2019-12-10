package edu.niu.splashandaudio;

/********************************************************************
 CSCI 522 - Portfolio 10 - Semester (Spring) Year - 2019

 Programmer(s): Rahul Reddy Gopu
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple application that will demonstrate the use of a splash screen and the use of audio. The
 application will play one of two songs that feature different instruments (ukulele and drums) when a button is
 pushed.

 *********************************************************************/

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //Create the TimerTask
        TimerTask task = new TimerTask() {
            @Override
            public void run()
            {
                //Finish the activity
                finish();

                //Go to the MainActivity
                startActivity( new Intent(SplashActivity.this, MainActivity.class) );
            }
        };//end TimerTask

        //Create the Timer object
        Timer timer = new Timer();

        //Create the schedule for the timer
        timer.schedule(task, 5000);

    }//end onCreate
}//end SplashActivity
