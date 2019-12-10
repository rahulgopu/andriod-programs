package edu.niu.z1840816.bouncingball;

/*****************************************************************************************
 CSCI 522 - Portfolio 13 - Semester (Spring) Year - 2019

 Programmer(s): Saran Kumar Reddy Padala
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple application that will simulate a ball bouncing around
 the screen at a constant velocity

 *****************************************************************************************/

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball
{
    private final int RADIUS = 50,
            REVERSE = -1;

    private int x, y, velX, velY;

    public Ball()
    {
        //starting point for the center of the ball
        x = 100;
        y = 100;

        //initial "speed"  and direction of travel
        velX = 10;
        velY = 10;
    }//end of Ball constructor

    public void move( int leftWall, int topWall, int rightWall, int bottomWall )
    {
        //move the ball
        x += velX;
        y += velY;

        //if the ball has collided with the bottom or the top of the screen, change the direction that
        //the ball is traveling
        if( y > bottomWall - RADIUS )
        {
            y = bottomWall - RADIUS;
            velY *= REVERSE;
        }
        else if( y < topWall + RADIUS )
        {
            y = topWall + RADIUS;
            velY *= REVERSE;
        }


        //if the ball has collided with the right or left side of the screen, change the direction that
        //the ball is traveling
        if( x > rightWall - RADIUS )
        {
            x = rightWall - RADIUS;
            velX *= REVERSE;
        }
        else if( x < leftWall + RADIUS )
        {
            x = leftWall + RADIUS;
            velX *= REVERSE;
        }
    }//end of move

    public void draw( Canvas canvas )
    {
        //the color of the ball
        Paint paint = new Paint();
        paint.setColor(Color.rgb(211,216,156));

        //draw the ball
        canvas.drawCircle(x, y, RADIUS,paint);
    }//end of draw
}//end of Ball class