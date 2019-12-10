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
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity
{
    private Button ukuleleBtn, drumsBtn;

    private MediaPlayer ukuleleMP, drumsMP;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect the Buttons on the screen
        ukuleleBtn = findViewById(R.id.ukuleleButton);
        drumsBtn = findViewById(R.id.drumsButton);

        //Create the MediaPlayer for the ukulele MP3 and connect the audio
        ukuleleMP = new MediaPlayer();
        ukuleleMP = MediaPlayer.create(this, R.raw.ukulele);

        //Create the MediaPlayer for the drums MP3 and connect the audio
        drumsMP = new MediaPlayer();
        drumsMP = MediaPlayer.create(this, R.raw.drums);
    } //end onCreate

    public void playUkulele(View view)
    {
        //if the ukulele MP3 is currently playing
        if(ukuleleMP.isPlaying())
        {
            //pause the media player for the ukulele
            ukuleleMP.pause();

            //change the label on the ukulele button to play
            ukuleleBtn.setText(R.string.playUkuleleText);
        }

        else //ukulele MP3 is not playing
        {
            //if the drums MP3 is currently playing
            if(drumsMP.isPlaying())
            {
                //pause the media player for the drums
                drumsMP.pause();

                //change the label on the drums button to play
                drumsBtn.setText(R.string.playDrumsText);
            }

            //play the ukulele MP3
            ukuleleMP.start();

            //update the ukulele button label to pause
            ukuleleBtn.setText(R.string.pauseUkuleleText);
        }
    }//end playUkulele

    public void playDrums(View view)
    {
        //if the drums MP3 is currently playing
        if(drumsMP.isPlaying())
        {
            //pause the media player for the drums
            drumsMP.pause();

            //change the label on the drums button to play
            drumsBtn.setText(R.string.playUkuleleText);
        }

        else //drums MP3 is not playing
        {
            //if the ukulele MP3 is currently playing
            if(ukuleleMP.isPlaying())
            {
                //pause the media player for the ukulele
                ukuleleMP.pause();

                //change the label on the ukulele button to play
                ukuleleBtn.setText(R.string.playUkuleleText);
            }

            //play the drums MP3
            drumsMP.start();

            //update the drums button label to pause
            drumsBtn.setText(R.string.pauseDrumsText);
        }
    }//end playDrums

}//end MainActivity
