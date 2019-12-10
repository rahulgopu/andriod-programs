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

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class UpdateActivity extends AppCompatActivity {

    private DatabaseManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //create the database
        manager = new DatabaseManager(this);

        //create the view
        updateView();
    }//end onCreate

    public void updateView()
    {
        ArrayList<Candy> candies = manager.selectAll();

        //check to see if there is info in the database/array list
        if (candies.size() > 0)
        {
            ScrollView scrollView = new ScrollView(this);

            GridLayout gridLayout = new GridLayout(this);

            //set the number of rows and columns for the grid
            gridLayout.setRowCount(candies.size());
            gridLayout.setColumnCount(4); //id,name,price,button

            //Create some arrays to hold the info that will be placed on the screen
            TextView [] ids = new TextView[candies.size()];

            EditText [][] nameAndPrices = new EditText[candies.size()][2];

            Button [] buttons = new Button[candies.size()];

            ButtonHandler handler = new ButtonHandler();

            //Get the dimensions of the screen to make all 4 items fir on one line
            Point size = new Point();
            getWindowManager().getDefaultDisplay().getSize(size);

            int width = size.x;

            //Loop to process the arrayList and build the layout
            int sub=0;
            for (Candy candy : candies)
            {
                //Create the textviews for the id
                ids[sub] = new TextView(this);
                ids[sub].setGravity(Gravity.CENTER);
                ids[sub].setText(""+candy.getId());

                //edittext fields [0] name [1] price
                nameAndPrices[sub][0] = new EditText(this);
                nameAndPrices[sub][1] = new EditText(this);

                nameAndPrices[sub][0].setText(candy.getName());
                nameAndPrices[sub][1].setText(""+candy.getPrice());
                nameAndPrices[sub][1].setInputType(InputType.TYPE_CLASS_NUMBER);

                nameAndPrices[sub][0].setId( 10 * candy.getId() );
                nameAndPrices[sub][1].setId(10*candy.getId()+1);

                //Buttons
                buttons[sub] = new Button(this);
                buttons[sub].setText(R.string.updateString);
                buttons[sub].setId(candy.getId());

                buttons[sub].setOnClickListener(handler);

                //Add the items to the gridlayout
                gridLayout.addView(ids[sub], (int)(width*.1), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(nameAndPrices[sub][0], (int)(width*.4), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(nameAndPrices[sub][1], (int)(width*.15), ViewGroup.LayoutParams.WRAP_CONTENT);
                gridLayout.addView(buttons[sub],(int)(width*.35), ViewGroup.LayoutParams.WRAP_CONTENT);

                sub++;
            }//end for loop

            //Add the gridLayout to the scroll view
            scrollView.addView(gridLayout);

            //display the scrollview
            setContentView(scrollView);
        }//end if
    }//end updateView

    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            //get the name and the price from the edit text fields
            int candyId = v.getId();

            EditText nameET = findViewById(10*candyId);
            EditText priceET = findViewById(10*candyId+1);

            String nameStr = nameET.getText().toString(),
                    priceStr = priceET.getText().toString();

            //convert the price to a double
            try {
                double price = Double.parseDouble(priceStr);

                manager.updateById(candyId, nameStr, price);

                Toast.makeText(UpdateActivity.this, "Candy updated: "+nameStr,Toast.LENGTH_SHORT).show();

                updateView();
            }
            catch (NumberFormatException nfe)
            {
                Toast.makeText(UpdateActivity.this,"Price Error", Toast.LENGTH_SHORT).show();
            }
        }//end onClick
    }//end ButtonHandler
}//end UpdateActivity
