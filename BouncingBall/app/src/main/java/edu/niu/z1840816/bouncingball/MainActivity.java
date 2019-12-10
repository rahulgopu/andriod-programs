package edu.niu.z1840816.bouncingball;

/*****************************************************************************************
 CSCI 522 - Portfolio 13 - Semester (Spring) Year - 2019

 Programmer(s): Saran Kumar Reddy Padala
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple application that will simulate a ball bouncing around
          the screen at a constant velocity

 ***************************************************************************************/

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends Activity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a frame layout and connect it to the screen
        FrameLayout layout = findViewById(R.id.frameLayout);

        //Create bounce surface view
        BounceSurfaceView bounceSurfaceView = new BounceSurfaceView( this, null);

        //Add the surface view to the frame layout
        layout.addView( bounceSurfaceView );
    }//end onCreate
}//end MainActivity
