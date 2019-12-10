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
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView areaResultTV;

    private RadioGroup type_of_shape;

    static final int REQUEST_CODE = 13;

    int type = 19;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the variable to the objects on the screen
        type_of_shape = findViewById(R.id.shapeRadioGroup);
        areaResultTV =findViewById(R.id.resultTextView);

        //set up the anon. listener for the cheese selection
        type_of_shape.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch(checkedId){
                    case R.id.triangleRadioButton: type=1;
                        break;
                    case R.id.circleRadioButton: type=2;
                        break;
                    case R.id.ellipseRadioButton: type = 3 ;
                        break;

                }
            }
        });
    }//end onCreate

    public void CalculateArea(View view) {

        Intent intent;

        if (type == 1) {
            //create the intent to call Triangle_Activity
            intent = new Intent(MainActivity.this, Triangle_Activity.class);
            //startActivity();
            startActivityForResult(intent,REQUEST_CODE);
        } else if (type == 2) {
            //create the intent to call Circle_Activity
            intent= new Intent(MainActivity.this, Circle_Activity.class);
            //startActivity();
            startActivityForResult(intent, REQUEST_CODE);
        } else if (type == 3) {
            //create the intent to call Ellipse_Activity
            intent = new Intent(MainActivity.this, Ellipse_Activity.class);
            //startActivity();
            startActivityForResult(intent, REQUEST_CODE);
        } else {
            Toast.makeText(view.getContext(), "Choose an option", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onActivityResult(int request, int result, Intent newIntent) {

        String shapeOfArea;

        if(request == REQUEST_CODE && result == RESULT_OK){
            shapeOfArea = newIntent.getStringExtra("Area is");
            areaResultTV.setText("Area Value is : " + shapeOfArea);
        }
    }
}

