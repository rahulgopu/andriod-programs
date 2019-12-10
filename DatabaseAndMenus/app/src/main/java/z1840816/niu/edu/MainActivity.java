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

import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.text.NumberFormat;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private DatabaseManager manager;
    private double total;
    private ScrollView scrollView;
    private int buttonWidth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //create the database
        manager = new DatabaseManager(this);

        //initialize the total to 0
        total = 0.0;

        //connect the scrollview to the screen
        scrollView = findViewById(R.id.contentLayout);

        //calculate the width of the button
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);

        buttonWidth = size.x/2;

        updateView();
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }//end onCreate

    protected void onResume()
    {
        super.onResume();
        updateView();
    }//end onResume

    public void updateView()
    {
        ArrayList<Candy> candies = manager.selectAll();

        if (candies.size() > 0)
        {
            //clear the scrollview
            scrollView.removeAllViewsInLayout();

            //gridLayout for the buttons
            GridLayout gridLayout = new GridLayout(this);
            gridLayout.setRowCount((candies.size()+1)/2);
            gridLayout.setColumnCount(2);

            //array of buttons, 2 per row
            CandyButton [] buttons = new CandyButton[candies.size()];

            ButtonHandler handler = new ButtonHandler();

            //fill the gridLayout
            int sub=0;
            for (Candy candy : candies)
            {
                //create the button
                buttons[sub] = new CandyButton(this,candy);
                buttons[sub].setText(candy.getName()+"\n"+candy.getPrice());

                //handle the button click
                buttons[sub].setOnClickListener(handler);

                //add the button to the gridLayout
                gridLayout.addView(buttons[sub], buttonWidth, GridLayout.LayoutParams.WRAP_CONTENT);

                sub++;
            }//end for

            //add the gridLayout to the scrollview
            scrollView.addView(gridLayout);
        }//end if
    }//end updateView

    private class ButtonHandler implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            //increment the total by the price of the selected candy
            total+=((CandyButton) v).getPrice();

            String paymentAmount = NumberFormat.getCurrencyInstance().format(total);

            Toast.makeText(MainActivity.this, "Total: "+paymentAmount, Toast.LENGTH_LONG).show();
        }//end onClick
    }//end ButtonHandler

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
        if (id == R.id.action_add)
        {
            Toast.makeText(this, "Menu Option: add selected", Toast.LENGTH_SHORT).show();

            Intent insertIntent = new Intent(MainActivity.this, InsertActivity.class);
            startActivity(insertIntent);

            return true;
        }
        else if (id == R.id.action_delete)
        {
            Toast.makeText(this, "Menu Option: delete selected", Toast.LENGTH_SHORT).show();
            Intent deleteIntent = new Intent(this,DeleteActivity.class);
            startActivity(deleteIntent);
            return true;


        }
        else if(id == R.id.action_update)
        {
            Toast.makeText(this, "Menu Option: update selected", Toast.LENGTH_SHORT).show();
            Intent updateintent = new Intent(this,UpdateActivity.class);
            startActivity(updateintent);
            return true;
        }
        else if (id == R.id.action_resetTotal)
        {
            Toast.makeText(this,"Menu Option: reset selected",Toast.LENGTH_SHORT).show();
            total = 0.0;
        }

        return super.onOptionsItemSelected(item);
    }
}
