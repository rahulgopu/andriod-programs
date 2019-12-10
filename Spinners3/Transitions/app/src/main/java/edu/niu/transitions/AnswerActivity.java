/***********************************************************************************************
 CSCI 522 - Portfolio 8 - Semester (Spring) Year - 2019

 Programmer(s): Rahul Reddy Gopu
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple application that will demonstrate the use of animated transitions.

 ***********************************************************************************************/
package edu.niu.transitions;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
    }//end onCreate

    public void getQuestion(View view)
    {
        finish();
        overridePendingTransition(R.anim.question_on, R.anim.answer_off);
    }//end getQuestion

}//end AnswerActivity
