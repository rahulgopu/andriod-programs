/********************************************************************
 CSCI 522 - Assignment 2 - Spring 2019

 Programmer(s): RAHUL REDDY GOPU (Z1839171)
                SARAN KUMAR REDDY PADALA (Z1840816)
 Section: 1
 TA: HARSHITH DESAMSETTI

 Purpose:  This assignment is an Android application that will function as a Quadratic equation calculator

 Assignment Due Date : Wednesday, February 27 on Blackboard by 11:59 PM
 *********************************************************************/
package edu.niu.cs.z1839171;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.preference.EditTextPreference;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends Activity {

    private EditText num1, num2, num3;
    private TextView xValue1TV, xValue2TV;

    private Button calculateBtn, clearBtn;

    private Double aValue, bValue, cValue, discriminant, xValue1, xValue2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //connect the instance variables with the objects on the screen
        num1 = findViewById(R.id.numEditText1);
        num2 = findViewById(R.id.numEditText2);
        num3 = findViewById(R.id.numEditText3);

        xValue1TV = findViewById(R.id.value1TextView);
        xValue2TV = findViewById(R.id.value2TextView);

        calculateBtn = findViewById(R.id.calculateButton);
        clearBtn = findViewById(R.id.clearButton);



        //handle the addition button being clicked
        calculateBtn.setOnClickListener(new View.OnClickListener() {

            DecimalFormat df = new DecimalFormat("#.00");

            @Override
            public void onClick(View v) {

                if(num1.getText().toString().matches("") ||
                        num2.getText().toString().matches("") ||  num3.getText().toString().matches("") )
                {
                    //display an error message and exit the onClick method
                    Toast.makeText(v.getContext(), "Cannot have an Empty Field", Toast.LENGTH_LONG ).show();
                    return;
                }
                else if(num1.getText().toString().startsWith("0"))
                {
                    //display an error message and exit the onClick method
                    Toast.makeText(v.getContext(), "Coefficient 'a' cannot have a Zero Value", Toast.LENGTH_LONG ).show();
                    return;
                }

                //Get the numbers that the user entered
                aValue = Double.parseDouble( num1.getText().toString() );
                bValue = Double.parseDouble( num2.getText().toString() );
                cValue = Double.parseDouble( num3.getText().toString() );

                df.format(aValue);
                df.format(bValue);
                df.format(cValue);

                //Calculate the Discriminate
                discriminant = Math.pow(bValue,2) - 4*aValue*cValue;

                if(discriminant == 0)
                {
                    xValue1 = -bValue / (2*aValue);

                    //Put the value on the screen
                    xValue1TV.setText(df.format(xValue1).toString());
                }
                else if (discriminant < 0)
                {
                    xValue1TV.setText("Imaginary");
                    xValue2TV.setText("Imaginary");
                }
                else if (discriminant > 0)
                {
                    xValue1 = (-bValue + Math.sqrt(discriminant)) / (2*aValue);
                    xValue2 = (-bValue - Math.sqrt(discriminant)) / (2*aValue);

                    //Put the values on the screen
                    xValue1TV.setText(df.format(xValue1).toString());
                    xValue2TV.setText(df.format(xValue2).toString());

                }
            }
        });

        //handle the clear button being clicked
        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1.setText("");
                num2.setText("");
                num3.setText("");

                xValue1TV.setText("");
                xValue2TV.setText("");
            }
        });
    }// end onCreate
}
