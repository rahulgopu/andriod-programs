package edu.niu.cs.z1840816.gradecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Calculator241 extends AppCompatActivity {

    Button submitButton;
    EditText quiz1, quiz2, quiz3, quiz4, quiz5, quiz6, quiz7, quiz8, quiz9, quiz10, quiz11, quiz12;
    EditText exam1, exam2, exam3;
    EditText assignment1, assignment2, assignment3, assignment4, assignment5, assignment6, assignment7, assignment8;
    Double finalQuizExamScore = 0.0;
    Double finalAssignmentScore = 0.0;
    Double finalExamScore = 0.0;
    Double finalScore = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator241);

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
                assignment8.getText().toString().matches("")       )
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


            //Need to take top three quizzes

            //Toast.makeText(Calculator.this,"The quizzes score is "+finalQuizScore,Toast.LENGTH_SHORT).show();
            finalQuizExamScore = (quiz1Score + quiz2Score + quiz3Score + quiz4Score + quiz5Score + quiz6Score + quiz7Score + quiz8Score + quiz9Score + quiz10Score + quiz11Score + quiz12Score +
                    exam1Score + exam2Score + exam3Score);
            finalQuizExamScore = finalQuizExamScore * (0.6);

            finalAssignmentScore = (assignment1Score + assignment2Score + assignment3Score + assignment4Score + assignment5Score + assignment6Score + assignment7Score + assignment8Score);

            finalAssignmentScore = finalAssignmentScore * (0.4);

            finalExamScore = finalQuizExamScore + finalAssignmentScore;

            finalScore = (finalExamScore / 276) * 100;

            Toast.makeText(Calculator241.this, "The Total Score is " + finalScore, Toast.LENGTH_SHORT).show();

        }
    }

}
