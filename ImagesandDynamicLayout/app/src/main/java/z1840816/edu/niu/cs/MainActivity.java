package z1840816.edu.niu.cs;

/********************************************************************
 CSCI 522 - Portfolio 7 - Semester (Spring) Year - 2019

 Programmer(s): Saran Kumar Reddy Padala
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple application that will function as an image gallery.

 *********************************************************************/

import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private LinearLayout gallery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gallery = findViewById(R.id.characterLayout);

        fillGallery();
    }// end onCreate

    private void fillGallery()
    {
        ImageButton characterIB;

        for (int cnt = 0; cnt < CharacterInfo.description.length; cnt++)
        {
           characterIB = new ImageButton(this);

           //Create a Character Object
            Character character = new Character(CharacterInfo.description[cnt], CharacterInfo.id[cnt]);

            //Put the information fro the customer on the ImageButton
            characterIB.setContentDescription( character.getCharacterDescription());

            characterIB.setImageDrawable(ResourcesCompat.getDrawable(getResources(), character.getCharacterID(), null));

            //Handle the Button click
            characterIB.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    String descrip = (String)v.getContentDescription();

                    Toast.makeText(getApplicationContext(), descrip, Toast.LENGTH_LONG).show();
                }
            });

            //Add the imageButtonto the Linear Layout
            gallery.addView( characterIB );

        }//end for loop

    }//end fillGallery

}
