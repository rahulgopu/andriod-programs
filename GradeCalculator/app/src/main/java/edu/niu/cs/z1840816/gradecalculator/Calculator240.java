package edu.niu.cs.z1840816.gradecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class Calculator240 extends AppCompatActivity {

    Button submitButton;
    EditText quiz1, quiz2, quiz3, quiz4, quiz5, quiz6, quiz7, quiz8, quiz9, quiz10, quiz11, quiz12;
    EditText exam1, exam2, exam3;
    EditText assignment1, assignment2, assignment3, assignment4, assignment5, assignment6, assignment7, assignment8, assignment9, assignment10;
    Double finalQuizExamScore = 0.0;
    Double finalAssignmentScore = 0.0;
    Double finalExamScore = 0.0;
    Double finalScore = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator240);

        quiz1 = (EditText) findViewById(R.id.quiz1);
        quiz2 = (EditText) findViewById(R.id.quiz2);
        quiz3 = (EditText) findViewById(R.id.quiz3);
        quiz4 = (EditText) findViewById(R.id.quiz4);
        quiz5 = (EditText) findViewById(R.id.quiz5);
        quiz6 = (EditText) findViewById(R.id.quiz6);
        quiz7 = (EditText) findViewById(R.id.quiz7);
        quiz8 = (EditText) findViewById(R.id.quiz8);
        quiz9 = (EditText) findViewById(R.id.quiz9);
        quiz10 = (EditText) findViewById(R.id.quiz10);
        quiz11 = (EditText) findViewById(R.id.quiz11);
        quiz12 = (EditText) findViewById(R.id.quiz12);
        exam1 = (EditText) findViewById(R.id.exam1);
        exam2 = (EditText) findViewById(R.id.exam2);
        exam3 = (EditText) findViewById(R.id.exam3);
        assignment1 = (EditText) findViewById(R.id.assignment1);
        assignment2 = (EditText) findViewById(R.id.assignment2);
        assignment3 = (EditText) findViewById(R.id.assignment3);
        assignment4 = (EditText) findViewById(R.id.assignment4);
        assignment5 = (EditText) findViewById(R.id.assignment5);
        assignment6 = (EditText) findViewById(R.id.assignment6);
        assignment7 = (EditText) findViewById(R.id.assignment7);
        assignment8 = (EditText) findViewById(R.id.assignment8);
        assignment9 = (EditText) findViewById(R.id.assignment9);
        assignment10 = (EditText) findViewById(R.id.assignment10);
    }

    public void calculate(View view) {

        if(     quiz1.getText().toString().matches("") ||
                quiz2.getText().toString().matches("") ||
                quiz3.getText().toString().matches("") ||
                quiz4.getText().toString().matches("") ||
                quiz5.getText().toString().matches("") ||
                quiz6.getText().toString().matches("") ||
                quiz7.getText().toString().matches("") ||
                quiz8.getText().toString().matches("") ||
                quiz9.getText().toString().matches("") ||
                quiz10.getText().toString().matches("") ||
                quiz11.getText().toString().matches("") ||
                quiz12.getText().toString().matches("") ||
                exam1.getText().toString().matches("") ||
                exam2.getText().toString().matches("") ||
                exam3.getText().toString().matches("") ||
                assignment1.getText().toString().matches("") ||
                assignment2.getText().toString().matches("") ||
                assignment3.getText().toString().matches("") ||
                assignment4.getText().toString().matches("") ||
                assignment5.getText().toString().matches("") ||
                assignment6.getText().toString().matches("") ||
                assignment7.getText().toString().matches("") ||
                assignment8.getText().toString().matches("") ||
                assignment9.getText().toString().matches("") ||
                assignment10.getText().toString().matches("")      )
        {
            //Display an error message and exit the onClick method
            Toast.makeText(view.getContext(), "Cannot have an Empty Field", Toast.LENGTH_LONG ).show();
            return;
        }
        else {

            Double quiz1Score = Double.parseDouble(quiz1.getText().toString());
            Double quiz2Score = Double.parseDouble(quiz2.getText().toString());
            Double quiz3Score = Double.parseDouble(quiz3.getText().toString());
            Double quiz4Score = Double.parseDouble(quiz4.getText().toString());
            Double quiz5Score = Double.parseDouble(quiz5.getText().toString());
            Double quiz6Score = Double.parseDouble(quiz6.getText().toString());
            Double quiz7Score = Double.parseDouble(quiz7.getText().toString());
            Double quiz8Score = Double.parseDouble(quiz8.getText().toString());
            Double quiz9Score = Double.parseDouble(quiz9.getText().toString());
            Double quiz10Score = Double.parseDouble(quiz10.getText().toString());
            Double quiz11Score = Double.parseDouble(quiz11.getText().toString());
            Double quiz12Score = Double.parseDouble(quiz12.getText().toString());

            Double exam1Score = Double.parseDouble(exam1.getText().toString());
            Double exam2Score = Double.parseDouble(exam2.getText().toString());
            Double exam3Score = Double.parseDouble(exam3.getText().toString());

            Double assignment1Score = Double.parseDouble(assignment1.getText().toString());
            Double assignment2Score = Double.parseDouble(assignment2.getText().toString());
            Double assignment3Score = Double.parseDouble(assignment3.getText().toString());
            Double assignment4Score = Double.parseDouble(assignment4.getText().toString());
            Double assignment5Score = Double.parseDouble(assignment5.getText().toString());
            Double assignment6Score = Double.parseDouble(assignment6.getText().toString());
            Double assignment7Score = Double.parseDouble(assignment7.getText().toString());
            Double assignment8Score = Double.parseDouble(assignment8.getText().toString());
            Double assignment9Score = Double.parseDouble(assignment9.getText().toString());
            Double assignment10Score = Double.parseDouble(assignment10.getText().toString());

            ArrayList<Double> arrList = new ArrayList<Double>();

            arrList.add(quiz1Score); arrList.add(quiz2Score); arrList.add(quiz3Score);
            arrList.add(quiz4Score); arrList.add(quiz5Score); arrList.add(quiz6Score);
            arrList.add(quiz7Score); arrList.add(quiz8Score); arrList.add(quiz7Score);
            arrList.add(quiz10Score); arrList.add(quiz11Score); arrList.add(quiz12Score);

            Collections.sort(arrList);

            arrList.remove(0);
            arrList.remove(0);

            Double quizSum = 0.0;

            for(int i = 0; i < arrList.size(); i++)
            {
               quizSum += arrList.get(i);
            }

            //Toast.makeText(Calculator.this,"The quizzes score is "+finalQuizScore,Toast.LENGTH_SHORT).show();
            finalQuizExamScore = (quizSum + exam1Score + exam2Score + exam3Score);
            finalQuizExamScore = ( ( finalQuizExamScore / 400 ) * (0.7) );

            finalAssignmentScore = (assignment1Score + assignment2Score + assignment3Score + assignment4Score + assignment5Score
                                    + assignment6Score + assignment7Score + assignment8Score + assignment9Score + assignment10Score);

            finalAssignmentScore = ( (finalAssignmentScore / 1000) * (0.3) );

            finalExamScore = ( ( finalQuizExamScore + finalAssignmentScore ) * 100 );

            if( finalExamScore >= 90 & finalExamScore <= 100 )
            {
                Toast.makeText(Calculator240.this, "Your Final Grade is 'A'.",Toast.LENGTH_SHORT).show();
            }
            //Toast.makeText(Calculator240.this, "The Total Score is " + finalExamScore, Toast.LENGTH_SHORT).show();

        }
    }

}
