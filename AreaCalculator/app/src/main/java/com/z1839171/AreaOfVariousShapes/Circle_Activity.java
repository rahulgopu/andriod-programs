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

public class Circle_Activity extends Activity
{

    private TextView circleTitle, radiusTV;
    private EditText RadiusET;
    private Double radius;
    private static final double piValue = 3.141;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle);

        //connect the variable to the objects on the screen
        circleTitle = findViewById(R.id.circleTitleTextView);
        radiusTV = findViewById(R.id.radiusTextView);
        RadiusET = findViewById(R.id.RadiusEditText);

        circleTitle.setText(getResources().getString(R.string.CircleTitle));
        radiusTV.setText(getResources().getString(R.string.Radius));

    }//end onCreate

    public void calculateCircleArea(View view)
    {
            if (RadiusET.getText().toString().matches(""))
            {
                Toast.makeText(view.getContext(), "Please Enter Value ", Toast.LENGTH_LONG).show();
            }
            else if (RadiusET.getText().toString().matches("0"))
            {
                Toast.makeText(view.getContext(), "Radius cannot be zero", Toast.LENGTH_LONG).show();
            }
            else {
                radius = Double.parseDouble(RadiusET.getText().toString());

                double circleArea = piValue * radius * radius;

                DecimalFormat df = new DecimalFormat("#0.000");

                Intent newIntent;
                newIntent = getIntent();

                String areaOfCircle = " " + df.format(circleArea);

                newIntent.putExtra("Area is", areaOfCircle);

                //set a good result
                ((Activity) view.getContext()).setResult(RESULT_OK, newIntent);
                finish();
            }
    }//end calculateCircleArea
}//end MainActivity


