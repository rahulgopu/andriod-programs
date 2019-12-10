package edu.niu.z1839171;

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

public class Triangle_Activity extends Activity {

    private TextView triangleTitle, baseTV, heightTV;
    private EditText BaseET;
    private EditText HeightET;
    private Double base,height;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triangle_);

        //connect the variable to the objects on the screen
        BaseET = findViewById(R.id.BaseEditText);
        HeightET = findViewById(R.id.HeightEditText2);
        triangleTitle = findViewById(R.id.triangleTitleTextView);
        baseTV = findViewById(R.id.baseTextView);
        heightTV = findViewById(R.id.heightTextView);

        triangleTitle.setText(getResources().getString(R.string.TriangleTitle));
        baseTV.setText(getResources().getString(R.string.Base));
        heightTV.setText(getResources().getString(R.string.Height));
    }

    public void calculateTriangleArea(View view){
        if (BaseET.getText().toString().matches("") || HeightET.getText().toString().matches(""))
        {
            Toast.makeText(view.getContext(), "Please Enter Values ", Toast.LENGTH_LONG).show();
        }
        else if (BaseET.getText().toString().matches("0") || HeightET.getText().toString().matches("0"))
        {
            Toast.makeText(view.getContext(), "Dimensions cannot be zero", Toast.LENGTH_LONG).show();
        }
        else {

            base = Double.parseDouble(BaseET.getText().toString());
            height = Double.parseDouble(HeightET.getText().toString());

            double triangleArea = 0.5 * base * height;

            DecimalFormat df = new DecimalFormat("#0.000");

            Intent newIntent;
            newIntent = getIntent();

            String areaOfTriangle = " " + df.format(triangleArea);

            newIntent.putExtra("Area is", areaOfTriangle);

            //Set a Good Result
            ((Activity) view.getContext()).setResult(RESULT_OK, newIntent);
            finish();

        }

    }
}
