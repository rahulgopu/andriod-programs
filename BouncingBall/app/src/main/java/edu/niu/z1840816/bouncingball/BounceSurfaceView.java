package edu.niu.z1840816.bouncingball;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/*****************************************************************************************
 CSCI 522 - Portfolio 13 - Semester (Spring) Year - 2019

 Programmer(s): Saran Kumar Reddy Padala
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple application that will simulate a ball bouncing around
 the screen at a constant velocity

 ***************************************************************************************/

public class BounceSurfaceView extends SurfaceView
                                implements SurfaceHolder.Callback
{
    private BounceThread bounceThread;

    public BounceSurfaceView(Context context, AttributeSet attributeSet)
    {
        super(context, attributeSet);

        //Create a surfaceHolder
        SurfaceHolder holder = getHolder();

        //Attach the callback method to the surface holder
        holder.addCallback(this);

        //Attach the surface holder to the bounceThread
        bounceThread = new BounceThread(holder);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder)
    {
        //start thread execution
        bounceThread.start();
    }//end surfaceCreated

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
    {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder)
    {
        //Stop execution of the tread by ending the animation
        bounceThread.endBounce();

        //nullify the thread
        Thread dummyThread = bounceThread;
        bounceThread = null;
        dummyThread.interrupt();
    }//end surfaceDestroyed
}
