package edu.niu.cs.z1839171.assign4;

/**********************************************************************************************************
 CSCI 522 - Assignment 4 - Semester (Spring) Year - 2019

 Instructor Name : Amy Byrnes

 TA: Harshith Desamsetti

 Assignment Team Members : 1) Rahul Reddy Gopu (Z1839171)
                           2) Saran Kumar Reddy Padala (Z1840816)

 Purpose: The application should start with a splash screen that lets the user know the
          topic of the application. The application should have (at least) 6 images that function as buttons.
          When the user clicks on one of the images, a sound that is related to the image should be played.

 Assignment Due Date : Monday, April 15 on Blackboard by 11:59 PM

 *************************************************************************************************************/

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
        timer.schedule(task, 3000);

    }//end onCreate
}//end SplashActivity

