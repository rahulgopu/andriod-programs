package edu.niu.z1840816.threadcounter;

/*****************************************************************************************
 CSCI 522 - Portfolio 12 - Semester (Spring) Year - 2019

 Programmer(s): Saran Kumar Reddy Padala
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple application that will use a thread to update and display a
            counter every second.

 ***************************************************************************************/

import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView countTV;
    private Integer counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect the TextView to the screen
        countTV =findViewById(R.id.countTextView);

        //Initialise the counter to zero
        counter = 0;

        //Create the thread and pass a runnable
        Thread thread = new Thread(countNumbers);

        //Start the execution of the thread
        thread.start();

    }//end onCreate

    protected void onStart() {

        super.onStart();

        //reset the counter to zero
        counter = 0;
    }//end onStart

    private Runnable countNumbers = new Runnable() {

        private static final int DELAY = 1000;

        @Override
        public void run() {

            while(true)
            {
                //Increment the counter by 1
                counter++;

                try
                {
                    Thread.sleep(DELAY);
                }
                catch(InterruptedException e)
                {
                    e.printStackTrace();
                }

                //Update the UI thread by sending an empty message
                threadHandler.sendEmptyMessage(0);
            }//end while

        }//end run method
    };//end of countNumbers runnable
    
    public Handler threadHandler = new Handler()
    {
        //Code the handle message, so the UI thread knows what to do
        public void handleMessage(Message message)
        {
            countTV.setText(counter.toString());
        }
    };
}//end MainActivity
