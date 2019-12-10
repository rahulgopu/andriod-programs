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

public class AnimationArena
{
    private Ball myBall;

    public AnimationArena()
    {
        //Create the Ball object
        myBall = new Ball();
    }//end AnimationArena

    //Method to update the location of the ball
    public void update(int width, int height){ myBall.move(0,0,width,height); }//end update

    //method to draw
    public void draw(Canvas canvas)
    {
        //set the background color for the canvas
        canvas.drawRGB(156,174,216);

        //draw the ball on the canvas
        myBall.draw(canvas);
    }//end draw
}//end AnimationArena
