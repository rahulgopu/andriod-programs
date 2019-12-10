package edu.niu.cs.z1839171.databaseandmenus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class InsertActivity extends AppCompatActivity
{
    private DatabaseManager databaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        databaseManager = new DatabaseManager(this);
    }//end onCreate

    //Add Button
    public void insertCandy(View view)
    {
        //Get the info from the editText fields
        EditText candyNameET = findViewById(R.id.nameEditText),
                priceET = findViewById(R.id.priceEditText);

        String nameStr = candyNameET.getText().toString(),
                priceStr = priceET.getText().toString();

        try
        {
            double price = Double.parseDouble(priceStr);

            //Create the candy object
            Candy candy = new Candy(0,nameStr, price);

            //Insert the cndy object into the database
            databaseManager.insert(candy);

            Toast.makeText(this, "Candy: " + nameStr + " added to DB", Toast.LENGTH_SHORT).show();
        }
        catch (NumberFormatException nfe)
        {
            Toast.makeText(this,"Price error", Toast.LENGTH_SHORT).show();
        }

        ArrayList<Candy> candies = databasemanager.selectAll();
        for(Candy candy : candies )
        {
            Toast.makeText(this, "The candy is " + candy.candyToString(),Toast.LENGTH_SHORT).show();
        }

        //Clear the editText fields
        candyNameET.setText("");
        priceET.setText("");
    }//end insertCandy

    //back Button
    public void goBack(View view)
    {
        finish();
    }//end goBack
}//end InsertActivity
