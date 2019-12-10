package edu.niu.cs.activitylifecycle;

/********************************************************************
 CSCI 522 - Portfolio 6 - Semester (Spring) Year - 2019

 Programmer(s): Rahul Reddy Gopu
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple application to illustrate the lifecycle of an activity.

 *********************************************************************/

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends Activity
{
    private static final String SA_TAG = "2nd Activity Lifecycle";

    private String createMessage, startMessage, resumeMessage, pauseMessage, stopMessage,
            restartMessage, destroyMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        //Populate the strings
        createMessage = (String) getResources().getText(R.string.createMsg2);
        startMessage = (String) getResources().getText(R.string.startMsg2);
        resumeMessage = (String) getResources().getText(R.string.resumeMsg2);
        pauseMessage = (String) getResources().getText(R.string.pauseMsg2);
        restartMessage = (String) getResources().getText(R.string.restartMsg2);
        stopMessage = (String) getResources().getText(R.string.stopMsg2);
        destroyMessage = (String) getResources().getText(R.string.destroyMsg2);

        //Display a Log Message
        Log.d(SA_TAG, createMessage);
    }//end onCreate

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.d( SA_TAG, startMessage );
    }//end onStart

    @Override
    protected void onResume() {
        super.onResume();
        Log.d( SA_TAG, resumeMessage );
    }//end onResume

    @Override
    protected void onPause() {
        super.onPause();
        Log.d( SA_TAG, pauseMessage );
    }//end onPause

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d( SA_TAG, restartMessage );
    }//end onRestart

    @Override
    protected void onStop() {
        super.onStop();
        Log.d( SA_TAG, stopMessage );
    }//end onStop

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d( SA_TAG, destroyMessage );
    }//end onDestroy

    public void goBack(View view)
    {
        finish();
    }//end goBack


}
