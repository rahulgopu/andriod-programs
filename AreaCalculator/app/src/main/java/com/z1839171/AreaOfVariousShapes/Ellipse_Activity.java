package com.z1839171.AreaOfVariousShapes;

/********************************************************************
 CSCI 522 - MID TERM - Semester (Spring) Year - 2019

 Programmer(s): RAHUL REDDY GOPU
 Section: 1
 TA: Harshith Desamsetti
 Date Due: 03/25/2019

 Purpose: An application to calculate the area of various Shapes

 *********************************************************************/

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Ellipse_Activity extends Activity {

    private TextView ellipseTitle, MajorTV, MinorTV;
    private EditText MajorAxis;
    private EditText MinorAxis;
    private double major,minor;
    private static final double piValue = 3.141;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ellipse);

        //connect the variable to the objects on the screen
        ellipseTitle = findViewById(R.id.ellipseTitleTextView);
        MajorTV = findViewById(R.id.majorTextView);
        MinorTV = findViewById(R.id.minorTextView);
        MajorAxis = findViewById(R.id.MajorEditText);
        MinorAxis = findViewById(R.id.MinorEditText);

        ellipseTitle.setText(getResources().getString(R.string.EllipseTitle));
        MajorTV.setText(getResources().getString(R.string.Major));
        MinorTV.setText(getResources().getString(R.string.Minor));

    }// end onCreate

    public void calculateEllipseArea(View view){
        if (MajorAxis.getText().toString().matches("") || MinorAxis.getText().toString().matches(""))
        {
            Toast.makeText(view.getContext(), "Please Enter Values ", Toast.LENGTH_LONG).show();
        }
        else if (MajorAxis.getText().toString().matches("0") || MinorAxis.getText().toString().matches("0"))
        {
            Toast.makeText(view.getContext(), "Dimensions cannot be zero", Toast.LENGTH_LONG).show();
        }
        else {

            major = Double.parseDouble(MajorAxis.getText().toString());
            minor = Double.parseDouble(MinorAxis.getText().toString());

            double ellipseArea = piValue * major * minor;

            DecimalFormat df = new DecimalFormat("#0.000");

            Intent newIntent;
            newIntent = getIntent();

            String areaOfEllipse = " " + df.format(ellipseArea);

            newIntent.putExtra("Area is", areaOfEllipse);

            //Set a Good Result
            ((Activity) view.getContext()).setResult(RESULT_OK, newIntent);
            finish();
            }

        }

    }
