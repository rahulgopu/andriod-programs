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

public class StoryThree extends AppCompatActivity {

    EditText maleNameET, noun1ET, noun2ET, adjective1ET, adjective2ET, nounPluralET, foodPluralET, verbEdET,liquidET;
    TextView storyTV3;
    Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_three);

        //connect the variable to the objects on the screen
        maleNameET = (EditText)findViewById(R.id.maleName);
        adjective1ET = (EditText)findViewById(R.id.adjective1);
        noun1ET = (EditText)findViewById(R.id.noun1);
        adjective2ET = (EditText)findViewById(R.id.adjective2);
        foodPluralET = (EditText)findViewById(R.id.foodPlural);
        nounPluralET = (EditText)findViewById(R.id.nounPlural);
        verbEdET = (EditText)findViewById(R.id.verb_ending_ED);
        noun2ET = (EditText)findViewById(R.id.noun2);
        liquidET = (EditText)findViewById(R.id.liquid);

        storyTV3 = (TextView)findViewById(R.id.story3Screen);

        submitButton = (Button)findViewById(R.id.story3Button);

        submitButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                if (    maleNameET.getText().toString().matches("") ||
                        adjective1ET.getText().toString().matches("") ||
                        noun1ET.getText().toString().matches("") ||
                        adjective2ET.getText().toString().matches("") ||
                        foodPluralET.getText().toString().matches("") ||
                        nounPluralET.getText().toString().matches("") ||
                        verbEdET.getText().toString().matches("") ||
                        noun2ET.getText().toString().matches("") ||
                        liquidET.getText().toString().matches("")         )
                {
                    //Display a toast message and log message
                    Toast.makeText(view.getContext(), "Cannot Have Empty Fields", Toast.LENGTH_LONG).show();
                }
                else {
                    String maleNameText = maleNameET.getText().toString();
                    String adjective1Text = adjective1ET.getText().toString();
                    String noun1Text = noun1ET.getText().toString();
                    String adjective2Text = adjective2ET.getText().toString();
                    String foodPluralText = foodPluralET.getText().toString();
                    String nounPluralText = nounPluralET.getText().toString();
                    String verbEdText = verbEdET.getText().toString();
                    String noun2Text = noun2ET.getText().toString();
                    String liquidText = liquidET.getText().toString();

                    storyTV3.setText("Come on over to " + maleNameText + "`s Pizza Parlor where you can enjoy you " +
                            "favorite " + adjective1Text + "-dish pizza`s. You can try our famous " + noun1Text +
                            "-lovers pizza, or select from our list of " + adjective2Text + "toppings, including sauteed " +
                            foodPluralText + nounPluralText + "and many more. Our crusts are hand-" + verbEdText +
                            "and basted in " + noun2Text + "to make them" + " seem more " + liquidText + "-made." + "\n\n");
                }
            }
        });
    }//end onCreate
}//end StoryThree
