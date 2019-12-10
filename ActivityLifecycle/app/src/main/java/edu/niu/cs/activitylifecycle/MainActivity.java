package edu.niu.cs.activitylifecycle;

/********************************************************************
 CSCI 522 - Portfolio 6 - Semester (Spring) Year - 2019

 Programmer(s): Rahul Reddy Gopu
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple application to illustrate the lifecycle of an activity.

 *********************************************************************/

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity
{
    private static final String MA_TAG = "Lifecycle";

    private String createMessage, startMessage, resumeMessage, pauseMessage, stopMessage,
                                                          restartMessage, destroyMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Populate the strings from the strings.xml file
        createMessage = (String)getResources().getText(R.string.createMsg);
        startMessage = (String)getResources().getText(R.string.startMsg);
        resumeMessage = (String)getResources().getText(R.string.resumeMsg);
        pauseMessage = (String)getResources().getText(R.string.pauseMsg);
        stopMessage = (String)getResources().getText(R.string.stopMsg);
        restartMessage = (String)getResources().getText(R.string.restartMsg);
        destroyMessage = (String)getResources().getText(R.string.destroyMsg);

        //Display a toast message and log message
        Toast.makeText(getApplicationContext(), createMessage, Toast.LENGTH_SHORT).show();

        Log.d( MA_TAG, createMessage );
        }//end onCreate

    @Override
    protected void onStart()
    {
        super.onStart();
        //Display a toast message and log message
        Toast.makeText(getApplicationContext(), startMessage, Toast.LENGTH_SHORT).show();

        Log.d( MA_TAG, startMessage );
    }//end onStart

    @Override
    protected void onResume() {
        super.onResume();
        //Display a toast message and log message
        Toast.makeText(getApplicationContext(), resumeMessage, Toast.LENGTH_SHORT).show();

        Log.d( MA_TAG, resumeMessage );
    }//end onResume

    @Override
    protected void onPause() {
        super.onPause();
        //Display a toast message and log message
        Toast.makeText(getApplicationContext(), pauseMessage, Toast.LENGTH_SHORT).show();

        Log.d( MA_TAG, pauseMessage );
    }//end onPause

    @Override
    protected void onStop() {
        super.onStop();
        //Display a toast message and log message
        Toast.makeText(getApplicationContext(), stopMessage, Toast.LENGTH_SHORT).show();

        Log.d( MA_TAG, stopMessage );
    }//end onStop

    @Override
    protected void onRestart() {
        super.onRestart();
        //Display a toast message and log message
        Toast.makeText(getApplicationContext(), restartMessage, Toast.LENGTH_SHORT).show();

        Log.d( MA_TAG, restartMessage );
    }//end onRestart

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Display a toast message and log message
        Toast.makeText(getApplicationContext(), destroyMessage, Toast.LENGTH_SHORT).show();

        Log.d( MA_TAG, destroyMessage );
    }//end onDestroy

    public void doActivity(View view)
    {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivity(intent);
    }//end doActivity

}//end MainActivity
