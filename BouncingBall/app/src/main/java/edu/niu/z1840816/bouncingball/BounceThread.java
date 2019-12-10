package edu.niu.z1840816.bouncingball;

/*****************************************************************************************
 CSCI 522 - Portfolio 13 - Semester (Spring) Year - 2019

 Programmer(s): Saran Kumar Reddy Padala
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple application that will simulate a ball bouncing around
 the screen at a constant velocity

 ***************************************************************************************/

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class BounceThread extends Thread
{
    private SurfaceHolder surfaceHolder;

    private AnimationArena animationArena;

    private boolean isRunning;

    public BounceThread(SurfaceHolder sh)
    {
        surfaceHolder = sh;

        //Initialise boolean variable to indicate application is running
        isRunning = true;

        //Create the animation arena
        animationArena = new AnimationArena();
    }//end Constructor

    public void run()
    {
        try
        {
            while (isRunning)
            {
                //Create a canvas and lock it so that nothing else can make a change to it
                Canvas canvas = surfaceHolder.lockCanvas();

                //Update the ball location
                animationArena.update(canvas.getWidth(),canvas.getHeight());
                animationArena.draw(canvas);

                //Unlock the canvas so that it can be updated
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
        catch (NullPointerException npe)
        {
            npe.printStackTrace();
        }
    }//end run method

    public void endBounce()
    {
        isRunning = false;
    }
}//end BounceThread
