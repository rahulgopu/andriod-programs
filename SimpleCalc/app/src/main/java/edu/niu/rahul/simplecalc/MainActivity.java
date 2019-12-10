/***************************************************************************
 * Instructor Name : Amy Byrnes
 *
 * PORTFOLIO : 1 (SIMPLE CALCULATOR)
 *
 * Assignment Team Members : 1) Rahul Reddy Gopu (Z1839171)
 *                           2) Saran Kumar Reddy Padala (Z1840816)
 *
 * Assignment Due Date : Wednesday, February 13 on Blackboard by 11:59 PM
 ***************************************************************************/
package edu.niu.rahul.simplecalc;

import android.app.Activity;
import android.os.Bundle;
/*import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;*/
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity
{
    //Instance Variables
    private EditText num1ET, num2ET;
    private TextView answerTV;

    private Button addBtn, subBtn, multiplyBtn, divisionBtn, clearBtn;

    private Integer num1, num2, addResult, subResult, multiplyResult, divisionResult;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //connect the instance variables with the objects on the screen
        num1ET = findViewById(R.id.editText1);
        num2ET = findViewById(R.id.editText2) ;

        answerTV = findViewById(R.id.answerEditView);

        addBtn = findViewById(R.id.addButton);
        subBtn = findViewById(R.id.subtractbutton);
        multiplyBtn = findViewById(R.id.multiplicationbutton);
        divisionBtn = findViewById(R.id.divisionbutton);

        clearBtn = findViewById(R.id.clearButton);

        //handle the addition button being clicked
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Check for empty fields
                if(num1ET.getText().toString().matches("") ||
                        num2ET.getText().toString().matches("") )
                {
                    //display an error message and exit the onClick method
                    Toast.makeText(v.getContext(), "cannot have an empty field", Toast.LENGTH_LONG ).show();
                    return;
                }
                //Get the numbers that the user entered
                num1 = Integer.parseInt( num1ET.getText().toString() );
                num2 = Integer.parseInt( num2ET.getText().toString() );

                //Calculate the sum
                addResult = num1 + num2;
                //subResult = num1 - num2;


                //Put the sum on the screen
                answerTV.setText(addResult.toString());
                //answerTV.setText(subResult.toString());

            }//end Onclick
        });

        //handle the subtraction button being clicked
        subBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Check for empty fields
                if(num1ET.getText().toString().matches("") ||
                        num2ET.getText().toString().matches("") )
                {
                    //display an error message and exit the onClick method
                    Toast.makeText(v.getContext(), "cannot have an empty field", Toast.LENGTH_LONG ).show();
                    return;
                }
                //Get the numbers that the user entered
                num1 = Integer.parseInt( num1ET.getText().toString() );
                num2 = Integer.parseInt( num2ET.getText().toString() );

                //Calculate the sum
                subResult = num1 - num2;


                //Put the sum on the screen
                answerTV.setText(subResult.toString());

            }//end Onclick
        });

        //handle the multiplication button being clicked
        multiplyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Check for empty fields
                if(num1ET.getText().toString().matches("") ||
                        num2ET.getText().toString().matches("") )
                {
                    //display an error message and exit the onClick method
                    Toast.makeText(v.getContext(), "cannot have an empty field", Toast.LENGTH_LONG ).show();
                    return;
                }
                //Get the numbers that the user entered
                num1 = Integer.parseInt( num1ET.getText().toString() );
                num2 = Integer.parseInt( num2ET.getText().toString() );

                //Calculate the sum
                multiplyResult = num1 * num2;


                //Put the sum on the screen
                answerTV.setText(multiplyResult.toString());

            }//end Onclick
        });

        //handle the division button being clicked
        divisionBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //Check for empty fields
                if(num1ET.getText().toString().matches("") ||
                        num2ET.getText().toString().matches("") )
                {
                    //display an error message and exit the onClick method
                    Toast.makeText(v.getContext(), "cannot have an empty field", Toast.LENGTH_LONG ).show();
                    return;
                }
                //Get the numbers that the user entered
                num1 = Integer.parseInt( num1ET.getText().toString() );
                num2 = Integer.parseInt( num2ET.getText().toString() );

                //Calculate the sum
                divisionResult = num1 / num2;


                //Put the sum on the screen
                answerTV.setText(divisionResult.toString());

            }//end Onclick
        });

        clearBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                num1ET.setText("");
                num2ET.setText("");
                answerTV.setText("");
            }//end onClick

        });

    }
}

        /*Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}*/
