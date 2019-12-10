/********************************************************************
 CSCI 522 - Portfolio 2 - Spring 2019

 Programmer: RAHUL REDDY GOPU
 Section: 1
 TA: HARSHITH DESAMSETTI

 Purpose: This application acts as a shipping calculator. The user will input a weight (in ounces) of a package
 to be shipped. As the weight is being inputted, the various costs for the shipping will be directly computed and
 displayed in various TextView objects.
 
 *********************************************************************/
package edu.niu.z1839171.shipcalculator;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends Activity
{

        //Instance Variables
        ShippingItem item;

        EditText weightET;
        TextView baseTV, addedTV, totalTV;


        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Connect the EditText and TextViews to the objects on the screen
        weightET = findViewById(R.id.weightEditText);

        baseTV = findViewById(R.id.baseCostTextView);
        addedTV = findViewById(R.id.addedCostTextView);
        totalTV = findViewById(R.id.totalCostTextView);

        //Create the shipping item
        item = new ShippingItem();

        //put the focus on the edit text
        weightET.requestFocus();

        //add the TextWatcher to the EditText field
        weightET.addTextChangedListener( weightWatcher );

    }//end onCreate

        TextWatcher weightWatcher = new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                try
                {
                    item.setWeight( Integer.parseInt( s.toString() ) );
                }
                catch (NumberFormatException nfe)
                {
                    item.setWeight(0);
                }

                DecimalFormat df = new DecimalFormat( "#0.00" );

                //put the costs in the TextViews
                baseTV.setText("$" + df.format(item.getBaseCost()));
                addedTV.setText("$" + df.format(item.getAddedCost()));
                totalTV.setText("$" + df.format(item.getTotalCost()));
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        };

    }//end Main Activity