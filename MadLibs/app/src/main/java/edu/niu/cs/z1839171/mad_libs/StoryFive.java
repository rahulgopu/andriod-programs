package edu.niu.cs.z1839171.mad_libs;

/********************************************************************************************/
//      NAME : RAHUL REDDY GOPU
//      Z-ID : Z1839171
//   SECTION : 1
// Professor : AMY BYRNES
//        TA : Harshith Desamsetti

/**********************  G R A D U A T E - P R O J E C T  **********************************/
/*
 * DESCRIPTION : This is a Mad Libs application that will ask the user to enter various
 *               types of words (noun, verb, adverb, part of the body, etc...) and then
 *               use the values entered by the user to fill in a story with missing parts.
 *               The key to Mad Libs (and what makes it fun) is that the user only knows the
 *               title of the story when they're entering the words. For each word, the user
 *               will be able to enter their own word. list.
 *
 ********************************************************************************************/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class StoryFive extends AppCompatActivity {

    EditText sillyWordET, animalET, musicalInstrumentET, noun1ET, adjectiveET, noun2ET;

    TextView storyTV5;

    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_five);

        //connect the variable to the objects on the screen
        sillyWordET = (EditText)findViewById(R.id.sillyWord);
        animalET = (EditText)findViewById(R.id.animal);
        musicalInstrumentET = (EditText)findViewById(R.id.musicalInstrument);
        noun1ET = (EditText)findViewById(R.id.noun1);
        adjectiveET = (EditText)findViewById(R.id.adjective);
        noun2ET = (EditText)findViewById(R.id.noun2);

        storyTV5 = (TextView)findViewById(R.id.story5Screen);

        submitButton = (Button)findViewById(R.id.story5Button);

        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if (    sillyWordET.getText().toString().matches("") ||
                        animalET.getText().toString().matches("") ||
                        musicalInstrumentET.getText().toString().matches("") ||
                        noun1ET.getText().toString().matches("") ||
                        adjectiveET.getText().toString().matches("") ||
                        noun2ET.getText().toString().matches("")    )
                {
                    //Display a toast message and log message
                    Toast.makeText(view.getContext(), "Cannot Have Empty Fields", Toast.LENGTH_LONG).show();
                }
                else {
                    String sillyWordText = sillyWordET.getText().toString();
                    String animalText = animalET.getText().toString();
                    String musicalInstrumentText = musicalInstrumentET.getText().toString();
                    String noun1Text = noun1ET.getText().toString();
                    String adjectiveText = adjectiveET.getText().toString();
                    String noun2Text = noun2ET.getText().toString();

                    storyTV5.setText("Hey, " + sillyWordText + ", " + sillyWordText + "! \n" +
                                     "The " + animalText + " and the " + musicalInstrumentText + ", \n" +
                                     "The cow jumped over the " + noun1Text + "; \n" +
                                     "The " + adjectiveText + " dog laughed \n" +
                                     "To see such sport, \n" +
                                     "And the " + noun2Text + " ran away with the spoon." + "\n\n");
                }
            }
        });

    }//end onCreate
}//end StoryFive
