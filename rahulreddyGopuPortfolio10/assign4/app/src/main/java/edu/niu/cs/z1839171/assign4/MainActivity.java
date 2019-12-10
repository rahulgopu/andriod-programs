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
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    private Button chalengerBtn, astonBtn, lamboBtn, ferariBtn, ageraBtn, shelbyBtn;

    private MediaPlayer chalengerMP, astonMP, lamboMP, ferariMP, ageraMP, shelbyMP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect the Buttons on the screen
        chalengerBtn = findViewById(R.id.chalengerButton);
        astonBtn = findViewById(R.id.astonButton);
        lamboBtn = findViewById(R.id.lamboButton);
        ferariBtn = findViewById(R.id.ferariButton);
        ageraBtn = findViewById(R.id.ageraButton);
        shelbyBtn = findViewById(R.id.shelbyButton);

        //Create the MediaPlayer for the challenger MP3 and connect the audio
        chalengerMP = new MediaPlayer();
        chalengerMP = MediaPlayer.create(this, R.raw.challenger);

        //Create the MediaPlayer for the aston MP3 and connect the audio
        astonMP = new MediaPlayer();
        astonMP = MediaPlayer.create(this, R.raw.aston);

        //Create the MediaPlayer for the lambo MP3 and connect the audio
        lamboMP = new MediaPlayer();
        lamboMP = MediaPlayer.create(this, R.raw.lamborghini);

        //Create the MediaPlayer for the ferari MP3 and connect the audio
        ferariMP = new MediaPlayer();
        ferariMP = MediaPlayer.create(this, R.raw.ferrari);

        //Create the MediaPlayer for the agera MP3 and connect the audio
        ageraMP = new MediaPlayer();
        ageraMP = MediaPlayer.create(this, R.raw.agera);

        //Create the MediaPlayer for the shelby MP3 and connect the audio
        shelbyMP = new MediaPlayer();
        shelbyMP = MediaPlayer.create(this, R.raw.shelby);
    }//end onCreate

    /**********    PLAY THE CHALLENGER mp3     *******************/
    public void playChallenger(View view)
    {
        //if the challenger MP3 is currently playing
        if(chalengerMP.isPlaying())
        {
            //pause the media player for the challenger
            chalengerMP.pause();
        }

        else //challenger MP3 is not playing
        {
            //if the aston MP3 is currently playing
            if(astonMP.isPlaying())
            {
                //pause the media player for the aston
                astonMP.pause();
            }
            //if the lambo MP3 is currently playing
            else if(lamboMP.isPlaying())
            {
                //pause the media player for the lambo
                lamboMP.pause();
            }
            //if the ferrari MP3 is currently playing
            else if(ferariMP.isPlaying())
            {
                //pause the media player for the ferrari
                ferariMP.pause();
            }
            //if the agera MP3 is currently playing
            else if(ageraMP.isPlaying())
            {
                //pause the media player for the agera
                ageraMP.pause();
            }
            //if the shelby MP3 is currently playing
            else if(shelbyMP.isPlaying())
            {
                //pause the media player for the shelby
                shelbyMP.pause();
            }

            //play the challenger MP3
            chalengerMP.start();

        }
    }//end playChallenger

    /**********    PLAY THE ASTON MARTIN mp3     *******************/
    public void playAston(View view)
    {
        //if the aston MP3 is currently playing
        if(astonMP.isPlaying())
        {
            //pause the media player for the aston
            astonMP.pause();
        }

        else //aston MP3 is not playing
        {
            //if the challenger MP3 is currently playing
            if(chalengerMP.isPlaying())
            {
                //pause the media player for the aston
                chalengerMP.pause();
            }
            //if the lambo MP3 is currently playing
            else if(lamboMP.isPlaying())
            {
                //pause the media player for the lambo
                lamboMP.pause();
            }
            //if the ferrari MP3 is currently playing
            else if(ferariMP.isPlaying())
            {
                //pause the media player for the ferrari
                ferariMP.pause();
            }
            //if the agera MP3 is currently playing
            else if(ageraMP.isPlaying())
            {
                //pause the media player for the agera
                ageraMP.pause();
            }
            //if the shelby MP3 is currently playing
            else if(shelbyMP.isPlaying())
            {
                //pause the media player for the shelby
                shelbyMP.pause();
            }

            //play the aston MP3
            astonMP.start();
        }
    }//end playAston

    /**********    PLAY THE LAMBORGHINI mp3     *******************/
    public void playLambo(View view)
    {
        //if the lambo MP3 is currently playing
        if(lamboMP.isPlaying())
        {
            //pause the media player for the lambo
            lamboMP.pause();
        }

        else //lambo MP3 is not playing
        {
            //if the challenger MP3 is currently playing
            if(chalengerMP.isPlaying())
            {
                //pause the media player for the aston
                chalengerMP.pause();
            }
            //if the aston MP3 is currently playing
            else if(astonMP.isPlaying())
            {
                //pause the media player for the aston
                astonMP.pause();
            }
            //if the ferrari MP3 is currently playing
            else if(ferariMP.isPlaying())
            {
                //pause the media player for the ferrari
                ferariMP.pause();
            }
            //if the agera MP3 is currently playing
            else if(ageraMP.isPlaying())
            {
                //pause the media player for the agera
                ageraMP.pause();
            }
            //if the shelby MP3 is currently playing
            else if(shelbyMP.isPlaying())
            {
                //pause the media player for the shelby
                shelbyMP.pause();
            }

            //play the lambo MP3
            lamboMP.start();
        }
    }//end playLambo

    /**********    PLAY THE FERRARI mp3     *******************/
    public void playFerrari(View view)
    {
        //if the ferrari MP3 is currently playing
        if(ferariMP.isPlaying())
        {
            //pause the media player for the ferrari
            ferariMP.pause();
        }

        else //ferrari MP3 is not playing
        {
            //if the challenger MP3 is currently playing
            if(chalengerMP.isPlaying())
            {
                //pause the media player for the aston
                chalengerMP.pause();
            }
            //if the aston MP3 is currently playing
            else if(astonMP.isPlaying())
            {
                //pause the media player for the aston
                astonMP.pause();
            }
            //if the lambo MP3 is currently playing
            else if(lamboMP.isPlaying())
            {
                //pause the media player for the lambo
                lamboMP.pause();
            }
            //if the agera MP3 is currently playing
            else if(ageraMP.isPlaying())
            {
                //pause the media player for the agera
                ageraMP.pause();
            }
            //if the shelby MP3 is currently playing
            else if(shelbyMP.isPlaying())
            {
                //pause the media player for the shelby
                shelbyMP.pause();
            }

            //play the ferrari MP3
            ferariMP.start();
        }
    }//end playFerrari

    /**********    PLAY THE KOENIGSEGG mp3     *******************/
    public void playKoenigsegg(View view)
    {
        //if the agera MP3 is currently playing
        if(ageraMP.isPlaying())
        {
            //pause the media player for the agera
            ageraMP.pause();
        }

        else //agera MP3 is not playing
        {
            //if the challenger MP3 is currently playing
            if(chalengerMP.isPlaying())
            {
                //pause the media player for the aston
                chalengerMP.pause();
            }
            //if the aston MP3 is currently playing
            else if(astonMP.isPlaying())
            {
                //pause the media player for the aston
                astonMP.pause();
            }
            //if the lambo MP3 is currently playing
            else if(lamboMP.isPlaying())
            {
                //pause the media player for the lambo
                lamboMP.pause();
            }
            //if the ferrari MP3 is currently playing
            else if(ferariMP.isPlaying())
            {
                //pause the media player for the ferrari
                ferariMP.pause();
            }
            //if the shelby MP3 is currently playing
            else if(shelbyMP.isPlaying())
            {
                //pause the media player for the shelby
                shelbyMP.pause();
            }

            //play the agera MP3
            ageraMP.start();
        }
    }//end playKoenigsegg

    /**********    PLAY THE SHELBY mp3     *******************/
    public void playShelby(View view)
    {
        //if the shelby MP3 is currently playing
        if(shelbyMP.isPlaying())
        {
            //pause the media player for the shelby
            shelbyMP.pause();
        }

        else //shelby MP3 is not playing
        {
            //if the challenger MP3 is currently playing
            if(chalengerMP.isPlaying())
            {
                //pause the media player for the aston
                chalengerMP.pause();
            }
            //if the aston MP3 is currently playing
            else if(astonMP.isPlaying())
            {
                //pause the media player for the aston
                astonMP.pause();
            }
            //if the lambo MP3 is currently playing
            else if(lamboMP.isPlaying())
            {
                //pause the media player for the lambo
                lamboMP.pause();
            }
            //if the ferrari MP3 is currently playing
            else if(ferariMP.isPlaying())
            {
                //pause the media player for the ferrari
                ferariMP.pause();
            }
            //if the agera MP3 is currently playing
            else if(ageraMP.isPlaying())
            {
                //pause the media player for the agera
                ageraMP.pause();
            }

            //play the shelby MP3
            shelbyMP.start();
        }
    }//end playShelby
}//end MainActivity
