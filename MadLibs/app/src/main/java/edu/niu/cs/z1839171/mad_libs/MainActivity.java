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

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button storyOneBtn, storyTwoBtn, storyThreeBtn, storyFourBtn, storyFiveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the variable to the objects on the screen
        storyOneBtn = (Button)findViewById(R.id.storyOneButton);
        storyTwoBtn = (Button)findViewById(R.id.storyTwoButton);
        storyThreeBtn = (Button)findViewById(R.id.storyThreeButton);
        storyFourBtn = (Button)findViewById(R.id.storyFourButton);
        storyFiveBtn = (Button)findViewById(R.id.storyFiveButton);

        storyOneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,StoryOne.class));
            }
        });

        storyTwoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,StoryTwo.class));
            }
        });

        storyThreeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,StoryThree.class));
            }
        });

        storyFourBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,StoryFour.class));
            }
        });

        storyFiveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,StoryFive.class));
            }
        });
    }//end onCreate
}//end MainActivity
