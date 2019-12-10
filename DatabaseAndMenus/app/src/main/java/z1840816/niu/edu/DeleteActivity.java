package z1840816.niu.edu;

/**************************************************************************************************
 CSCI 522 - Portfolio 14 - Semester (Spring) Year - 2019

 Programmer(s): Saran Kumar Reddy Padala
 Section: 1
 TA: Harshith Desamsetti

 Purpose: To design a simple database application that will act as a store of some type of product.
 The store will have the ability to add, delete, and update products.
 The application will also demonstrate the use of menus

 **************************************************************************************************/

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.util.ArrayList;

public class DeleteActivity extends AppCompatActivity
{
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        databaseManager = new DatabaseManager(this);
        updateView();
    }//end onCreate

    public void updateView()
    {
        ArrayList<Candy> candies = databaseManager.selectAll();

        //Create the layout
        RelativeLayout layout = new RelativeLayout(this);
        ScrollView scrollView = new ScrollView(this);
        RadioGroup radioGrooup = new RadioGroup(this);

        //Loop to process each candy in the arraylist
        for (Candy candy : candies)
        {
            //Create the radio button to be placed into the radio group
            RadioButton radioButton = new RadioButton(this);

            //Put info into the radio button
            radioButton.setId(candy.getId());
            radioButton.setText(candy.candyToString());

            //add the radio button to the radio group
            radioGrooup.addView(radioButton);
        }//end for loop

        //Setup the handler for the radioButtons in the radiogroup
        RadioButtonHandler handler = new RadioButtonHandler();
        radioGrooup.setOnCheckedChangeListener(handler);

        //Create the back button
        Button backbtn = new Button(this);
        backbtn.setText(R.string.backString);
        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });

        //Add the radio group to the scroll view
        scrollView.addView(radioGrooup);

        //Add the scrollview to the relative layout
        layout.addView(scrollView);

        //Setup some parameters to make the back button display at the bottom of the screen
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                                                                             ViewGroup.LayoutParams.WRAP_CONTENT);

        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.setMargins(0,0,0,50);

        //Add the button to the layout
        layout.addView(backbtn, params);

        //display the relative layout
        setContentView(layout);
    } //end updateView

    private class RadioButtonHandler implements RadioGroup.OnCheckedChangeListener
    {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId)
        {
         databaseManager.deleteByID( checkedId );
            Toast.makeText(DeleteActivity.this, "candy deleted", Toast.LENGTH_SHORT).show();

            updateView();
        }
    }//end RadioButtonHandler

 }//end DeleteActivity



